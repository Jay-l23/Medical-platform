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
import com.ruoyi.system.domain.SysExamCost;
import com.ruoyi.system.service.ISysExamCostService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 检查费用Controller
 * 
 * @author 李杰
 * @date 2022-11-04
 */
@RestController
@RequestMapping("/system/cost")
public class SysExamCostController extends BaseController
{
    @Autowired
    private ISysExamCostService sysExamCostService;

    /**
     * 查询检查费用列表
     */
    @PreAuthorize("@ss.hasPermi('system:cost:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysExamCost sysExamCost)
    {
        startPage();
        List<SysExamCost> list = sysExamCostService.selectSysExamCostList(sysExamCost);
        return getDataTable(list);
    }

    /**
     * 导出检查费用列表
     */

    @PreAuthorize("@ss.hasPermi('system:cost:export')")
    @Log(title = "检查费用", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysExamCost sysExamCost)
    {
        List<SysExamCost> list = sysExamCostService.selectSysExamCostList(sysExamCost);
        ExcelUtil<SysExamCost> util = new ExcelUtil<SysExamCost>(SysExamCost.class);
        util.exportExcel(response, list, "检查费用数据");
    }

    /**
     * 获取检查费用详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:cost:query')")
    @GetMapping(value = "/{examId}")
    public AjaxResult getInfo(@PathVariable("examId") Long examId)
    {
        return success(sysExamCostService.selectSysExamCostByExamId(examId));
    }

    /**
     * 新增检查费用
     */
    @PreAuthorize("@ss.hasPermi('system:cost:add')")
    @Log(title = "检查费用", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysExamCost sysExamCost)
    {
        return toAjax(sysExamCostService.insertSysExamCost(sysExamCost));
    }

    /**
     * 修改检查费用
     */
    @PreAuthorize("@ss.hasPermi('system:cost:edit')")
    @Log(title = "检查费用", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysExamCost sysExamCost)
    {
        return toAjax(sysExamCostService.updateSysExamCost(sysExamCost));
    }

    /**
     * 删除检查费用
     */
    @PreAuthorize("@ss.hasPermi('system:cost:remove')")
    @Log(title = "检查费用", businessType = BusinessType.DELETE)
	@DeleteMapping("/{examIds}")
    public AjaxResult remove(@PathVariable Long[] examIds)
    {
        return toAjax(sysExamCostService.deleteSysExamCostByExamIds(examIds));
    }
}
