[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/s1KbEcyq)
[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=23342891)

# Cereal Lab 2 - Cereal Analysis

This project is designed for AP CS-A, focusing on analyzing data that has been processed with Java. The lab is based on the Cereal Lab provided by College Board on AP Classroom.

## Lab Directions and Prompt

Previously in Part 1 of this lab you created a `Cereal` class to model data pulled from this dataset:

<img width="587" height="397" alt="image" src="https://github.com/user-attachments/assets/16400c15-c49c-4c95-84c5-bf8ec4b546de" />

[https://www.kaggle.com/crawford/80-cereals/version/2#cereal.csv]

A stock `Cereal` class has been provided in this project regardless of what you answered previously. You should read and familizarize yourself with it.

Now we can analyze the cereal data to answer research questions such as:  

- Which cereals have between 17 and 18 carbohydrates by cup? 
- Which cereal has the highest percent of fiber per calorie?   
- How many net carbs are there in a specific cereal?

In this lab you will write and test the three **static** methods to answer those questions.

You will use the `CerealRunner` class, which contains starter code for this activity and a finished `main` method. You will edit the static method bodies at the beginning of this class, but **do not edit the `main` method until question 4**. Note, because you are writing static methods that need to access the `ArrayList` of `Cereal` objects, the `CerealRunner` class has a `static ArrayList` of `Cereal` objects.  

1. Write the method `public static ArrayList<Cereal> filterCarbsPerCup(int min, int max)` that returns an `ArrayList` of all cereals that are between `min` and `max` carbohydrates by cup, inclusive. Note that the serving size differs for each cereal, so you cannot simply use the carbohydrates information directly from the data set. You will need to calculate how many servings are in a cup and multiply the carbohydrates by that number (e.g., if a cereal has a serving size of 0.5 cups, there are 2 servings in a cup, so you will need to multiply the carbohydrates by 2 to calculate how many carbohydrates are in a cup). Once your method is completed, you can verify your code by running `CerealRunner.java`. (Not this is **NOT** the same as running tests for your grade.) The expected results and the results of your method will be printed to the console. Compare the two sets of results to validate your code. (30 points)
2. Write the method `public static Cereal highestPercentFiber()` that returns the `Cereal` object that has the highest percentage of fiber per calorie. You can calculate the percentage of fiber per calorie by dividing the amount of fiber by the number of calories in a serving size. (30 points)
3. Write the method `public static double findNetCarbsPerCup(Cereal c)` that will calculate the difference of the total carbohydrates and fiber in a cup. “Net carbs” is a term used to describe how many carbohydrates are absorbed by the body. While the net carb calculations for whole foods and processed foods are slightly different, for this lab, net carbs are calculated by taking the total amount of carbohydrates (the sum of sugar, starch, and fiber) and subtracting the amount of fiber because fiber is not absorbed by the body. (30 points)
4. Data validation is the process of checking the accuracy and quality of data before they are used, imported, or processed. You will now consider the validity of the cereal data you have been provided. Modify the `CerealRunner.java` to add the following lines of code to the main method to test your method that calculates net carbs for the cereals: All-Bran with Extra Fiber, Apple Jacks, and Cocoa Puffs. (10 points)
```
for(Cereal c: cereals) { 
   if(c.getName().equals("All-Bran with Extra Fiber") ||   
      c.getName().equals("Apple Jacks") ||  
      c.getName().equals("Cocoa Puffs")) 
   { 
       System.out.println("\nCereal: " + c.getName() + ", NetCarbs: "    
                           + findNetCarbs(c)); 
   } 
}
```

Look at the values that are displayed. One of the values is not valid! Which value seems out of place? What conclusions might you draw about this data set based on your research? Write your answer in the comments of the `CerealRunner.java` file. You **MUST** begin your comment with "Question 4 Answer" as part of a multi-line comment answer.

## Project Structure

- **`cerealSubset.csv`**: A file that contains the name, calories, fiber, carbohydrates, and cups for 76 different cereals.  
- **`Cereal.java`**: A complete Cereal class to model cereals from the cereal dataset.
- **`CerealRunner.java`**: Contains class file stubs. Students are required to complete these classes and the appropriate methods. Some testing code is included. **THIS IS THE FILE YOU EDIT**
- **`CerealRunnerTest.java`**: JUnit test cases for each method in `CerealRunner.java`. These tests validate the correctness of the implemented methods. **RUN THIS TO SEE YOUR CURRENT GRADE**
- **`pom.xml`**, **`devcontainer.json`**: JSON file for setting up Codespaces and Maven configuration file that manages dependencies and plugins required to build and run the project. **DO NOT TOUCH THESE**

## Workflow Instructions

### Option 1: GitHub Codespaces (Recommended)

1. Click the green **Code** button on this repository
2. Select the **Codespaces** tab
3. Click **Create codespace on main**
4. Wait for the environment to build (~2 minutes the first time)
5. Start coding in `src/main/java/CerealRunner.java`

> **Note:** If the Java extension shows errors on first load, press `Cmd+Shift+P` (Mac) or `Ctrl+Shift+P` (Windows) and run **"Developer: Reload Window"**. This is a one-time setup step.

### Option 2: Local Development

1. Accept the assignment via the GitHub Classroom link
2. Clone the repository using GitHub Desktop
3. Open the project in your IDE (VS Code, IntelliJ, or Eclipse)
4. **Requirements:** Java 17+, Maven 3.x

## Running Tests

### In VS Code / Codespaces

Click the green play button next to any test method in `Unit4Test.java`, or open the **Testing** sidebar (beaker icon).

### Command Line

Run all tests:
```
mvn test
```
## Autograding

Your code is automatically graded when you push to GitHub. Check the **Actions** tab to see your score. Each method is tested independently — you earn points for each method you complete correctly.

## Honor Code
Remember to adhere to the GSSM Academic Integrity Policy. Do not copy code from others or AI, and ensure all work is your own.

## Contact
If you have any questions or need assistance, send me an email or come to office hours. 

## Acknowledgements
This project has been adapted from the cereal lab available on AP Classroom by College Board. ChatGPT helped write `devcontainer.json`, `classroom.yaml`, and `CerealRunnerTests.java`.
