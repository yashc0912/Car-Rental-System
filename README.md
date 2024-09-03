# Car Rental System

## Project Overview

The Car Rental System is a Java-based console application designed to manage the renting and returning of cars within a small car rental business. The system allows customers to rent available cars for a specified number of days and facilitates the return process. The application handles essential operations like car availability, customer management, and rental transactions.

## Features

- **Car Management**: Add and manage cars with details such as brand, model, and base rental price.
- **Customer Management**: Register and manage customers who rent cars from the system.
- **Car Rental**: Rent cars to customers, calculate rental prices based on the number of days, and update car availability.
- **Car Return**: Manage the return of rented cars and update their availability.
- **Menu Interface**: User-friendly console menu for interacting with the system.

## Class Descriptions

### 1. Car.java

This class represents a car in the Car Rental System. It contains attributes like `carId`, `brand`, `model`, `basePricePerDay`, and `isAvailable`. The class provides methods to calculate the rental price based on the number of days, check availability, and update the car's status when rented or returned.

**Key Methods:**
- `calculatePrice(int rentalDays)`: Calculates the total rental price based on the number of days.
- `isAvailable()`: Checks if the car is available for rent.
- `rent()`: Marks the car as rented.
- `returnCar()`: Marks the car as returned and available for rent.

### 2. CarRentalSystem.java

This class is the core of the Car Rental System. It manages the list of cars, customers, and rentals. It provides functionalities for adding cars and customers, renting cars, and returning them. The class also includes a console-based menu to interact with the system.

**Key Methods:**
- `addCar(Car car)`: Adds a car to the system.
- `addCustomer(Customer customer)`: Registers a new customer.
- `rentCar(Car car, Customer customer, int days)`: Rents a car to a customer for a specified number of days.
- `returnCar(Car car)`: Manages the return of a rented car.
- `menu()`: Displays a console menu for the user to interact with the system.

### 3. Customer.java

This class represents a customer in the Car Rental System. It includes attributes like `customerId` and `name` to identify and manage customer details.

**Key Methods:**
- `getCustomerId()`: Returns the customer's ID.
- `getName()`: Returns the customer's name.

### 4. Main.java

The `Main` class is the entry point of the Car Rental System. It initializes the `CarRentalSystem`, adds a few cars to the system, and starts the menu interface for interaction.

**Key Functions:**
- Initializes the Car Rental System.
- Adds predefined cars to the system.
- Launches the system menu for user interaction.

### 5. Rental.java

The `Rental` class represents a rental transaction in the Car Rental System. It ties together the `Car`, `Customer`, and the number of days for which the car is rented.

**Key Methods:**
- `getCar()`: Returns the car involved in the rental.
- `getCustomer()`: Returns the customer involved in the rental.
- `getDays()`: Returns the number of days the car is rented.

## How to Run

1. **Clone the Repository**: Clone this repository to your local machine using `git clone <repository-url>`.
2. **Navigate to Project Directory**: Use a terminal or IDE to navigate to the project directory.
3. **Compile the Code**: Compile the Java files using a Java compiler.
4. **Run the Application**: Execute the `Main` class to start the Car Rental System.
5. **Follow the Menu**: Use the console menu to rent and return cars.

## Example Usage

Upon running the application, the system will prompt the user with a menu to either rent a car, return a car, or exit the system. The user can follow the on-screen prompts to perform these actions. The system will handle availability checks and update the system's records accordingly.

## Future Enhancements

- **Database Integration**: Store car, customer, and rental data in a database for persistence.
- **GUI Interface**: Develop a graphical user interface for a more user-friendly experience.
- **Extended Pricing**: Implement dynamic pricing models based on factors like seasonality, car demand, and rental duration.

## License

This project is open-source and available under the [MIT License](LICENSE).
