package com.nowcoder.community.dao;

import org.springframework.stereotype.Repository;

@Repository("alphaHibernate")
public class AlphaDaoHibernateimpl implements AlphaDao {
    @Override
    public String select(){
        return "Hibernate";
    }
}
