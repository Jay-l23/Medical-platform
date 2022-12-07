<template>
    <div id="app">

    <div id="chat">
        <p v-for="(item,index) in msgList" :key="FriendChat">{{item}}</p>

    </div>

    <div class="lt">
            <textarea placeholder="请输入内容..." class="inputMe" name="" v-model="msg" id="" cols="105" rows="5"></textarea>
    <button class="btnlt" @click="sendMessage">发送</button>
        </div>
    </div>
</template>

<script>
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
    var admin = JSON.parse(window.sessionStorage.getItem('user'))
    this.user = admin
    var vm = this;
    console.log(admin.name);
    if ("WebSocket" in window) {
      console.log("connect websocket...");
      let token = window.sessionStorage.getItem("tokenStr");
      this.websocket = new WebSocket("ws://127.0.0.1:8081/ws/" + admin.name);
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
      this.websocket.send(this.user.name + "：" + this.msg);
      this.msg = "";
    },
    initUser(){
        this.getRequest("/admin/info").then(resp => {
            if (resp){
                this.user = resp
                console.log(this.user)
            }
        })
    }
  },
};
</script>

<style lang="scss" scoped>
    #app {
        margin: 20px auto;
        width: 800px;
        height: 600px;
        overflow: hidden;
        border-radius: 10px;
        .sidebar, #chat {
            height: 80%;
        }
        #chat {
            position: relative;
            overflow: hidden;
            background-color: #fff;
        border: 1px solid #eee;
            padding: 10px;

        }
    }
    .lt{
        height: 20%;
        border: 10px solid #eee;
        background: #eee;
        position: relative;
        .btnlt{
            position: absolute;
            right: 20px;
            bottom: 40px;
        }
        .inputMe{
            resize:none;
            background: none;
            border: none;
        }
    }
</style>
