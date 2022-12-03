<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="编号" prop="dId">
        <el-input
          v-model="queryParams.dId"
          placeholder="请输入编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="姓名" prop="dName">
        <el-input
          v-model="queryParams.dName"
          placeholder="请输入姓名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="所属部门" prop="deptsId">
        <el-select v-model="queryParams.deptsId" placeholder="请选择所属部门" clearable>
          <el-option
            v-for="dict in dict.type.sys_depts"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="手机号" prop="dPhone">
        <el-input
          v-model="queryParams.dPhone"
          placeholder="请输入手机号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="性别" prop="dSex">
        <el-select v-model="queryParams.dSex" placeholder="请选择性别" clearable>
          <el-option
            v-for="dict in dict.type.sys_user_sex"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="年龄" prop="dAge">
        <el-input
          v-model="queryParams.dAge"
          placeholder="请输入年龄"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="排班状态" prop="orderwork">
        <el-select v-model="queryParams.orderwork" placeholder="请选择排班状态" clearable>
          <el-option
            v-for="dict in dict.type.sys_work_status"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="学历背景" prop="dEducationBg">
        <el-select v-model="queryParams.dEducationBg" placeholder="请选择学历背景" clearable>
          <el-option
            v-for="dict in dict.type.sys_education"
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
          v-hasPermi="['system:docters:add']"
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
          v-hasPermi="['system:docters:edit']"
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
          v-hasPermi="['system:docters:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:docters:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="doctersList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="编号" align="center" prop="dId" />
      <el-table-column label="姓名" align="center" prop="dName" />
      <el-table-column label="所属部门" align="center" prop="deptsId">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_depts" :value="scope.row.deptsId"/>
        </template>
      </el-table-column>
      <el-table-column label="手机号" align="center" prop="dPhone" />
      <el-table-column label="性别" align="center" prop="dSex">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_user_sex" :value="scope.row.dSex"/>
        </template>
      </el-table-column>
      <el-table-column label="年龄" align="center" prop="dAge" />
      <el-table-column label="排班状态" align="center" prop="orderwork">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_work_status" :value="scope.row.orderwork"/>
        </template>
      </el-table-column>
      <el-table-column label="学历背景" align="center" prop="dEducationBg">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_education" :value="scope.row.dEducationBg"/>
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
            v-hasPermi="['system:docters:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:docters:remove']"
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

    <!-- 添加或修改医生信息管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="姓名" prop="dName">
          <el-input v-model="form.dName" placeholder="请输入姓名" />
        </el-form-item>
        <el-form-item label="所属部门" prop="deptsId">
          <el-select v-model="form.deptsId" placeholder="请选择所属部门">
            <el-option
              v-for="dict in dict.type.sys_depts"
              :key="dict.value"
              :label="dict.label"
:value="parseInt(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="手机号" prop="dPhone">
          <el-input v-model="form.dPhone" placeholder="请输入手机号" />
        </el-form-item>
        <el-form-item label="性别" prop="dSex">
          <el-select v-model="form.dSex" placeholder="请选择性别">
            <el-option
              v-for="dict in dict.type.sys_user_sex"
              :key="dict.value"
              :label="dict.label"
:value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="年龄" prop="dAge">
          <el-input v-model="form.dAge" placeholder="请输入年龄" />
        </el-form-item>
        <el-form-item label="排班状态" prop="orderwork">
          <el-select v-model="form.orderwork" placeholder="请选择排班状态">
            <el-option
              v-for="dict in dict.type.sys_work_status"
              :key="dict.value"
              :label="dict.label"
:value="parseInt(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="学历背景" prop="dEducationBg">
          <el-select v-model="form.dEducationBg" placeholder="请选择学历背景">
            <el-option
              v-for="dict in dict.type.sys_education"
              :key="dict.value"
              :label="dict.label"
:value="parseInt(dict.value)"
            ></el-option>
          </el-select>
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
import { listDocters, getDocters, delDocters, addDocters, updateDocters } from "@/api/system/docters";

export default {
  name: "Docters",
  dicts: ['sys_education', 'sys_work_status', 'sys_user_sex', 'sys_depts'],
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
      // 医生信息管理表格数据
      doctersList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        dId: null,
        dName: null,
        deptsId: null,
        dPhone: null,
        dSex: null,
        dAge: null,
        orderwork: null,
        dEducationBg: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        dName: [
          { required: true, message: "姓名不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询医生信息管理列表 */
    getList() {
      this.loading = true;
      listDocters(this.queryParams).then(response => {
        this.doctersList = response.rows;
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
        dId: null,
        dName: null,
        deptsId: null,
        dPhone: null,
        dSex: null,
        dAge: null,
        orderwork: null,
        dEducationBg: null,
        createTime: null
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
      this.ids = selection.map(item => item.dId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加医生信息管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const dId = row.dId || this.ids
      getDocters(dId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改医生信息管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.dId != null) {
            updateDocters(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addDocters(this.form).then(response => {
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
      const dIds = row.dId || this.ids;
      this.$modal.confirm('是否确认删除医生信息管理编号为"' + dIds + '"的数据项？').then(function() {
        return delDocters(dIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/docters/export', {
        ...this.queryParams
      }, `docters_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
