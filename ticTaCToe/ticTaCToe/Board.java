package ticTaCToe;

public class Board {
	private char[][] board;
	private int boardSize=3;
	
	private char p1Symbol,p2Symbol;
	private int count;
	
	private static final char BLANK=' ';
	
	public static final int PLAYER1WINS=1;
	public static final int PLAYER2WINS=2;
	public static final int DRAW=3;
	public static final int INCOMPLETE=4;
	public static final int INVALID=5;
	
	public Board(char p1Symbol,char p2Symbol) {
		board=new char[boardSize][boardSize];
		for(int i=0;i<boardSize;i++) {
			for(int j=0;j<boardSize;j++)
				board[i][j]=BLANK;
		}
		
		this.p1Symbol=p1Symbol;
		this.p2Symbol=p2Symbol;
		
	}

	public int move(char symbol, int x, int y) {
		/* Make move and return status 
		 * 1= Player 1 Wins
		 * 2= Player 2 wins
		 * 3= Draw
		 * 4= IncomPlete
		 * 5= Invalid
		 */
		
		//Invalid move for out of bounds input or pre-occupied cell
		if(x<0 || x>=boardSize || y<0 || y>=boardSize || board[x][y]!=BLANK)
			return INVALID;
		
		
		//Make move
		board[x][y]=symbol;
		count++;
		
		
		//Check matching Row
		if(board[x][0]== board[x][1] && board[x][0]== board[x][2])
			return symbol==p1Symbol ? PLAYER1WINS : PLAYER2WINS; 
		
		//Check matching Column
		if(board[0][y]== board[1][y] && board[0][y]== board[2][y])
			return symbol==p1Symbol ? PLAYER1WINS : PLAYER2WINS; 
		
		
		//Check 1st Diagonal
		if(board[0][0]!=BLANK && board[0][0]== board[1][1] && board[0][0]== board[2][2])
			return symbol==p1Symbol ? PLAYER1WINS : PLAYER2WINS; 
		
		
		//Check 2nd Diagonal
		if(board[0][2]!=BLANK && board[0][2]== board[1][1] && board[0][2]== board[2][0])
			return symbol==p1Symbol ? PLAYER1WINS : PLAYER2WINS; 
				
		//Check Draw
		if (count==boardSize*boardSize)
			return DRAW;
				
		
		return INCOMPLETE;
		
	}

	public void printBoard() {
		System.out.println("_______________");
		for(int i=0;i<boardSize;i++) {
			for(int j=0;j<boardSize;j++) {
				System.out.print("| " + board[i][j] + " |");
			}
			System.out.println();
		}
		System.out.println("_______________");
		
	}
	
}
