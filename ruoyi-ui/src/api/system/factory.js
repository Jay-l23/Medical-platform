import request from '@/utils/request'

// 查询生产厂商管理列表
export function listFactory(query) {
  return request({
    url: '/system/factory/list',
    method: 'get',
    params: query
  })
}

// 查询生产厂商管理详细
export function getFactory(facId) {
  return request({
    url: '/system/factory/' + facId,
    method: 'get'
  })
}

// 新增生产厂商管理
export function addFactory(data) {
  return request({
    url: '/system/factory',
    method: 'post',
    data: data
  })
}

// 修改生产厂商管理
export function updateFactory(data) {
  return request({
    url: '/system/factory',
    method: 'put',
    data: data
  })
}

// 删除生产厂商管理
export function delFactory(facId) {
  return request({
    url: '/system/factory/' + facId,
    method: 'delete'
  })
}
