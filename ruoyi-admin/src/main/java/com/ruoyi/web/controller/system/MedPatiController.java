package com.ruoyi.web.controller.system;

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
import com.ruoyi.system.domain.MedPati;
import com.ruoyi.system.service.IMedPatiService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 患者库Controller
 *
 * @author ruoyi
 * @date 2022-11-04
 */
@RestController
@RequestMapping("/system/pati")
public class MedPatiController extends BaseController
{
    @Autowired
    private IMedPatiService medPatiService;

    /**
     * 查询患者库列表
     */
    @PreAuthorize("@ss.hasPermi('system:pati:list')")
    @GetMapping("/list")
    public TableDataInfo list(MedPati medPati)
    {
        startPage();
        List<MedPati> list = medPatiService.selectMedPatiList(medPati);
        return getDataTable(list);
    }

    /**
     * 导出患者库列表
     */
    @PreAuthorize("@ss.hasPermi('system:pati:export')")
    @Log(title = "患者库", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MedPati medPati)
    {
        List<MedPati> list = medPatiService.selectMedPatiList(medPati);
        ExcelUtil<MedPati> util = new ExcelUtil<MedPati>(MedPati.class);
        util.exportExcel(response, list, "患者库数据");
    }

    /**
     * 获取患者库详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:pati:query')")
    @GetMapping(value = "/{patiId}")
    public AjaxResult getInfo(@PathVariable("patiId") Long patiId)
    {
        return success(medPatiService.selectMedPatiByPatiId(patiId));
    }

    /**
     * 新增患者库
     */
    @PreAuthorize("@ss.hasPermi('system:pati:add')")
    @Log(title = "患者库", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MedPati medPati)
    {
        return toAjax(medPatiService.insertMedPati(medPati));
    }

    /**
     * 修改患者库
     */
    @PreAuthorize("@ss.hasPermi('system:pati:edit')")
    @Log(title = "患者库", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MedPati medPati)
    {
        return toAjax(medPatiService.updateMedPati(medPati));
    }

    /**
     * 删除患者库
     */
    @PreAuthorize("@ss.hasPermi('system:pati:remove')")
    @Log(title = "患者库", businessType = BusinessType.DELETE)
	@DeleteMapping("/{patiIds}")
    public AjaxResult remove(@PathVariable Long[] patiIds)
    {
        return toAjax(medPatiService.deleteMedPatiByPatiIds(patiIds));
    }
}
