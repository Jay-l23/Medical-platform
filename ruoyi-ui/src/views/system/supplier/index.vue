<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="供应商ID" prop="supId">
        <el-input
          v-model="queryParams.supId"
          placeholder="请输入供应商ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="名称" prop="supName">
        <el-input
          v-model="queryParams.supName"
          placeholder="请输入供应商名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="联系人" prop="supContact">
        <el-input
          v-model="queryParams.supContact"
          placeholder="请输入联系人"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="手机号" prop="supMobile">
        <el-input
          v-model="queryParams.supMobile"
          placeholder="请输入联系人手机"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="联系短号" prop="supTel">
        <el-input
          v-model="queryParams.supTel"
          placeholder="请输入联系人短号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="银行账号" prop="supAccount">
        <el-input
          v-model="queryParams.supAccount"
          placeholder="请输入银行账号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="地址" prop="supAddress">
        <el-input
          v-model="queryParams.supAddress"
          placeholder="请输入地址"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="状态" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择状态" clearable>
          <el-option
            v-for="dict in dict.type.sys_factory_status"
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
          v-hasPermi="['system:supplier:add']"
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
          v-hasPermi="['system:supplier:edit']"
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
          v-hasPermi="['system:supplier:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:supplier:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="supplierList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="供应商ID" align="center" prop="supId" />
      <el-table-column label="供应商名称" align="center" prop="supName" />
      <el-table-column label="联系人" align="center" prop="supContact" />
      <el-table-column label="联系人手机" align="center" prop="supMobile" />
      <el-table-column label="联系人电话" align="center" prop="supTel" />
      <el-table-column label="银行账号" align="center" prop="supAccount" />
      <el-table-column label="地址" align="center" prop="supAddress" />
      <el-table-column label="状态" align="center" prop="status">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_factory_status" :value="scope.row.status"/>
        </template>
      </el-table-column>
      <el-table-column label="创建时间" align="center" prop="createTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:supplier:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:supplier:remove']"
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

    <!-- 添加或修改供应商维护对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="供应商" prop="supName">
          <el-input v-model="form.supName" placeholder="请输入供应商名称" />
        </el-form-item>
        <el-form-item label="联系人" prop="supContact">
          <el-input v-model="form.supContact" placeholder="请输入联系人" />
        </el-form-item>
        <el-form-item label="手机号" prop="supMobile">
          <el-input v-model="form.supMobile" placeholder="请输入联系人手机" />
        </el-form-item>
        <el-form-item label="联系短号" prop="supTel">
          <el-input v-model="form.supTel" placeholder="请输入联系人电话" />
        </el-form-item>
        <el-form-item label="银行账号" prop="supAccount">
          <el-input v-model="form.supAccount" placeholder="请输入银行账号" />
        </el-form-item>
        <el-form-item label="地址" prop="supAddress">
          <el-input v-model="form.supAddress" placeholder="请输入地址" />
        </el-form-item>
        <el-form-item label="状态">
          <el-radio-group v-model="form.status">
            <el-radio
              v-for="dict in dict.type.sys_factory_status"
              :key="dict.value"
:label="parseInt(dict.value)"
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
import { listSupplier, getSupplier, delSupplier, addSupplier, updateSupplier } from "@/api/system/supplier";

export default {
  name: "Supplier",
  dicts: ['sys_factory_status'],
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
      // 供应商维护表格数据
      supplierList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        supId: null,
        supName: null,
        supContact: null,
        supMobile: null,
        supTel: null,
        supAccount: null,
        supAddress: null,
        status: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        supName: [
          { required: true, message: "供应商名称不能为空", trigger: "blur" }
        ],
        supContact: [
          { required: true, message: "联系人不能为空", trigger: "blur" }
        ],
        supMobile: [
          { required: true, message: "联系人手机不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询供应商维护列表 */
    getList() {
      this.loading = true;
      listSupplier(this.queryParams).then(response => {
        this.supplierList = response.rows;
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
        supId: null,
        supName: null,
        supContact: null,
        supMobile: null,
        supTel: null,
        supAccount: null,
        supAddress: null,
        status: 0,
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
      this.ids = selection.map(item => item.supId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加供应商维护";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const supId = row.supId || this.ids
      getSupplier(supId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改供应商维护";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.supId != null) {
            updateSupplier(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addSupplier(this.form).then(response => {
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
      const supIds = row.supId || this.ids;
      this.$modal.confirm('是否确认删除供应商维护编号为"' + supIds + '"的数据项？').then(function() {
        return delSupplier(supIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/supplier/export', {
        ...this.queryParams
      }, `supplier_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
