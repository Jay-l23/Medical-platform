package com.ruoyi.web.his;

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
import com.ruoyi.his.domain.HisDocters;
import com.ruoyi.his.service.IHisDoctersService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 医生管理Controller
 * 
 * @author ruoyi
 * @date 2022-12-05
 */
@RestController
@RequestMapping("/his/docters")
public class HisDoctersController extends BaseController
{
    @Autowired
    private IHisDoctersService hisDoctersService;

    /**
     * 查询医生管理列表
     */
    @PreAuthorize("@ss.hasPermi('his:docters:list')")
    @GetMapping("/list")
    public TableDataInfo list(HisDocters hisDocters)
    {
        startPage();
        List<HisDocters> list = hisDoctersService.selectHisDoctersList(hisDocters);
        return getDataTable(list);
    }

    /**
     * 导出医生管理列表
     */
    @PreAuthorize("@ss.hasPermi('his:docters:export')")
    @Log(title = "医生管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HisDocters hisDocters)
    {
        List<HisDocters> list = hisDoctersService.selectHisDoctersList(hisDocters);
        ExcelUtil<HisDocters> util = new ExcelUtil<HisDocters>(HisDocters.class);
        util.exportExcel(response, list, "医生管理数据");
    }

    /**
     * 获取医生管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('his:docters:query')")
    @GetMapping(value = "/{dId}")
    public AjaxResult getInfo(@PathVariable("dId") Long dId)
    {
        return success(hisDoctersService.selectHisDoctersByDId(dId));
    }

    /**
     * 新增医生管理
     */
    @PreAuthorize("@ss.hasPermi('his:docters:add')")
    @Log(title = "医生管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HisDocters hisDocters)
    {
        return toAjax(hisDoctersService.insertHisDocters(hisDocters));
    }

    /**
     * 修改医生管理
     */
    @PreAuthorize("@ss.hasPermi('his:docters:edit')")
    @Log(title = "医生管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HisDocters hisDocters)
    {
        return toAjax(hisDoctersService.updateHisDocters(hisDocters));
    }

    /**
     * 删除医生管理
     */
    @PreAuthorize("@ss.hasPermi('his:docters:remove')")
    @Log(title = "医生管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{dIds}")
    public AjaxResult remove(@PathVariable Long[] dIds)
    {
        return toAjax(hisDoctersService.deleteHisDoctersByDIds(dIds));
    }
}
