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
import com.ruoyi.system.domain.HisReg;
import com.ruoyi.system.service.IHisRegService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 挂号列表Controller
 * 
 * @author lijie
 * @date 2022-12-03
 */
@RestController
@RequestMapping("/system/reg")
public class HisRegController extends BaseController
{
    @Autowired
    private IHisRegService hisRegService;

    /**
     * 查询挂号列表列表
     */
    @PreAuthorize("@ss.hasPermi('system:reg:list')")
    @GetMapping("/list")
    public TableDataInfo list(HisReg hisReg)
    {
        startPage();
        List<HisReg> list = hisRegService.selectHisRegList(hisReg);
        return getDataTable(list);
    }

    /**
     * 导出挂号列表列表
     */
    @PreAuthorize("@ss.hasPermi('system:reg:export')")
    @Log(title = "挂号列表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HisReg hisReg)
    {
        List<HisReg> list = hisRegService.selectHisRegList(hisReg);
        ExcelUtil<HisReg> util = new ExcelUtil<HisReg>(HisReg.class);
        util.exportExcel(response, list, "挂号列表数据");
    }

    /**
     * 获取挂号列表详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:reg:query')")
    @GetMapping(value = "/{regId}")
    public AjaxResult getInfo(@PathVariable("regId") Long regId)
    {
        return success(hisRegService.selectHisRegByRegId(regId));
    }

    /**
     * 新增挂号列表
     */
    @PreAuthorize("@ss.hasPermi('system:reg:add')")
    @Log(title = "挂号列表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HisReg hisReg)
    {
        return toAjax(hisRegService.insertHisReg(hisReg));
    }

    /**
     * 修改挂号列表
     */
    @PreAuthorize("@ss.hasPermi('system:reg:edit')")
    @Log(title = "挂号列表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HisReg hisReg)
    {
        return toAjax(hisRegService.updateHisReg(hisReg));
    }

    /**
     * 删除挂号列表
     */
    @PreAuthorize("@ss.hasPermi('system:reg:remove')")
    @Log(title = "挂号列表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{regIds}")
    public AjaxResult remove(@PathVariable Long[] regIds)
    {
        return toAjax(hisRegService.deleteHisRegByRegIds(regIds));
    }
}
