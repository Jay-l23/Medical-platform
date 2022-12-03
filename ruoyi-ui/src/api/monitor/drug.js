import request from '@/utils/request'

// 查询药品进销存管理列表
export function listDrug(query) {
  return request({
    url: '/system/drug/list',
    method: 'get',
    params: query
  })
}

// 查询药品进销存管理详细
export function getDrug(drugId) {
  return request({
    url: '/system/drug/' + drugId,
    method: 'get'
  })
}

// 新增药品进销存管理
export function addDrug(data) {
  return request({
    url: '/system/drug',
    method: 'post',
    data: data
  })
}

// 修改药品进销存管理
export function updateDrug(data) {
  return request({
    url: '/system/drug',
    method: 'put',
    data: data
  })
}

// 删除药品进销存管理
export function delDrug(drugId) {
  return request({
    url: '/system/drug/' + drugId,
    method: 'delete'
  })
}
