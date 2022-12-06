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
import com.ruoyi.his.domain.HisPur;
import com.ruoyi.his.service.IHisPurService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 提交订单Controller
 * 
 * @author ruoyi
 * @date 2022-12-06
 */
@RestController
@RequestMapping("/his/puradd")
public class HisPurController extends BaseController
{
    @Autowired
    private IHisPurService hisPurService;

    /**
     * 查询提交订单列表
     */
    @PreAuthorize("@ss.hasPermi('his:puradd:list')")
    @GetMapping("/list")
    public TableDataInfo list(HisPur hisPur)
    {
        startPage();
        List<HisPur> list = hisPurService.selectHisPurList(hisPur);
        return getDataTable(list);
    }

    /**
     * 导出提交订单列表
     */
    @PreAuthorize("@ss.hasPermi('his:puradd:export')")
    @Log(title = "提交订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HisPur hisPur)
    {
        List<HisPur> list = hisPurService.selectHisPurList(hisPur);
        ExcelUtil<HisPur> util = new ExcelUtil<HisPur>(HisPur.class);
        util.exportExcel(response, list, "提交订单数据");
    }

    /**
     * 获取提交订单详细信息
     */
    @PreAuthorize("@ss.hasPermi('his:puradd:query')")
    @GetMapping(value = "/{purOrderId}")
    public AjaxResult getInfo(@PathVariable("purOrderId") String purOrderId)
    {
        return success(hisPurService.selectHisPurByPurOrderId(purOrderId));
    }

    /**
     * 新增提交订单
     */
    @PreAuthorize("@ss.hasPermi('his:puradd:add')")
    @Log(title = "提交订单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HisPur hisPur)
    {
        return toAjax(hisPurService.insertHisPur(hisPur));
    }

    /**
     * 修改提交订单
     */
    @PreAuthorize("@ss.hasPermi('his:puradd:edit')")
    @Log(title = "提交订单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HisPur hisPur)
    {
        return toAjax(hisPurService.updateHisPur(hisPur));
    }

    /**
     * 删除提交订单
     */
    @PreAuthorize("@ss.hasPermi('his:puradd:remove')")
    @Log(title = "提交订单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{purOrderIds}")
    public AjaxResult remove(@PathVariable String[] purOrderIds)
    {
        return toAjax(hisPurService.deleteHisPurByPurOrderIds(purOrderIds));
    }
}
