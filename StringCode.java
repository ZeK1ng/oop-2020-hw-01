import java.util.HashSet;
import java.util.Set;

// CS108 HW1 -- String static methods

public class StringCode {

	/**
	 * Given a string, returns the length of the largest run.
	 * A a run is a series of adajcent chars that are the same.
	 * @param str
	 * @return max run length
	 */
	public static int maxRun(String str) {
		if(str.length() ==0) return 0;
		int res=1;
		int temp=1;
		for(int i=0; i< str.length()-1; i++) {
			if(str.charAt(i) == str.charAt(i+1)) {
				temp++;
				res= Math.max(res, temp);
			}else {
				temp =1;
			}
		}
		return res; // YOUR CODE HERE
	}

	
	/**
	 * Given a string, for each digit in the original string,
	 * replaces the digit with that many occurrences of the character
	 * following. So the string "a3tx2z" yields "attttxzzz".
	 * @param str
	 * @return blown up string
	 */
	public static String blowup(String str) {
		String res ="";
		if(str.length()==0)return res;
		
		for(int i =0; i< str.length()-1 ; i++) {
			char ch = str.charAt(i);
			if(Character.isDigit(ch)) {
				for(int k =0; k<Integer.parseInt(ch+"");k++) {
					res+=str.charAt(i+1);
				}
			}else {
				res+=str.charAt(i);
			}
		}
		if(!Character.isDigit(str.charAt(str.length()-1))){
			res+=str.charAt(str.length()-1);
		}
		return res;
	}
	
	/**
	 * Given 2 strings, consider all the substrings within them
	 * of length len. Returns true if there are any such substrings
	 * which appear in both strings.
	 * Compute this in linear time using a HashSet. Len will be 1 or more.
	 */
	public static boolean stringIntersect(String a, String b, int len) {
		if(a.length()< len || b.length() <len)return false;
		HashSet<String> ZeSet = new HashSet<String>();
		if(a.length() == len) {
			ZeSet.add(a);
		}else {
			for(int i =0; i< a.length()-len+1; i++) {
				ZeSet.add(a.substring(i,i+len));
			}		
		}
		if(b.length()==len) {
			if(ZeSet.contains(b))return true;
		}else {
			for(int i =0; i< b.length()-len+1; i++) {
				if(ZeSet.contains(b.substring(i,i+len))) return true;
			}
		}
		return false;
	}
	
}
