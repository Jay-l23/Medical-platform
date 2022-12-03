import request from '@/utils/request'

// 查询挂号列表列表
export function listReg(query) {
  return request({
    url: '/system/reg/list',
    method: 'get',
    params: query
  })
}

// 查询挂号列表详细
export function getReg(regId) {
  return request({
    url: '/system/reg/' + regId,
    method: 'get'
  })
}

// 新增挂号列表
export function addReg(data) {
  return request({
    url: '/system/reg',
    method: 'post',
    data: data
  })
}

// 修改挂号列表
export function updateReg(data) {
  return request({
    url: '/system/reg',
    method: 'put',
    data: data
  })
}

// 删除挂号列表
export function delReg(regId) {
  return request({
    url: '/system/reg/' + regId,
    method: 'delete'
  })
}
