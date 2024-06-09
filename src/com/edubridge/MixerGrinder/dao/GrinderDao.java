package com.edubridge.MixerGrinder.dao;

import java.util.List;


import com.edubridge.MixerGrinder.model.Grinder;
public interface GrinderDao {
	
		int addGrinder(Grinder g);
		List<Grinder> findGrinders();
		Grinder findGrinderByBrand(String brand);
		int updateGrinder(Grinder g);
		int deleteGrinderByBrand(String brand);
		void deleteAllGrinders();

}
