package com.example.pms.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pms.system.mapper.BaseMapper;
import com.example.pms.system.mapper.G_DepartmentMapper;

@Service
public class G_DepartmentService<T> extends BaseService<T> {
	@Autowired
	public G_DepartmentMapper<T> departmentMapper;

	@Override
	public BaseMapper<T> getMapper() {
		return departmentMapper;
	}

}
