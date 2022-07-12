package com.zr.service.shop.impl;

import com.github.pagehelper.PageHelper;
import com.zr.mapper.shop.CityMapper;
import com.zr.mapper.shop.ProvinceMapper;
import com.zr.service.shop.CityService;
import com.zr.util.RedisUtils;
import com.zr.util.TokenUtil;
import com.zr.vo.shop.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private RedisUtils redisUtils;

    @Resource
    private CityMapper cityMapper;

    @Autowired
    private TokenUtil tokenUtil;

    @Resource
    private ProvinceMapper provinceMapper;

    /**
     * 查询城市
     * @param city
     */
    @Override
    public List<City> list(City city) {
        //分页插件使用，放在接口方法前，只生效一次
        PageHelper.startPage(city.getPageNum(), city.getPageSize());
        return cityMapper.list(city);
    }

    /**
     * 新增城市
     * @param city
     */
    @Override
    public void add(City city) {
        city.setCreateId(tokenUtil.getUserId());
        city.setCreateTime(new Date());
        cityMapper.insertSelective(city);
    }

    @Override
    public void edit(City city) {
        //判断是否有修改
        if(city.getId() != null){
            //修改该城市
            city.setModifyId(tokenUtil.getUserId());
            city.setModifyTime(new Date());
            cityMapper.updateByPrimaryKeySelective(city);
        }
    }

    @Override
    public void del(Long id) {
        //删除该城市
        cityMapper.deleteByPrimaryKey(id);
    }
}
