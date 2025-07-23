import java.util.Random;
import java.util.Scanner;

public class Execise12_3 {
    public static void main(String [] args){


        try {
            int[] array = new int[100];


            Scanner input = new Scanner(System.in);
            Random random = new Random();

            for(int i = 0; i < array.length ; i++){
                array[i] = random.nextInt(100);

            }

            System.out.println("enter an index:");

            int index = input.nextInt();

            System.out.println(array[index]);
        }
        catch (ArrayIndexOutOfBoundsException ex){

            System.out.println(" the index is out of bounds");
        }


    }
}
