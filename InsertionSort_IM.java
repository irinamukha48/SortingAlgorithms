/**
 * This program will randomly generate a list of numbers ranging from 1 to input (inclusive)
 * and will sort them in an ascending order using the Insertion Sort method.
 * Insertion Sort takes the next item in the array and places it in the correct place of the already sorted part of the array
 *
 * @IMukhametzhanova
 * @1.8
 * 7/31/18
 */
import java.util.Random;

public class InsertionSort_IM
{
    public static void main(String [] args)
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

        int numOfComp = 0;
        int numOfMoved = 0;

        for (int i = 1; i < numOfData; i++){
            StdDraw.clear(StdDraw.WHITE);

            String moved = "Pairs moved: " + numOfMoved;

            int initi = i;
            for (int j = i - 1; j >= 0; j--){
                StdDraw.clear(StdDraw.WHITE);
                numOfComp++;
                String compared = "Pairs compared: " + numOfComp;
                for (int k = 0; k < numOfData; k++){
                    double height = data[k];
                    if (k == i || k == j) StdDraw.setPenColor(StdDraw.GREEN);
                    else StdDraw.setPenColor(StdDraw.RED);
                    StdDraw.filledRectangle(k + 0.5, height / 2, 0.5, height / 2);
                }
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.text(numOfData * 0.1, max * 0.95, compared);
                StdDraw.text(numOfData * 0.3, max * 0.95, moved);

                StdDraw.pause(1);
                StdDraw.show();

                if (data[i] < data[j]){
                    numOfMoved++;
                    moved = "Pairs moved: " + numOfMoved;
                    int temp = data[j];
                    data[j] = data[i];
                    data[i] = temp;
                    StdDraw.clear(StdDraw.WHITE);
                    for (int k = 0; k < numOfData; k++){
                        double height = data[k];
                        if (k == i || k == j) StdDraw.setPenColor(StdDraw.YELLOW);
                        else StdDraw.setPenColor(StdDraw.RED);
                        StdDraw.filledRectangle(k + 0.5, height / 2, 0.5, height / 2);
                    }
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.text(numOfData * 0.1, max * 0.95, compared);
                    StdDraw.text(numOfData * 0.3, max * 0.95, moved);
                }else if (data[i] >= data[j]) {
                    break;
                }

                StdDraw.pause(1);
                StdDraw.show();

                i--;
            }
            i = initi;
        }
    }
}
