package com.ruoyi.his.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.his.mapper.HisDeptsMapper;
import com.ruoyi.his.domain.HisDepts;
import com.ruoyi.his.service.IHisDeptsService;

/**
 * 科室管理Service业务层处理
 * 
 * @author lijie
 * @date 2022-12-05
 */
@Service
public class HisDeptsServiceImpl implements IHisDeptsService 
{
    @Autowired
    private HisDeptsMapper hisDeptsMapper;

    /**
     * 查询科室管理
     * 
     * @param deptsId 科室管理主键
     * @return 科室管理
     */
    @Override
    public HisDepts selectHisDeptsByDeptsId(Long deptsId)
    {
        return hisDeptsMapper.selectHisDeptsByDeptsId(deptsId);
    }

    /**
     * 查询科室管理列表
     * 
     * @param hisDepts 科室管理
     * @return 科室管理
     */
    @Override
    public List<HisDepts> selectHisDeptsList(HisDepts hisDepts)
    {
        return hisDeptsMapper.selectHisDeptsList(hisDepts);
    }

    /**
     * 新增科室管理
     * 
     * @param hisDepts 科室管理
     * @return 结果
     */
    @Override
    public int insertHisDepts(HisDepts hisDepts)
    {
        hisDepts.setCreateTime(DateUtils.getNowDate());
        return hisDeptsMapper.insertHisDepts(hisDepts);
    }

    /**
     * 修改科室管理
     * 
     * @param hisDepts 科室管理
     * @return 结果
     */
    @Override
    public int updateHisDepts(HisDepts hisDepts)
    {
        hisDepts.setUpdateTime(DateUtils.getNowDate());
        return hisDeptsMapper.updateHisDepts(hisDepts);
    }

    /**
     * 批量删除科室管理
     * 
     * @param deptsIds 需要删除的科室管理主键
     * @return 结果
     */
    @Override
    public int deleteHisDeptsByDeptsIds(Long[] deptsIds)
    {
        return hisDeptsMapper.deleteHisDeptsByDeptsIds(deptsIds);
    }

    /**
     * 删除科室管理信息
     * 
     * @param deptsId 科室管理主键
     * @return 结果
     */
    @Override
    public int deleteHisDeptsByDeptsId(Long deptsId)
    {
        return hisDeptsMapper.deleteHisDeptsByDeptsId(deptsId);
    }
}
