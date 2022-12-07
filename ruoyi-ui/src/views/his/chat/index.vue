<template>
  <div>
    <el-tabs v-model="activeName" type="card">
      <el-tab-pane label="聊天室" name="SayMana"><SayMana></SayMana></el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
  // import SayMana from "../../components/sys/basic/SayMana";
  import SayMana from "./SayMana";
  export default {
    name: "SysBasic",
    data() {
      return {
        activeName: 'DepMana'
      }
    },
    components:{
      SayMana
    }

  }
</script>

<style scoped>

</style>
