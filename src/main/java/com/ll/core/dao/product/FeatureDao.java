package com.ll.core.dao.product;

import java.util.List;

import com.ll.core.bean.product.Feature;
import com.ll.core.query.product.FeatureQuery;

public interface FeatureDao {

	public void addFeature(Feature feature);

	public Feature getFeatureById(Integer id);

	public List<Feature> getFeaturesByKeys(List<Integer> idList);

	public void delFeature(Integer id);

	public void deleteByKeys(List<Integer> idList);

	public void updateFeature(Feature feature);

	public List<Feature> getFeatureList(FeatureQuery featureQuery);

}
