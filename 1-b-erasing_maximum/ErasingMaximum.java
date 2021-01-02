import java.io.PrintWriter;
import java.util.Scanner;

public class ErasingMaximum {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n;
        n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        int[] result = new int[n - 1];

        // your code
		int max = Integer.MIN_VALUE;
		int maxIndex = -1;
		int maxCounter = 1;
		
		for(int i = 0; i < n; i++) {
			if(a[i] > max) {
				max = a[i];
				maxIndex = i;
				maxCounter = 1;
			} else if(a[i] == max) {
				maxCounter++;
				if(maxCounter == 3)
					maxIndex = i;
			}			
		}

		int resultIndex = 0;
		for (int i = 0; i < n; i++) {
			if(i == maxIndex)
				continue;
			result[resultIndex] = a[i];
			resultIndex++;
		} 

        for (int i = 0; i < result.length; ++i) {
            if (i != 0) out.print(' ');
            out.print(result[i]);
        }
        out.println();

        in.close();
        out.close();
    }
}