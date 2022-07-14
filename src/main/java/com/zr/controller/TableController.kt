package com.zr.controller

import com.alibaba.fastjson.JSON
import com.zr.service.table.Impl.TableServerImpl

import com.zr.util.Result
import com.zr.vo.table.CarDates
import com.zr.vo.table.SimpleOrder
import com.zr.vo.table.TimeRange
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.text.DateFormat
import java.util.*

@RestController
@RequestMapping("/table")
class TableController {
    private var timeRange:TimeRange?= null
    private val dateFormat = DateFormat.getDateInstance()

    @Autowired
    val tableService: TableServerImpl?=null
    @RequestMapping("/countCarNum")
    fun countCarNum():String{
        val carDatesList = mutableListOf<CarDates>();
        val result=tableService?.countCarNum()
        if(result!=null){
            for(table in result){
               val carDates = CarDates()
                carDates.carname = table.carname
                carDates.timeList = tableService?.selectTimeByCarName(table.carname)
                //carDates.num = table.num

               if(timeRange!=null){
                   carDates.num = getCarNum(carDates.timeList,timeRange?.startTime,timeRange?.endTime)
                   println(":啊啊啊${carDates.num}")
               }else {
                   carDates.num = table.num
               }
             carDatesList?.add(carDates)
            }

        }
        timeRange = null
        return JSON.toJSONString(Result(true,"查询成功",carDatesList))
    }

    @SinceKotlin("1.1")
    public inline fun <T> mutableListOf(): MutableList<T> = ArrayList()

    @RequestMapping("/submitTime")
    fun submitTime(@RequestBody tr:TimeRange?):String{

        timeRange = tr
        println(":成功了$timeRange")
        return JSON.toJSONString(Result(true,"提交成功",null))
    }

    fun getCarNum(dateList:List<Date>,startTime:Date?,endTime:Date?):Int{
        var result = 0
        for( date in dateList){
            if(date.compareTo(startTime)>=0 && date.compareTo(endTime)<=0){
                result++
            }
        }
        return result
    }
    @RequestMapping("/listOrder")
    fun listOrder():String{
        val orderList = tableService?.listOrder()
         val result = selectOrderByTime(orderList,timeRange)
        return JSON.toJSONString(Result(true,"查询成功",result))
    }

    fun selectOrderByTime(orderList:List<SimpleOrder>?,timeRange: TimeRange?):List<SimpleOrder>?{
        val result = mutableListOf<SimpleOrder>()
       if(timeRange!=null){
           if(orderList!=null) {
               for(order in orderList){
                   if(order.orderTime.compareTo(timeRange?.startTime)>=0 && order.orderTime.compareTo(timeRange?.endTime)<=0){
                       result.add(order)
                   }
               }
               return result
           }
       }
       return orderList
    }



}



