# Vehicle Booking System

## Description

The Vehicle Booking System is a Java-based application for managing and booking vehicles. This project includes features for vehicle registration, allocation, trip management, and reporting.

## Table of Contents

- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Database Setup](#database-setup)
- [Dependencies](#dependencies)



## Features

- Vehicle registration: Register new vehicles with their details (registration number, type, manufacturer, capacity).
- Vehicle allocation: Allocate vehicles for trips based on capacity and availability.
- Trip management: Record trip details, including start and end kilometers, start time, and trip status.
- Database integration: Store vehicle and trip data in a MySQL database.
- Reporting: Generate CSV reports of vehicle usage.

## Installation

To run this application, you'll need Java and MySQL installed on your system. Follow these steps to set up the project:

1. Install an integrated development environment to execute the program of specified language.
  
2. Install the MySQL database and configure it with your credentials. Update the database connection details in the code accordingly.

3. Download the MySQL Connector/J JAR file and add it to your project's classpath.

4. Establish the connection of database by adding the jar file to the project's classpath.

5.Build the project.


## Usage

1. Run the program:


2. Follow the on-screen instructions to interact with the system, including vehicle registration, allocation, and reporting.

## Database Setup

Create a MySQL database for the project. You can use a tool like phpMyAdmin or execute SQL commands in your MySQL client:

CREATE DATABASE suretrustproject;

Create the necessary tables in your database. 

You can do this by running the SQL script provided in your project's database folder or by executing SQL commands manually. 

Ensure that the tables match the structure required for the project.

Update the database connection details in the code to match your MySQL database credentials:

connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"Table Name", "your-username", "your-password");

## Dependencies
Java (JDK): The project requires Java to run. Make sure you have Java installed on your system.

MySQL: The application uses MySQL as its database. Install and configure MySQL with the required database and tables.

MySQL Connector/J: Download the MySQL Connector/J JAR file and add it to your project's classpath. You can find it here.

## Thank You

Thank you for using and exploring our Vehicle Booking System project! We hope you find it useful and valuable for your needs. If you have any questions, suggestions, or feedback, please feel free to reach out to us.

Happy coding!



