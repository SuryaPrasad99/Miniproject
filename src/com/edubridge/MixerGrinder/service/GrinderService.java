package com.edubridge.MixerGrinder.service;

import java.util.List;

import com.edubridge.MixerGrinder.model.Grinder;

public interface GrinderService {
	
		int addGrinder(Grinder g);
		List<Grinder> findGrinders();
		Grinder findGrinderByBrand(String brand);
		int updateGrinder(Grinder g);
		int deleteGrinderBybrand(String brand);
		void deleteAllGrinders();
		
		
}
