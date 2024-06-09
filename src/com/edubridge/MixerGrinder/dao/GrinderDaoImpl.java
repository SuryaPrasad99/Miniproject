package com.edubridge.MixerGrinder.dao;

import com.edubridge.MixerGrinder.model.Grinder;

import com.edubridge.MixerGrinder.util.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public  class GrinderDaoImpl implements GrinderDao {
	
		static Connection con=DBUtils.getConnection();
		

		@Override
		public int addGrinder(Grinder g) {
			String INSERT_QUERY="insert into grinder(brand,colour,weight,price,capacity)values(?,?,?,?,?)";
			int status=0;
			try {
				PreparedStatement ps=con.prepareStatement(INSERT_QUERY);
				ps.setString(1,g.getBrand());
				ps.setString(2,g.getColour());
				ps.setFloat(3,g.getWeight());
				ps.setFloat(4,g.getPrice());
				ps.setFloat(5,g.getCapacity());
				
				status=ps.executeUpdate();
				
				}catch(SQLException e) {
				e.printStackTrace();
				
			}
		return status;
		}

		@Override
		public List<Grinder> findGrinders() {
			String SELECT_QUERY="select * from grinder";
			List<Grinder>grinderList=new ArrayList<>();
			try {
				PreparedStatement ps=con.prepareStatement(SELECT_QUERY);
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					Grinder g=new Grinder();
					g.setId(rs.getInt("id"));
					g.setBrand(rs.getString("Brand"));
					g.setColour(rs.getString("Colour"));
					g.setWeight(rs.getFloat("Weight"));
					g.setPrice(rs.getFloat("Price"));
					g.setCapacity(rs.getFloat("Capacity"));
					grinderList.add(g);					
				}
			}catch(SQLException e) {
				e.printStackTrace();
				
			}
		return grinderList;
		}

		@Override
		public int updateGrinder(Grinder g) {
			String UPDATE_QUERY="update grinder set colour=?,weight=?,price=?,capacity=?,brand=? where id=?";
			int status=0;
			try {
				PreparedStatement ps=con.prepareStatement(UPDATE_QUERY);
				
				
				ps.setString(1,g.getColour());
				ps.setFloat(2,g.getWeight());
				ps.setFloat(3,g.getPrice());
				ps.setFloat(4,g.getCapacity());
				ps.setString(5,g.getBrand());
				ps.setInt(6,g.getId());
				
				status=ps.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return status;
		}

		public int deleteGrinderByBrand(String brand) {
			String DELETE_QUERY="delete from grinder where brand=?";
			int status=0;
			
			try {
				PreparedStatement ps=con.prepareStatement(DELETE_QUERY);
				ps.setString(1, brand);
				status=ps.executeUpdate();				
			}catch(SQLException e) {
				e.printStackTrace();
			}

			return status;
		}

		@Override
		public void deleteAllGrinders() {
			String DELETE_QUERY="delete from grinder";	
			try{
				PreparedStatement ps=con.prepareStatement(DELETE_QUERY);
						
				ps.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}

		
		@Override
		public Grinder findGrinderByBrand(String brand) {
			Grinder g=null;
			String SELECT_QUERY="select * from grinder where brand=?";
			try {
				PreparedStatement ps=con.prepareStatement(SELECT_QUERY);
				ps.setString(1,brand);
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					g=new Grinder();
					g.setId(rs.getInt("Id"));
					g.setBrand(rs.getString("brand"));
					g.setColour(rs.getString("colour"));
					g.setWeight(rs.getFloat("weight"));
					g.setPrice(rs.getFloat("price"));
					g.setCapacity(rs.getFloat("capacity"));
					
				}
			
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			return g;
		}
	
}



