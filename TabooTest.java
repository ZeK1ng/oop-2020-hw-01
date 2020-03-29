// TabooTest.java
// Taboo class tests -- nothing provided.

import java.util.*;

import junit.framework.TestCase;

public class TabooTest extends TestCase {
	
	
	public void testnoFollow1() {
		List<String> mlist= new ArrayList<>();
		for(char i ='a'; i<'d'; i++) {
			mlist.add(i+"");
		}
		Taboo<String> tb = new Taboo<String>(mlist);
		assertEquals(0,tb.noFollow("f").size());
		Set<String> st = new HashSet<>();
		st.add("b");
		assertEquals(st,tb.noFollow("a"));
		assertEquals(0,tb.noFollow("d").size());
	}
	public void testnoFollow2() {
		List<String> mlist= new ArrayList<>();
		mlist.add("a");
		mlist.add("c");
		mlist.add("a");
		mlist.add("a");
		mlist.add("b");
		Taboo<String> tb = new Taboo<String>(mlist);
		Set<String> st = new HashSet<>();
		st.add("c");
		st.add("a");
		st.add("b");
		assertEquals(st, tb.noFollow("a"));
	}
	public void testnoFollow3() {
		List<Integer> ruleList = new ArrayList<>();
		ruleList.add(1);
		ruleList.add(2);
		ruleList.add(3);
		ruleList.add(2);
		ruleList.add(1);
		ruleList.add(3);
		Taboo<Integer>tb = new Taboo<Integer>(ruleList);
		List<Integer> mlist = new ArrayList<>();
		mlist.add(2);
		mlist.add(3);
		mlist.add(1);
		mlist.add(2);
		mlist.add(1);
		mlist.add(3);
		Set<Integer> st = new HashSet<>();
		st.add(1);
		st.add(3);
		assertEquals(st, tb.noFollow(2));
		
	}
	public void testReduce() {
		List<String> ruleList= new ArrayList<>();
		Taboo<String> tb = new Taboo<String>(ruleList);
		List<String> mlist = new ArrayList<>();
		mlist.add("a");
		mlist.add("c");
		mlist.add("b");
		List<String> resultList = new ArrayList<>();
		resultList.add("a");
		resultList.add("c");
		resultList.add("b");
		tb.reduce(mlist);
		assertEquals(resultList,mlist );	
	}
	public void testReduce1() {
		List<String> ruleList= new ArrayList<>();
		ruleList.add("a");
		ruleList.add("c");
		ruleList.add("a");
		ruleList.add("b");
		Taboo<String> tb = new Taboo<String>(ruleList);
		List<String> mlist = new ArrayList<>();
		mlist.add("a");
		mlist.add("c");
		mlist.add("b");
		mlist.add("x");
		mlist.add("c");
		mlist.add("a");
		List<String> resultList = new ArrayList<>();
		resultList.add("a");
		resultList.add("x");
		resultList.add("c");
		tb.reduce(mlist);
		assertEquals(resultList,mlist );
	}
	public void testReduce2() {
		List<String> ruleList= new ArrayList<>();
		ruleList.add("a");
		ruleList.add(null);
		ruleList.add("c");
		ruleList.add(null);
		ruleList.add("b");
		ruleList.add("x");
		Taboo<String> tb = new Taboo<String>(ruleList);
		List<String> mlist = new ArrayList<>();
		mlist.add("a");
		mlist.add("c");
		mlist.add("b");
		mlist.add("x");
		mlist.add("c");
		mlist.add("a");
		List<String> resultList = new ArrayList<>();
		resultList.add("a");
		resultList.add("c");
		resultList.add("b");
		resultList.add("c");
		resultList.add("a");
		tb.reduce(mlist);
		assertEquals(resultList,mlist );
		
	}
}
