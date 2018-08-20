package com.common.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.util.List;

public abstract class BaseDao<T> {

    public Logger logger = LoggerFactory.getLogger(this.getClass());
    protected String namespace;
    protected SqlSessionTemplate sqlSessionTemplate;

    public int insert(T t){
        loggerSession();
        return getSqlSessionTemplate().insert(getNamespace()+".insert", t);
    }

    public int update(T t){
        loggerSession();
        return getSqlSessionTemplate().update(getNamespace()+".update", t);
    }

    public int delete(T t){
        loggerSession();
        return getSqlSessionTemplate().delete(getNamespace()+".delete", t);
    }

    public T queryByID(Long id){
        loggerSession();
        return getSqlSessionTemplate().selectOne(getNamespace()+".queryByID", id);
    }

    public List<T> queryList(T t){
        loggerSession();
        return getSqlSessionTemplate().selectList(getNamespace() + ".queryList", t);
    }


    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public SqlSessionTemplate getSqlSessionTemplate() {
        return sqlSessionTemplate;
    }

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    private void loggerSession(){
        SqlSessionTemplate sqlSessionTemplate = getSqlSessionTemplate();
        Connection conn = sqlSessionTemplate.getConnection();
        logger.info("sqlSessionTemplate:{}, session:{}", sqlSessionTemplate, conn);
    }
}
