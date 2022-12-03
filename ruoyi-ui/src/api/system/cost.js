import request from '@/utils/request'

// 查询检查费用列表
export function listCost(query) {
  return request({
    url: '/system/cost/list',
    method: 'get',
    params: query
  })
}

// 查询检查费用详细
export function getCost(examId) {
  return request({
    url: '/system/cost/' + examId,
    method: 'get'
  })
}

// 新增检查费用
export function addCost(data) {
  return request({
    url: '/system/cost',
    method: 'post',
    data: data
  })
}

// 修改检查费用
export function updateCost(data) {
  return request({
    url: '/system/cost',
    method: 'put',
    data: data
  })
}

// 删除检查费用
export function delCost(examId) {
  return request({
    url: '/system/cost/' + examId,
    method: 'delete'
  })
}
