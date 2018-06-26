import java.util.Scanner;

public class DataStructuresJavaSubarray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		int count = 0;

		for (int i = 0; i < n; i++) {
			int sum = 0;

			for (int j = i; j < n; j++) {
				sum += a[j];
				if (sum < 0) {
					count++;
				}
			}
		}
		System.out.println(count);
	}

}
