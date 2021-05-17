package TwoThreeSemestrWork;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Generator {
    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(new File("C:\\SemestrWork\\2-3Tree-SemestrWork\\src\\main\\java\\random.txt"));
        Random rand = new Random();
        List<Integer> nums = new ArrayList<>();
        int number, count = 0;
        while (count < 10000) {
            number = rand.nextInt(10000) + 1;
            out.print("I" + " " + number);

            nums.add(count);

            count++;

            out.println();
        }
        out.close();
    }

}
