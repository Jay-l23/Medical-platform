<template>
  <div class="app-container">


    <el-row :gutter="20">
      <el-col :span="7" :xs="24">
        <!-- 添加或修改患者库对话框 -->
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
        <div style="margin: auto">
          <el-button type="primary" @click="submitForm">确 定</el-button>
          <el-button @click="cancel">取 消</el-button>
        </div>
      </el-col>
      <el-col :span="14" :xs="24">

      </el-col>
    </el-row>




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
