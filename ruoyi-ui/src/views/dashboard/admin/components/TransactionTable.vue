<template>
  <el-table :data="list" style="width: 100%;padding-top: 15px;">
    <el-table-column label="订单号" min-width="200">
      <template slot-scope="scope">
        {{ scope.row.orderId }}
      </template>
    </el-table-column>
    <el-table-column label="价格" width="195" align="center">
      <template slot-scope="scope">
        ¥{{ scope.row.orderPrice }}
      </template>
    </el-table-column>
    <el-table-column label="状态" width="100" align="center">
      <template slot-scope="{row}">
        <el-tag :type="row.orderState">
          {{ row.orderState=="W"?"未取货":"已取货" }}
        </el-tag>
      </template>
    </el-table-column>
  </el-table>
</template>

<script>
import { transactionList } from '@/api/remote-search'

export default {
  filters: {
    statusFilter(status) {
      const statusMap = {
        success: 'success',
        pending: 'danger'
      }
      return statusMap[status]
    },
    orderNoFilter(str) {
      return str.substring(0, 30)
    }
  },
  data() {
    return {
      list: null
    }
  },
  created() {
    this.fetchData()
  },
  // methods: {
  //   fetchData() {
  //     transactionList().then(response => {
  //       this.list = response.rows.slice(0, 8)
  //     })
  //   }
  // }
}
</script>
