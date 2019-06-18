import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;
 
public class Mian7 {
	public static TreeSet<Integer>  set = new TreeSet<>();
	public static List<Integer> list =new ArrayList<>();
	public static void f(String year,String mon,String day)
	{
		int y = Integer.parseInt(year);
		int m = Integer.parseInt(mon);
		int d = Integer.parseInt(day);
		if(y<=59)
		{
			y+=2000;
		}else {
			y+=1900;
		}
		if(((y%4==0&&y%100!=0)||y%400==0) && m==2 && d>0 && d<=29)
		{
			set.add(Integer.parseInt(""+y+mon+day));
		}
		if(y%4!=0 && m==2 && d>0 &&d<=28)
		{
			set.add(Integer.parseInt(""+y+mon+day));
		}
		if((m==1||m==3||m==5||m==7||m==8||m==10||m==12) && d>0 && d<=31)
		{
			set.add(Integer.parseInt(""+y+mon+day));
		}
		if((m==4|| m==6|| m==9|| m==11) && d>0&&d<=30)
		{
			set.add(Integer.parseInt(""+y+mon+day));
		}
            
	}
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	String str = in.nextLine();
	String[] s =str.split("/");
	f(s[0],s[1],s[2]);
	f(s[2],s[0],s[1]);
	f(s[2],s[1],s[0]);
	list.addAll(set);
	for(int i=0;i<list.size();i++)
	{
		String ans = ""+list.get(i);
		System.out.println(ans.substring(0, 4)+"-"+ans.substring(4,6)+"-"+ans.substring(6,8));
	}
	
}
}