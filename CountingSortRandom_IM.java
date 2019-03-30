/**
 * This program will randomly generate a list (with input length) of numbers from 0 to max input (inclusive)
 * and will sort them in an ascending order using the Counting Sort method.
 * Counting sort method first calculates how many of each number there is in the list and creates a list of those values.
 * Then it adds the two consecutive values and makes the second value the sum, and it repeats until it reaches the end of the list of values.
 * Then, it goes down the list of numbers and calculates its new position using its value in the value list, subtracting 1 from that value after each use.
 * The new sorted list of numbers is printed out.
 *
 * @IMukhametzhanova
 * @1.8
 * 7/24/18
 */
import java.util.Random;

public class CountingSortRandom_IM
{
    public static void main (String [] args)
    {
        Random rn = new Random();
        int max = Integer.parseInt(args[0]);
        int length = Integer.parseInt(args[1]);
        int [] data = new int[length];

        //Randomize the data
        for (int i = 0; i < length; i++){
            int newNum = rn.nextInt(max + 1);
            data[i] = newNum;
        }

        int [] check = new int[max+1];
        int [] sortedData = new int[length];

        //Print out the original data
        System.out.println("Data:   ");

        for (int i = 0; i < length; i++){
            System.out.printf("%4d", data[i]);
        }

        System.out.println();
        System.out.println("Check:  "); //Will be used to print out the original list of amounts of numbers

        //Calculate the amount of each number in the list
        for (int i = 0; i < length; i++){
            check[data[i]]++;
        }

        //Print out the amounts
        for (int i = 0; i < max+1; i++){
            System.out.printf("%4d", check[i]);
        }

        System.out.println();
        System.out.println("Modif:  "); //Will be used to print out the modified list of amounts

        //Create a new list of amounts by adding consecutive values
        for (int i = 0; i < max; i++){
            int mod = check[i] + check[i+1];
            check[i+1] = mod;
        }

        //Print out the modified list of amounts
        for (int i = 0; i < max+1; i++){
            System.out.printf("%4d", check[i]);
        }

        System.out.println();
        System.out.println("Sorted: "); //Will be used to print out the sorted array

        //Creates a new sorted array using the modified amounts array and assigning new indices to the original data
        for (int i = 0; i < length; i++){
            sortedData[check[data[i]] - 1] = data[i];
            check[data[i]]--;
        }

        //Print out the sorted array
        for (int i = 0; i < length; i++){
            System.out.printf("%4d", sortedData[i]);
        }

        System.out.println();
        System.out.println("**********************************");
    }
}
