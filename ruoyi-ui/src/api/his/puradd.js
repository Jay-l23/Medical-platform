import request from '@/utils/request'

// 查询提交订单列表
export function listPuradd(query) {
  return request({
    url: '/his/puradd/list',
    method: 'get',
    params: query
  })
}

// 查询提交订单详细
export function getPuradd(purOrderId) {
  return request({
    url: '/his/puradd/' + purOrderId,
    method: 'get'
  })
}

// 新增提交订单
export function addPuradd(data) {
  return request({
    url: '/his/puradd',
    method: 'post',
    data: data
  })
}

// 修改提交订单
export function updatePuradd(data) {
  return request({
    url: '/his/puradd',
    method: 'put',
    data: data
  })
}

// 删除提交订单
export function delPuradd(purOrderId) {
  return request({
    url: '/his/puradd/' + purOrderId,
    method: 'delete'
  })
}
