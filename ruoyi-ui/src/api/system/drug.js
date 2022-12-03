import request from '@/utils/request'

// 查询药品信息维护列表
export function listDrug(query) {
  return request({
    url: '/system/drug/list',
    method: 'get',
    params: query
  })
}

// 查询药品信息维护详细
export function getDrug(drugId) {
  return request({
    url: '/system/drug/' + drugId,
    method: 'get'
  })
}

// 新增药品信息维护
export function addDrug(data) {
  return request({
    url: '/system/drug',
    method: 'post',
    data: data
  })
}

// 修改药品信息维护
export function updateDrug(data) {
  return request({
    url: '/system/drug',
    method: 'put',
    data: data
  })
}

// 删除药品信息维护
export function delDrug(drugId) {
  return request({
    url: '/system/drug/' + drugId,
    method: 'delete'
  })
}
