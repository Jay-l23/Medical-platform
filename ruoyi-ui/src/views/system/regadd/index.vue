<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="患者姓名" prop="patiName">
        <el-input
          v-model="queryParams.patiName"
          placeholder="请输入患者姓名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="身份证号" prop="regCardNum">
        <el-input
          v-model="queryParams.regCardNum"
          placeholder="请输入身份证号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>

      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
        <el-button type="warning" plain icon="el-icon-download"
                   size="mini" @click="handleExport" v-hasPermi="['system:reg:export']">导出</el-button>
      </el-form-item>
    </el-form>

<!--    <el-row :gutter="10" class="mb8">-->
<!--      <el-col :span="1.5">-->
<!--        <el-button-->
<!--          type="warning"-->
<!--          plain-->
<!--          icon="el-icon-download"-->
<!--          size="mini"-->
<!--          @click="handleExport"-->
<!--          v-hasPermi="['system:reg:export']"-->
<!--        >导出-->
<!--        </el-button>-->
<!--      </el-col>-->
<!--      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>-->
<!--    </el-row>-->

    <el-table v-loading="loading" :data="regList" border @selection-change="handleSelectionChange">
      <el-table-column label="患者姓名" align="center" prop="patiName"/>
      <el-table-column label="挂号科室" align="center" prop="regDepts"/>
<!--      <el-table-column label="接诊医生" align="center" prop="regDocter"/>-->
      <el-table-column label="挂号费用" align="center" prop="regPrice"/>
      <el-table-column label="流水编号" align="center" prop="regNum"/>
      <el-table-column label="状态" align="center" prop="regStatus">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.his_reg" :value="scope.row.regStatus"/>
        </template>
      </el-table-column>
      <el-table-column label="就诊日期" align="center" prop="regSdate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.regSdate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="挂号类型" align="center" prop="regType"/>
      <el-table-column label="挂号时段" align="center" prop="regTime">
        <template slot-scope="scope">
          <span>{{ scope.row.status==1?"上午":"下午"}}</span>
        </template>
      </el-table-column>
    </el-table>

<!--    <pagination-->
<!--      v-show="total>0"-->
<!--      :total="total"-->
<!--      :page.sync="queryParams.pageNum"-->
<!--      :limit.sync="queryParams.pageSize"-->
<!--      @pagination="getList"-->
<!--    />-->
    <br>
    <el-tabs v-model="activeName" type="card">
      <el-tab-pane label="门诊" name="first">
        挂号费5￥
        <el-button
          type="danger"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:reg:add']"
        >挂号收费
        </el-button>
      </el-tab-pane>
      <el-tab-pane label="门诊+病例本" name="second">
        挂号费20￥
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:reg:add']"
        >挂号收费
        </el-button>
      </el-tab-pane>
      <el-tab-pane label="急诊" name="third">
        挂号费30￥
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:reg:add']"
        >挂号收费
        </el-button>
      </el-tab-pane>
      <el-tab-pane label="急诊+病例表" name="fourth">
        挂号费45￥
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:reg:add']"
        >挂号收费
        </el-button>
      </el-tab-pane>
    </el-tabs>


    <br>
    <el-row>
      <el-form :model="queryParamsDepts" ref="DeptqueryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
        <el-form-item label="科室编号" prop="deptsId">
          <el-input
            v-model="queryParamsDepts.deptsId"
            placeholder="请输入科室编号"
            clearable
            @keyup.enter.native="handleNodeClick"
          />
        </el-form-item>

        <el-form-item label="科室状态" prop="status">
          <el-select v-model="queryParamsDepts.status" placeholder="请选择科室状态" clearable>
<!--            <el-option-->
<!--              v-for="dict in dict.type.sys_status"-->
<!--              :key="dict.value"-->
<!--              :label="dict.label"-->
<!--              :value="dict.value"-->
<!--            />-->
                <el-option label="值班中" value="1"></el-option>
                <el-option label="空闲中" value="2"></el-option>
          </el-select>
        </el-form-item>

        <el-form-item>
          <el-button type="primary" icon="el-icon-search" size="mini" @click="handleNodeClick">搜索</el-button>
          <el-button icon="el-icon-refresh" size="mini" @click="resetQueryDepts">重置</el-button>
        </el-form-item>
      </el-form>

      <el-table v-loading="loading" :data="deptsList" border @selection-change="handleSelectionChange">
        <el-table-column label="科室编号" align="center" prop="deptsId"/>
        <el-table-column label="科室名称" align="center" prop="deptsName"/>
        <el-table-column label="科室挂号量" align="center" prop="deptsNum"/>
        <el-table-column label="科室状态" align="center" prop="status">
          <template slot-scope="scope">
<!--            <dict-tag :options="dict.type.sys_status" :value="scope.row.status"/>-->
            <span>{{scope.row.status==1?"值班中":"空闲中"}}</span>
          </template>
        </el-table-column>
      </el-table>

    </el-row>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParamsDepts.pageNum"
      :limit.sync="queryParamsDepts.pageSize"
      @pagination="getDeptsList"
    />

    <!-- 添加或修改挂号列表对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="患者姓名" prop="patiName">
          <el-input v-model="form.patiName" placeholder="请输入患者姓名"/>
        </el-form-item>
        <el-form-item label="身份证号" prop="regCardNum">
          <el-input v-model="form.regCardNum" placeholder="请输入身份证号"/>
        </el-form-item>
        <el-form-item label="挂号类型" prop="regType">
          <el-select v-model = "form.regType" placeholder="请输入挂号类型">
            <el-option label="门诊" value="门诊"></el-option>
            <el-option label="门诊+病历单" value="门诊+病历单"></el-option>
            <el-option label="急诊" value="急诊"></el-option>
            <el-option label="急诊+病历单" value="急诊+病历单"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="挂号费用" prop="regType">
          <el-select v-model = "form.regPrice" placeholder="请输入挂号费用">
            <el-option label="5" value="5"></el-option>
            <el-option label="门诊+病历单" value="门诊+病历单"></el-option>
            <el-option label="急诊" value="急诊"></el-option>
            <el-option label="急诊+病历单" value="急诊+病历单"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="挂号科室" prop="regDepts">
          <el-select v-model="form.regDepts" placeholder="请选择挂号科室">
            <el-option label="内科" value="内科"></el-option>
            <el-option label="外科" value="外科"></el-option>
            <el-option label="儿科" value="儿科"></el-option>
            <el-option label="妇科" value="妇科"></el-option>
            <el-option label="眼科" value="眼科"></el-option>
            <el-option label="耳鼻喉科" value="耳鼻喉科"></el-option>
            <el-option label="口腔科" value="口腔科"></el-option>
            <el-option label="皮肤科" value="皮肤科"></el-option>
          </el-select>
<!--          <el-input v-model="form.regDepts" placeholder="请输入挂号科室"/>-->
        </el-form-item>
<!--        <el-form-item label="接诊医生" prop="regDocter">-->
<!--          <el-input v-model="form.regDocter" placeholder="请输入接诊医生"/>-->
<!--        </el-form-item>-->
<!--        <el-form-item label="挂号费用" prop="regPrice">-->
<!--          <el-input v-model="form.regPrice" placeholder="请输入挂号费用"/>-->
<!--        </el-form-item>-->
<!--        <el-form-item label="流水编号" prop="regNum">-->
<!--          <el-input v-model="form.regNum" placeholder="请输入流水编号"/>-->
<!--        </el-form-item>-->
<!--        <el-form-item label="状态" prop="regStatus">-->
<!--          <el-select v-model="form.regStatus" placeholder="请选择状态">-->
<!--            <el-option-->
<!--              v-for="dict in dict.type.his_reg"-->
<!--              :key="dict.value"-->
<!--              :label="dict.label"-->
<!--              :value="dict.value"-->
<!--            ></el-option>-->
<!--          </el-select>-->
<!--        </el-form-item>-->
<!--        <el-form-item label="就诊日期" prop="regSdate">-->
<!--          <el-date-picker clearable-->
<!--                          v-model="form.regSdate"-->
<!--                          type="date"-->
<!--                          value-format="yyyy-MM-dd"-->
<!--                          placeholder="请选择就诊日期">-->
<!--          </el-date-picker>-->
<!--        </el-form-item>-->
        <el-form-item label="挂号时段" prop="regTime">
<!--          <el-input v-model="form.regTime" placeholder="请输入挂号时段"/>-->
          <el-select v-model="form.regTime" placeholder="请输入挂号时段">
            <el-option label="上午" value="上午"></el-option>
            <el-option label="下午" value="下午"></el-option>
          </el-select>

        </el-form-item>
<!--        <el-form-item label="挂号时间" prop="regRdate">-->
<!--          <el-date-picker clearable-->
<!--                          v-model="form.regRdate"-->
<!--                          type="date"-->
<!--                          value-format="yyyy-MM-dd"-->
<!--                          placeholder="请选择挂号时间">-->
<!--          </el-date-picker>-->
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
  import {listReg, getReg, delReg, addReg, updateReg} from "@/api/system/reg";
  import { listDepts, getDepts, delDepts, addDepts, updateDepts } from "@/api/system/depts";

  export default {
    name: "Reg",
    dicts: ['his_reg'],
    data() {
      return {

        deptsList: [],

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
        // 挂号列表表格数据
        regList: [],
        // 弹出层标题
        title: "",
        // 是否显示弹出层
        open: false,
        // 查询患者参数
        queryParams: {
          pageNum: 1,
          pageSize: 10,
          patiName: null,
          regCardNum: null,
          regDepts: null,
          regDocter: null,
          regPrice: null,
          regNum: null,
          regStatus: null,
          regSdate: null,
          regType: null,
          regTime: null,
          regRdate: null,
        },
        //查询科室参数
        queryParamsDepts: {
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
          // patiName: [
          //   {required: true, message: "患者姓名不能为空", trigger: "blur"}
          // ],
          // regCardNum: [
          //   {required: true, message: "身份证号不能为空", trigger: "blur"}
          // ],
          // regDepts: [
          //   {required: true, message: "挂号科室不能为空", trigger: "change"}
          // ],
          // regPrice: [
          //   {required: true, message: "挂号费用不能为空", trigger: "blur"}
          // ],
          // regNum: [
          //   {required: true, message: "流水编号不能为空", trigger: "blur"}
          // ],
          // regStatus: [
          //   {required: true, message: "状态不能为空", trigger: "change"}
          // ],
          // regType: [
          //   {required: true, message: "挂号类型不能为空", trigger: "change"}
          // ],
          // regTime: [
          //   {required: true, message: "挂号时段不能为空", trigger: "blur"}
          // ],
          // regRdate: [
          //   {required: true, message: "挂号时间不能为空", trigger: "blur"}
          // ],
        }
      };
    },
    created() {
      this.getList();
      this.getDeptsList();
    },
    methods: {
      /** 查询科室管理列表 */
      getDeptsList() {
        this.loading = true;
        listDepts(this.queryParamsDepts).then(response => {
          this.deptsList = response.rows;
          this.total = response.total;
          this.loading = false;
        });
      },
      /** 查询挂号列表列表 */
      getList() {
        this.loading = true;
        listReg(this.queryParams).then(response => {
          this.regList = response.rows;
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
          regId: null,
          patiName: null,
          regCardNum: null,
          regDepts: null,
          regDocter: null,
          regPrice: null,
          regNum: null,
          regStatus: null,
          regSdate: null,
          regType: null,
          regTime: null,
          regRdate: null,
          createBy: null,
          createTime: null,
          updateBy: null,
          updateTime: null
        };
        this.resetForm("form");
      },
      // 科室表单重置
      deptsreset() {
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
      /** 科室搜索按钮操作 */
      handleNodeClick() {
        this.queryParamsDepts.pageNum = 1;
        this.getList();
      },
      /** 重置按钮操作 */
      resetQuery() {
        this.resetForm("queryForm");
        this.handleQuery();
      },
      /** 新增按钮操作 */
      handleAdd() {
        this.reset();
        this.open = true;
        this.title = "添加挂号列表";
      },
      /** 提交按钮 */
      submitForm() {
        this.$refs["form"].validate(valid => {
          if (valid) {
            if (this.form.regId != null) {
              updateReg(this.form).then(response => {
                this.$modal.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              });
            } else {
              addReg(this.form).then(response => {
                this.$modal.msgSuccess("新增成功");
                this.open = false;
                this.getList();
              });
            }
          }
        });
      },
      /** 导出按钮操作 */
      handleExport() {
        this.download('system/reg/export', {
          ...this.queryParams
        }, `reg_${new Date().getTime()}.xlsx`)
      }
    }
  };
</script>
