// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

public class CharGrid {
	private char[][] grid;

	
	/**
	 * Constructs a new CharGrid with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public CharGrid(char[][] grid) {
		this.grid = grid;
	}
	
	/**
	 * Returns the area for the given char in the grid. (see handout).
	 * @param ch char to look for
	 * @return area for given char
	 */
	public int charArea(char ch) {
		boolean been =false;
		int minRow=Integer.MAX_VALUE;
		int minCol=Integer.MAX_VALUE;
		int maxRow=Integer.MIN_VALUE;
		int maxCol=Integer.MIN_VALUE;
		if(grid.length==0)return 0;
		if(grid[0].length==0)return 0;
		for(int row =0; row<grid.length; row++) {
			for(int col = 0; col<grid[0].length; col++) {
				if(grid[row][col]== ch) {
					been =true;
					minRow=Math.min(minRow, row);
					minCol= Math.min(minCol, col);
					maxRow = Math.max(maxRow, row);
					maxCol = Math.max(maxCol, col);
				}
			}
		}
		if(!been)return 0;
		return (maxRow-minRow+1)*(maxCol-minCol+1);
	}
	
	/**
	 * Returns the count of '+' figures in the grid (see handout).
	 * @return number of + in grid
	 */
	public int countPlus() {
		int res =0;
		if(grid.length<3 || grid[0].length <3 )return 0;
		for(int row = 1; row<grid.length; row++) {
			for(int col =0; col<grid[0].length; col++) {
				
				int lenRight  = getArmLength(row, col, 0, 1);
				int lenLeft=getArmLength(row, col, 0, -1);
				int lenUp=getArmLength(row, col, -1,0);
				int lenDown=getArmLength(row, col, 1,0);
				if(lenRight >=2 && lenRight == lenLeft && lenRight == lenUp && lenRight == lenDown) {
					res++;
				}
				
			}
			
		}
		return res; 
	}
	
	private int getArmLength(int row, int col, int rowDiff, int colDiff) {
		int res = 1;
		int ch = grid[row][col];
		
		int nextRow=row+rowDiff;
		int nextCol =col+colDiff;
		
		while( nextRow>= 0 && nextRow<grid.length  && nextCol>=0 && nextCol<grid[0].length) {
			
			if(grid[nextRow][nextCol] ==ch) {
			
				res++;
				nextRow+=rowDiff;
				nextCol+=colDiff;
			}else 
				break;
		}
		return res;
	}
	
}
