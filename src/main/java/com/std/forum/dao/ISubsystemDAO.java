package com.std.forum.dao;

import com.std.forum.dao.base.IBaseDAO;
import com.std.forum.domain.Subsystem;

//dao层 
public interface ISubsystemDAO extends IBaseDAO<Subsystem> {
    String NAMESPACE = ISubsystemDAO.class.getName().concat(".");

    public int update(Subsystem data);
}
