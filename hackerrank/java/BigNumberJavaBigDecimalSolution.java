import java.math.BigDecimal;
import java.util.*;

/**
 * @see ../bignumber_java-bigdecimal-task.pdf
 */
class BigNumberJavaBigDecimalSolution {
	public static void main(String[] args) {
		//Input
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] s = new String[n + 2];
		for (int i = 0; i < n; i++) {
			s[i] = sc.next();
		}
		sc.close();

		// Implementation begin
		boolean ordered = false;

		while (!ordered) {
			ordered = true;
			for (int i = 0; i < n - 1; i++) {
				BigDecimal firstNumber = new BigDecimal(s[i]);
				BigDecimal secondNumber = new BigDecimal(s[i + 1]);
				if (firstNumber.compareTo(secondNumber) == -1) {
					String temp = s[i];
					s[i] = s[i + 1];
					s[i + 1] = temp;
					ordered = false;
				}
			}
		}
		// Implementation end

		//Output
		for (int i = 0; i < n; i++) {
			System.out.println(s[i]);
		}
	}

/* Testcase 1
INPUT:
9
-100
50
0
56.6
90
0.12
.12
02.34
000.000

OUTPUT:
90
56.6
50
02.34
0.12
.12
0
000.000
-100
 */
}
