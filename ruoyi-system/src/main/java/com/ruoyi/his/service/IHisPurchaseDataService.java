package com.ruoyi.his.service;

import java.util.List;
import com.ruoyi.his.domain.HisPurchaseData;

/**
 * 订单审核Service接口
 * 
 * @author ruoyi
 * @date 2022-12-08
 */
public interface IHisPurchaseDataService 
{
    /**
     * 查询订单审核
     * 
     * @param purOrderId 订单审核主键
     * @return 订单审核
     */
    public HisPurchaseData selectHisPurchaseDataByPurOrderId(String purOrderId);

    /**
     * 查询订单审核列表
     * 
     * @param hisPurchaseData 订单审核
     * @return 订单审核集合
     */
    public List<HisPurchaseData> selectHisPurchaseDataList(HisPurchaseData hisPurchaseData);

    /**
     * 新增订单审核
     * 
     * @param hisPurchaseData 订单审核
     * @return 结果
     */
    public int insertHisPurchaseData(HisPurchaseData hisPurchaseData);

    /**
     * 修改订单审核
     * 
     * @param hisPurchaseData 订单审核
     * @return 结果
     */
    public int updateHisPurchaseData(HisPurchaseData hisPurchaseData);

    /**
     * 批量删除订单审核
     * 
     * @param purOrderIds 需要删除的订单审核主键集合
     * @return 结果
     */
    public int deleteHisPurchaseDataByPurOrderIds(String[] purOrderIds);

    /**
     * 删除订单审核信息
     * 
     * @param purOrderId 订单审核主键
     * @return 结果
     */
    public int deleteHisPurchaseDataByPurOrderId(String purOrderId);
}
