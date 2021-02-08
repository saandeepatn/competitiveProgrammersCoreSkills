import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ChainMatrix {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n;
        n = in.nextInt();
        int[] m = new int[n + 1];
        for (int i = 0; i <= n; ++i)
            m[i] = in.nextInt();

        long result = 0;
        // your code
		long[][] dp = new long[n][n];
		for(int i = 0; i < n; ++i) {
			dp[i][i] = 0;
		}
		for(int i = 0; i < n - 1; ++i) {
			dp[i][i + 1] = dp[i][i] + dp[i + 1][i + 1] + m[i] * m[i + 1] * m[i + 2];
		}

		int len = 3;
		while(len <= n) {
			for(int i = 0; i < n - len + 1; ++i) {
				int j = i + len - 1;
				dp[i][j] = Integer.MAX_VALUE;
				for(int k = i; k < j; ++k) {
					dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + m[i] * m[k + 1] * m[j + 1]);
				}
			}
			++len;
		}

		result = dp[0][n - 1];

        out.println(result);

        out.close();
    }
}