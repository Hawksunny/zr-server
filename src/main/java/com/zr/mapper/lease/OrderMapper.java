package com.zr.mapper.lease;

import com.zr.vo.lease.Order;
import com.zr.vo.lease.OrderForOrderPage;
import com.zr.vo.table.SimpleOrder;
import com.zr.vo.table.table;

import java.util.Date;
import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<OrderForOrderPage> list(OrderForOrderPage order);

    List<table> countCarNum();

    List<Date> selectTimeByCarName(String carName);

    List<SimpleOrder> listOrder();
}