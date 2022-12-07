import request from '@/utils/request'

// 查询收费查询列表
export function listChargedetail(query) {
  return request({
    url: '/his/chargedetail/list',
    method: 'get',
    params: query
  })
}

// 查询收费查询详细
export function getChargedetail(id) {
  return request({
    url: '/his/chargedetail/' + id,
    method: 'get'
  })
}

// 新增收费查询
export function addChargedetail(data) {
  return request({
    url: '/his/chargedetail',
    method: 'post',
    data: data
  })
}

// 修改收费查询
export function updateChargedetail(data) {
  return request({
    url: '/his/chargedetail',
    method: 'put',
    data: data
  })
}

// 删除收费查询
export function delChargedetail(id) {
  return request({
    url: '/his/chargedetail/' + id,
    method: 'delete'
  })
}
