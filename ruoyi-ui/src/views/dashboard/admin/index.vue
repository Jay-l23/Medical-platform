<template>
  <div class="dashboard-editor-container">

    <div class="app-container home">
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
      </el-row>
      <el-divider />
    </div>

    <panel-group @handleSetLineChartData="handleSetLineChartData" />

    <el-row style="background:#fff;padding:16px 16px 0;margin-bottom:32px;">
      <line-chart :chart-data="lineChartData" />
    </el-row>

    <el-row :gutter="32">
      <el-col :xs="24" :sm="24" :lg="8">
        <div class="chart-wrapper">
          <raddar-chart />
        </div>
      </el-col>
      <el-col :xs="24" :sm="24" :lg="8">
        <div class="chart-wrapper">
          <pie-chart />
        </div>
      </el-col>
      <el-col :xs="24" :sm="24" :lg="8">
        <div class="chart-wrapper">
          <bar-chart />
        </div>
      </el-col>
    </el-row>

    <el-row :gutter="8">
      <el-col :xs="{span: 24}" :sm="{span: 24}" :md="{span: 24}" :lg="{span: 12}" :xl="{span: 12}" style="padding-right:8px;margin-bottom:30px;">
        <transaction-table />
      </el-col>
      <el-col :xs="{span: 24}" :sm="{span: 12}" :md="{span: 12}" :lg="{span: 6}" :xl="{span: 6}" style="margin-bottom:30px;">
        <todo-list />
      </el-col>
      <el-col :xs="{span: 24}" :sm="{span: 12}" :md="{span: 12}" :lg="{span: 6}" :xl="{span: 6}" style="margin-bottom:30px;">
        <box-card />
      </el-col>
    </el-row>

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
import GithubCorner from '@/components/GithubCorner'
import PanelGroup from './components/PanelGroup'
import LineChart from './components/LineChart'
import RaddarChart from './components/RaddarChart'
import PieChart from './components/PieChart'
import BarChart from './components/BarChart'
import TransactionTable from './components/TransactionTable'
import TodoList from './components/TodoList/index'
import BoxCard from './components/BoxCard'

const lineChartData = {
  newVisitis: {
    expectedData: [100, 120, 161, 134, 105, 160, 165],
    actualData: [120, 82, 91, 154, 162, 140, 145]
  },
  messages: {
    expectedData: [200, 192, 120, 144, 160, 130, 140],
    actualData: [180, 160, 151, 106, 145, 150, 130]
  },
  purchases: {
    expectedData: [80, 100, 121, 104, 105, 90, 100],
    actualData: [120, 90, 100, 138, 142, 130, 130]
  },
  shoppings: {
    expectedData: [130, 140, 141, 142, 145, 150, 160],
    actualData: [120, 82, 91, 154, 162, 140, 130]
  }
}

export default {
  name: 'DashboardAdmin',
  components: {
    GithubCorner,
    PanelGroup,
    LineChart,
    RaddarChart,
    PieChart,
    BarChart,
    TransactionTable,
    TodoList,
    BoxCard
  },
  data() {
    return {
      lineChartData: lineChartData.newVisitis
    }
  },
  methods: {
    handleSetLineChartData(type) {
      this.lineChartData = lineChartData[type]
    },
    goTarget(href) {
      window.open(href, "_blank");
    },
  }
}
</script>

<style lang="scss" scoped>
.dashboard-editor-container {
  padding: 32px;
  background-color: rgb(240, 242, 245);
  position: relative;

  .github-corner {
    position: absolute;
    top: 0px;
    border: 0;
    right: 0;
  }

  .chart-wrapper {
    background: #fff;
    padding: 16px 16px 0;
    margin-bottom: 32px;
  }
}

@media (max-width:1024px) {
  .chart-wrapper {
    padding: 8px;
  }
}


</style>
