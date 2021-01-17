import java.io.PrintWriter;
import java.util.Scanner;

public class King {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int r, c;
        r = in.nextInt();
        c = in.nextInt();

        int result = 0;

        // your code
		int R = Math.min(r,c);
		int C = Math.max(r,c);
		int MAX_N = 106;
		int[] v1 = new int[MAX_N];
		int[] v2 = new int[MAX_N];

		int a = 0;
		for(int i = 1; i < MAX_N; i += 3, a += (3 - 1)) {
			v1[i] = a;
			v1[i + 1] = a + 1;
			v1[i + 2] = a + 2;
		}

		if(R == 1) {
			result = v1[C];
		} else {
			a = v1[R];
			for(int j=1;j<MAX_N; j+= 3, a += (R + R + v1[R])) {
				v2[j] = a;
				v2[j + 1] = a + R;
				v2[j + 2] = a + R + R;
			}
			result = v2[C];
		}

		out.println(result);

		in.close();
		out.close();
    }

}