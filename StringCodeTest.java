// StringCodeTest
// Some test code is provided for the early HW1 problems,
// and much is left for you to add.

import org.junit.jupiter.api.BeforeAll;

import junit.framework.TestCase;

public class StringCodeTest extends TestCase {
	//
	// blowup
	//
	@BeforeAll
	public void  setUp() {
		 StringCode strcode = new StringCode();
	}
	
	public void testBlowup1() {
		// basic cases
		assertEquals("xxaaaabb", StringCode.blowup("xx3abb"));
		assertEquals("xxxZZZZ", StringCode.blowup("2x3Z"));
	}
	
	public void testBlowup2() {
		// things with digits
		
		// digit at end
		assertEquals("axxx", StringCode.blowup("a2x3"));
		
		// digits next to each other
		assertEquals("a33111", StringCode.blowup("a231"));
		
		// try a 0
		assertEquals("aabb", StringCode.blowup("aa0bb"));
	}
	
	public void testBlowup3() {
		// weird chars, empty string
		assertEquals("AB&&,- ab", StringCode.blowup("AB&&,- ab"));
		assertEquals("", StringCode.blowup(""));
		
		// string with only digits
		assertEquals("", StringCode.blowup("2"));
		assertEquals("33", StringCode.blowup("23"));
	}
	
	
	//
	// maxRun
	//
	public void testRun1() {
		assertEquals(2, StringCode.maxRun("hoopla"));
		assertEquals(3, StringCode.maxRun("hoopllla"));
	}
	
	public void testRun2() {
		assertEquals(3, StringCode.maxRun("abbcccddbbbxx"));
		assertEquals(0, StringCode.maxRun(""));
		assertEquals(3, StringCode.maxRun("hhhooppoo"));
	}
	
	public void testRun3() {
		// "evolve" technique -- make a series of test cases
		// where each is change from the one above.
		assertEquals(1, StringCode.maxRun("123"));
		assertEquals(2, StringCode.maxRun("1223"));
		assertEquals(2, StringCode.maxRun("112233"));
		assertEquals(3, StringCode.maxRun("1112233"));
	}
	

	// Need test cases for stringIntersect
	public void testIntersect() {
		assertFalse(StringCode.stringIntersect("", "", 1));
		assertFalse(StringCode.stringIntersect("a", "", 1));
		assertFalse(StringCode.stringIntersect("", "b", 1));
		assertFalse(StringCode.stringIntersect("a", "b", 1));
		assertFalse(StringCode.stringIntersect("aa", "bb", 1));
		assertTrue(StringCode.stringIntersect("ab", "b", 1));
		assertTrue(StringCode.stringIntersect("ab", "ab", 1));
		assertTrue(StringCode.stringIntersect("abc", "a", 1));
		assertTrue(StringCode.stringIntersect("abbcc", "bc", 2));
		assertTrue(StringCode.stringIntersect("abbcc", "bcd", 2));
		assertFalse(StringCode.stringIntersect("abbcc", "cd", 2));
		assertTrue(StringCode.stringIntersect("abbdcacc", "bbdcabcc", 3));
		assertFalse(StringCode.stringIntersect("asdalsndlasldnansda", "asdjejnasdnajnanenasjdn", 10));
		assertTrue(StringCode.stringIntersect("EEAAXXDDEEAASSDDEEASDWKKHUHWJ@@!#@@!@#", "EAEAXEDEASDEASDEQWDKNAWU@!@@!#@!@@AW@A", 3));
		
	}
}
