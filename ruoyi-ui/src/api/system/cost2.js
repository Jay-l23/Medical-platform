import request from '@/utils/request'

// 查询挂号费用设置列表
export function listCost2(query) {
  return request({
    url: '/system/cost2/list',
    method: 'get',
    params: query
  })
}

// 查询挂号费用设置详细
export function getCost2(regId) {
  return request({
    url: '/system/cost2/' + regId,
    method: 'get'
  })
}

// 新增挂号费用设置
export function addCost2(data) {
  return request({
    url: '/system/cost2',
    method: 'post',
    data: data
  })
}

// 修改挂号费用设置
export function updateCost2(data) {
  return request({
    url: '/system/cost2',
    method: 'put',
    data: data
  })
}

// 删除挂号费用设置
export function delCost2(regId) {
  return request({
    url: '/system/cost2/' + regId,
    method: 'delete'
  })
}
