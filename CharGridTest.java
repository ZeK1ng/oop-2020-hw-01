
// Test cases for CharGrid -- a few basic tests are provided.

import junit.framework.TestCase;

public class CharGridTest extends TestCase {
	
	public void testCharAreaFullEmpy() {
		char [][]grid = new char[][] {};
		CharGrid cg = new CharGrid(grid);
		assertEquals(0, cg.charArea('a'));
		assertEquals(0, cg.charArea('z'));
		assertEquals(0, cg.charArea('k'));
	
	}
	
	public void testCharAreaPartEmty() {
		char [][]grid = new char[][] {
			{},
			{},
			{},
		};
		CharGrid cg = new CharGrid(grid);
		assertEquals(0, cg.charArea('1'));
		assertEquals(0, cg.charArea('2'));
		assertEquals(0, cg.charArea('3'));
	}
	
	
	public void testCharArea1() {
		char[][] grid = new char[][] {
				{'a', 'y', ' '},
				{'x', 'a', 'z'},
			};
		
		
		CharGrid cg = new CharGrid(grid);
				
		assertEquals(4, cg.charArea('a'));
		assertEquals(1, cg.charArea('z'));
	}
	


	public void testCharArea2() {
		char[][] grid = new char[][] {
				{'c', 'a', ' '},
				{'b', ' ', 'b'},
				{' ', ' ', 'a'}
			};
		
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(6, cg.charArea('a'));
		assertEquals(3, cg.charArea('b'));
		assertEquals(1, cg.charArea('c'));
	}
	
	public void testArea3(){
		char[][] grid = new char[][] {
			{' ', ' ', 'z'},
			{'b', ' ', 'b'},
			{' ', ' ', 'a'}
		};

		CharGrid cg = new CharGrid(grid);
		
		assertEquals(6, cg.charArea(' '));
		assertEquals(3, cg.charArea('b'));
		assertEquals(0, cg.charArea('1'));
		assertEquals(1,cg.charArea('z'));
	}
	
	public void testcountPlusEmpty() {
		char[][] grid = new char[][] {
			
		};
		CharGrid cg = new CharGrid(grid);
		assertEquals(0,cg.countPlus());
		grid = new char[][]{
				{},
				{},
				{},
				{},
				{},
		};
		CharGrid cg1 = new CharGrid(grid);
		assertEquals(0,cg1.countPlus());
	}
	public void testCountPlus1() {
		char[][] grid = new char[][] {
			{' ','x',' '},
			{'x','x','x'},
			{' ','x',' '},
		};
		CharGrid cg = new CharGrid(grid);
		assertEquals(1,cg.countPlus());
		
		grid = new char[][]{
			{' ','x',' '},
			{'x','x','x'},
			{' ','x',' '},
			{' ','x',' '},
			
		};
		CharGrid cg1 = new CharGrid(grid);
		assertEquals(0,cg1.countPlus());
		
	}
	public void testcountPlus2() {
		char[][] grid = new char[][] {
			{'a','b','c','d','e'},
			{'g','b','c','f','k'},
			{'c','c','c','c','c'},
			{'g','b','c','f','g'},
			{'g','b','c','f','m'},
		};
		CharGrid cg = new CharGrid(grid);
		assertEquals(1, cg.countPlus());
		grid = new char[][] {
			
			{'a','b','c','d','e'},
			{'g','b','c','f','k'},
			{'c','c','c','c','c'},
			{'g','b','c','f','g'},
			{'g','b','c','f','m'},
			{'g','y','c','f','m'},
			
		};
		CharGrid cg1 = new CharGrid(grid);
		assertEquals(0, cg1.countPlus());
	}
	
	public void testCountPlus3() {
		char[][]grid  = new char[][] {
			{' ','x','a',' ','1','2'},
			{'x','x','x','1','1','1'},
			{' ','x','x','x','1','2'},
			{'y','j','x','l','3','b'},
			{'x','j','y','1','3','s'},
			{'j','j','j','1','3','s'},
			{' ','j','j','3','3','3'},
			{'j','j','j','j','j','4'},
			{' ',' ','j','1','3','s'},
			{' ',' ','j','1','4','s'},
			{' ',' ',' ','1','3','s',},
		};
		CharGrid cg = new CharGrid(grid);
		assertEquals(4, cg.countPlus());
	}
}
