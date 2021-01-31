import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class LIS {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n;
        n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        int result = 0;
        // your code
		int[] dp = new int[n];
		for(int i = 0; i < n; i++) {
			dp[i] = 1;
		}

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < i; j++) {
				if(a[i] > a[j])
					dp[i] = Math.max(dp[i], dp[j] + 1);
			}
		}

		for(int i = 0; i < n; i++) {
			if(result < dp[i])
				result = dp[i];
		}

        out.println(result);

        out.close();
    }
}