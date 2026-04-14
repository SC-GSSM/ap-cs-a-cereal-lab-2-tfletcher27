import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class CerealRunner
{
   /* Question 1: Write filterCarbsPerCup
    * This static method will return an ArrayList of cereal
    * objects with carbs per cup between min and max inclusive
    * @param: min - the minimum integer value of the range
    * @param: max - the maximum integer value of the range
    * Precondition: min < max
    */
   public static ArrayList<Cereal> filterCarbsPerCup(int min, int max)
   {
      ArrayList<Cereal> result = new ArrayList<Cereal>();

      for (Cereal c : cereals)
      {
         double carbsPerCup = c.getCarbs() / c.getCups();

         if (carbsPerCup >= min && carbsPerCup <= max)
         {
            result.add(c);
         }
      }
      return result;
   }
   
   /* Question 2: Write highestPercentFiber
    * This static method will return the cereal with the highest
    * percentage of Fiber per calorie
    * Precondition: cereals.size() > 0
    */
   public static Cereal highestPercentFiber()
   {
      Cereal max = cereals.get(0);
      double maxPercent = max.getFiber() / max.getCalories();

      for (Cereal c : cereals)
      {
         double percent = c.getFiber() / c.getCalories();

         if (percent > maxPercent)
         {
            maxPercent = percent;
            max = c;
         }
      }
      return max;
   }
 
   /* Question 3: Write findNetCarbsPerCup
    * This static method will take in a cereal object and returns
    * difference of carbs and fiber per cup for that cereal
    * @param: c - Cereal object
    */
   public static double findNetCarbsPerCup(Cereal c)
   {
      // Correct formula: (carbs - fiber) per cup
      return (c.getCarbs() - c.getFiber()) / c.getCups();
   }

   /* Question 4 Answer
    * All-Bran with Extra Fiber has the highest fiber per calorie.
    * Apple Jacks has moderate carbs and low fiber.
    * Cocoa Puffs has high carbs and very low fiber, making it less healthy.
    */

   /*****************************************************************
    * The code below does not need to be edited.
    ****************************************************************/
   
   // ArrayList of Cereal objects from cerealSubset.csv
   private static ArrayList<Cereal> cereals = new ArrayList<Cereal>();
 
   public CerealRunner(String fileName)
   {
      try
      {
         FileReader fileRdr = new FileReader(fileName);
         Scanner scan = new Scanner(fileRdr);

         while (scan.hasNext())
         {
            String myStr = scan.nextLine();
            String[] myArray = myStr.split(",");  

            String name = myArray[0];
            int calories = Integer.parseInt(myArray[1]);
            double fiber = Double.parseDouble(myArray[2]);
            double carbs = Double.parseDouble(myArray[3]);
            double cups = Double.parseDouble(myArray[4]);

            cereals.add(new Cereal(name, calories, fiber, carbs, cups));  
         }
         scan.close();
      } 
      catch (FileNotFoundException e)
      {
         System.out.println("An error occurred.");
         e.printStackTrace();
      }

      int numCereals = cereals.size();
      System.out.println(numCereals + " records created.");  
   }

   public static void main(String[] args)
   {
      String fileName = "src/data/cerealSubset.csv";
      CerealRunner cr = new CerealRunner(fileName);

      ArrayList<Cereal> results = filterCarbsPerCup(17, 18);

      String names = "[";
      for (Cereal c : results)
         names += c.getName() + ", ";

      if (names.length() > 2)
         names = names.substring(0, names.length() - 2) + "]";
      else
         names += "]";

      // Test Question 1
      System.out.println("\n*****Filter Carbs Per Cup Results*****");
      System.out.println("Actual results:   " + names);

      // Test Question 2
      System.out.println("\n*****Highest Percent Fiber Results*****");
      System.out.println("Actual results:   " + highestPercentFiber().getName());
     
      // Test Question 3
      System.out.println("\n*****Find Net Carbs Results*****");
      Cereal testCereal = new Cereal("Golden Crisp", 100, 0, 11, 0.88);
      System.out.println("Actual results:   " + findNetCarbsPerCup(testCereal));
   }
}