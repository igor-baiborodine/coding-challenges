import java.util.Arrays;
import java.util.Scanner;

public class DataStructuresJavaSubarray {

	private static int count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
//		System.out.println(n + ", " + Arrays.toString(arr));

		for (int i = 0; i < n; i++) {
			computePartialSums(arr, i);
		}
		System.out.println(count);
	}

	private static void computePartialSums(int[] arr, int start) {
		int[] partialSums;
		if ((arr.length - start) % 2 == 1) {
			partialSums = new int[(arr.length + 1) / 2];
		} else {
			partialSums = new int[arr.length / 2];
		}

		if (arr.length == 2) {
			countNegative(arr[0]);
			countNegative(arr[1]);
			countNegative(arr[0] + arr[1]);
		} else{
			int j = 0;
			for (int i = start; i < arr.length; i++) {
				if (i % 2 == 1) {
					countNegative(arr[i - 1]);
					countNegative(arr[i]);
					partialSums[j] = arr[i - 1] + arr[i];
					j++;
				} else if (i == arr.length - 1) {
					countNegative(arr[i]);
					partialSums[j] = arr[i];
				}
			}
			computePartialSums(partialSums, 0);
		}
	}

	private static void countNegative(int number) {
		if (number < 0) {
			count++;
		}
	}

}
