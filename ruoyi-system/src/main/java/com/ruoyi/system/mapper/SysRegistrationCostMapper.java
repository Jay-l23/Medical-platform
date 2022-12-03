package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysRegistrationCost;

/**
 * 挂号费用设置Mapper接口
 * 
 * @author 李杰
 * @date 2022-11-04
 */
public interface SysRegistrationCostMapper 
{
    /**
     * 查询挂号费用设置
     * 
     * @param regId 挂号费用设置主键
     * @return 挂号费用设置
     */
    public SysRegistrationCost selectSysRegistrationCostByRegId(Long regId);

    /**
     * 查询挂号费用设置列表
     * 
     * @param sysRegistrationCost 挂号费用设置
     * @return 挂号费用设置集合
     */
    public List<SysRegistrationCost> selectSysRegistrationCostList(SysRegistrationCost sysRegistrationCost);

    /**
     * 新增挂号费用设置
     * 
     * @param sysRegistrationCost 挂号费用设置
     * @return 结果
     */
    public int insertSysRegistrationCost(SysRegistrationCost sysRegistrationCost);

    /**
     * 修改挂号费用设置
     * 
     * @param sysRegistrationCost 挂号费用设置
     * @return 结果
     */
    public int updateSysRegistrationCost(SysRegistrationCost sysRegistrationCost);

    /**
     * 删除挂号费用设置
     * 
     * @param regId 挂号费用设置主键
     * @return 结果
     */
    public int deleteSysRegistrationCostByRegId(Long regId);

    /**
     * 批量删除挂号费用设置
     * 
     * @param regIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysRegistrationCostByRegIds(Long[] regIds);
}
