//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.

public class TetrisGrid {
	
	private boolean[][] tetrisGrid;
	/**
	 * Constructs a new instance with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public TetrisGrid(boolean[][] grid) {
		tetrisGrid = grid;
	}
	
	
	/**
	 * Does row-clearing on the grid (see handout).
	 */
	public void clearRows() {
		int MaxRow = tetrisGrid.length;
		int MaxCol = tetrisGrid[0].length;
		boolean shouldClear=true;
		for(int col = 0; col<MaxCol;col++) {
			if(shouldClear)col =0 ;
			shouldClear=true;
			for(int row = 0; row<MaxRow; row++) {
				if(!tetrisGrid[row][col]) {
					shouldClear=false;
					break;
				}
			}
		
			if(shouldClear) {
				int nextCol = col+1;
				int currCol = col;
				while(nextCol<MaxCol) {
					for(int i=0;i<MaxRow;i++) {
					
						tetrisGrid[i][currCol] = tetrisGrid[i][nextCol];
					}
					nextCol++;
					currCol++;
				}
				for(int i=0;i<MaxRow;i++) {
					tetrisGrid[i][MaxCol-1]=false;
				}
			}

		}
//		for(int i=0;i<tetrisGrid.length;i++) {
//		for(int j=0;j<tetrisGrid[0].length;j++) {
//			System.out.print(tetrisGrid[i][j]+" ");
//		}
//		System.out.println();
//	}


		
	}	
	
	/**
	 * Returns the internal 2d grid array.
	 * @return 2d grid array
	 */
	boolean[][] getGrid() {
		return tetrisGrid;
	}
}
