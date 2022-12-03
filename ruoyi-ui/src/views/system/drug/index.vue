<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="药品名称" prop="drugName">
        <el-input
          v-model="queryParams.drugName"
          placeholder="请输入药品名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="单位" prop="drugUnit">
        <el-input
          v-model="queryParams.drugUnit"
          placeholder="请输入单位"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="处方价格" prop="drugRxPrice">
        <el-input
          v-model="queryParams.drugRxPrice"
          placeholder="请输入处方价格"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="库存量" prop="drugStocks">
        <el-input
          v-model="queryParams.drugStocks"
          placeholder="请输入库存量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="预警值" prop="drugWarning">
        <el-input
          v-model="queryParams.drugWarning"
          placeholder="请输入预警值"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="状态" prop="drugStatus">
        <el-select v-model="queryParams.drugStatus" placeholder="请选择状态" clearable>
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
          v-hasPermi="['system:drug:add']"
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
          v-hasPermi="['system:drug:edit']"
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
          v-hasPermi="['system:drug:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:drug:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="drugList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="药品ID" align="center" prop="drugId" />
      <el-table-column label="药品名称" align="center" prop="drugName" />
      <el-table-column label="药品编码" align="center" prop="drugNumber" />
      <el-table-column label="药品关键字" align="center" prop="drugKey" />
      <el-table-column label="药品类型" align="center" prop="drugType" />
      <el-table-column label="处方类型" align="center" prop="drugRxType" />
      <el-table-column label="单位" align="center" prop="drugUnit" />
      <el-table-column label="处方价格" align="center" prop="drugRxPrice" />
      <el-table-column label="库存量" align="center" prop="drugStocks" />
      <el-table-column label="预警值" align="center" prop="drugWarning" />
      <el-table-column label="换算值" align="center" prop="drugMatrixing" />
      <el-table-column label="状态" align="center" prop="drugStatus">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_factory_status" :value="scope.row.drugStatus"/>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:drug:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:drug:remove']"
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

    <!-- 添加或修改药品信息维护对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="药品名称" prop="drugName">
          <el-input v-model="form.drugName" placeholder="请输入药品名称" />
        </el-form-item>
        <el-form-item label="单位" prop="drugUnit">
          <el-input v-model="form.drugUnit" placeholder="请输入单位" />
        </el-form-item>
        <el-form-item label="处方价格" prop="drugRxPrice">
          <el-input v-model="form.drugRxPrice" placeholder="请输入处方价格" />
        </el-form-item>
        <el-form-item label="库存量" prop="drugStocks">
          <el-input v-model="form.drugStocks" placeholder="请输入库存量" />
        </el-form-item>
        <el-form-item label="预警值" prop="drugWarning">
          <el-input v-model="form.drugWarning" placeholder="请输入预警值" />
        </el-form-item>
<!--        <el-form-item label="换算值" prop="drugMatrixing">-->
<!--          <el-input-number v-model="num" :step="1" :min="0"></el-input-number>-->
<!--&lt;!&ndash;          <el-input-number v-model="num" :step="1" @change="handleChange" :min="1" :max="10" label="??"/>&ndash;&gt;-->
<!--        </el-form-item>-->

        <el-form-item label="状态" prop="drugStatus">
          <el-select v-model="form.drugStatus" placeholder="请选择状态">
            <el-option
              v-for="dict in dict.type.sys_factory_status"
              :key="dict.value"
              :label="dict.label"
:value="parseInt(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item>

<!--        <el-form-item label="厂家ID" prop="facId">-->
<!--          <el-input v-model="form.facId" placeholder="请输入厂家ID" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="备注" prop="remark">-->
<!--          <el-input v-model="form.remark" placeholder="请输入备注" />-->
<!--        </el-form-item>-->
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listDrug, getDrug, delDrug, addDrug, updateDrug } from "@/api/system/drug";

export default {
  name: "Drug",
  dicts: ['sys_factory_status'],
  data() {
    return {
      num: 1,
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
      // 药品信息维护表格数据
      drugList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        drugName: null,
        drugNumber: null,
        drugKey: null,
        drugType: null,
        drugRxType: null,
        drugUnit: null,
        drugRxPrice: null,
        drugStocks: null,
        drugWarning: null,
        drugMatrixing: null,
        drugStatus: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        drugName: [
          { required: true, message: "药品名称不能为空", trigger: "blur" }
        ],
        drugNumber: [
          { required: true, message: "药品编码不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询药品信息维护列表 */
    getList() {
      this.loading = true;
      listDrug(this.queryParams).then(response => {
        this.drugList = response.rows;
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
        drugId: null,
        drugName: null,
        drugNumber: null,
        drugKey: null,
        drugType: null,
        drugRxType: null,
        drugUnit: null,
        drugRxPrice: null,
        drugStocks: null,
        drugWarning: null,
        drugMatrixing: null,
        drugStatus: null,
        facId: null,
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
      this.ids = selection.map(item => item.drugId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加药品信息维护";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const drugId = row.drugId || this.ids
      getDrug(drugId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改药品信息维护";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.drugId != null) {
            updateDrug(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addDrug(this.form).then(response => {
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
      const drugIds = row.drugId || this.ids;
      this.$modal.confirm('是否确认删除药品信息维护编号为"' + drugIds + '"的数据项？').then(function() {
        return delDrug(drugIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/drug/export', {
        ...this.queryParams
      }, `drug_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
