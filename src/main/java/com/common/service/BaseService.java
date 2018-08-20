package com.common.service;

import com.common.dao.BaseDao;

import java.util.List;

public class BaseService<T> {

    private BaseDao<T> baseDao;

    public BaseDao<T> getBaseDao() {
        return baseDao;
    }

    public void setBaseDao(BaseDao<T> baseDao) {
        this.baseDao = baseDao;
    }

    public int insert(T t){
        return baseDao.insert(t);
    }

    public int update(T t){
        return baseDao.update(t);
    }

    public int delete(T t){
        return baseDao.delete(t);
    }

    public T getByID(Long id){
        return baseDao.queryByID(id);
    }

    public List<T> getList(T t){
        return baseDao.queryList(t);
    }
}
