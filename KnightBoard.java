public class KnightBoard{

private int[][] board;
private int[][] moves = {{-1,  2}, {1,   2},
			 {-2,  1}, {-2, -1},
			 {-1, -2}, {1,  -2},
			 {2,   1}, {2,  -1}
			};

public int currno = 1;
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
	if (x < 0 || x >= sizerow || y < 0 || y >= sizecol){
		return false;
	}
	if (board[x][y] == 0){
		board[x][y] = currno;
		currno++;
		return true;
	}
	return false;
}

public boolean removeKnight(int x, int y){
	if (board[x][y] == 0){
		return false;
	}
	board[x][y] = 0;
	currno--;
	return true;
}

public void pieceTest(int x, int y){
	board[x][y] = 1;
	for (int ch = 0; ch < 8; ch++){
		currno++;
		board[x + moves[ch][0]] [y + moves[ch][1]] = currno;
	}
}


private boolean solveHelp(int x, int y){
	if (solved()){
		// debug(x, y);
		return true;
	}
	for (int ch = 0; ch < 8; ch++){
		if(placeKnight(x, y)){
			// debug(x, y);
			if (solveHelp(x + moves[ch][0], y + moves[ch][1])){
				return true;
			}
			removeKnight(x, y);
			// debug(x, y);
		}
	}
	return false;
}

private void debug(int x, int y){
	System.out.println(Text.go(1,1));
	System.out.println(this);
	System.out.println(x + " " + y);
	System.out.println(currno);
	Text.wait(00); //adjust this delay
}

public String toString(){
	String out = "";
	for (int x = 0; x < sizerow; x++){
		for (int y = 0; y < sizecol; y++){
			if (board[x][y] <= 10){
				out += "  ";
				out += board[x][y];
			}else{
				out += " ";
				out += board[x][y];
			}
		}
		out+= "\n";
	}
	return out;
}

public boolean solved(){
	for (int x = 0; x < sizerow; x++){
		for (int y = 0; y < sizecol; y++){
			if (board[x][y] == 0){
				return false;
			}
		}
	}
	return true;
}

public boolean solve(int startposx, int startposy){
	return solveHelp(startposx, startposy);
}

public static void main(String[] args) {
	KnightBoard k = new KnightBoard(5, 5);
	// k.pieceTest(3, 3);
	k.solve(0, 0);
	// k.placeKnight(0, 0);
	System.out.println(k);
	System.out.println(k.currno);
}
}
