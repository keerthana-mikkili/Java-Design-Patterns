# Design Patterns

## Overview
This project focuses on implementing various design patterns in Java, specifically the Factory Design Pattern. The goal is to create a structured system for handling different types of items and managing a store.

## Requirements
1.Eclipse, VS Code, or IntelliJ.
Note: If using Eclipse, ensure Git CLI is installed or use GitHub Desktop for code commits.

## SetUp Instructions
1. Clone the repository to your local system.
2. For Eclipse, import the project as an Existing Maven Project. For IntelliJ, open it directly using 'Get from VCS'.
3. All code should be pushed to the main branch.
4. Ensure GitHub actions are successful post-push.


## Project Overview

### Item Superclass
Create an Item superclass to serve as the API.

### Item Subclasses
Derive three classes from Item: FoodItem, ElectronicItem, and ServiceItem. Each class must override the toString() method.

### CSV File Handling
Create a FileUtil class for reading and writing text files. Objects should be created from CSV files (FoodItemCSV.txt, ElectronicItemCSV.txt, ServiceItemCSV.txt).

For example:

In FoodItemCSV.txt, each line contains data for a single FoodItem object.

### Factory Design Pattern
Apply the Factory Design Pattern to abstract the creation of ALL objects.

1. FoodItemFactory: Implements the Factory method pattern.
2. ElectronicItemFactory: Implements Lazy Singleton and Factory method patterns.
3. ServiceItemFactory: Implements Eager Singleton and Factory method patterns.

### AbstractStore and Store Class
Create an AbstractStore abstract class.
Derive a Store class from AbstractStore and use its demo() method to create several objects using the Factories. Sort them by:
1. ID
2. Name
3. Price