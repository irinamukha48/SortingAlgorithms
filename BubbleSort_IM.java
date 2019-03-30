/**
 * This program will randomly generate a list of numbers ranging from 1 to input (inclusive)
 * and will sort them in an ascending order using the Bubble Sort method.
 * Bubble Sort is comparing two consecutive numbers and switches them if the greater number is on the left.
 * If it reaches the end of the list, it goes back to the beginning and repeats the process until everything is sorted.
 *
 * @IMukhametzhanova
 * @1.8
 * 7/23/18
 */
import java.util.Random;

public class BubbleSort_IM
{
    public static void main (String [] args)
    {
        Random rn = new Random();
        int max = Integer.parseInt(args[0]);
        int numOfData = Integer.parseInt(args[1]); //Prompts to input the max number from 1 to this number
        int [] data = new int[numOfData]; //Creates an array with the length of the input

        StdDraw.setCanvasSize(800, 800);
        StdDraw.setXscale(0, numOfData);
        StdDraw.setYscale(0, max);
        StdDraw.enableDoubleBuffering();
        StdDraw.setPenColor(StdDraw.RED);

        //Randomize the data
        for (int i = 0; i < numOfData; i++){
            data[i] = 1 + rn.nextInt(max);
        }

        //Sort out the data
        int check1, check2; //Will be used to check two consecutive values
        int numOfMov = 0; //Will be used to check if the array is sorted
        boolean sorted = false; //Checks if the array is sorted
        boolean needToMove = false; //Will be used to decide how to display the output of the movement needs to be made
        int numOfComp = 0; //Will be used to display the number of comparisons
        int numOfMoved = 0; //Will be used to display the number of movements made

        //The animation
        while (sorted == false){
            for (int i = 0; i < numOfData - 1; i++){
                StdDraw.clear(StdDraw.WHITE);
                numOfComp++;

                String compared = "Pairs compared: " + numOfComp;
                String moved = "Pairs moved: " + numOfMoved;


                check1 = data[i];
                check2 = data[i+1];

                if (check1 > check2){ //If movement needs to be made
                    needToMove = true;
                    numOfMoved++;
                    numOfMov++;
                }

                //Draw the data with the comparison (green)
                for (int j = 0; j < numOfData; j++){
                    double height = data[j];
                    if (j == i || j == (i + 1)) StdDraw.setPenColor(StdDraw.GREEN);
                    else StdDraw.setPenColor(StdDraw.RED);
                    StdDraw.filledRectangle(j + 0.5, height / 2, 0.5, height / 2);
                }

                //Draw the text
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.text(numOfData * 0.1, max * 0.95, compared);
                StdDraw.text(numOfData * 0.3, max * 0.95, moved);

                if (needToMove == true){
                    StdDraw.show();
                    StdDraw.pause(1);
                    StdDraw.clear(StdDraw.WHITE);

                    data[i] = check2;
                    data[i+1] = check1;

                    //Draw the data with the movement (yellow)
                    for (int j = 0; j < numOfData; j++){
                        double height = data[j];
                        if (j == i || j == (i + 1)) StdDraw.setPenColor(StdDraw.YELLOW);
                        else StdDraw.setPenColor(StdDraw.RED);
                        StdDraw.filledRectangle(j + 0.5, height / 2, 0.5, height / 2);
                    }
                }
                needToMove = false;

                //Draw the text
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.text(numOfData * 0.1, max * 0.95, compared);
                StdDraw.text(numOfData * 0.3, max * 0.95, moved);

                StdDraw.show();
                StdDraw.pause(1);
            }

            //If the data is sorted
            if (numOfMov == 0){
                sorted = true;
            }
            numOfMov = 0;
        }
    }
}

