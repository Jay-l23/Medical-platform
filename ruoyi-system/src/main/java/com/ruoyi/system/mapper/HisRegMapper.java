package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.HisReg;

/**
 * 挂号列表Mapper接口
 * 
 * @author lijie
 * @date 2022-12-03
 */
public interface HisRegMapper 
{
    /**
     * 查询挂号列表
     * 
     * @param regId 挂号列表主键
     * @return 挂号列表
     */
    public HisReg selectHisRegByRegId(Long regId);

    /**
     * 查询挂号列表列表
     * 
     * @param hisReg 挂号列表
     * @return 挂号列表集合
     */
    public List<HisReg> selectHisRegList(HisReg hisReg);

    /**
     * 新增挂号列表
     * 
     * @param hisReg 挂号列表
     * @return 结果
     */
    public int insertHisReg(HisReg hisReg);

    /**
     * 修改挂号列表
     * 
     * @param hisReg 挂号列表
     * @return 结果
     */
    public int updateHisReg(HisReg hisReg);

    /**
     * 删除挂号列表
     * 
     * @param regId 挂号列表主键
     * @return 结果
     */
    public int deleteHisRegByRegId(Long regId);

    /**
     * 批量删除挂号列表
     * 
     * @param regIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHisRegByRegIds(Long[] regIds);
}
