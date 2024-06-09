package com.edubridge.MixerGrinder.main;


import java.util.List;

import java.util.Scanner;

import com.edubridge.MixerGrinder.model.Grinder;

import com.edubridge.MixerGrinder.service.GrinderServiceImpl;


public class MixerGrinderMainApp {

	public static void main(String[] args) {
		com.edubridge.MixerGrinder.service.GrinderService service=new GrinderServiceImpl();
		Grinder g=null;
		
		
		Scanner in =new Scanner(System.in);
		int option ;
		do {
			System.out.println("Welcome to Grinder App");
			System.out.println("*******************");
			System.out.println("1.add Grinder");
			System.out.println("2. view Grinder");
			System.out.println("3. search Grinder");
			System.out.println("4. update Grinder");
			System.out.println("5. delete Grinder");
			System.out.println("6. delete all Grinder");
			System.out.println("0. exit");
			System.out.println("Please choose option:");
			option = in.nextInt();
			
			switch(option){
			case 1:
				System.out.println("Add name of grinder:");
				System.out.println("--------------------");
				System.out.println("Add grinder brand name:");
				String brand=in.next();
				System.out.println("Enter grinder colour:");
				String colour=in.next();
				System.out.println("Enter grinder weight:");
				float weight=in.nextFloat();
				System.out.println("Enter grinder Price:");
				float price=in.nextFloat();
				System.out.println("Enter grinder Capacity:");
				float capacity=in.nextFloat();
				
				
				g=new Grinder();
				g.setBrand(brand);
				g.setColour(colour);
				g.setWeight(weight);
				g.setPrice(price);
				g.setCapacity(capacity);
				
				int status=service.addGrinder(g);
				
				if(status==1) {
					
					System.out.println("Brand is added..!");
				}
				else {
					System.out.println("something is fishy");
				}
				
				break;
			case 2:
				System.out.println("view brands");
				List<Grinder> grinders=service.findGrinders();
				System.out.println("BRAND\tCOLOUR\tWEIGHT\tPRICE\tCAPACITY");
				System.out.println("-----\t-----\t------\t------\t-------");
				
				for(Grinder grinder:grinders) {
					System.out.println(grinder.getBrand()+"\t"+grinder.getColour()+"\t"+grinder.getWeight()+"\t"+grinder.getPrice()+"\t"+grinder.getCapacity());
				}
				break;
			case 3:
				System.out.println("search grinder");
				System.out.println("please enter grinder name:");
				String searchBrand=in.next();
				Grinder searchGrinder=service.findGrinderByBrand(searchBrand);
				if(searchGrinder!=null) {
					//System.out.println("Id: "+searchGrinder.getId());
					System.out.println("Brand: "+searchGrinder.getBrand());
					System.out.println("Colour: "+searchGrinder.getColour());
					System.out.println("Weight: "+searchGrinder.getWeight());
					System.out.println("Capacity: "+searchGrinder.getCapacity());
				}else {
					System.out.println("no Grinder found..!");
				}
				break;
			case 4:
				System.out.println("please enter Grinder name:");
				searchBrand=in.next();
				searchGrinder=service.findGrinderByBrand(searchBrand);
				if(searchGrinder!=null) {
					//displaying existing contact details
					//System.out.println("Id: "+searchGrinder.getId());
					System.out.println("Brand: "+searchGrinder.getBrand());
					System.out.println("Colour: "+searchGrinder.getColour());
					System.out.println("Weight: "+searchGrinder.getWeight());
					System.out.println("Price: "+searchGrinder.getPrice());
					//Reading contact update info
					System.out.println("please enter brand:");
					brand=in.next();
					System.out.println("please enter colour:");
					colour=in.next();
					System.out.println("please enter wieght:");
					weight=in.nextFloat();
					System.out.println("please enter price:");
					price=in.nextFloat();
					System.out.println("please enter capacity:");
					capacity=in.nextFloat();
					
					Grinder updateGrinder=new Grinder();
					
					updateGrinder.setColour(colour);
					updateGrinder.setWeight(weight);
					updateGrinder.setPrice(price);
					updateGrinder.setCapacity(capacity);
					updateGrinder.setId(searchGrinder.getId());
					                                                                              
					int updateStatus =service.updateGrinder(updateGrinder);
					if(updateStatus==1) {
						System.out.println("Grinder updated successfull");
					}else {
						System.out.println("something is wrong!");
					}
					
				}else {
					System.out.println("no contact found with brand");
				}
				break;
			case 5:
				System.out.println("delete grinder");
				System.out.println("Please enter grinder brand:");
				searchBrand=in.next();
				
				searchGrinder =service.findGrinderByBrand(searchBrand);
				if(searchGrinder!=null) {
					int deleteStatus=service.deleteGrinderBybrand(searchBrand);
					if(deleteStatus==1) {
						System.out.println("Grinder deleted successfully");
					}else {
						System.out.println("something went wrong");
					}
					}else {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
						                                                             
						System.out.println("No Grinder found...!");
						
				}

				break;
			case 6:
				System.out.println("Are you sure delete all Grinder?[Y/N]");
				
				String deleteConfirmStatus = in.next();
				if(deleteConfirmStatus.equalsIgnoreCase("Y")) {
					service.deleteAllGrinders();
					System.out.println("all grinders deleted!");
				}
				break;
			case 0:
				System.out.println("BYE--...--!");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid option!");
				break;	
		
			}
		}while(option!=0);
	}
	
}
