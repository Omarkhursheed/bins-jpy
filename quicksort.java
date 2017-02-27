import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
import java.io.PrintWriter;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class quicksort{
  public static int comps = 0;
  public static Random r = new Random();
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("How many numbers do you want to enter?");
    int number = scanner.nextInt();
    int[] array= new int[number];
    int i;
    System.out.println("Randomly generated (1) or user entry (2)");
    int check = scanner.nextInt();
    if (check == 2){
      for (i = 0; i < number; i++){
        System.out.println("Enter an integer element:");
        Scanner scanner1 = new Scanner(System.in);
        array[i] = scanner1.nextInt();
      }
    }
    else if (check == 1){
      for (i = 0; i < number; i++){
        array[i] = r.nextInt(1000);
      }
    }
    System.out.println("The unsorted array:");
     for (i = 0; i < number; i++)
    {
      System.out.println(array[i]);
    }  
    quickSort(array, 0, number - 1);
    System.out.println("\n\nThe sorted array:");
    for (i = 0; i < number; i++)
    {
      System.out.println(array[i]);
    }
    System.out.print("No of comparisons: ");
    System.out.print(comps);  
    try{
      String path1 = "/home/omarkhursheed/java-programs/qcomp.txt";
      String path2 = "/home/omarkhursheed/java-programs/qnum.txt";
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

  public static int partition (int arr[], int left, int right)
  {
    int i = left, j = right;
    int temp;
    int pivot = arr[(left + right)/2];
    while (i <= j)
    {
      while (arr[i] < pivot)
        {
          i++;
          comps++;
        }
      while (arr[j] > pivot)
        {
          j--;
          comps++;
        }
      if (i <= j){
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        i++;
        j--;
      }
      comps++;
    }
    return i;
  }

  public static void quickSort(int arr[], int left, int right){
    int p = partition(arr, left, right);
    if (left < p - 1)
      quickSort(arr, left, p -1);
    if (p < right)
      quickSort(arr, p, right);
  }

}