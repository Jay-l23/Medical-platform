import request from '@/utils/request'

// 查询医生信息管理列表
export function listDocters(query) {
  return request({
    url: '/system/docters/list',
    method: 'get',
    params: query
  })
}

// 查询医生信息管理详细
export function getDocters(dId) {
  return request({
    url: '/system/docters/' + dId,
    method: 'get'
  })
}

// 新增医生信息管理
export function addDocters(data) {
  return request({
    url: '/system/docters',
    method: 'post',
    data: data
  })
}

// 修改医生信息管理
export function updateDocters(data) {
  return request({
    url: '/system/docters',
    method: 'put',
    data: data
  })
}

// 删除医生信息管理
export function delDocters(dId) {
  return request({
    url: '/system/docters/' + dId,
    method: 'delete'
  })
}
