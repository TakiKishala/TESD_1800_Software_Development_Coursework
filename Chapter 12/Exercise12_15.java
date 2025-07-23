import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Exercise12_15 {
    public static void main ( String [] args) throws IOException {
        File file = new File("Exercise12_15");

        if(!file.exists()){
            try(PrintWriter output = new PrintWriter(file)){
                Random random = new Random();
                for(int i = 0; i < 100 ; i++){
                    int num = random.nextInt(1000);
                    output.print(num + " ");
                }
            }
        }
        ArrayList<Integer> numbers = new ArrayList<>();

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNext()){
                numbers.add(scanner.nextInt());
            }
        }

        Collections.sort(numbers);
        System.out.println("Sorted numbers:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }

    }
}