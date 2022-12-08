package com.ruoyi.web.his;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.core.domain.entity.SysDictData;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.his.service.IHisPurchaseService;
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
import com.ruoyi.his.domain.HisPurchaseData;
import com.ruoyi.his.service.IHisPurchaseDataService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 订单审核Controller
 *
 * @author ruoyi
 * @date 2022-12-08
 */
@RestController
@RequestMapping("/his/data")
public class HisPurchaseDataController extends BaseController
{
    @Autowired
    private IHisPurchaseDataService hisPurchaseDataService;

    @Autowired
    private IHisPurchaseService hisPurchaseService;
    /**
     * 查询订单审核列表
     */
    @PreAuthorize("@ss.hasPermi('his:Data:list')")
    @GetMapping("/list")
    public TableDataInfo list(HisPurchaseData hisPurchaseData)
    {
        startPage();
        List<HisPurchaseData> list = hisPurchaseDataService.selectHisPurchaseDataList(hisPurchaseData);
        return getDataTable(list);
    }

    /**
     * 导出订单审核列表
     */
    @PreAuthorize("@ss.hasPermi('his:Data:export')")
    @Log(title = "订单审核", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HisPurchaseData hisPurchaseData)
    {
        List<HisPurchaseData> list = hisPurchaseDataService.selectHisPurchaseDataList(hisPurchaseData);
        ExcelUtil<HisPurchaseData> util = new ExcelUtil<HisPurchaseData>(HisPurchaseData.class);
        util.exportExcel(response, list, "订单审核数据");
    }

    /**
     * 获取订单审核详细信息
     */
    @PreAuthorize("@ss.hasPermi('his:Data:query')")
    @GetMapping(value = "/{purOrderId}")
    public AjaxResult getInfo(@PathVariable("purOrderId") String purOrderId)
    {
        return success(hisPurchaseDataService.selectHisPurchaseDataByPurOrderId(purOrderId));
    }

    /**
     * 根据订单编号查询订单具体信息
     * @param dictType
     * @return
     */
//    @GetMapping(value = "/type/{dictType}")
//    public AjaxResult dictType(@PathVariable String dictType)
//    {
//        List<HisPurchaseData> data = hisPurchaseService.selectTypeDataByInfo(dictType);
////        List<SysDictData> data = hisPurchaseService.selectDictDataByType(dictType);
//        if (StringUtils.isNull(data))
//        {
//            data = new ArrayList<HisPurchaseData>();
//        }
//        return success(data);
//    }
    /**
     * 新增订单审核
     */
    @PreAuthorize("@ss.hasPermi('his:Data:add')")
    @Log(title = "订单审核", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HisPurchaseData hisPurchaseData)
    {
        return toAjax(hisPurchaseDataService.insertHisPurchaseData(hisPurchaseData));
    }

    /**
     * 修改订单审核
     */
    @PreAuthorize("@ss.hasPermi('his:Data:edit')")
    @Log(title = "订单审核", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HisPurchaseData hisPurchaseData)
    {
        return toAjax(hisPurchaseDataService.updateHisPurchaseData(hisPurchaseData));
    }

    /**
     * 删除订单审核
     */
    @PreAuthorize("@ss.hasPermi('his:Data:remove')")
    @Log(title = "订单审核", businessType = BusinessType.DELETE)
	@DeleteMapping("/{purOrderIds}")
    public AjaxResult remove(@PathVariable String[] purOrderIds)
    {
        return toAjax(hisPurchaseDataService.deleteHisPurchaseDataByPurOrderIds(purOrderIds));
    }
}
