import java.util.Scanner;
import java.util.Arrays;
import java.io.PrintWriter;
import java.io.File;
import java.util.Random;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class bins {
    public static int comps = 0;
    public static Random r = new Random();
    public static void main(String[] args){
      Scanner scanner = new Scanner(System.in);
      System.out.print("How many integers do you wish to enter?");
      int number = scanner.nextInt();
      int[] array = new int[number];
      int i;
      System.out.print("Randomly generated (1) or user entry (2)?");
      int check = scanner.nextInt();
      if (check == 2){
        for (i = 0; i < number; i++){
          System.out.print("Enter an integer element to the array");
          Scanner scanner1 = new Scanner(System.in);
          array[i] = scanner.nextInt();
        }
      }
      else if (check == 1){
        for (i = 0; i < number; i++){
          array[i] = r.nextInt();
        }
      }
      for (i = 0; i < number ;i++ ) {
        System.out.println(array[i]);      
      }
      System.out.print("\n\n\nSorted Array\n");
      Arrays.sort(array);
      for (i = 0; i < number ;i++ ){
        System.out.println(array[i]);      
      }
      System.out.println("Enter element to be searched for");
      Scanner scanner2 = new Scanner(System.in);
      int key = scanner2.nextInt();
      int x = binsearch(array, key);
      if (x != -1){  
      System.out.print("The required number is at position " + x );
      System.out.println(" in the array formed after sorting");
      }
      else{
        System.out.println("The required element is not present");
      }
      System.out.println("The number of comparisons is " + comps);
      try{
      String path1 = "/home/omarkhursheed/binsearch/comparisons.txt";
      String path2 = "/home/omarkhursheed/binsearch/numbers.txt";
      File file1 = new File(path1);
      File file2 = new File(path2);
    
      FileWriter fw1 = new FileWriter(file1.getAbsoluteFile(),true);
      FileWriter fw2 = new FileWriter(file2.getAbsoluteFile(),true);
      BufferedWriter bw1 = new BufferedWriter(fw1);
      BufferedWriter bw2 = new BufferedWriter(fw2);

      bw1.write(Integer.toString(comps));
      bw1.newLine();

      bw2.write(Integer.toString(number));
      bw2.newLine();

      bw1.close();
      bw2.close();
    }
      catch (IOException e){
    e.printStackTrace();
  }
  }


  public static int binsearch(int[] inpArr, int key)
  {
    int start = 0;
    int end = inpArr.length - 1;
    

    while(start <= end){
      int mid = (start + end)/2;
      if (key == inpArr[mid]){
        return mid;
      }
      else if (key < inpArr[mid]){
        end = mid - 1;
      }
      else if (key > inpArr[mid]){
        start = mid + 1;
      }
      comps++;
    }
      return - 1;
  }
}