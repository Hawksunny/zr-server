package com.zr.service.table.Impl

import com.zr.mapper.lease.OrderMapper
import com.zr.service.table.TableServer
import com.zr.vo.table.SimpleOrder
import com.zr.vo.table.table
import jdk.nashorn.internal.objects.Global.println
import org.springframework.stereotype.Service

import java.util.*
import javax.annotation.Resource

@Service

class TableServerImpl: TableServer {
    @Resource
    val orderMapper:OrderMapper?=null
    override fun countCarNum(): MutableList<table>? {
       val tableList = orderMapper?.countCarNum()
      // println(selectTimeByCarName("奥迪A4L"))
        return tableList
    }

    override fun selectTimeByCarName(carName: String?): MutableList<Date>?{
        return orderMapper?.selectTimeByCarName(carName)
    }

    override fun listOrder(): MutableList<SimpleOrder>? {
        return orderMapper?.listOrder()
    }
}