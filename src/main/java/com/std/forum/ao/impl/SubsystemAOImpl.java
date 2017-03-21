package com.std.forum.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.std.forum.ao.ISubsystemAO;
import com.std.forum.bo.ISubsystemBO;
import com.std.forum.bo.base.Paginable;
import com.std.forum.domain.Subsystem;
import com.std.forum.exception.BizException;



//CHECK ��鲢��ע�� 
@Service
public class SubsystemAOImpl implements ISubsystemAO {

	@Autowired
	private ISubsystemBO subsystemBO;

	@Override
	public String addSubsystem(Subsystem data) {
		return subsystemBO.saveSubsystem(data);
	}

	@Override
	public int editSubsystem(Subsystem data) {
		if (!subsystemBO.isSubsystemExist(data.getCode())) {
			throw new BizException("xn0000", "记录编号不存在");
		}
		return subsystemBO.refreshSubsystem(data);
	}

	@Override
	public int dropSubsystem(String code) {
		if (!subsystemBO.isSubsystemExist(code)) {
			throw new BizException("xn0000", "记录编号不存在");
		}
		return subsystemBO.removeSubsystem(code);
	}

	@Override
	public Paginable<Subsystem> querySubsystemPage(int start, int limit,
			Subsystem condition) {
		return subsystemBO.getPaginable(start, limit, condition);
	}

	@Override
	public List<Subsystem> querySubsystemList(Subsystem condition) {
		return subsystemBO.querySubsystemList(condition);
	}

	@Override
	public Subsystem getSubsystem(String code) {
		return subsystemBO.getSubsystem(code);
	}
}