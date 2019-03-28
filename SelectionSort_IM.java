/**
 * This program will randomly generate a list of numbers ranging from 1 to input (inclusive)
 * and will sort them in an ascending order using the Selection Sort method.
 * Selection Sort chooses the smallest number in the unsorted part of the list and puts it in the last place of the sorted part of the list.
 *
 * @IMukhametzhanova
 * @1.8
 * 7/24/18
 */
import java.util.Random;

public class SelectionSort_IM
{
    public static void main(String [] args)
    {
        Random rn = new Random();
        int max = Integer.parseInt(args[0]);
        int numOfData = Integer.parseInt(args[1]); //Prompts to input the max number from 1 to this number
        int [] data = new int[numOfData]; //Creates an array with the length of the input

        StdDraw.setCanvasSize(600, 600);
        StdDraw.setXscale(0, numOfData);
        StdDraw.setYscale(0, max);
        StdDraw.enableDoubleBuffering();
        StdDraw.setPenColor(StdDraw.RED);

        //Randomize the data
        for (int i = 0; i < numOfData; i++){
            data[i] = 1 + rn.nextInt(max);
        }

        int curMinInd;
        int temp;
        int numOfComp = 0; //Will be used to display the number of comparisons
        int numOfMoved = 0; //Will be used to display the number of movements made
        String compared = "Pairs compared: " + numOfComp;
        String moved = "Pairs moved: " + numOfMoved;

        for (int i = 0; i < numOfData; i++){
            StdDraw.clear(StdDraw.WHITE);



            compared = "Pairs compared: " + numOfComp;
            moved = "Pairs moved: " + numOfMoved;

            curMinInd = i;
            for (int j = i + 1; j < numOfData; j++){
                StdDraw.clear(StdDraw.WHITE);

                numOfComp++;

                compared = "Pairs compared: " + numOfComp;

                if (data[j] < data[curMinInd]){
                    curMinInd = j;
                }
                for(int k = 0; k < numOfData; k++){
                    double height = data[k];
                    if (k == j || k == curMinInd) StdDraw.setPenColor(StdDraw.GREEN);
                    else StdDraw.setPenColor(StdDraw.RED);
                    StdDraw.filledRectangle(k + 0.5, height / 2, 0.5, height / 2);
                }

                //Draw the text

                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.text(numOfData * 0.1, max * 0.95, compared);
                StdDraw.text(numOfData * 0.3, max * 0.95, moved);

                StdDraw.show();
                StdDraw.pause(1);
            }



            temp = data[i];
            data[i] = data[curMinInd];
            data[curMinInd] = temp;

            if (curMinInd != i && i != numOfData - 1){
                StdDraw.clear(StdDraw.WHITE);
                for (int j = 0; j < numOfData; j++){
                    double height = data[j];
                    if (j == curMinInd || j == i) StdDraw.setPenColor(StdDraw.YELLOW);
                    else StdDraw.setPenColor(StdDraw.RED);
                    StdDraw.filledRectangle(j + 0.5, height / 2, 0.5, height / 2);
                }
                numOfMoved++;
                moved = "Pairs moved: " + numOfMoved;

                //Draw the text
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.text(numOfData * 0.1, max * 0.95, compared);
                StdDraw.text(numOfData * 0.3, max * 0.95, moved);

                StdDraw.show();
                StdDraw.pause(1);
            }
        }

        StdDraw.setPenColor(StdDraw.RED);
        for(int i = 0; i < numOfData; i++){
            double height = data[i];
            StdDraw.filledRectangle(i + 0.5, height / 2, 0.5, height / 2);
        }

        //Draw the text
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(numOfData * 0.1, max * 0.95, compared);
        StdDraw.text(numOfData * 0.3, max * 0.95, moved);

        StdDraw.show();
    }
}