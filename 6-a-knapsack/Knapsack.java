import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Arrays;
import java.util.*;
import java.io.*;  
import java.util.StringTokenizer;  
import java.util.ArrayList;
public class Knapsack {
	public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n, W;
        n = in.nextInt();
        W = in.nextInt();

        int[] w = new int[n];
        int[] v = new int[n];
        for (int i = 0; i < n; ++i) {
            w[i] = in.nextInt();
            v[i] = in.nextInt();
        }

        ArrayList<Integer> result = new ArrayList<Integer>();
        // your code
		Integer[][] dp = new Integer[n + 1][W + 1];
		for(int i = 0; i<= n; ++i) {
			for(int j = 0; j <= W; ++j) {
				if(i == 0 || j == 0) {
					dp[i][j] = 0;
				} else {
					if(j - w[i - 1] >= 0) {
						dp[i][j] = Math.max(dp[i - 1][j], dp[i -1][j - w[i - 1]] + v[i - 1]);
					} else {
						dp[i][j] = dp[i - 1][j];
					}
				}
			}
		}

		for(int i = n, j = W; i >= 1; --i) {
			if(dp[i][j] != dp[i - 1][j]) {
				result.add(i);
				j -= w[i - 1];
			}
		}
		Collections.sort(result);
		out.println(result.size());
        for (int i = 0; i < result.size(); ++i) {
            if (i != 0) out.print(' ');
            out.print(result.get(i));
        }
        out.println();

        out.close();
    }
}