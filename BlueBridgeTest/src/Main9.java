import java.util.Scanner;
 
public class Main9 {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int k=s.nextInt();
		int qkl[][]=new int[n][2];
		for(int i=0;i<n;i++){
			qkl[i][0]=s.nextInt();
			qkl[i][1]=s.nextInt();
		}
		System.out.println(fun(qkl,k));
	}
	public static int fun(int b[][],int k){
		int max=0;
		for(int i=2;;i++){
			int x=0;
			for(int j=0;j<b.length;j++){
				if(b[j][0]/i>0&&b[j][1]/i>0)
					x+=(b[j][0]/i)*(b[j][1]/i);//总块数
			}
			if(x<k){//若小于k块
				max=i-1;
				break;
			}
		}
		return max;
	}
}