package com.std.forum.bo;

import java.util.List;

import com.std.forum.bo.base.IPaginableBO;
import com.std.forum.domain.Subsystem;



//CHECK ��鲢��ע�� 
public interface ISubsystemBO extends IPaginableBO<Subsystem> {


	public boolean isSubsystemExist(String code);


	public String saveSubsystem(Subsystem data);


	public int removeSubsystem(String code);


	public int refreshSubsystem(Subsystem data);


	public List<Subsystem> querySubsystemList(Subsystem condition);


	public Subsystem getSubsystem(String code);


}