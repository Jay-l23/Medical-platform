package com.ruoyi.his.service;

import java.util.List;
import com.ruoyi.his.domain.HisChargedetail;

/**
 * 收费查询Service接口
 * 
 * @author ruoyi
 * @date 2022-12-06
 */
public interface IHisChargedetailService 
{
    /**
     * 查询收费查询
     * 
     * @param id 收费查询主键
     * @return 收费查询
     */
    public HisChargedetail selectHisChargedetailById(Long id);

    /**
     * 查询收费查询列表
     * 
     * @param hisChargedetail 收费查询
     * @return 收费查询集合
     */
    public List<HisChargedetail> selectHisChargedetailList(HisChargedetail hisChargedetail);

    /**
     * 新增收费查询
     * 
     * @param hisChargedetail 收费查询
     * @return 结果
     */
    public int insertHisChargedetail(HisChargedetail hisChargedetail);

    /**
     * 修改收费查询
     * 
     * @param hisChargedetail 收费查询
     * @return 结果
     */
    public int updateHisChargedetail(HisChargedetail hisChargedetail);

    /**
     * 批量删除收费查询
     * 
     * @param ids 需要删除的收费查询主键集合
     * @return 结果
     */
    public int deleteHisChargedetailByIds(Long[] ids);

    /**
     * 删除收费查询信息
     * 
     * @param id 收费查询主键
     * @return 结果
     */
    public int deleteHisChargedetailById(Long id);
}
