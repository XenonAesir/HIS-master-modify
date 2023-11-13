package com.xenon.hrs.generate;

import com.xenon.hrs.models.Cashier;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CashierDao
{
    int deleteByPrimaryKey(String cashierId);

    int insert(Cashier record);

    int insertSelective(Cashier record);

    Cashier selectByPrimaryKey(String cashierId);

    int updateByPrimaryKeySelective(Cashier record);

    int updateByPrimaryKey(Cashier record);
}