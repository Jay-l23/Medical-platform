package com.ruoyi.his.mapper;

import java.util.List;
import com.ruoyi.his.domain.HisPur;

/**
 * 提交订单Mapper接口
 * 
 * @author ruoyi
 * @date 2022-12-06
 */
public interface HisPurMapper 
{
    /**
     * 查询提交订单
     * 
     * @param purOrderId 提交订单主键
     * @return 提交订单
     */
    public HisPur selectHisPurByPurOrderId(String purOrderId);

    /**
     * 查询提交订单列表
     * 
     * @param hisPur 提交订单
     * @return 提交订单集合
     */
    public List<HisPur> selectHisPurList(HisPur hisPur);

    /**
     * 新增提交订单
     * 
     * @param hisPur 提交订单
     * @return 结果
     */
    public int insertHisPur(HisPur hisPur);

    /**
     * 修改提交订单
     * 
     * @param hisPur 提交订单
     * @return 结果
     */
    public int updateHisPur(HisPur hisPur);

    /**
     * 删除提交订单
     * 
     * @param purOrderId 提交订单主键
     * @return 结果
     */
    public int deleteHisPurByPurOrderId(String purOrderId);

    /**
     * 批量删除提交订单
     * 
     * @param purOrderIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHisPurByPurOrderIds(String[] purOrderIds);
}
