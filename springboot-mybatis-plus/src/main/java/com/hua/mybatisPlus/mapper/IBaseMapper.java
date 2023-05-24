package com.hua.mybatisPlus.mapper;

import com.hua.mybatisPlus.bean.BaseMyBean;
import com.hua.mybatisPlus.bean.BaseQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IBaseMapper<T extends BaseMyBean> {
    int insert(T bean);

    List<T> findListByParam();
}
