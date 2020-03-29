import java.util.*;

public class Appearances {
	
	/**
	 * 
	 * Returns the number of elements that appear the same number
	 * of times in both collections. Static method. (see handout).
	 * @return number of same-appearance elements
	 */
	public static <T> int sameCount(Collection<T> a, Collection<T> b) {
		int res = 0;
		 HashMap<T,Integer> mp1 = new HashMap<T,Integer>();
		 HashMap<T,Integer> mp2 = new HashMap<T,Integer>();
		 for(T item : a) {
			 if(mp1.containsKey(item)) {
				 mp1.put(item,mp1.get(item)+1);
			 }else {
				 mp1.put(item,1);
			 }
		 }
		 for(T item : b) {
			 if(mp2.containsKey(item)) {
				 mp2.put(item,mp2.get(item)+1);
			 }else {
				 mp2.put(item,1);
			 }
		 }
		 for(T key:mp1.keySet()) {
			 if(mp2.containsKey(key)) {
				 if(mp1.get(key) == mp2.get(key))res++;
			 }
		 }
		return res;
	}
	
}
