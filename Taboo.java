
/*
 HW1 Taboo problem class.
 Taboo encapsulates some rules about what objects
 may not follow other objects.
 (See handout).
*/

import java.util.*;

public class Taboo<T> {
	//rules provided
	private List<T> myTaboo;
	// maps element and elements that shouldn`t be followed by it
	private Map<T,Set<T> > ruleMap;
	/**
	 * Constructs a new Taboo using the given rules (see handout.)
	 * @param rules rules for new Taboo
	 * 
	 */
	public Taboo(List<T> rules) {
		myTaboo = new ArrayList<>(rules);
		ruleMap = new HashMap<>();
		for(int i=1; i<myTaboo.size(); i++) {
			T elem = myTaboo.get(i);
			T prevElem = myTaboo.get(i-1);
			if(ruleMap.containsKey(elem)) {
				ruleMap.get(elem).add(prevElem);
			}else {
				Set<T> newList = new HashSet<>();
				newList.add(prevElem);
				ruleMap.put(elem,newList);
			}
		}
	}
	
	
	/**
	 * Returns the set of elements which should not follow
	 * the given element.
	 * @param elem
	 * @return elements which should not follow the given element
	 */
	public Set<T> noFollow(T elem) {
		if(elem == null) return Collections.emptySet();
		Set<T> ZeSet = new HashSet<>();
		for(int i= 1; i < myTaboo.size();i++) {
			if(myTaboo.get(i-1) != null && myTaboo.get(i)!= null) {
				if(myTaboo.get(i-1).equals(elem)) {
					ZeSet.add(myTaboo.get(i));
				}
			}
		}
		if(ZeSet.size() == 0) return Collections.emptySet();
		return ZeSet;
	}
	
	/**
	 * Removes elements from the given list that
	 * violate the rules (see handout).
	 * @param list collection to reduce
	 */
	public void reduce(List<T> list) {
		for(int i = 1;i<list.size();i++) {
			T elem = list.get(i);
		//	System.out.print(i+" " + elem+" prev->");
			T prev = list.get(i-1);
			//System.out.println(prev);
			if(ruleMap.containsKey(elem)) {
				if(ruleMap.get(elem).contains(prev)) {
				//	System.out.println("deleting: "+elem);
					list.remove(i);
					i--;
				}
			}
		}
	}
	
}
