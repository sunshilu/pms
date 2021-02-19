package com.example.pms.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pms.system.mapper.BaseMapper;
import com.example.pms.system.mapper.G_PointMapper;

@Service
public class G_PointService<T> extends BaseService<T> {
	@Autowired
	public G_PointMapper<T> G_PointMapper;

	@Override
	public BaseMapper<T> getMapper() {
		return G_PointMapper;
	}

}
