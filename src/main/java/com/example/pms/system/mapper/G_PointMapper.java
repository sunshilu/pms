package com.example.pms.system.mapper;

import java.util.List;

import com.example.pms.system.model.G_PointModel;

public interface G_PointMapper<T> extends BaseMapper<T> {

	List<G_PointModel> getListGroupBYDate(G_PointModel pointModel);

}
