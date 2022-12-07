package com.ruoyi.his.mapper;

import java.util.List;
import com.ruoyi.his.domain.HisChargedetail;

/**
 * 收费查询Mapper接口
 * 
 * @author ruoyi
 * @date 2022-12-06
 */
public interface HisChargedetailMapper 
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
     * 删除收费查询
     * 
     * @param id 收费查询主键
     * @return 结果
     */
    public int deleteHisChargedetailById(Long id);

    /**
     * 批量删除收费查询
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHisChargedetailByIds(Long[] ids);
}
