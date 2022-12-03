<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="患者名称" prop="patiName">
        <el-input
          v-model="queryParams.patiName"
          placeholder="请输入患者名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="身份证" prop="patiCode">
        <el-input
          v-model="queryParams.patiCode"
          placeholder="请输入患者身份证"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="患者电话" prop="patiPhone">
        <el-input
          v-model="queryParams.patiPhone"
          placeholder="请输入患者电话"
          clearable
          @keyup.enter.native="handleQuery"
        />
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
          v-hasPermi="['system:pati:add']"
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
          v-hasPermi="['system:pati:edit']"
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
          v-hasPermi="['system:pati:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:pati:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="patiList" border @selection-change="handleSelectionChange">
<!--      <el-table-column type="selection" width="55" align="center" />-->
<!--      <el-table-column label="患者编号" align="center" prop="patiId" />-->
      <el-table-column label="姓名" align="center" prop="patiName" />
      <el-table-column label="身份证号" align="center" prop="patiCode" width="160" />
      <el-table-column label="电话" align="center" prop="patiPhone" />
      <el-table-column label="出生年月" align="center" prop="patiBirthday" width="150">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.patiBirthday, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="患者年龄" align="center" prop="patiAge" />
      <el-table-column label="患者性别" align="center" prop="patiSex">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_user_sex" :value="scope.row.patiSex"/>
        </template>
      </el-table-column>
      <el-table-column label="患者过敏史" align="center" prop="patiAllergy" />
      <el-table-column label="信息状态" align="center" prop="status">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_info_status" :value="scope.row.status"/>
        </template>
      </el-table-column>
<!--      <el-table-column label="创建时间" align="center" prop="createTime" width="180">-->
<!--        <template slot-scope="scope">-->
<!--          <span>{{ parseTime(scope.row.createTime, '{y}-{m}-{d}') }}</span>-->
<!--        </template>-->
<!--      </el-table-column>-->
<!--      <el-table-column label="备注" align="center" prop="remark" />-->
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:pati:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:pati:remove']"
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

    <!-- 添加或修改患者库对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="姓名" prop="patiName">
          <el-input v-model="form.patiName" placeholder="请输入患者名称" />
        </el-form-item>
        <el-form-item label="身份证号" prop="patiCode">
          <el-input v-model="form.patiCode" placeholder="请输入患者身份证" />
        </el-form-item>
        <el-form-item label="患者电话" prop="patiPhone">
          <el-input v-model="form.patiPhone" placeholder="请输入患者电话" />
        </el-form-item>
        <el-form-item label="出生年月" prop="patiBirthday">
          <el-date-picker clearable
            v-model="form.patiBirthday"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择出生年月">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="患者年龄" prop="patiAge">
          <el-input v-model="form.patiAge" placeholder="请输入患者年龄" />
        </el-form-item>
        <el-form-item label="患者性别" prop="patiSex">
          <el-select v-model="form.patiSex" placeholder="请选择患者性别">
            <el-option
              v-for="dict in dict.type.sys_user_sex"
              :key="dict.value"
              :label="dict.label"
:value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="患者住址" prop="patiAddress">
          <el-input v-model="form.patiAddress" placeholder="请输入患者住址" />
        </el-form-item>
        <el-form-item label="过敏史" prop="patiAllergy">
          <el-input v-model="form.patiAllergy" placeholder="请输入患者过敏史" />
        </el-form-item>
        <el-form-item label="信息状态">
          <el-radio-group v-model="form.status">
            <el-radio
              v-for="dict in dict.type.sys_info_status"
              :key="dict.value"
:label="dict.value"
            >{{dict.label}}</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" placeholder="请输入备注" />
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
import { listPati, getPati, delPati, addPati, updatePati } from "@/api/system/pati";

export default {
  name: "Pati",
  dicts: ['sys_info_status', 'sys_user_sex'],
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
      // 患者库表格数据
      patiList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        patiName: null,
        patiCode: null,
        patiPhone: null,
        patiBirthday: null,
        patiAge: null,
        patiSex: null,
        patiAllergy: null,
        status: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        patiName: [
          { required: true, message: "患者名称不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询患者库列表 */
    getList() {
      this.loading = true;
      listPati(this.queryParams).then(response => {
        this.patiList = response.rows;
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
        patiId: null,
        patiName: null,
        patiCode: null,
        patiPhone: null,
        patiBirthday: null,
        patiAge: null,
        patiSex: null,
        patiAddress: null,
        patiAllergy: null,
        status: "0",
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        remark: null
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
      this.ids = selection.map(item => item.patiId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加患者库";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const patiId = row.patiId || this.ids
      getPati(patiId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改患者库";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.patiId != null) {
            updatePati(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addPati(this.form).then(response => {
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
      const patiIds = row.patiId || this.ids;
      this.$modal.confirm('是否确认删除患者库编号为"' + patiIds + '"的数据项？').then(function() {
        return delPati(patiIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/pati/export', {
        ...this.queryParams
      }, `pati_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
