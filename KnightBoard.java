public class KnightBoard{

private int[][] board;
private int[][] moves = {{-1,  2}, {1,   2},
			 {-2,  1}, {-2, -1},
			 {-1, -2}, {1,  -2},
			 {2,   1}, {2,  -1}
			};

private int currno = 1;
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

public void pieceTest(int x, int y){
	board[x][y] = 1;
	for (int ch = 0; ch < 8; ch++){
		currno++;
		board[x + moves[ch][0]] [y + moves[ch][1]] = currno;
	}
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

private void debug(){
	System.out.println(Text.go(1,1));
	System.out.println(this);Text.wait(1000); //adjust this delay
}

public String toString(){
	String out = "";
	for (int x = 0; x < sizerow; x++){
		for (int y = 0; y < sizecol; y++){
			out+= board[x][y];
			out += " ";
		}
		out+= "\n";
	}
	return out;
}

public boolean solve(int startposx, int startposy){
	return solveHelp(startposx, startposy);
}

public static void main(String[] args) {
	KnightBoard k = new KnightBoard(6, 6);
	k.pieceTest(3, 3);
	// k.solve(2, 2);
	System.out.println(k);
}
}
