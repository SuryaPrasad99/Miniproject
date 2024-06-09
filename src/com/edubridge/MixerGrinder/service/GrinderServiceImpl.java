package com.edubridge.MixerGrinder.service;

import java.util.List;

import com.edubridge.MixerGrinder.dao.GrinderDao;
import com.edubridge.MixerGrinder.dao.GrinderDaoImpl;
import com.edubridge.MixerGrinder.model.Grinder;

public class GrinderServiceImpl implements GrinderService{

	private GrinderDao dao=new GrinderDaoImpl();
	@Override
	public int addGrinder(Grinder g) {
		// TODO Auto-generated method stub
		return  dao.addGrinder(g);
	}

	@Override
	public List<Grinder> findGrinders() {
		// TODO Auto-generated method stub
		return dao.findGrinders();
	}

	@Override
	public Grinder findGrinderByBrand(String brand) {
		// TODO Auto-generated method stub
		return dao.findGrinderByBrand(brand);
	}

	@Override
	public int updateGrinder(Grinder g) {
		// TODO Auto-generated method stub
		return dao.updateGrinder(g);
	}

	@Override
	public int deleteGrinderBybrand(String brand) {
		// TODO Auto-generated method stub
		return dao.deleteGrinderByBrand(brand);
	}

	@Override
	public void deleteAllGrinders() {
		// TODO Auto-generated method stub
		dao.deleteAllGrinders();
	}

	

	

}
