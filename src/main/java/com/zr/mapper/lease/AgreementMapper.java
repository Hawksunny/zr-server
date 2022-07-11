package com.zr.mapper.lease;

import com.zr.vo.lease.Agreement;

public interface AgreementMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Agreement record);

    int insertSelective(Agreement record);

    Agreement selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Agreement record);

    int updateByPrimaryKeyWithBLOBs(Agreement record);

    int updateByPrimaryKey(Agreement record);
}