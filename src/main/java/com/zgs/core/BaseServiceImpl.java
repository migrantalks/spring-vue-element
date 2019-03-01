package com.zgs.core;

import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Condition;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * 基于通用MyBatis Mapper插件的Service接口的实现
 * @author
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {

    @Autowired
    protected BaseMapper<T> mapper;

    private Class<T> modelClass;// 当前泛型真实类型的Class

    public BaseServiceImpl() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        modelClass = (Class<T>) pt.getActualTypeArguments()[0];
    }

    @Override
    public void insert(T model) {
        mapper.insertSelective(model);
    }

    @Override
    public void deleteById(Long id) {
        mapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(T model) {
        mapper.updateByPrimaryKeySelective(model);
    }

    @Override
    public T selectById(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<T> selectByCondition(Condition condition) {
        return mapper.selectByCondition(condition);
    }

    @Override

    public List<T> selectAll() {
        return mapper.selectAll();
    }
    @Override
    public List<T> select(T t) {return mapper.select(t);}
}
