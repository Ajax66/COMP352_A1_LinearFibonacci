import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * This class implements a linear algorithm to generate the fibonacci sequence.
 * It then calls the method while incrementing the input and calculates the amount of time it took to run the method.
 */
public class LinearFibonacciAlgorithm
{
    /**
     * calculates fibonacci numbers.
     * @param n the nth fibonacci number to return.
     * @return a long[]. answer[0] contains the nth fibonacci number.
     */
    public static long[] LinearFibonacci(int n)
    {
        if (n <=1)
        {
            long[] answer = {n,0};
            return answer;
        }
        else
        {
            long[] temp = LinearFibonacci(n-1);
            long[] answer = {temp[0] + temp[1], temp[0]};
            return answer;
        }
    }

    /**
     * The main method implements a while loop to increment calls of the LinearFibonacci method, in increments of 5.
     * It opens a file named "outLinearFibonacci.txt" to keep track of the timings for each iteration, in nanoseconds.
     * @param args no arguments expected.
     */
    public static void main(String[] args)
    {
        long linearFibonacciStartTimeMs;
        long linearFibonacciEndTimeMs;
        long linearFibonacciElapsedTimeMs;

        long linearFibonacciStartTimeNano;
        long linearFibonacciElapsedTimeNano;
        long[] linearFibonacciResult;

        PrintWriter outWriter = null;
        FileWriter fileWriter;
        try
        {
            fileWriter = new FileWriter("outLinearFibonacci.txt");
            outWriter = new PrintWriter(fileWriter);
        }
        catch (IOException e)
        {
            System.out.println("Can't create outLinearFibonacci.txt. Program will now close");
            System.exit(1);
        }

        int count = 5;
        while(count <= 100)
        {
            linearFibonacciStartTimeMs = System.currentTimeMillis();
            linearFibonacciStartTimeNano = System.nanoTime();
            linearFibonacciResult= LinearFibonacci(count);
            linearFibonacciElapsedTimeNano = System.nanoTime() - linearFibonacciStartTimeNano;
            linearFibonacciEndTimeMs = System.currentTimeMillis();
            linearFibonacciElapsedTimeMs = linearFibonacciEndTimeMs - linearFibonacciStartTimeMs;
            outWriter.printf("[LinearFibonacci(%d)]\n\tResult: %d\n\tTime elapsed: %d ns\n\t\t\t\t  %d ms\n\n", count, linearFibonacciResult[0], linearFibonacciElapsedTimeNano, linearFibonacciElapsedTimeMs);

            count += 5;
        }
        outWriter.close();
    }
}