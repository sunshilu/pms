package com.example.pms.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pms.system.mapper.BaseMapper;
import com.example.pms.system.mapper.G_PointMapper;
import com.example.pms.system.model.G_PointModel;

@Service
public class G_PointService<T> extends BaseService<T> {
	@Autowired
	public G_PointMapper<T> G_PointMapper;

	@Override
	public BaseMapper<T> getMapper() {
		return G_PointMapper;
	}

	public List<G_PointModel> getListGroupBYDate(G_PointModel pointModel) {
		return G_PointMapper.getListGroupBYDate(pointModel);
	}

	public List<G_PointModel> getListGroupBYTerms(G_PointModel pointModel) {
		return G_PointMapper.getListGroupBYTerms(pointModel);
	}

}
