package ticTaCToe;

import java.util.*;

public class Game {
	
	private Players player1,player2;
	private Board board;
	private int  playersCount;
	
	static Scanner sc=new Scanner(System.in);
	
	
	
	
	public static void main(String[] args) {
		Game ticTacToe=new Game();
		ticTacToe.startGame();
	}
	
	public void startGame() {
		/*Take Players Input
		 * Create the board 
		 * Run the Game
		 */
		
		//Take Players Input
		player1=createPlayer(++playersCount);
		player2=createPlayer(++playersCount);
		while(player1.getSymbol()==player2.getSymbol()) {
			System.out.println("Symbol already taken. Enter another symbol");
			player2.setSymbol(sc.next().charAt(0));
		}
		
		//Create board
		board=new Board(player1.getSymbol(),player2.getSymbol());
		board.printBoard();
		
		
		//Play the game
		boolean player1Turn=true;
		int status = Board.INCOMPLETE;
		while(status==Board.INCOMPLETE || status==Board.INVALID ) {
			if(player1Turn) {
				System.out.println("Player 1 - "+player1.getName()+"'s turn:");
				System.out.println("Enter x:");
				int x=sc.nextInt();
				System.out.println("Enter y:");
				int y=sc.nextInt();
				status=board.move(player1.getSymbol(),x,y);
				if(status==Board.INVALID) { 
					System.out.println("Invalid move. Please try again !!!!!!!");
					continue;
				}
			}
			else {
				System.out.println("Player 2 - "+player2.getName()+"'s turn:");
				System.out.println("Enter x:");
				int x=sc.nextInt();
				System.out.println("Enter y:");
				int y=sc.nextInt();
				status=board.move(player2.getSymbol(),x,y);
				if(status==Board.INVALID) { 
					System.out.println("Invalid move. Please try again !!!!!!!");	
					continue;
				}
			}
			player1Turn=!player1Turn;
			board.printBoard();
		}
		
		if(status==Board.PLAYER1WINS)
			System.out.println("Player 1 - "+player1.getName()+" wins !!!");
		else if(status==Board.PLAYER2WINS)
			System.out.println("Player 2 - "+player2.getName()+" wins !!!");
		else 
			System.out.println("Draw !!!!");
		
	}

	private Players createPlayer(int i) {
		System.out.println("Enter Player "+i+" name:");
		String name=sc.next();
		System.out.println("Enter Player "+i+" symbol:");
		char symbol=sc.next().charAt(0);
		while(symbol==' ') {
			System.out.println("Invalid move. Please try again !!!!!!!");
			symbol=sc.next().charAt(0);
		}
		Players p=new Players(name,symbol);
		return p;
		
	}

}
