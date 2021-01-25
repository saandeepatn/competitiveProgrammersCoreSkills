import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Manhattan {
    public static void main(String[] arg) {
        FastScanner in = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n;
        n = in.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];

        for (int i = 0; i < n; ++i) {
            x[i] = in.nextInt();
            y[i] = in.nextInt();
        }

        int[] f = new int[n];
        int[] s = new int[n];

        // your code
		int minSum = Integer.MAX_VALUE;
		int minDiff = Integer.MAX_VALUE;
		int maxSum = Integer.MIN_VALUE;
		int maxDiff = Integer.MIN_VALUE;
		int a = 0;
		int b = 0;
		int c = 0;
		int d = 0;

		for(int i = 0; i< n; i++) {
			if(x[i] + y[i] > maxSum) {
				maxSum = x[i] + y[i];
				a = i + 1;
			}
			if(x[i] - y[i] > maxDiff) {
				maxDiff = x[i] - y[i];
				b = i + 1;
			}
			if(x[i] + y[i] < minSum) {
				minSum = x[i] + y[i];
				c = i + 1;
			}
			if(x[i] - y[i] < minDiff) {
				minDiff = x[i] - y[i];
				d = i + 1;
			}
			if(maxSum - minSum > maxDiff - minDiff) {
				f[i] = a;
				s[i] = c;
			} else {
				f[i] = b;
				s[i] = d;
			}
		}

        for (int i = 0; i < n; ++i) {
            out.println(f[i] + " " + s[i]);
        }

        out.close();
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}