<template>
  <div>
    <el-form ref="elForm" :model="formData" :rules="rules" size="medium" label-width="100px"
      label-position="left">
      <el-row gutter="15">
        <el-form-item label="单行文本" prop="field118">
          <el-input v-model="formData.field118" placeholder="请输入单行文本" clearable :style="{width: '100%'}">
          </el-input>
        </el-form-item>
        <el-form-item label="" prop="field121">
          <el-button type="primary" icon="el-icon-search" size="medium"> 主要按钮 </el-button>
        </el-form-item>
        <el-form-item label="" prop="field120">
          <el-button type="primary" icon="el-icon-search" size="medium"> 主要按钮 </el-button>
        </el-form-item>
      </el-row>
      <el-form-item size="large">
        <el-button type="primary" @click="submitForm">提交</el-button>
        <el-button @click="resetForm">重置</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
export default {
  components: {},
  props: [],
  data() {
    return {
      formData: {
        field118: undefined,
        field121: '',
        field120: undefined,
      },
      rules: {
        field118: [{
          required: true,
          message: '请输入单行文本',
          trigger: 'blur'
        }],
      },
    }
  },
  computed: {},
  watch: {},
  created() {},
  mounted() {},
  methods: {
    submitForm() {
      this.$refs['elForm'].validate(valid => {
        if (!valid) return
        // TODO 提交表单
      })
    },
    resetForm() {
      this.$refs['elForm'].resetFields()
    },
  }
}

</script>
<style>
</style>
