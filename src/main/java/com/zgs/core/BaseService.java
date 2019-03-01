package com.zgs.core;

import tk.mybatis.mapper.entity.Condition;

import java.util.List;

/**
 * Service 层 基础接口，其他Service 接口 请继承该接口
 * @author zgs
 */
public interface BaseService<T> {

    /**
     * 保存
     * @param model
     */
    void insert(T model);
    /**
     * 通过主鍵刪除
     * @param id
     */
    void deleteById(Long id);
    /**
     * 更新
     * @param model
     */
    void update(T model);//更新

    /**
     * 通过ID查找
     * @param id
     * @return
     */
    T selectById(Long id);//通过ID查找

    /**
     * 根据条件查找
     * @param condition
     * @return
     */
    List<T> selectByCondition(Condition condition);

    /**
     * 获取所有
     * @return
     */
    List<T> selectAll();

    List<T> select(T t);
}
