import java.util.ArrayList;
import java.util.Scanner;

public class KMP {
	
	public static int[] LPS(String ptr) {
		
		int n=ptr.length();
		int lps[]=new int[n];
		
		int len=0, i=1;
		
		while( i<n ) {
			
			if( ptr.charAt(i)==ptr.charAt(len) ) {
				len++;
				lps[i]=len;
				i++;
			}else {
				
				if( len==0 ) {
					lps[i]=0;
					i++;
				}else {
					len=lps[len-1];
				}
				
			}
			
		}
		
		return lps;
		
		
		
	}
	
	public static ArrayList<Integer> kmp( String str, String prt ) {
		
		int lps[]=LPS(prt);
		
		int m=str.length();
		int n=prt.length();
		
		ArrayList<Integer> ans=new ArrayList<>();
		
		int i=0, j=0;
		
		while( i<m ) {
			
			if( str.charAt(i)==prt.charAt(j) ) {
				i++;
				j++;
			}
			
			if( j==n ) {
				ans.add( i-n );
				j=lps[j-1];
			}
			else if(  i<m && str.charAt(i)!=prt.charAt(j) ) {
				
				if( j==0 ) {
					i++;
				}else {
					j=lps[j-1];
				}
				
			}
			
		}
		
		
		return ans;
		
	}
	
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		String str, prt;
		str=sc.next();
		prt=sc.next();
		
		ArrayList<Integer> list=kmp(str, prt);
		
		System.out.println(list);
	}
}
