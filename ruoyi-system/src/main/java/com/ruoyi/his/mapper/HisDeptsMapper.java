package com.ruoyi.his.mapper;

import java.util.List;
import com.ruoyi.his.domain.HisDepts;

/**
 * 科室管理Mapper接口
 * 
 * @author lijie
 * @date 2022-12-05
 */
public interface HisDeptsMapper 
{
    /**
     * 查询科室管理
     * 
     * @param deptsId 科室管理主键
     * @return 科室管理
     */
    public HisDepts selectHisDeptsByDeptsId(Long deptsId);

    /**
     * 查询科室管理列表
     * 
     * @param hisDepts 科室管理
     * @return 科室管理集合
     */
    public List<HisDepts> selectHisDeptsList(HisDepts hisDepts);

    /**
     * 新增科室管理
     * 
     * @param hisDepts 科室管理
     * @return 结果
     */
    public int insertHisDepts(HisDepts hisDepts);

    /**
     * 修改科室管理
     * 
     * @param hisDepts 科室管理
     * @return 结果
     */
    public int updateHisDepts(HisDepts hisDepts);

    /**
     * 删除科室管理
     * 
     * @param deptsId 科室管理主键
     * @return 结果
     */
    public int deleteHisDeptsByDeptsId(Long deptsId);

    /**
     * 批量删除科室管理
     * 
     * @param deptsIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHisDeptsByDeptsIds(Long[] deptsIds);
}
