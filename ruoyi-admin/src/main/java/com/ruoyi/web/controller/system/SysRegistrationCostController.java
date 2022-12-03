package com.ruoyi.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SysRegistrationCost;
import com.ruoyi.system.service.ISysRegistrationCostService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 挂号费用设置Controller
 * 
 * @author 李杰
 * @date 2022-11-04
 */
@RestController
@RequestMapping("/system/cost2")
public class SysRegistrationCostController extends BaseController
{
    @Autowired
    private ISysRegistrationCostService sysRegistrationCostService;

    /**
     * 查询挂号费用设置列表
     */
    @PreAuthorize("@ss.hasPermi('system:cost2:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysRegistrationCost sysRegistrationCost)
    {
        startPage();
        List<SysRegistrationCost> list = sysRegistrationCostService.selectSysRegistrationCostList(sysRegistrationCost);
        return getDataTable(list);
    }

    /**
     * 导出挂号费用设置列表
     */
    @PreAuthorize("@ss.hasPermi('system:cost2:export')")
    @Log(title = "挂号费用设置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysRegistrationCost sysRegistrationCost)
    {
        List<SysRegistrationCost> list = sysRegistrationCostService.selectSysRegistrationCostList(sysRegistrationCost);
        ExcelUtil<SysRegistrationCost> util = new ExcelUtil<SysRegistrationCost>(SysRegistrationCost.class);
        util.exportExcel(response, list, "挂号费用设置数据");
    }

    /**
     * 获取挂号费用设置详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:cost2:query')")
    @GetMapping(value = "/{regId}")
    public AjaxResult getInfo(@PathVariable("regId") Long regId)
    {
        return success(sysRegistrationCostService.selectSysRegistrationCostByRegId(regId));
    }

    /**
     * 新增挂号费用设置
     */
    @PreAuthorize("@ss.hasPermi('system:cost2:add')")
    @Log(title = "挂号费用设置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysRegistrationCost sysRegistrationCost)
    {
        return toAjax(sysRegistrationCostService.insertSysRegistrationCost(sysRegistrationCost));
    }

    /**
     * 修改挂号费用设置
     */
    @PreAuthorize("@ss.hasPermi('system:cost2:edit')")
    @Log(title = "挂号费用设置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysRegistrationCost sysRegistrationCost)
    {
        return toAjax(sysRegistrationCostService.updateSysRegistrationCost(sysRegistrationCost));
    }

    /**
     * 删除挂号费用设置
     */
    @PreAuthorize("@ss.hasPermi('system:cost2:remove')")
    @Log(title = "挂号费用设置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{regIds}")
    public AjaxResult remove(@PathVariable Long[] regIds)
    {
        return toAjax(sysRegistrationCostService.deleteSysRegistrationCostByRegIds(regIds));
    }
}
