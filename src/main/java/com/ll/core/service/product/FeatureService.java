package com.ll.core.service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ll.core.bean.product.Feature;
import com.ll.core.dao.product.FeatureDao;
import com.ll.core.query.product.FeatureQuery;

@Service
public class FeatureService {
	@Autowired FeatureDao featureDao;
	
	public void addFeature(Feature feature){
		featureDao.addFeature(feature);
	}
	
	public Feature getFeatureById(Integer id){
		return featureDao.getFeatureById(id);
	}
	
	public void delFeature(Integer id){
		featureDao.delFeature(id);
	}
	
	public void updateFeature(Feature feature){
		featureDao.updateFeature(feature);
	}
	
	public List<Feature> getFeatureList(FeatureQuery featureQuery){
		return featureDao.getFeatureList(featureQuery);
	}
	
}
