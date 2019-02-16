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
	if (board[x][y] == 0){
		board[x][y] = currno;
		currno++;
		return true;
	}
	return true;
}

public boolean removeKnight(int x, int y){
	if (board[x][y] == 0){
		return false;
	}
	board[x][y] = 0;
	currno--;
	return true;
}


private void solveHelp(){}


public boolean solve(){
	return true;
}
}
