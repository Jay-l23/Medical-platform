<template>
  <div id="app">

<!--    <input id="room" type="text" v-model="msg">-->

<!--    </input>-->
    <el-card>
      <el-row>
        <el-col :span="10">
          <div id="chat">
            <p v-for="(item,index) in msgList" :key="index">{{item}}</p>
          </div>
        </el-col>
      </el-row>

    </el-card>
    <br>
      <el-card>
        <el-row :gutter="20">
          <el-col :span="6" :xs="24" hidden>
            1
          </el-col>
          <el-col :span="20" :xs="24">
            <label>医患在线诊疗：</label><br>
            <el-input  id="room" v-model="msg" type="textarea" placeholder="请输入单行文本"
                       :autosize="{minRows: 4, maxRows: 4}" :style="{width: '50%'}">
            </el-input>
            <button @click="sendMessage">发送</button>

          </el-col>
        </el-row>
      </el-card>

</div>
</template>

<script>
import {getUserProfile} from "../../../api/system/user";

export default {
  name: 'SayMana',
  data() {
    return {
      websocket: null,
      msgList: [],
      msg: "",
      user: {}
    };
  },
  created() {
    var admin = JSON.parse(window.sessionStorage.getItem('sessionObj'))
    this.user = JSON.parse(admin.data)
    var vm = this;
    console.log(this.user);
    if ("WebSocket" in window) {
      console.log("connect websocket...");
      let token = window.sessionStorage.getItem("tokenStr");
      this.websocket = new WebSocket("ws://127.0.0.1:8080/ws/" + this.user.username);
    } else {
      alert("建立连接失败");
    }
    this.websocket.onerror = function () {
      vm.msgList.push("出现错误！");
    };
    this.websocket.onopen = function (event) {
      vm.msgList.push("新建连接成功...");
    };
    this.websocket.onmessage = function (event) {
      vm.msgList.push(event.data);
    };
    this.websocket.onclose = function () {
      vm.msgList.push("关闭连接...");
    };
    // 监听窗口事件，当窗口关闭时，主动关闭websocket
    window.onbeforeunload = function () {
      vm.websocket.close();
    };
  },
  methods: {
    sendMessage() {
      this.websocket.send(this.user.username + ":" + this.msg);
      this.msg = "";
    },
    // initUser(){
    //     this.getRequest("/admin/info").then(resp => {
    //         if (resp){
    //             this.user = resp
    //             console.log(this.user)
    //         }
    //     })
    // }
  },
};
</script>

<style>

</style>
