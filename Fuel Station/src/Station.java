import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Station {
	
	private String stationName;
	private int ID;
	private Gasoline[] gasolineArray = new Gasoline[10];
	private Diesel[] dieselArray = new Diesel[10];
	private Service[] serviceArray = new Service[10];
	private double averageGasolinePrice = 0;
	private double totalGasolineInStation = 0;
	private double averageDieselPrice = 0;
	private double totalDieselInStation = 0;
	static int serviceCount = 0;
	static int personnelCount = 0;
	ArrayList<Person> personList = new ArrayList<Person>();
	ArrayList<Profitable> calcPro = new ArrayList<Profitable>();
	
	
	
	Station(String stationName,int ID){
		this.stationName=stationName;
		this.ID=ID;
	}
	
	
	
	public static Station createStation() {
		Scanner myscanner = new Scanner(System.in);
		System.out.print("Please enter the name of the Station: ");
		String stationName = myscanner.nextLine();
		while(true) {
			try {
				System.out.print("Please enter the Station ID: ");
				int ID = myscanner.nextInt();
				return new Station(stationName,ID);
			}
			catch(InputMismatchException e) {
	            System.err.println("ID should be an integer...");
	            myscanner.nextLine();
			}
		}
	}
	
	
	
	public static void findStationAndAddGasoline(Station[] stationArray) {
		Scanner myscanner = new Scanner(System.in);		
		while(true) {
			try {
				System.out.print("Please enter the ID of the Station you want to search: ");
				int stationID = myscanner.nextInt();
			
			
				boolean isStationFound = false;
				Station desiredStation = null;
				for(int i=0;i<stationArray.length;i++) {
					if(stationArray[i]!=null && stationArray[i].getID()==stationID) {
						isStationFound=true;
						desiredStation=stationArray[i];
						break;
					}
				}
				System.out.println();
				if(isStationFound) {
					Scanner myscanner1 = new Scanner(System.in);
					System.out.print("Please enter the origin of gasoline: ");
					String origin = myscanner1.nextLine();
					
					while(true) {
						try {
							System.out.print("Please enter the price per liter: ");
							double pricePerLiter = myscanner1.nextDouble();
							System.out.print("Please enter the total shipment volume in liter: ");
							double totalLiters = myscanner1.nextDouble();
							for(int i=0;i<desiredStation.getGasolineArray().length;i++) {
								if(desiredStation.getGasolineArray()[i]==null) {
									desiredStation.getGasolineArray()[i]=new Gasoline(origin,pricePerLiter,totalLiters);
									desiredStation.totalGasolineInStation += totalLiters;
									desiredStation.averageGasolinePrice = (((desiredStation.totalGasolineInStation - totalLiters) * desiredStation.averageGasolinePrice) + (pricePerLiter * totalLiters)) / (desiredStation.totalGasolineInStation);
									break;
								}
							}
							System.out.println();
							System.out.println("The total gasoline liters in Station #" + desiredStation.getID() + " is " + desiredStation.getTotalGasolineInStation());
							System.out.println("The average gasoline price in Station #" + desiredStation.getID() + " is " + desiredStation.getAverageGasolinePrice());
							break;
						} 
						catch(InputMismatchException e) {
				            System.err.println("price should be a double...");
				            myscanner1.nextLine();
						}
					}
				}
				else {
					System.out.println("No station found with the given ID!");
				}
				break;
			}
			catch(InputMismatchException e) {
	            System.err.println("ID should be an integer...");
	            myscanner.nextLine();
			}
		}
	}
	
	
	
	public static void findStationAndAddDiesel(Station[] stationArray) {
		Scanner myscanner = new Scanner(System.in);
		while(true) {
			try {
				System.out.print("Please enter the ID of the Station you want to search: ");
				int stationID = myscanner.nextInt();
				boolean isStationFound=false;
				Station desiredStation=null;
				for(int i=0;i<stationArray.length;i++) {
					if(stationArray[i]!=null && stationArray[i].getID()==stationID) {
						isStationFound=true;
						desiredStation=stationArray[i];
						break;
					}
				}
				System.out.println();
				if(isStationFound) {
					Scanner myscanner2 = new Scanner(System.in);
					System.out.print("Please enter the origin of Diesel: ");
					String origin = myscanner2.nextLine();
					while(true) {
						try {
							System.out.print("Please enter the price per liter: ");
							double pricePerLiter = myscanner2.nextDouble();
							System.out.print("Please enter the total shipment volume in liter: ");
							double totalLiters = myscanner2.nextDouble();
							for(int i=0;i<desiredStation.getDieselArray().length;i++) {
								if(desiredStation.getDieselArray()[i]==null) {
									desiredStation.getDieselArray()[i]=new Diesel(origin,pricePerLiter,totalLiters);
									desiredStation.totalDieselInStation += totalLiters;
									desiredStation.averageDieselPrice = (((desiredStation.totalDieselInStation - totalLiters) * desiredStation.averageDieselPrice) + (pricePerLiter * totalLiters)) / (desiredStation.totalDieselInStation);
									break;
								}
							}
							System.out.println();
							System.out.println("The total diesel liters in Station #" + desiredStation.getID() + " is " + desiredStation.getTotalDieselInStation());
							System.out.println("The average diesel price in Station #" + desiredStation.getID() + " is " + desiredStation.getAverageDieselPrice());
							break;
						}
						catch(InputMismatchException e) {
				            System.err.println("price should be a double...");
				            myscanner2.nextLine();
						}
					}
				}
				else {
					System.out.println("No station found with the given ID!");
				}
				break;
			}
			catch(InputMismatchException e) {
		        System.err.println("ID should be an integer...");
		        myscanner.nextLine();
			}
		}
	}
	
	
	
	
	public static void displayStationInventory(Station[] stationArray) {
		Scanner myscanner = new Scanner(System.in);
		while(true) {
			try {
				System.out.print("Please enter the ID of the Station you want to display: ");
				int stationID = myscanner.nextInt();
				boolean isStationFound=false;
				Station chosenStation=null;
				for(int i=0;i<stationArray.length;i++) {
					if(stationArray[i]!=null && stationArray[i].getID()==stationID) {
						isStationFound=true;
						chosenStation=stationArray[i];
						break;
					}
				}
				System.out.println();
				if(isStationFound) {
					System.out.println("Displaying the inventory of Station #"+chosenStation.getID());
					int gasolineLength = 0;
					int dieselLength = 0;
					for(int i=0;i<chosenStation.getGasolineArray().length;i++) {
						if(chosenStation.getGasolineArray()[i]==null) {
							break;
						}
						gasolineLength++;
						System.out.println();
						System.out.println("Gasoline...");
						System.out.println("The origin is: "+chosenStation.getGasolineArray()[i].getOrigin());
						System.out.println("Price per liter is: "+chosenStation.getGasolineArray()[i].getPricePerLiter());
						System.out.println("Total liters of this gasoline is: "+chosenStation.getGasolineArray()[i].getTotalLiters());
					}
					if(gasolineLength > 0) {
					System.out.println();
					System.out.println("The total gasoline liters in Station #" + chosenStation.getID() + " is " + chosenStation.getTotalGasolineInStation());
					System.out.println("The average gasoline price in Station #" + chosenStation.getID() + " is " + chosenStation.getAverageGasolinePrice());
					
					}
					
					for(int i=0;i<chosenStation.getDieselArray().length;i++) {
						if(chosenStation.getDieselArray()[i]==null) {
							break;
						}
						dieselLength++;
						System.out.println();
						System.out.println("Diesel...");
						System.out.println("The origin is: "+chosenStation.getDieselArray()[i].getOrigin());
						System.out.println("Price per liter is: "+chosenStation.getDieselArray()[i].getPricePerLiter());
						System.out.println("Total liters of this Diesel is: "+chosenStation.getDieselArray()[i].getTotalLiters());
					}
					if(dieselLength > 0) {
					System.out.println();
					System.out.println("The total diesel liters in Station #" + chosenStation.getID() + " is " + chosenStation.getTotalDieselInStation());
					System.out.println("The average diesel price in Station #" + chosenStation.getID() + " is " + chosenStation.getAverageDieselPrice());
					}
				}
				else {
					System.out.println("No station found with the given ID!");
				}
				break;
			}
			catch (InputMismatchException e) {
	            System.err.println("Please enter an integer!");
	            myscanner.nextLine();
			}
		}
	}

	
	
	
	public static void sellGasoline(Station[] stationArray) {
		Scanner myscanner = new Scanner(System.in);
		while(true) {
			try {
				System.out.print("Please enter the ID of the Station you want to sell Gasoline: ");
				int stationID = myscanner.nextInt();
				boolean isStationFound = false;
				Station desiredStation = null;
				for(int i=0;i<stationArray.length;i++) {
					if(stationArray[i]!=null && stationArray[i].getID()==stationID) {
						isStationFound=true;
						desiredStation=stationArray[i];
						break;
					}
				}
				System.out.println();
				if(isStationFound) {
					for(int i=0;i<desiredStation.getGasolineArray().length;i++) {
						if(desiredStation.getGasolineArray()[i]!=null) {
							Scanner myscanner2 = new Scanner(System.in);
							System.out.print("Please enter the car plate: ");
							String carPlate = myscanner2.nextLine();
							while(true) {
								try {
									System.out.print("Please enter the gasoline liter: ");
									double litersBought = myscanner2.nextDouble();
							
									if(desiredStation.totalGasolineInStation >= litersBought) {
										Scanner myscanner3 = new Scanner(System.in);
										System.out.print("Please enter if you have a coupon (y/n): ");
										String hasCouponstr = myscanner3.nextLine();
										boolean hasCoupon = false;
										if (hasCouponstr.equals("y")) {
											hasCoupon = true;
										}
										
										double extraction = desiredStation.totalGasolineInStation - litersBought;
										desiredStation.setTotalGasolineInStation(extraction);
										
				
										//GasolineService.java
										double target2 = desiredStation.getAverageGasolinePrice();
										double averageGasolinePrice = target2 * litersBought;
										desiredStation.getServiceArray()[serviceCount++]=new GasolineService(carPlate, litersBought, hasCoupon);
										desiredStation.getServiceArray()[serviceCount-1].makeTransaction(averageGasolinePrice);
										desiredStation.calcPro.add(desiredStation.getServiceArray()[serviceCount-1]);
										
										Collections.shuffle(desiredStation.personList);
										System.out.println("Personnel that helped during this service");
										
										Iterator<Person> itr = desiredStation.personList.iterator();
								        while(itr.hasNext()){
								        	Person person = itr.next();
								            if ( person instanceof Personnel){
								            	person.displayInformation();
								            	((Personnel) person).incJobCount();
								            	return;
								            }
								        }									
											
									}else {
										System.out.println("Not enough gasoline in the station!");
									}
									break;
								}
								catch (InputMismatchException e) {
						            System.err.println("price should be a double...");
						            myscanner2.nextLine();
								}
							}
						}else {
							System.out.println("There is no gasoline!");
						}
						break;
					}		
				}
				else {
					System.out.println("No station found with the given ID!");
				}
				break;
			}
			catch (InputMismatchException e) {
	            System.err.println("Please enter an integer!");
	            myscanner.nextLine();
			}
		}
	}
	
	
	
	public static void sellDiesel(Station[] stationArray) {
		Scanner myscanner = new Scanner(System.in);
		while(true) {
			try {
				System.out.print("Please enter the ID of the Station you want to sell Diesel: ");
				int stationID = myscanner.nextInt();
				boolean isStationFound = false;
				Station desiredStation = null;
				for(int i=0;i<stationArray.length;i++) {
					if(stationArray[i]!=null && stationArray[i].getID()==stationID) {
						isStationFound=true;
						desiredStation=stationArray[i];
						break;
					}
				}
				System.out.println();
				if(isStationFound) {
					for(int i=0;i<desiredStation.getDieselArray().length;i++) {
						if(desiredStation.getDieselArray()[i]!=null) {
							Scanner myscanner2 = new Scanner(System.in);
							System.out.print("Please enter the car plate: ");
							String carPlate = myscanner2.nextLine();
							while(true) {
								try {
									System.out.print("Please enter the diesel liter: ");
									double litersBought = myscanner2.nextDouble();
							
									if(desiredStation.totalDieselInStation >= litersBought) {
										Scanner myscanner3 = new Scanner(System.in);
										System.out.print("Please enter if you want discounted anti-freeze (y/n): ");
										String discountedAnti = myscanner3.nextLine();
										boolean discountedAntiFreeze = false;
										int discountedAntiFreezeCount = 0;
										if (discountedAnti.equals("y")) {
											discountedAntiFreeze = true;
											System.out.print("Please enter how many anti-freeze you want: ");
											discountedAntiFreezeCount = myscanner3.nextInt();
										}
										
											
										double extraction = desiredStation.totalDieselInStation - litersBought;
										desiredStation.setTotalDieselInStation(extraction);
										
										
										//DieselService.java
										double discountedAntiFreezePrice = 25;
										double target2 = desiredStation.getAverageDieselPrice();
										double averageDieselPrice = (target2 * litersBought);
										desiredStation.getServiceArray()[serviceCount++]=new DieselService(carPlate, litersBought, discountedAntiFreeze, discountedAntiFreezeCount, discountedAntiFreezePrice);
										desiredStation.getServiceArray()[serviceCount-1].makeTransaction(averageDieselPrice);
										desiredStation.calcPro.add(desiredStation.getServiceArray()[serviceCount-1]);
										
										Collections.shuffle(desiredStation.personList);
										System.out.println("Personnel that helped during this service");
										
										Iterator<Person> itr = desiredStation.personList.iterator();
								        while(itr.hasNext()){
								        	Person person = itr.next();
								            if ( person instanceof Personnel){
								            	person.displayInformation();
								            	((Personnel) person).incJobCount();
								    	        return;
								            }
								        }
														
									}else {
										System.out.println("Not enough diesel in the station!");
									}
									break;
								}
								catch (InputMismatchException e) {
						            System.err.println("price should be a double...");
						            myscanner2.nextLine();
								}
							}
						}else {
							System.out.println("There is no diesel!");
						}
						break;
					}		
				}
				else {
					System.out.println("No station found with the given ID!");
				}
				break;
			}
			catch (InputMismatchException e) {
		        System.err.println("Please enter an integer!");
		        myscanner.nextLine();
			}
		}
	}


	
	public static void displayServices(Station[] stationArray) {
		Scanner myscanner = new Scanner(System.in);
		while(true) {
			try {
				System.out.print("Please enter the ID of the Station you want to display: ");
				int stationID = myscanner.nextInt();
				boolean isStationFound=false;
				Station chosenStation=null;
				for(int i=0;i<stationArray.length;i++) {
					if(stationArray[i]!=null && stationArray[i].getID()==stationID) {
						isStationFound=true;
						chosenStation=stationArray[i];
						break;
					}
				}
				System.out.println();
				if(isStationFound) {
					System.out.println("Displaying the sold services of Station #"+chosenStation.getID());
					
					ArrayList<Service> serviceList = new ArrayList<Service>();
					for (int i = 0; i < chosenStation.serviceArray.length; i++) {
						if(chosenStation.serviceArray[i]!=null) {		
							serviceList.add(chosenStation.serviceArray[i]);
						}
					}
					
					Collections.sort(serviceList);
					
					for(Service a : serviceList ) {
						if(a != null) {
							a.displayServiceInfo();
						}
					}
				}
				else {
					System.out.println("No station found with the given ID!");
				}
				break;
			}
			catch (InputMismatchException e) {
		        System.err.println("Please enter an integer!");
		        myscanner.nextLine();
			}
		}
	}
	
	
		
	
	public static void sellCarWash(Station[] stationArray) {
		Scanner myscanner = new Scanner(System.in);
		while(true) {
			try {
				System.out.print("Please enter the ID of the Station you want to sell car wash: ");
				int stationID = myscanner.nextInt();
				boolean isStationFound = false;
				Station desiredStation = null;
				for(int i=0;i<stationArray.length;i++) {
					if(stationArray[i]!=null && stationArray[i].getID()==stationID) {
						isStationFound=true;
						desiredStation=stationArray[i];
						break;
					}
				}
				System.out.println();
				if(isStationFound) {
					Scanner myscanner2 = new Scanner(System.in);
					
					System.out.print("Please enter the car plate: ");						
					String carPlate = myscanner2.nextLine();
				
					double price = CarWash.basePrice;
					desiredStation.getServiceArray()[serviceCount++]=new CarWash(carPlate);	
					desiredStation.getServiceArray()[serviceCount-1].makeTransaction(price);
					desiredStation.calcPro.add(desiredStation.getServiceArray()[serviceCount-1]);
					
					Collections.shuffle(desiredStation.personList);
					System.out.println("Personnel that helped during this service");
					
					Iterator<Person> itr = desiredStation.personList.iterator();
			        while(itr.hasNext()){
			        	Person person = itr.next();
			            if ( person instanceof Personnel){
			            	person.displayInformation();
			            	((Personnel) person).incJobCount();
			            	return;
			            }
			        } 
				}
				else {
					System.out.println("No station found with the given ID!");
				}
				break;
			}
			catch (InputMismatchException e) {
		        System.err.println("Please enter an integer!");
		        myscanner.nextLine();
			}
		}
	}

	
	
	
	public static void addPerson(Station[] stationArray) {
		Scanner myscanner = new Scanner(System.in);
		
		System.out.println("1. Add a personnel");
		System.out.println("2. Add a manager");
		String select = null;
		select = myscanner.nextLine();
		System.out.println();		
		while(true) {
			try {
				System.out.print("Please enter the ID of the Station you want to search: ");
				int stationID = myscanner.nextInt();
				boolean isStationFound = false;
				Station desiredStation = null;
				for(int i=0;i<stationArray.length;i++) {
					if(stationArray[i]!=null && stationArray[i].getID()==stationID) {
						isStationFound=true;
						desiredStation=stationArray[i];
						break;
					}
				}
				System.out.println();
				if(isStationFound) {
					if(select.equals("1")) {
						Scanner myscanner2 = new Scanner(System.in);
						System.out.print("Please enter a name: ");
						String name = myscanner2.nextLine();
						System.out.print("Please enter a surname: ");
						String surname = myscanner2.nextLine();
						Person myPersonnel1 = new Personnel(name, surname);
						desiredStation.personList.add(myPersonnel1);
						desiredStation.calcPro.add(myPersonnel1);
					}
					else if(select.equals("2")) {
						Scanner myscanner3 = new Scanner(System.in);				
						System.out.print("Please enter a name: ");
						String name = myscanner3.nextLine();
						System.out.print("Please enter a surname: ");
						String surname = myscanner3.nextLine();
						System.out.print("Please enter how many years the manager is working: ");
						int jobYear = myscanner3.nextInt();
						Person myPersonnel2 = new Manager(name, surname, jobYear);
						desiredStation.personList.add(myPersonnel2);
						desiredStation.calcPro.add(myPersonnel2);
					}else {
						System.out.println("Enter a valid number");
					}
				}
				else {
					System.out.println("No station found with the given ID!");
				}
				break;
			}
			catch (InputMismatchException e) {
		        System.err.println("Please enter an integer!");
		        myscanner.nextLine();
			}
		}
	}
	
	
	
	
	public static void calculateNetProfit(Station[] stationArray) {
		Scanner myscanner = new Scanner(System.in);
		double totalProfit = 0;
		while(true) {
			try {
				System.out.print("Please enter the ID of the Station you want to calculate profit: ");
				int stationID = myscanner.nextInt();
				boolean isStationFound = false;
				Station desiredStation = null;
				for(int i=0;i<stationArray.length;i++) {
					if(stationArray[i]!=null && stationArray[i].getID()==stationID) {
						isStationFound=true;
						desiredStation=stationArray[i];
						break;
					}
				}
				System.out.println();
				if(isStationFound) {
					
					Iterator<Profitable> itr = desiredStation.calcPro.iterator();
			        while(itr.hasNext()){
		
			               Profitable profit = itr.next();
		
			               if ( profit instanceof Personnel){
			                   System.out.println("Personnel: "+ profit.calculate());
			                   totalProfit += ((Personnel) profit).calculate();
			               }
			               else if ( profit instanceof Manager){
			                   System.out.println("Manager: "+ profit.calculate());
			                   totalProfit += ((Manager) profit).calculate();
			               }
			               else if ( profit instanceof GasolineService){
			                   System.out.println("GasolineService: "+ profit.calculate());
			                   totalProfit += ((GasolineService) profit).calculate();
			               }
			               else if ( profit instanceof DieselService){
			                   System.out.println("DieselService: "+ profit.calculate());
			                   totalProfit += ((DieselService) profit).calculate();
			               }
			               else if ( profit instanceof CarWash){
			                   System.out.println("CarWash: "+ profit.calculate());
			                   totalProfit += ((CarWash) profit).calculate();
			               }
			        }
		            System.out.println("Net profit of station is: " + totalProfit);
				}
				else {
					System.out.println("No station found with the given ID!");
				}
				break;
			}
			catch (InputMismatchException e) {
		        System.err.println("Please enter an integer!");
		        myscanner.nextLine();
			}
		}
	}
	
	
	
	
	public static void displayServices2(Station[] stationArray) {
		Scanner myscanner = new Scanner(System.in);
		while(true) {
			try {
				System.out.print("Please enter the ID of the Station you want to display: ");
				int stationID = myscanner.nextInt();
				boolean isStationFound=false;
				Station chosenStation=null;
				for(int i=0;i<stationArray.length;i++) {
					if(stationArray[i]!=null && stationArray[i].getID()==stationID) {
						isStationFound=true;
						chosenStation=stationArray[i];
						break;
					}
				}
				System.out.println();
				if(isStationFound) {
					System.out.println("Displaying the sold services of Station #"+chosenStation.getID());
					
					ArrayList<Service> serviceList = new ArrayList<Service>();
					for (int i = 0; i < chosenStation.serviceArray.length; i++) {
						if(chosenStation.serviceArray[i]!=null) {		
							serviceList.add(chosenStation.serviceArray[i]);
						}
					}
					
					CarPlateComparator carPlateComp = new CarPlateComparator();
					Collections.sort(serviceList, carPlateComp);
					
					for(Service a : serviceList ) {
						if(a != null) {
							a.displayServiceInfo();
						}
					}
				}
				else {
					System.out.println("No station found with the given ID!");
				}
				break;
			}
			catch (InputMismatchException e) {
		        System.err.println("Please enter an integer!");
		        myscanner.nextLine();
			}
		}
	}
		
	
	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Gasoline[] getGasolineArray() {
		return gasolineArray;
	}

	public void setGasolineArray(Gasoline[] gasolineArray) {
		this.gasolineArray = gasolineArray;
	}

	public Diesel[] getDieselArray() {
		return dieselArray;
	}

	public void setDieselArray(Diesel[] dieselArray) {
		this.dieselArray = dieselArray;
	}

	public double getAverageGasolinePrice() {
		return averageGasolinePrice;
	}

	public void setAverageGasolinePrice(int averageGasolinePrice) {
		this.averageGasolinePrice = averageGasolinePrice;
	}

	public double getTotalGasolineInStation() {
		return totalGasolineInStation;
	}

	public void setTotalGasolineInStation(int totalGasolineInStation) {
		this.totalGasolineInStation = totalGasolineInStation;
	}

	public double getAverageDieselPrice() {
		return averageDieselPrice;
	}

	public void setAverageDieselPrice(int averageDieselPrice) {
		this.averageDieselPrice = averageDieselPrice;
	}

	public double getTotalDieselInStation() {
		return totalDieselInStation;
	}

	public void setTotalDieselInStation(int totalDieselInStation) {
		this.totalDieselInStation = totalDieselInStation;
	}

	public Service[] getServiceArray() {
		return serviceArray;
	}

	public void setServiceArray(Service[] serviceArray) {
		this.serviceArray = serviceArray;
	}

	public void setAverageGasolinePrice(double averageGasolinePrice) {
		this.averageGasolinePrice = averageGasolinePrice;
	}

	public void setTotalGasolineInStation(double totalGasolineInStation) {
		this.totalGasolineInStation = totalGasolineInStation;
	}

	public void setAverageDieselPrice(double averageDieselPrice) {
		this.averageDieselPrice = averageDieselPrice;
	}

	public void setTotalDieselInStation(double totalDieselInStation) {
		this.totalDieselInStation = totalDieselInStation;
	}

}