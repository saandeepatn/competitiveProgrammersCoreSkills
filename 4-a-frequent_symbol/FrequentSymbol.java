import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Arrays;
import java.io.*;  
import java.util.StringTokenizer;  

public class FrequentSymbol {
    public static void main(String[] arg) {
        FastScanner in = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        String s;
        s = in.next();
        int q;
        q = in.nextInt();
        int[] l = new int[q];
        int[] r = new int[q];
        for (int i = 0; i < q; ++i) {
            l[i] = in.nextInt();
            r[i] = in.nextInt();
        }

        char[] result = new char[q];

        // your code
		int[][] holder = new int[s.length()][26];
		for(int i = 0; i < s.length(); i++) {
			for(int j = 0; j < 26; j++) {
				holder[i][j] = 0;
			}
		}
		holder[0][s.charAt(0) - 'a'] = holder[0][s.charAt(0) - 'a'] + 1;
		for(int i = 1; i < s.length(); i++) {
			for(int j = 0; j < 26; j++) {
				holder[i][j] = holder[i-1][j];
			}
			holder[i][s.charAt(i) - 'a']++;
		}

		for(int i = 0; i < q; i++) {
			int answer = -1;
			int charFrequency;
			char c = ' ';
			// indezes start from 1 as per problem
			int left = l[i] - 1;
			int right = r[i] - 1;

			int removeLeft = left - 1;
			
			for(int j = 0; j < 26; j++) {
				charFrequency = holder[right][j];
				
				if(removeLeft>=0)
					charFrequency = charFrequency - holder[removeLeft][j];
								
				if(charFrequency > answer) {
					answer = charFrequency;
					c = (char)(j + 'a');
				}
			}
			result[i] = c;			
		}		

        for (int i = 0; i < result.length; ++i) {
            out.println(result[i]);
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