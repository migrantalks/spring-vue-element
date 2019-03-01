package com.zgs.core;

import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.ExampleMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

/**
 * 定制版MyBatis Mapper插件接口，如需其他接口参考官方文档自行添加。
 * @author zgs
 */
public interface BaseMapper<T>
        extends
        tk.mybatis.mapper.common.BaseMapper<T>,
        ConditionMapper<T>,
        IdsMapper<T>,
        ExampleMapper,
        InsertListMapper<T> {
}
