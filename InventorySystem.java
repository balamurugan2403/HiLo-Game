package Implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class InventorySystem {

	public static void main(String[] args) {
		
		//different inventory list declaration
		List<CarDetail> carDtl = new ArrayList<>();
		List<CarDetail> coupeCarDtl = new ArrayList<>();
		List<CarDetail> sedanCarDtl = new ArrayList<>();
		List<CarDetail> suvCarDtl = new ArrayList<>();
		List<CarDetail> sportsCarDtl = new ArrayList<>();
		List<Integer> carIdList = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		
		//Adding input data for each Inventory
		CarDetail c1 = new CarDetail(1234, "718 Cayman", "Porsche", 25, 45000);
		CarDetail c2 = new CarDetail(3965, "GR Supra", "Toyota", 30, 18000);
		CarDetail c3 = new CarDetail(4322, "S5", "Audi", 35, 20000);
		CarDetail c4 = new CarDetail(3424, "RC", "Lexus", 25, 25000);
		CarDetail c5 = new CarDetail(8439, "M2", "BMW", 20, 16000);
		
		coupeCarDtl.add(c1);
		coupeCarDtl.add(c2);
		coupeCarDtl.add(c3);
		coupeCarDtl.add(c4);
		coupeCarDtl.add(c5);
		
		CarDetail c6 = new CarDetail(1234, "XF", "Jaguar", 25, 150000);
		CarDetail c7 = new CarDetail(3965, "750", "BMW", 30, 103000);
		CarDetail c8 = new CarDetail(4322, "Taycan", "Porsche", 35, 105000);
		CarDetail c9 = new CarDetail(3424, "S90", "Volvo", 25, 52000);
		CarDetail c10 = new CarDetail(8439, "A6", "Audi", 26, 55000);
		
		sedanCarDtl.add(c6);
		sedanCarDtl.add(c7);
		sedanCarDtl.add(c8);
		sedanCarDtl.add(c9);
		sedanCarDtl.add(c10);
		
		CarDetail c11 = new CarDetail(1234, "E-Pace", "Jaguar", 25, 41000);
		CarDetail c12 = new CarDetail(3965, "ESV", "Cadillac", 20, 80000);
		CarDetail c13 = new CarDetail(4322, "X3", "BMW", 35, 43000);
		CarDetail c14 = new CarDetail(3424, "Compass", "Jeep", 25, 24000);
		CarDetail c15 = new CarDetail(8439, "Defender", "Land Rover", 20, 46000);
		
		suvCarDtl.add(c11);
		suvCarDtl.add(c12);
		suvCarDtl.add(c13);
		suvCarDtl.add(c14);
		suvCarDtl.add(c15);
		
		CarDetail c16 = new CarDetail(1234, "911", "Porsche", 95, 100000);
		CarDetail c17 = new CarDetail(3965, "F-Type", "Jaguar", 30, 62000);
		CarDetail c18 = new CarDetail(4322, "AMG GT", "Mercedes", 35, 90000);
		CarDetail c19 = new CarDetail(3424, "GT-R", "Nissan", 22, 113000);
		CarDetail c20 = new CarDetail(8439, "LC", "Lexus", 34, 93000);
		
		sportsCarDtl.add(c16);
		sportsCarDtl.add(c17);
		sportsCarDtl.add(c18);
		sportsCarDtl.add(c19);
		sportsCarDtl.add(c20);
		
		//Welcome note to User
		System.out.println("                   Welcome");
		System.out.println("                     to");
		System.out.println("      Automotive Delarship Inventory System\n");
		
		System.out.println("      1. Coupe Inventory");
		System.out.println("      2. Sedan Inventory");
		System.out.println("      3. SUV Inventory");
		System.out.println("      4. Sports Car Inventory\n");
		
		System.out.println("Choose any one from the above list of Inventory:");
		Integer inventory = sc.nextInt();
		
		if(inventory==1) {
			carDtl=coupeCarDtl;
		}else if(inventory==2) {
			carDtl=sedanCarDtl;
		}else if(inventory==3) {
			carDtl=suvCarDtl;
		}else if(inventory==4) {
			carDtl=sportsCarDtl;
		}
		
		//getting the CAR ID to generate a random number for INSERT function
		for(CarDetail ids : carDtl) {
			carIdList.add(ids.getCarID());
		}
		
		System.out.println("\n***********   MENU   ***********");
		System.out.println("*        1. All Inventory      *");
		System.out.println("*        2. Search             *");
		System.out.println("*        3. Insert             *");
		System.out.println("*        4. Update             *");
		System.out.println("*        5. Delete             *");
		System.out.println("********************************");
		
		System.out.println("Choose the respective Action item number from the Menu:");
		Integer menu = sc.nextInt();
		
		if(menu==1) {//All Inventory
			int dispCount=0;
			allInvntryFunction(carDtl, dispCount);	
		}else if(menu==2) {//Search
			searchFunction(carDtl); 	
		}else if(menu==3) {//Insert
			insertFunction(carDtl, carIdList);
		}else if(menu==4) {//Update
			updateFunction(carDtl);
		}else if(menu==5) {//Delete
			deleteFunction(carDtl);
		}
	}
	
	public static void allInvntryFunction(List<CarDetail> carDtl, int dispCount) {
		Scanner sc = new Scanner(System.in);
		
		if(dispCount==0) {//to display it only the first time
			System.out.println("\n********* All Inventory **********\n");
			System.out.printf("%-10s %-10s %-10s %-10s %-10s\n\n", "CAR ID", "MODEL", "BRAND", "MILEAGE" , "COST");
			
			for(CarDetail dtl : carDtl) {
				System.out.printf("%-10s %-10s %-10s %-10s %-10s\n", dtl.getCarID(), dtl.getmodelName(), dtl.getBrand(), dtl.getMileage()+" mpg", "$ "+dtl.getCost());
			}
			System.out.println("\n***********************************");
		}
		
		System.out.println("\nSort By:");
		System.out.println("1. CAR ID");
		System.out.println("2. MODEL");
		System.out.println("3. BRAND");
		System.out.println("4. MILEAGE");
		System.out.println("5. PRICE");
		System.out.println("\nChoose the required sort option else press 0 to exit:");
		Integer sort = sc.nextInt();
		
		if(sort==1) {
			Collections.sort(carDtl, CarDetail.carIdComparator);//using comparator to sort based on the user selected option
			System.out.println("\n********* All Inventory - Sort by CAR ID **********\n");
			System.out.printf("%-10s %-10s %-10s %-10s %-10s\n\n", "CAR ID", "MODEL", "BRAND", "MILEAGE" , "COST");
			
			for(CarDetail dtl : carDtl) {
				System.out.printf("%-10s %-10s %-10s %-10s %-10s\n", dtl.getCarID(), dtl.getmodelName(), dtl.getBrand(), dtl.getMileage()+" mpg", "$ "+dtl.getCost());
			}
			System.out.println("\n*****************************************************");
		}else if(sort==2) {
			Collections.sort(carDtl, CarDetail.modelComparator);
			System.out.println("\n********* All Inventory - Sort by MODEL **********\n");
			System.out.printf("%-10s %-10s %-10s %-10s %-10s\n\n", "CAR ID", "MODEL", "BRAND", "MILEAGE" , "COST");
			
			for(CarDetail dtl : carDtl) {
				System.out.printf("%-10s %-10s %-10s %-10s %-10s\n", dtl.getCarID(), dtl.getmodelName(), dtl.getBrand(), dtl.getMileage()+" mpg", "$ "+dtl.getCost());
			}
			System.out.println("\n****************************************************");
		}else if(sort==3) {
			Collections.sort(carDtl, CarDetail.brandComparator);
			System.out.println("\n********* All Inventory - Sort by BRAND **********\n");
			System.out.printf("%-10s %-10s %-10s %-10s %-10s\n\n", "CAR ID", "MODEL", "BRAND", "MILEAGE" , "COST");
			
			for(CarDetail dtl : carDtl) {
				System.out.printf("%-10s %-10s %-10s %-10s %-10s\n", dtl.getCarID(), dtl.getmodelName(), dtl.getBrand(), dtl.getMileage()+" mpg", "$ "+dtl.getCost());
			}
			System.out.println("\n****************************************************");
		}else if(sort==4) {
			Collections.sort(carDtl, CarDetail.mileageComparator);
			System.out.println("\n********* All Inventory - Sort by MILEAGE **********\n");
			System.out.printf("%-10s %-10s %-10s %-10s %-10s\n\n", "CAR ID", "MODEL", "BRAND", "MILEAGE" , "COST");
			
			for(CarDetail dtl : carDtl) {
				System.out.printf("%-10s %-10s %-10s %-10s %-10s\n", dtl.getCarID(), dtl.getmodelName(), dtl.getBrand(), dtl.getMileage()+" mpg", "$ "+dtl.getCost());
			}
			System.out.println("\n*****************************************************");
		}else if(sort==5) {
			Collections.sort(carDtl, CarDetail.costComparator);
			System.out.println("\n********* All Inventory - Sort by PRICE **********\n");
			System.out.printf("%-10s %-10s %-10s %-10s %-10s\n\n", "CAR ID", "MODEL", "BRAND", "MILEAGE" , "COST");
			
			for(CarDetail dtl : carDtl) {
				System.out.printf("%-10s %-10s %-10s %-10s %-10s\n", dtl.getCarID(), dtl.getmodelName(), dtl.getBrand(), dtl.getMileage()+" mpg", "$ "+dtl.getCost());
			}
			System.out.println("\n****************************************************");
		}else {
			System.out.println("Thank you.");
			System.exit(0);
		}
		System.out.println("\nWant to sort again with different parameter (Y/N)?");
		String response = sc.next();
		if(response.equalsIgnoreCase("Y")) {
			dispCount++;//incrementing so that all the initial car details will not get displayed again
			allInvntryFunction(carDtl, dispCount);//recursive function call
		}else {
			System.out.println("Thank you.");
			System.exit(0);
		}
	}
	public static void searchFunction(List<CarDetail> carDtl) {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n********* Search **********");
		System.out.println("\nSearch By:");
		System.out.println("1. CAR ID");
		System.out.println("2. MODEL");
		System.out.println("3. BRAND");
		System.out.println("4. MILEAGE");
		System.out.println("5. PRICE");
		System.out.println("\nChoose any search option from above:");
		Integer search = sc.nextInt();
		
		if(search==1) {
			System.out.println("\nEnter the CAR ID: ");
			Integer carId=sc.nextInt();
			List<CarDetail> matchList = new ArrayList<>();
			for(CarDetail dtl : carDtl) {
				if(carId==dtl.getCarID()) {//matching the user input value with list of car details
					matchList.add(dtl);//If match found then adding it to separate list
				}
			}
			
			if(null!=matchList && !matchList.isEmpty()) {//using the matching list to display
				System.out.println("\n********* Search by CAR ID **********");
				System.out.printf("\n%-10s %-10s %-10s %-10s %-10s\n\n", "CAR ID", "MODEL", "BRAND", "MILEAGE" , "PRICE");
				for(CarDetail dtl : matchList) {
					System.out.printf("%-10s %-10s %-10s %-10s %-10s\n", dtl.getCarID(), dtl.getmodelName(), dtl.getBrand(), dtl.getMileage()+" mpg", "$ "+dtl.getCost());
				}
				System.out.println("\n*************************************");
			}else {// if matching list is empty
				System.out.println("\nSorry, no such data available in our Inventory. Please try again.");
				searchFunction(carDtl);
			}	
		}else if(search==2) {
			System.out.println("\nEnter the MODEL NAME: ");
			String model=sc.next();
			List<CarDetail> matchList = new ArrayList<>();
			for(CarDetail dtl : carDtl) {
				if(model.toLowerCase().equalsIgnoreCase(dtl.getmodelName().toLowerCase())) {
					matchList.add(dtl);
				}
			}
			
			if(null!=matchList && !matchList.isEmpty()) {
				System.out.println("\n********* Search by MODEL **********");
				System.out.printf("\n%-10s %-10s %-10s %-10s %-10s\n\n", "CAR ID", "MODEL", "BRAND", "MILEAGE" , "PRICE");
				for(CarDetail dtl : matchList) {
					System.out.printf("%-10s %-10s %-10s %-10s %-10s\n", dtl.getCarID(), dtl.getmodelName(), dtl.getBrand(), dtl.getMileage()+" mpg", "$ "+dtl.getCost());
				}
				System.out.println("\n************************************");
			}else {
				System.out.println("\nSorry, no such data available in our Inventory. Please try again.");
				searchFunction(carDtl);
			}
		}else if(search==3) {
			System.out.println("\nEnter the BRAND NAME: ");
			String brand=sc.next();
			List<CarDetail> matchList = new ArrayList<>();
			for(CarDetail dtl : carDtl) {
				if(brand.equalsIgnoreCase(dtl.getBrand())) {
					matchList.add(dtl);
				}
			}
			
			if(null!=matchList && !matchList.isEmpty()) {
				System.out.println("\n********* Search by BRAND **********");
				System.out.printf("\n%-10s %-10s %-10s %-10s %-10s\n\n", "CAR ID", "MODEL", "BRAND", "MILEAGE" , "PRICE");
				for(CarDetail dtl : matchList) {
					System.out.printf("%-10s %-10s %-10s %-10s %-10s\n", dtl.getCarID(), dtl.getmodelName(), dtl.getBrand(), dtl.getMileage()+" mpg", "$ "+dtl.getCost());
				}
				System.out.println("\n************************************");
			}else {
				System.out.println("\nSorry, no such data available in our Inventory. Please try again.");
				searchFunction(carDtl);
			}
		}else if(search==4) {
			System.out.println("\nEnter the MILEAGE: ");
			Integer mileage=sc.nextInt();
			List<CarDetail> matchList = new ArrayList<>();
			for(CarDetail dtl : carDtl) {
				if(mileage==dtl.getMileage()) {
					matchList.add(dtl);
				}
			}
			
			if(null!=matchList && !matchList.isEmpty()) {
				System.out.println("\n********* Search by MILEAGE **********");
				System.out.printf("\n%-10s %-10s %-10s %-10s %-10s\n\n", "CAR ID", "MODEL", "BRAND", "MILEAGE" , "PRICE");
				for(CarDetail dtl : matchList) {
					System.out.printf("%-10s %-10s %-10s %-10s %-10s\n", dtl.getCarID(), dtl.getmodelName(), dtl.getBrand(), dtl.getMileage()+" mpg", "$ "+dtl.getCost());
				}
				System.out.println("\n**************************************");
			}else {
				System.out.println("\nSorry, no such data available in our Inventory. Please try again.");
				searchFunction(carDtl);
			}
		}else if(search==5) {
			System.out.println("\nEnter the PRICE: ");
			double cost=sc.nextDouble();
			List<CarDetail> matchList = new ArrayList<>();
			for(CarDetail dtl : carDtl) {
				if(Double.compare(cost, dtl.getCost())==0) {
					matchList.add(dtl);
				}
			}
			
			if(null!=matchList && !matchList.isEmpty()) {
				System.out.println("\n********* Search by PRICE **********");
				System.out.printf("\n%-10s %-10s %-10s %-10s %-10s\n\n", "CAR ID", "MODEL", "BRAND", "MILEAGE" , "PRICE");
				for(CarDetail dtl : matchList) {
					System.out.printf("%-10s %-10s %-10s %-10s %-10s\n", dtl.getCarID(), dtl.getmodelName(), dtl.getBrand(), dtl.getMileage()+" mpg", "$ "+dtl.getCost());
				}
				System.out.println("\n************************************");
			}else {
				System.out.println("\nSorry, no such data available in our Inventory. Please try again.");
				searchFunction(carDtl);
			}
		}
		
		System.out.println("\nWant to search again with different parameter (Y/N)?");
		String response = sc.next();
		if(response.equalsIgnoreCase("Y")) {
			searchFunction(carDtl);//recursive function call
		}else {
			System.out.println("Thank you.");
			System.exit(0);
		}
	}

	public static void insertFunction(List<CarDetail> carDtl, List<Integer> carIdList) {
			Scanner sc = new Scanner(System.in);
			System.out.println("\n********* Add To Inventory **********");

			System.out.println("\nEnter MODEL NAME:");
			String modelNm = sc.next();
				
			System.out.println("\nEnter BRAND NAME:");
			String brandNm = sc.next();
				
			System.out.println("\nEnter MILEAGE:");
			Integer mileage = sc.nextInt();
				
			System.out.println("\nEnter PRICE:");
				double price = sc.nextDouble();
				
				CarDetail dtl1 = new CarDetail();//create instance for the model class
				//setting up the values to the model class object
						dtl1.setCarID(carIdRandomGenerator(carIdList));//unique ID generator for CAR ID
						dtl1.setmodelName(modelNm);
						dtl1.setBrand(brandNm);
						dtl1.setMileage(mileage);
						dtl1.setCost(price);
						carDtl.add(dtl1);//adding the obj to the list
						carIdList.add(carIdRandomGenerator(carIdList));//adding the unique generator CAR ID to the list
				
				System.out.printf("\n%-10s %-10s %-10s %-10s %-10s\n\n", "CAR ID", "MODEL", "BRAND", "MILEAGE" , "PRICE");
				for(CarDetail dtl : carDtl) {
					System.out.printf("%-10s %-10s %-10s %-10s %-10s\n", dtl.getCarID(), dtl.getmodelName(), dtl.getBrand(), dtl.getMileage()+" mpg", "$ "+dtl.getCost());
					}

				System.out.println("\nWant to insert another record (Y/N)?");
				String response = sc.next();
				if(response.equalsIgnoreCase("Y")) { 
						insertFunction(carDtl, carIdList);//recursive function call 
				}else {
					System.out.println("Thank you.");
					System.exit(0); 
				}
			
			
		}

	public static void updateFunction(List<CarDetail> carDtl) {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n********* Update **********");
		System.out.println("Enter CAR ID:");
		Integer carId=sc.nextInt();
		List<CarDetail> matchList = new ArrayList<>();
		
		for(CarDetail dtl : carDtl) {
			if(carId==dtl.getCarID()) {//matching the user input value with list of car details
				matchList.add(dtl);//If match found then adding it to separate list
			}
		}
		
		if(null!=matchList && !matchList.isEmpty()) {
			System.out.printf("\n%-10s %-10s %-10s %-10s %-10s\n\n", "CAR ID", "MODEL", "BRAND", "MILEAGE" , "PRICE");
			for(CarDetail dtl : matchList) {//to display the records based on the match
				System.out.printf("%-10s %-10s %-10s %-10s %-10s\n", dtl.getCarID(), dtl.getmodelName(), dtl.getBrand(), dtl.getMileage()+" mpg", "$ "+dtl.getCost());
			}
			
			System.out.println("\nParameters that can be updated:");
			System.out.println("1. MODEL");
			System.out.println("2. BRAND");
			System.out.println("3. MILEAGE");
			System.out.println("4. PRICE");
			System.out.println("5. All");
			System.out.println("\nProvide the respective parameter number that need to be updated:");
			Integer selected = sc.nextInt();
			
			if(selected==1) {
				System.out.println("\nEnter MODEL NAME:");//getting input for the parameter chosen for update
				String modelNm = sc.next();
				
				for(CarDetail dtl : carDtl) {
					if(carId==dtl.getCarID()) {//matching the CAR ID to select the particular record
						dtl.setmodelName(modelNm);//updating the parameter value
					}
				}
				
				System.out.printf("\n%-10s %-10s %-10s %-10s %-10s\n\n", "CAR ID", "MODEL", "BRAND", "MILEAGE" , "PRICE");
				for(CarDetail dtl : carDtl) {
					System.out.printf("%-10s %-10s %-10s %-10s %-10s\n", dtl.getCarID(), dtl.getmodelName(), dtl.getBrand(), dtl.getMileage()+" mpg", "$ "+dtl.getCost());
				}
			}else if(selected==2) {
				System.out.println("\nEnter BRAND NAME:");
				String brandNm = sc.next();
				
				for(CarDetail dtl : carDtl) {
					if(carId==dtl.getCarID()) {
						dtl.setBrand(brandNm);
					}
				}
				
				System.out.printf("\n%-10s %-10s %-10s %-10s %-10s\n\n", "CAR ID", "MODEL", "BRAND", "MILEAGE" , "PRICE");
				for(CarDetail dtl : carDtl) {
					System.out.printf("%-10s %-10s %-10s %-10s %-10s\n", dtl.getCarID(), dtl.getmodelName(), dtl.getBrand(), dtl.getMileage()+" mpg", "$ "+dtl.getCost());
				}
			}else if(selected==3) {
				System.out.println("\nEnter MILEAGE:");
				Integer mileage = sc.nextInt();
				 
				for(CarDetail dtl : carDtl) {
					if(carId==dtl.getCarID()) {
						dtl.setMileage(mileage);
					}
				}
				
				System.out.printf("\n%-10s %-10s %-10s %-10s %-10s\n\n", "CAR ID", "MODEL", "BRAND", "MILEAGE" , "PRICE");
				for(CarDetail dtl : carDtl) {
					System.out.printf("%-10s %-10s %-10s %-10s %-10s\n", dtl.getCarID(), dtl.getmodelName(), dtl.getBrand(), dtl.getMileage()+" mpg", "$ "+dtl.getCost());
				}
			}else if(selected==4) {
				System.out.println("\nEnter PRICE:");
				double price = sc.nextDouble();
				
				for(CarDetail dtl : carDtl) {
					if(carId==dtl.getCarID()) {
						dtl.setCost(price);
					}
				}
				
				System.out.printf("\n%-10s %-10s %-10s %-10s %-10s\n\n", "CAR ID", "MODEL", "BRAND", "MILEAGE" , "PRICE");
				for(CarDetail dtl : carDtl) {
					System.out.printf("%-10s %-10s %-10s %-10s %-10s\n", dtl.getCarID(), dtl.getmodelName(), dtl.getBrand(), dtl.getMileage()+" mpg", "$ "+dtl.getCost());
				}
			}else if(selected==5) {//To update all the parameters in the selected record
				System.out.println("\nEnter MODEL NAME:");
				String modelNm = sc.next();
				System.out.println("\nEnter BRAND NAME:");
				String brandNm = sc.next();
				System.out.println("\nEnter MILEAGE:");
				Integer mileage = sc.nextInt();
				System.out.println("\nEnter PRICE:");
				double price = sc.nextDouble();
				
				for(CarDetail dtl : carDtl) {
					if(carId==dtl.getCarID()) {
						dtl.setmodelName(modelNm);
						dtl.setBrand(brandNm);
						dtl.setMileage(mileage);
						dtl.setCost(price);
					}
				}
				System.out.printf("\n%-10s %-10s %-10s %-10s %-10s\n\n", "CAR ID", "MODEL", "BRAND", "MILEAGE" , "PRICE");
				for(CarDetail dtl : carDtl) {
					System.out.printf("%-10s %-10s %-10s %-10s %-10s\n", dtl.getCarID(), dtl.getmodelName(), dtl.getBrand(), dtl.getMileage()+" mpg", "$ "+dtl.getCost());
				}
			}
			
			System.out.println("\nWant to update another record (Y/N)?");
			String response = sc.next();
			if(response.equalsIgnoreCase("Y")) {
				updateFunction(carDtl);//recursive call function
			}else {
				System.out.println("Thank you.");
				System.exit(0);
			}
		}else {
			System.out.println("\nSorry, no such data available in our Inventory. Please try again.");
			updateFunction(carDtl);
		}
	}
	
	public static void deleteFunction(List<CarDetail> carDtl) {
		List<CarDetail> deleteList = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		System.out.println("\n********* Delete **********");
		System.out.println("Enter CAR ID:");
		Integer carId=sc.nextInt();
		List<CarDetail> matchList = new ArrayList<>();
		
		for(CarDetail dtl : carDtl) {
			if(carId==dtl.getCarID()) {//matching the user input value with list of car details
				matchList.add(dtl);//If match found then adding it to separate list
			}
		}
		
		if(null!=matchList && !matchList.isEmpty()) {
			System.out.printf("\n%-10s %-10s %-10s %-10s %-10s\n\n", "CAR ID", "MODEL", "BRAND", "MILEAGE" , "PRICE");
			for(CarDetail dtl : matchList) {
				System.out.printf("%-10s %-10s %-10s %-10s %-10s\n", dtl.getCarID(), dtl.getmodelName(), dtl.getBrand(), dtl.getMileage()+" mpg", "$ "+dtl.getCost());
			}
			
			System.out.println("\nDo you want to delete this record(Y/N):");//getting confirmation before deleting the record
			String selected = sc.next();
			
			if(selected.equalsIgnoreCase("Y")) {
				
				for(CarDetail dtl : carDtl) {
					if(carId==dtl.getCarID()) {
						deleteList.add(dtl);
						//adding the matched obj to a separate list as we cannot alter a list while iteration due to ConcurrentModificationExceptions
					}
				}
				
				carDtl.removeAll(deleteList);//removing the delete list element from the main list
				
				System.out.printf("\n%-10s %-10s %-10s %-10s %-10s\n\n", "CAR ID", "MODEL", "BRAND", "MILEAGE" , "PRICE");
				for(CarDetail dtl : carDtl) {
					System.out.printf("%-10s %-10s %-10s %-10s %-10s\n", dtl.getCarID(), dtl.getmodelName(), dtl.getBrand(), dtl.getMileage()+" mpg", "$ "+dtl.getCost());
				}
			}else {
				System.out.println("\nWant to delete another record (Y/N)?");
				String response = sc.next();
				if(response.equalsIgnoreCase("Y")) {
					updateFunction(carDtl);//recursive function call
				}else {
					System.out.println("Thank you.");
					System.exit(0);
				}
			}
			
			System.out.println("\nWant to delete another record (Y/N)?");
			String response = sc.next();
			if(response.equalsIgnoreCase("Y")) {
				updateFunction(carDtl);//recursive function call
			}else {
				System.out.println("Thank you.");
				System.exit(0);
			}
		}else {
			System.out.println("\nSorry, no such data available in our Inventory. Please try again.");
			updateFunction(carDtl);//recursive function call
		}
	}
	
	//random number CAR ID generator
	public static Integer carIdRandomGenerator(List<Integer> carIdList) {
		Integer carID = null;
		carID  = 1000 + new Random().nextInt(9000);
		
		if(!carIdList.contains(carID)) {//check to avoid duplicate car id
			return carID;
		}else {
			carIdRandomGenerator(carIdList);//recursive function call
		}
		return carID;
		
	}
}
