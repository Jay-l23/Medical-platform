package com.ruoyi.his.service;

import java.util.List;
import com.ruoyi.his.domain.HisPurchase;

/**
 * 采购入库Service接口
 * 
 * @author ruoyi
 * @date 2022-12-05
 */
public interface IHisPurchaseService 
{
    /**
     * 查询采购入库
     * 
     * @param purId 采购入库主键
     * @return 采购入库
     */
    public HisPurchase selectHisPurchaseByPurId(String purId);

    /**
     * 查询采购入库列表
     * 
     * @param hisPurchase 采购入库
     * @return 采购入库集合
     */
    public List<HisPurchase> selectHisPurchaseList(HisPurchase hisPurchase);

    /**
     * 新增采购入库
     * 
     * @param hisPurchase 采购入库
     * @return 结果
     */
    public int insertHisPurchase(HisPurchase hisPurchase);

    /**
     * 修改采购入库
     * 
     * @param hisPurchase 采购入库
     * @return 结果
     */
    public int updateHisPurchase(HisPurchase hisPurchase);

    /**
     * 批量删除采购入库
     * 
     * @param purIds 需要删除的采购入库主键集合
     * @return 结果
     */
    public int deleteHisPurchaseByPurIds(String[] purIds);

    /**
     * 删除采购入库信息
     * 
     * @param purId 采购入库主键
     * @return 结果
     */
    public int deleteHisPurchaseByPurId(String purId);
}
