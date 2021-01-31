import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class EditDistance {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n, m;
        n = in.nextInt();
        m = in.nextInt();
        String u, w;
        u = in.next();
        w = in.next();
        int I, D, S;
        I = in.nextInt();
        D = in.nextInt();
        S = in.nextInt();

        int result = 0;

        // your code
		int[][] dp = new int[n + 1][m + 1];
		for(int i = 0; i < n + 1; i++) {
			for(int j = 0; j< m + 1; j++) {
				dp[i][j] = 0;
			}
		}
		for(int i = 0; i < n + 1; i++) {
			for(int j = 0; j< m + 1; j++) {
				if(i == 0 && j == 0) {
					dp[i][j] = 0;
				} else if(i == 0) {
					dp[i][j] = dp[i][j - 1] + I;
				} else if(j == 0) {
					dp[i][j] = dp[i - 1][j] + D;
				} else if(u.charAt(i - 1) == w.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.min(dp[i - 1][j - 1] + S, Math.min(dp[i - 1][j] + D, dp[i][j - 1] + I));
				}
			}
		}
		result = dp[n][m];

        out.println(result);

        out.close();
    }
}