import java.io.PrintWriter;
import java.util.Scanner;

public class Increment {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		String inputNumber = in.nextLine();
		int lengthOfInputNumber = inputNumber.length();
		int numberOfNines = 0;
		int lengthOfIncrementedNumber = lengthOfInputNumber;
		
		for (int i = 0; i < lengthOfInputNumber; i++) {
			if(inputNumber.charAt(i) == '9') {
				numberOfNines++;
			} else {
				break;
			}
		}
		if(numberOfNines == lengthOfInputNumber)
			lengthOfIncrementedNumber += 1;
		
		out.println(lengthOfIncrementedNumber);

		in.close();
		out.close();
    }
}