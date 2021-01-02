import java.io.PrintWriter;
import java.util.Scanner;

public class AdditionAndSubtraction {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int x, y, z;
        x = in.nextInt();
        y = in.nextInt();
        z = in.nextInt();

        int result = -1;
        int limit = 1000; // because the maximum z is 1000 hence if we take the minimum difference between x and y as 1, we would need 2000 entries to exceed possibilty of reaching z 
        int[] arr = new int[limit*2 + 1];

        if(z == 0)
        {
          result = 0;
        } else if(x==y) {
          if(z==x) {
            result = 1;
          }        
        } else {
          
          arr[0] = 0;
          for(int i = 1; i <= limit; i++) {
              arr[(2*i)-1] = arr[(2*i)-2] + x;
              arr[(2*i)] = arr[(2*i)-1] - y;
              if(arr[(2*i)-1] == z)
              {
                result = (2*i)-1;
                break;
              }
              if(arr[(2*i)] == z)
              {
                result = (2*i);
                break;
              }
          }
        }

        out.println(result);

        in.close();
        out.close();
    }
}