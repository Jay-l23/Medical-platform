import request from '@/utils/request'

// 查询科室管理列表
export function listDepts(query) {
  return request({
    url: '/his/depts/list',
    method: 'get',
    params: query
  })
}

// 查询科室管理详细
export function getDepts(deptsId) {
  return request({
    url: '/his/depts/' + deptsId,
    method: 'get'
  })
}

// 新增科室管理
export function addDepts(data) {
  return request({
    url: '/his/depts',
    method: 'post',
    data: data
  })
}

// 修改科室管理
export function updateDepts(data) {
  return request({
    url: '/his/depts',
    method: 'put',
    data: data
  })
}

// 删除科室管理
export function delDepts(deptsId) {
  return request({
    url: '/his/depts/' + deptsId,
    method: 'delete'
  })
}
