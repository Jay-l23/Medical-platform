<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="科室编号" prop="deptsId">
        <el-input
          v-model="queryParams.deptsId"
          placeholder="请输入科室编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>

      <el-form-item label="科室状态" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择科室状态" clearable>
          <el-option
            v-for="dict in dict.type.sys_status"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:depts:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:depts:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:depts:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:depts:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="deptsList"  border @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="科室编号" align="center" prop="deptsId" />
      <el-table-column label="科室名称" align="center" prop="deptsName" />
      <el-table-column label="科室编码" align="center" prop="deptsCode" />
      <el-table-column label="科室挂号量" align="center" prop="deptsNum" />
      <el-table-column label="负责人" align="center" prop="deptsLeader" />
      <el-table-column label="科室电话" align="center" prop="deptsPhone" />
      <el-table-column label="科室状态" align="center" prop="status">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_status" :value="scope.row.status"/>
        </template>
      </el-table-column>
      <el-table-column label="创建时间" align="center" prop="createTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:depts:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:depts:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改科室管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="科室名称" prop="deptsName">
          <el-input v-model="form.deptsName" placeholder="请输入科室名称" />
        </el-form-item>
        <el-form-item label="科室编码" prop="deptsCode">
          <el-input v-model="form.deptsCode" placeholder="请输入科室编码" />
        </el-form-item>
        <el-form-item label="负责人" prop="deptsLeader">
          <el-input v-model="form.deptsLeader" placeholder="请输入科室领导" />
        </el-form-item>
        <el-form-item label="科室电话" prop="deptsPhone">
          <el-input v-model="form.deptsPhone" placeholder="请输入科室电话" />
        </el-form-item>
        <el-form-item label="科室状态">
          <el-radio-group v-model="form.status">
            <el-radio
              v-for="dict in dict.type.sys_status"
              :key="dict.value"
              :label="parseInt(dict.value)"
            >{{dict.label}}</el-radio>
          </el-radio-group>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
  import { listDepts, getDepts, delDepts, addDepts, updateDepts } from "@/api/system/depts";

  export default {
    name: "Depts",
    dicts: ['sys_status'],
    data() {
      return {
        // 遮罩层
        loading: true,
        // 选中数组
        ids: [],
        // 非单个禁用
        single: true,
        // 非多个禁用
        multiple: true,
        // 显示搜索条件
        showSearch: true,
        // 总条数
        total: 0,
        // 科室管理表格数据
        deptsList: [],
        // 弹出层标题
        title: "",
        // 是否显示弹出层
        open: false,
        // 查询参数
        queryParams: {
          pageNum: 1,
          pageSize: 10,
          deptsId: null,
          deptsName: null,
          deptsCode: null,
          deptsLeader: null,
          deptsPhone: null,
          status: null,
          createTime: null,
        },
        // 表单参数
        form: {},
        // 表单校验
        rules: {
          deptsId: [
            { required: true, message: "科室编号不能为空", trigger: "blur" }
          ],
          deptsName: [
            { required: true, message: "科室名称不能为空", trigger: "blur" }
          ],
          deptsCode: [
            { required: true, message: "科室编码不能为空", trigger: "blur" }
          ],
          deptsNum: [
            { required: true, message: "科室挂号量不能为空", trigger: "blur" }
          ],
          status: [
            { required: true, message: "科室状态不能为空", trigger: "blur" }
          ],
        }
      };
    },
    created() {
      this.getList();
    },
    methods: {
      /** 查询科室管理列表 */
      getList() {
        this.loading = true;
        listDepts(this.queryParams).then(response => {
          this.deptsList = response.rows;
          this.total = response.total;
          this.loading = false;
        });
      },
      // 取消按钮
      cancel() {
        this.open = false;
        this.reset();
      },
      // 表单重置
      reset() {
        this.form = {
          deptsId: null,
          deptsName: null,
          deptsCode: null,
          deptsNum: null,
          deptsLeader: null,
          deptsPhone: null,
          status: 0,
          createBy: null,
          createTime: null,
          updateBy: null,
          updateTime: null
        };
        this.resetForm("form");
      },
      /** 搜索按钮操作 */
      handleQuery() {
        this.queryParams.pageNum = 1;
        this.getList();
      },
      /** 重置按钮操作 */
      resetQuery() {
        this.resetForm("queryForm");
        this.handleQuery();
      },
      // 多选框选中数据
      handleSelectionChange(selection) {
        this.ids = selection.map(item => item.deptsId)
        this.single = selection.length!==1
        this.multiple = !selection.length
      },
      /** 新增按钮操作 */
      handleAdd() {
        this.reset();
        this.open = true;
        this.title = "添加科室管理";
      },
      /** 修改按钮操作 */
      handleUpdate(row) {
        this.reset();
        const deptsId = row.deptsId || this.ids
        getDepts(deptsId).then(response => {
          this.form = response.data;
          this.open = true;
          this.title = "修改科室管理";
        });
      },
      /** 提交按钮 */
      submitForm() {
        this.$refs["form"].validate(valid => {
          if (valid) {
            if (this.form.deptsId != null) {
              updateDepts(this.form).then(response => {
                this.$modal.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              });
            } else {
              addDepts(this.form).then(response => {
                this.$modal.msgSuccess("新增成功");
                this.open = false;
                this.getList();
              });
            }
          }
        });
      },
      /** 删除按钮操作 */
      handleDelete(row) {
        const deptsIds = row.deptsId || this.ids;
        this.$modal.confirm('是否确认删除科室管理编号为"' + deptsIds + '"的数据项？').then(function() {
          return delDepts(deptsIds);
        }).then(() => {
          this.getList();
          this.$modal.msgSuccess("删除成功");
        }).catch(() => {});
      },
      /** 导出按钮操作 */
      handleExport() {
        this.download('system/depts/export', {
          ...this.queryParams
        }, `depts_${new Date().getTime()}.xlsx`)
      }
    }
  };
</script>
