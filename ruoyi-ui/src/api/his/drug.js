import request from '@/utils/request'

// 查询药品订单关联测试列表
export function listDrug(query) {
  return request({
    url: '/his/drug/list',
    method: 'get',
    params: query
  })
}

// 查询药品订单关联测试详细
export function getDrug(purOrderId) {
  return request({
    url: '/his/drug/' + purOrderId,
    method: 'get'
  })
}

// 新增药品订单关联测试
export function addDrug(data) {
  return request({
    url: '/his/drug',
    method: 'post',
    data: data
  })
}

// 修改药品订单关联测试
export function updateDrug(data) {
  return request({
    url: '/his/drug',
    method: 'put',
    data: data
  })
}

// 删除药品订单关联测试
export function delDrug(purOrderId) {
  return request({
    url: '/his/drug/' + purOrderId,
    method: 'delete'
  })
}
