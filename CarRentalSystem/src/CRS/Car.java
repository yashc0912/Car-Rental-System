package CRS;


public class Car {
	
	private String carId;
	private String brand;
	private String model;
	private double basePricePerDay;
	private boolean isAvailable;
	
	public Car(String carId,String brand, String model, double basePricePerDay) {
		
		this.carId = carId;
		this.brand = brand;
		this.model = model;
		this.basePricePerDay = basePricePerDay;
		this.isAvailable = true;

	}
	
	public String getCarId() {
		return carId;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public String getModel() {
		return model;
	}
	
	/**
	 * 
	 * @param rentalDays : No of days car is being rented
	 * @return final Rent applicable
	 */
	public double calculateprice (int rentalDays) {
		
		return basePricePerDay*rentalDays;
	}
	
	public boolean isAvailable() {
		
		return isAvailable;
	}
	
	public void rent() {
		isAvailable = false;
	}
	
	public void returnCar() {
		isAvailable = true;
	}
	
	
	
}
