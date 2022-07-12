package com.zr.service.lease;

import com.zr.vo.lease.Order;
import com.zr.vo.lease.OrderForOrderPage;

import java.util.List;

public interface OrderService {
    List<OrderForOrderPage> list(OrderForOrderPage order);
}
