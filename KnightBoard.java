public class KnightBoard{

private int[][] board;
private int[][] moves = {{-1,  2}, {1,   2}, 
			 {-2,  1}, {-2, -1}, 
			 {-1, -2}, {1,  -2}, 
			 {2,   1}, {2,  -1}
			};

int currno = 0;

public KnightBoard(int rows, int cols){
	board = new int[rows][cols];
}

public boolean placeKnight(int x, int y){
	board[x][y] = currno;
	currno++;
	return true;
}

//private class Tile{
//	private int possibleMoves;
//}
}
