import request from '@/utils/request'

// 查询订单审核列表
export function listData(query) {
  return request({
    url: '/his/Data/list',
    method: 'get',
    params: query
  })
}

// 查询订单审核详细
export function getData(purOrderId) {
  return request({
    url: '/his/data/' + purOrderId,
    method: 'get'
  })
}

// 新增订单审核
export function addData(data) {
  return request({
    url: '/his/Data',
    method: 'post',
    data: data
  })
}

// 修改订单审核
export function updateData(data) {
  return request({
    url: '/his/Data',
    method: 'put',
    data: data
  })
}

// 删除订单审核
export function delData(purOrderId) {
  return request({
    url: '/his/Data/' + purOrderId,
    method: 'delete'
  })
}
