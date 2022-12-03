<template>
  <div class="app-container home">

    <el-row :gutter="20">
      <el-col :sm="24" :lg="24">
        <blockquote class="text-warning" style="font-size: 28px">
          数据统计2
        </blockquote>
        <hr />
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :sm="24" :lg="12" style="padding-left: 20px">
        <h2>医疗信息管理系统</h2>
        <p>
          医疗设施的建设力度逐渐增加，接诊患者的数量逐渐增加，外加医院运营过程中产生的各类海量的数据和医疗信息，使医院管理难度增大，医院各部门之间的信息无法有效共享。除此之外，医疗机构内存有海量的就诊信息，但是由于缺乏有效的集成、管理手段，导致对信息的有效利用程度较低，则对医疗服务水平的提升造成较大影响        </p>
        <p>
          <el-button
            type="primary"
            size="mini"
            icon="el-icon-cloudy"
            plain
            @click="goTarget('https://gitee.com/lijie2002211329')"
            >访问码云</el-button
          >
        </p>
      </el-col>

      <el-col :sm="24" :lg="12" style="padding-left: 50px">
        <el-row>
          <el-col :span="12">
            <h2>技术栈</h2>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="6">
            <h4>后端技术</h4>
            <ul>
              <li>SpringBoot</li>
              <li>Spring Security</li>
              <li>JWT</li>
              <li>MyBatis</li>
              <li><Docker></Docker></li>
            </ul>
          </el-col>
          <el-col :span="6">
            <h4>前端技术</h4>
            <ul>
              <li>Vue</li>
              <li>Vuex</li>
              <li>Element-ui</li>
              <li>Axios</li>
            </ul>
          </el-col>
        </el-row>
      </el-col>
    </el-row>
    <el-divider />
    <el-row :gutter="20">
      <el-col :xs="24" :sm="24" :md="12" :lg="8">
        <el-card class="update-log">
          <div slot="header" class="clearfix">
            <span>联系信息</span>
          </div>
          <div class="body">
            <p>
              <i class="el-icon-s-promotion"></i> QQ：<el-link
                href="https://gitee.com/lijie2002211329/Medical-system.git"
                target="_blank">2132596913@qq.com</el-link
              >
            </p>
            <p>
              <i class="el-icon-chat-dot-round"></i> Gitee：<a
                href="javascript:"></a
              >
              <a href="https://gitee.com/lijie2002211329" target="_blank" class="item">https://gitee.com/lijie2002211329</a>
            </p>
            <p>
              <i class="el-icon-money"></i> Email：<a
                href="javascript:;"
                class="支付宝信息">m15958764153@163.com</a>
            </p>
          </div>
        </el-card>
      </el-col>

      <el-col :xs="24" :sm="24" :md="12" :lg="8">
        <el-card class="update-log">
          <div slot="header" class="clearfix">
            <span>日志说明</span>
          </div>
          <el-collapse accordion>
            <el-collapse-item title="小李到此一游">
              <ol>
                <li>数据逻辑删除不进行唯一验证</li>
                <li>Excel注解支持导出对象的子列表方法</li>
                <li>Excel注解支持自定义隐藏属性列</li>
                <li>医疗信息管理系统1.0测试版本正式发布</li>
              </ol>
            </el-collapse-item>
          </el-collapse>
        </el-card>
      </el-col>
      <el-col :xs="24" :sm="24" :md="12" :lg="8">
        <el-card class="update-log">
          <div slot="header" class="clearfix">
            <span>微信二维码</span>
          </div>
          <div class="body">
            <img src="../assets/images/weichat.png" alt="donate" width="50%"/>
            <span style="display: inline-block; height: 30px; line-height: 30px">
              有关我所知道的一切都愿与你交流
              Talk is cheap show me the code
            </span>
          </div>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  name: "Index",
  data() {
    return {
      like: true,
      value1: 4154.564,
      value2: 2222,
      title: "今年的增长",
      input: "Hello element UI!",
      // 版本号
      version: "3.8.4",
    };
  },
  methods: {
    goTarget(href) {
      window.open(href, "_blank");
    },
  },
};
</script>

<style scoped lang="scss">

  .like {
    cursor: pointer;
    font-size: 25px;
    display: inline-block;
  }
.home {
  blockquote {
    padding: 10px 20px;
    margin: 0 0 20px;
    font-size: 17.5px;
    border-left: 5px solid #eee;
  }
  hr {
    margin-top: 20px;
    margin-bottom: 20px;
    border: 0;
    border-top: 1px solid #eee;
  }
  .col-item {
    margin-bottom: 20px;
  }

  ul {
    padding: 0;
    margin: 0;
  }

  font-family: "open sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
  font-size: 13px;
  color: #676a6c;
  overflow-x: hidden;

  ul {
    list-style-type: none;
  }

  h4 {
    margin-top: 0px;
  }

  h2 {
    margin-top: 10px;
    font-size: 26px;
    font-weight: 100;
  }

  p {
    margin-top: 10px;

    b {
      font-weight: 700;
    }
  }

  .update-log {
    ol {
      display: block;
      list-style-type: decimal;
      margin-block-start: 1em;
      margin-block-end: 1em;
      margin-inline-start: 0;
      margin-inline-end: 0;
      padding-inline-start: 40px;
    }
  }
}
</style>

