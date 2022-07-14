package com.zr.controller.lease;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.zr.service.lease.OrderService;
import com.zr.util.AjaxResult;
import com.zr.vo.lease.OrderForOrderPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 订单操作类
 */
@RestController
@RequestMapping("/lease/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 查询订单列表
     * @param order
     * @return
     */
    @RequestMapping("/list")
    public String list(@RequestBody OrderForOrderPage order) {
        List<OrderForOrderPage> orderList = orderService.list(order);
        PageInfo<OrderForOrderPage> pageInfo = new PageInfo<>(orderList);

        return JSON.toJSONString(AjaxResult.success("查询成功", pageInfo));
    }

}
