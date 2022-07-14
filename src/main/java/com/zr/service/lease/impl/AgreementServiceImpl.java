package com.zr.service.lease.impl;

import com.github.pagehelper.PageHelper;
import com.zr.mapper.lease.AgreementMapper;
import com.zr.service.lease.AgreementService;
import com.zr.vo.lease.Agreement;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class AgreementServiceImpl implements AgreementService {

    @Resource
    private AgreementMapper agreementMapper;

    /**
     * 查询合同
     * @param agreement
     * @return
     */
    @Override
    public List<Agreement> list(Agreement agreement) {
        //分页插件使用，放在接口方法前，只生效一次
        PageHelper.startPage(agreement.getPageNum(), agreement.getPageSize());
        return agreementMapper.list(agreement);
    }

    /**
     * 新增合同
     * @param agreement
     */
    @Override
    public void add(Agreement agreement) {
        agreement.setStatus("有效");
        agreement.setCreateId("admin");
        agreement.setCreateTime(new Date());
        agreementMapper.insertSelective(agreement);
    }

    /**
     * 编辑合同
     * @param agreement
     */
    @Override
    public void edit(Agreement agreement) {

        agreementMapper.updateByPrimaryKeySelective(agreement);
    }

    /**
     * 删除合同
     * @param id
     */
    @Override
    public void del(Long id) {
        agreementMapper.deleteByPrimaryKey(id);
    }
}
