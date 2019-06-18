import java.util.Scanner;

public class Main10 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int i, j;
		int arr[] = new int[n];
		int count = 0;
		int s = 0, t = 0;
		// 数据导入
		for (int m = 0; m < arr.length; m++) {
			arr[m] = in.nextInt();
		}
		for (i = 0; i < n; i++) {
			s = s + arr[i];
			if (s % k == 0) {
				count++;
			}

		}
		//子区间
		for (int m = 0; m < n; m++) {
			for (j = m + 1; j < n; j++) {
				t = t + arr[j];
				if (t % k == 0)
					count++;
			}
			t = 0;
		}
		System.out.println(count);
	}
}