package com.zr.service.table;

import com.zr.vo.table.SimpleOrder;
import com.zr.vo.table.table;


import java.util.Date;
import java.util.List;

public interface TableServer {
    List<table> countCarNum();
    List<Date> selectTimeByCarName(String carName);


    List<SimpleOrder> listOrder();
}
