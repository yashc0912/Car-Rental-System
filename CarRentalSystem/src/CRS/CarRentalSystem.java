package CRS;

import java.io.Closeable;
import java.util.*;

public class CarRentalSystem{
	
	
	private List<Car> cars;
	private List<Customer> customers;
	private List<Rental> rentals;
	
	public CarRentalSystem() {
		
		cars = new ArrayList<>();
		customers = new ArrayList<>();
		rentals = new ArrayList<>();
		
	}
	
	public void addCar(Car car) {
		cars.add(car);
	}
	
	public void addCustomer(Customer customer) {
		customers.add(customer);
	}
	
	
	/**
	 * 
	 * @param car the: carDetails customer want to rent
	 * @param customer : customer detail
	 * @param days : No. of Days he wants to rent the car
	 */
	public void rentCar(Car car, Customer customer, int days) {
		
		if(car.isAvailable()) {
			car.rent();
			rentals.add(new Rental(car, customer, days));
		}
		
		else {
			System.out.println("Car is not available for rent.");
		}
	}
	
	public void returnCar(Car car) {
		
		car.returnCar();
		
		Rental rentalToRemove = null;
		
		for(Rental rental : rentals) {
			
			if(rental.getCar() == car) {
				rentalToRemove = rental;
				break;
			}
		}
		
		if (rentalToRemove != null) {
			
			rentals.remove(rentalToRemove);
		}else {
			System.out.println("Car was not rented");
		}
	}
	
	public void menu() {
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			System.out.println("===== Car Rental System =====");
            System.out.println("1. Rent a Car");
            System.out.println("2. Return a Car");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = sc.nextInt();
            sc.nextLine(); // consume Line
            
           if (choice == 1) {
        	   
        	   System.out.println("\n== Rent a Car ==\n");
        	   System.out.println("Enter your name: ");
        	   String customerName = sc.nextLine();
        	   
        	   System.out.println("\n Available Cars:");
        	   for (Car car : cars) {
        		   
        		   if(car.isAvailable()) {
        			   System.out.println(car.getCarId()+" - "+car.getBrand()+" "+car.getModel());
        		   }
        	   }
        	   
        	   System.out.println("\nEnter the car ID you want to rent: ");
        	   String carId = sc.nextLine();
        	   
        	   System.out.println("\nEnter the numbe of days for rental: ");
        	   int rentalDays = sc.nextInt();
        	   sc.nextLine();
        	   
        	   Customer newCustomer = new Customer("Cus"+(customers.size()+1),customerName);
        	   addCustomer(newCustomer);
        	   
        	   Car selectedCar = null;
        	    for(Car car : cars) {
        	    	if(car.getCarId().equals(carId) && car.isAvailable()) {
        	    		selectedCar = car;
        	    		break;
        	    	}
        	    }
        	    
        	    if(selectedCar != null) {
        	    	
        	    	double totalPrice = selectedCar.calculateprice(rentalDays);
        	    	System.out.println("\n== Rent a Car ==\n");
        	    	System.out.println("Custometr ID: "+newCustomer.getCustomerId());
        	    	System.out.println("Customer Name: "+newCustomer.getName());
        	    	System.out.println("Car: "+selectedCar.getBrand()+" "+selectedCar.getBrand());
        	    	System.out.println("Rental Days: "+ rentalDays);
        	    	System.out.printf("Total Price: $%.2f%n",totalPrice);
        	    	
        	    	System.out.println("\nConfirm rental (Y/N): ");
        	    	String confirm = sc.nextLine();
        	    	
        	    	if(confirm.equalsIgnoreCase("Y")) {
        	    		rentCar(selectedCar, newCustomer, rentalDays);
        	    		System.out.println("\nCar rented successfully.");
        	    	}else {
        	    		System.out.println("\nRental Canceled.");
        	    	}
        	    }else {
        	    	System.out.println("\nInvalid car selectio or car not available for rent.");
        	    	
        	    }
        	   
           }else if(choice == 2) {
        	   System.out.println("\n== Return a Car ==\n");
        	   System.out.println("Enter the car ID you want to return: ");
        	   String carId = sc.nextLine();
        	   
        	   Car carToReturn = null;
        	   
        	   for (Car car : cars) {
        		   if(car.getCarId().equals(carId) && !car.isAvailable()) {
        			   
        			   carToReturn = car;
        			   break;
        		   }
        	   }
        	   
        	   if(carToReturn != null) {
        		   
        		   Customer customer = null;
        		   
        		   for(Rental rental : rentals) {
        			   
        			   if(rental.getCar() == carToReturn) {
        				   customer = rental.getCustomer();
        				   break;
        			   }
        		   }
        		   
        		   if (customer != null) {
        			   
        			   returnCar(carToReturn);
        			   System.out.println("Car returned successfully by "+customer.getName());
        			   
        			   
        		   }else {
        			   System.out.println("Car was not rented or rental information is missing.");
        		   }
        	   }else if(choice == 3) {
        		   sc.close();
        		   break;
        		  
        		
        	   }else {
        		   
        		   System.out.println("Invalid choice. Please enter a vlid option.");
        	   }
           }
           
           System.out.println("\nThank you for using the Car Rental System!");
            
		}
	}
	
	

}
