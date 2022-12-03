import request from '@/utils/request'

// 查询供应商维护列表
export function listSupplier(query) {
  return request({
    url: '/system/supplier/list',
    method: 'get',
    params: query
  })
}

// 查询供应商维护详细
export function getSupplier(supId) {
  return request({
    url: '/system/supplier/' + supId,
    method: 'get'
  })
}

// 新增供应商维护
export function addSupplier(data) {
  return request({
    url: '/system/supplier',
    method: 'post',
    data: data
  })
}

// 修改供应商维护
export function updateSupplier(data) {
  return request({
    url: '/system/supplier',
    method: 'put',
    data: data
  })
}

// 删除供应商维护
export function delSupplier(supId) {
  return request({
    url: '/system/supplier/' + supId,
    method: 'delete'
  })
}
