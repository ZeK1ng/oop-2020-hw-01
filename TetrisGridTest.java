import junit.framework.TestCase;
import java.util.*;

public class TetrisGridTest extends TestCase {
	
	public void testClearEmpty() {
		boolean[][] before =
			{	
				{},
					{},
					{}
			};
			
			boolean[][] after =
			{	
				{true, true, false, },
				{false, false, true, }
			};
			
			TetrisGrid tetris = new TetrisGrid(before);
			tetris.clearRows();

			assertFalse( Arrays.deepEquals(after, tetris.getGrid()) );
	}
	public void testClear0() {
		boolean[][] before =
			{	
				{true}
			};
			
			boolean[][] after =
			{	
				{false}
			};
			
			TetrisGrid tetris = new TetrisGrid(before);
			tetris.clearRows();

			assertTrue( Arrays.deepEquals(after, tetris.getGrid()) );
	}
	public void testClear01() {
		boolean[][] before =
			{	
				{false}
			};
			
			boolean[][] after =
			{	
				{false}
			};
			
			TetrisGrid tetris = new TetrisGrid(before);
			tetris.clearRows();

			assertTrue( Arrays.deepEquals(after, tetris.getGrid()) );
	}
	public void testClear02() {
		boolean[][] before =
			{	
				{true},
				{true}
			};
			
			boolean[][] after =
			{	
				{false},
				{false}
			};
			
			TetrisGrid tetris = new TetrisGrid(before);
			tetris.clearRows();

			assertTrue( Arrays.deepEquals(after, tetris.getGrid()) );
	}
	public void testClear03() {
		boolean[][] before =
			{	
				{true,true},
				{true,true}
			};
			
			boolean[][] after =
			{	
				{false,false},
				{false,false}
			};
			
			TetrisGrid tetris = new TetrisGrid(before);
			tetris.clearRows();

			assertTrue( Arrays.deepEquals(after, tetris.getGrid()) );
	}
	public void testClear1() {
		boolean[][] before =
		{	
			{true, true, false, },
			{false, true, true, }
		};
		
		boolean[][] after =
		{	
			{true, false, false},
			{false, true, false}
		};
		
		TetrisGrid tetris = new TetrisGrid(before);
		tetris.clearRows();

		assertTrue( Arrays.deepEquals(after, tetris.getGrid()) );
	}
	public void testClear2() {
		boolean[][] before =
			{	
				{true, true, false, },
				{false, false, true, }
			};
			
			boolean[][] after =
			{	
				{true, true, false, },
				{false, false, true, }
			};
			
			TetrisGrid tetris = new TetrisGrid(before);
			tetris.clearRows();

			assertTrue( Arrays.deepEquals(after, tetris.getGrid()) );
	}
	public void testClear3() {
		boolean[][] before =
			{	
				{true, true, false, },
				{true, false, true, }
			};
			
		boolean[][] after =
		{	
			{true, false, false, },
			{false, true, false, }
		};
		
		TetrisGrid tetris = new TetrisGrid(before);
		tetris.clearRows();
		assertTrue( Arrays.deepEquals(after, tetris.getGrid()) );
	
	}
	public void testClear4() {
		boolean[][] before =
			{	
				{true, true, true,},
				{true, true, true,},
				{true,true,true,}
			};
			
			boolean[][] after =
			{	
				{false, false, false, },
				{false, false, false, },
				{false, false, false, }
			};
			
			TetrisGrid tetris = new TetrisGrid(before);
			tetris.clearRows();

			assertTrue( Arrays.deepEquals(after, tetris.getGrid()) );
	}
	
	
}
