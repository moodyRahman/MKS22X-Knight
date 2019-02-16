public class KnightBoard{

private int[][] board;
private int[][] moves = {{-1,  2}, {1,   2},
			 {-2,  1}, {-2, -1},
			 {-1, -2}, {1,  -2},
			 {2,   1}, {2,  -1}
			};

private int currno = 0;
private int sizerow;
private int sizecol;
private int totalsquares;

public KnightBoard(int rows, int cols){
	board = new int[rows][cols];
	sizerow = rows;
	sizecol = cols;
	totalsquares = sizerow * sizecol;
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


private boolean solveHelp(int x, int y){
	if (currno >= totalsquares){
		return true;
	}
	for (int ch = 0; ch < 8; ch++){
		if(placeKnight(x, y)){
			if (solveHelp(x + moves[ch][0], y + moves[ch][1])){
				return true;
			}
			removeKnight(x, y);
		}
	}
	return false;
}


public boolean solve(){
	return true;
}
}
