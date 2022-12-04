import request from '@/utils/request'

// 查询患者库列表
export function listPati(query) {
  return request({
    url: '/his/addpati/list',
    method: 'get',
    params: query
  })
// }
//
// // 查询患者库详细
// export function getPati(patiId) {
//   return request({
//     url: '/system/pati/' + patiId,
//     method: 'get'
//   })
// }
//
// // 新增患者库
// export function addPati(data) {
//   return request({
//     url: '/system/pati',
//     method: 'post',
//     data: data
//   })
// }
//
// // 修改患者库
// export function updatePati(data) {
//   return request({
//     url: '/system/pati',
//     method: 'put',
//     data: data
//   })
// }
//
// // 删除患者库
// export function delPati(patiId) {
//   return request({
//     url: '/system/pati/' + patiId,
//     method: 'delete'
//   })
}
