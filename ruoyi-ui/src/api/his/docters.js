import request from '@/utils/request'

// 查询医生管理列表
export function listDocters(query) {
  return request({
    url: '/his/docters/list',
    method: 'get',
    params: query
  })
}

// 查询医生管理详细
export function getDocters(dId) {
  return request({
    url: '/his/docters/' + dId,
    method: 'get'
  })
}

// 新增医生管理
export function addDocters(data) {
  return request({
    url: '/his/docters',
    method: 'post',
    data: data
  })
}

// 修改医生管理
export function updateDocters(data) {
  return request({
    url: '/his/docters',
    method: 'put',
    data: data
  })
}

// 删除医生管理
export function delDocters(dId) {
  return request({
    url: '/his/docters/' + dId,
    method: 'delete'
  })
}
