import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;


public class heapsort{
  public static int n;
  public static int greatest;
  public static int[] a;
  public static Random r = new Random();
  public static void swap(int[] numbers, int i, int j){
    int temp = numbers[i];
    numbers[i] = numbers[j];
    numbers[j] = temp;
  }
  public static void heapify(int[] arr, int i){
    int lc = 2*i + 1;
    int rc = 2*i + 2;
    if (lc <= n && arr[lc] > a[i]){
      greatest = lc;
    } else {
      greatest = i;
    }
    if (rc <= n && arr[rc] > a[greatest]){
      greatest = rc;
    }
    if (greatest != i){
      swap(arr, i, greatest);
      System.out.println("\n");
      for (int k = 0; k < arr.length; k++)
      {
        System.out.println(arr[k]);
      }
      heapify(arr, greatest);
    }
  }
  public static void sort (int[] arr){
    a = arr;
    buildheap(a);
    for ( int i = n; i > 0; i--){
      swap(a, 0,i);
      System.out.println("\n");
      for (int k = 0; k < arr.length; k++)
      {
        System.out.println(arr[k]);
      }
      n--;
      heapify(a, 0);
    }
  }
  public static void buildheap(int[] arr){
    n = arr.length - 1;
    for (int i = n/2; i >= 0; i--){
      heapify(arr,i);
    }
  }
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("How many numbers do you want to enter?");
    int number = scanner.nextInt();
    if (number <= 0)
    {
      System.out.println("This is invalid. Please run again");
      return;
    }
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

    sort(array);
    System.out.println("\n\n The sorted array:");
    for (i = 0; i < number; i++)
    {
      System.out.println(array[i]);
    }  
  }
}