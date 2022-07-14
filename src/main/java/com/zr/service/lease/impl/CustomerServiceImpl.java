package com.zr.service.lease.impl;
import com.github.pagehelper.PageHelper;
import com.mysql.jdbc.StringUtils;
import com.zr.mapper.lease.CustomerMapper;
import com.zr.service.lease.CustomerService;
import com.zr.util.Md5Util;
import com.zr.vo.lease.Customer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Resource
    private CustomerMapper customerMapper;

    /**
     * 查询客户
     * @param customer
     * @return
     */
    @Override
    public List<Customer> list(Customer customer) {
        //分页插件使用，放在接口方法前，只生效一次
        PageHelper.startPage(customer.getPageNum(), customer.getPageSize());
        return customerMapper.list(customer);
    }

    /**
     * 新增客户
     * @param customer
     */
    @Override
    public void add(Customer customer) {
        //对密码进行加密处理
        customer.setPassword(Md5Util.EncoderByMd5(customer.getPassword()));
        customer.setStatus("正常");
        customer.setCreateId("admin");
        customer.setCreateTime(new Date());
        customerMapper.insertSelective(customer);
    }

    @Transactional
    @Override
    public void edit(Customer customer) {
        //如果存在修改密码，则加密密码
        if(!StringUtils.isNullOrEmpty(customer.getPassword())) {
            customer.setPassword(Md5Util.EncoderByMd5(customer.getPassword()));
        }
        customer.setModifyTime(new Date());
        customerMapper.updateByPrimaryKeySelective(customer);
    }


    @Override
    public void del(Long id) {
        customerMapper.deleteByPrimaryKey(id);
    }
}
