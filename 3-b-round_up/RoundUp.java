import java.io.PrintWriter;
import java.util.Scanner;

public class RoundUp {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        long x, y;
        x = in.nextLong();
        y = in.nextLong();

        long result = 0;

        // your code
		if(x*y < 0)
			result = x/y;
		else {
			if(x%y == 0)
				result = x/y;
			else 
				result = x/y + 1;
		}

        out.println(result);

        in.close();
        out.close();
    }
}