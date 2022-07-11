package com.zr.service.lease.impl;

import com.zr.mapper.lease.OrderMapper;
import com.zr.service.lease.OrderService;
import com.zr.vo.lease.Order;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;

    @Override
    public List<Order> list(Order order) {
        return orderMapper.list(order);
    }
}
