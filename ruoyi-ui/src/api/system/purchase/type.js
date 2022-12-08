import request from '@/utils/request'

// 查询采购入库列表
export function listPurchase(query) {
  return request({
    url: '/system/purchase/type/list',
    method: 'get',
    params: query
  })
}

// 查询采购入库详细
export function getPurchase(purOrderId) {
  return request({
    url: '/system/purchase/type/' + purOrderId,
    method: 'get'
  })
}

// 新增采购入库
export function addPurchase(data) {
  return request({
    url: '/system/purchase',
    method: 'post',
    data: data
  })
}

// 修改采购入库
export function updatePurchase(data) {
  return request({
    url: '/system/purchase',
    method: 'put',
    data: data
  })
}

// 删除采购入库
export function delPurchase(purOrderId) {
  return request({
    url: '/system/purchase/' + purOrderId,
    method: 'delete'
  })
}
