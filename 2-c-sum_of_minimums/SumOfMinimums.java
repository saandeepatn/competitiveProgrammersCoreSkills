import java.io.PrintWriter;
import java.util.Scanner;

public class SumOfMinimums {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n;
        n = in.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; ++i)
            A[i] = in.nextInt();

        // your code
		//int M = (int) 1e9 + 7;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int left = 0, right = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (A[j] >= A[i]) {
                    left++;
                } else break;
            }
            for (int j = i + 1; j < n; j++) {
                if (A[j] > A[i]) {
                    right++;
                } else break;
            }
            /*sum = (sum + A[i]) % M;
            sum = (sum + A[i]  * (left + (left + 1) * right)) % M;*/
			sum = (sum + A[i]);
            sum = (sum + A[i]  * (left + (left + 1) * right));
        }
        out.println(sum); 

        in.close();
        out.close();
    }
}