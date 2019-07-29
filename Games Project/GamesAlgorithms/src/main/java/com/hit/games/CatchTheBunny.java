package com.hit.games;


import java.util.Random;

import com.hit.gameAlgo.GameBoard;

public abstract class CatchTheBunny
extends GameBoard {
	BoardSigns [][]board;
	
	public GameMove computerLocation;
	public GameMove playerLocation;
	

	
	 int numOfMoves=15;  //changeable

	public CatchTheBunny(int rowLength, int colLength) {
		super(rowLength, colLength);
		
		board=new BoardSigns[rowLength][colLength];
		for(int row=0;row<board.length;row++)
			for(int col=0;col<board[0].length;col++)
			{
				board[row][col]=BoardSigns.BLANK;
			}


		
		Random rand = new Random();
		
		computerLocation=new GameMove(rand.nextInt(9),rand.nextInt(9));
		board[computerLocation.getRow()][computerLocation.getColumn()]=BoardSigns.COMPUTER;
		
		do//////// choose a random location for the player as long as its not right next to the computer or in his location
		{
			playerLocation=new GameMove(rand.nextInt(9),rand.nextInt(9));
		}
		while(playerLocation.equals(computerLocation)
				|| 
				(Math.abs(playerLocation.getRow()-computerLocation.getRow())
				+
				Math.abs(playerLocation.getColumn()-computerLocation.getColumn()))==1
				
				
				);

		board[playerLocation.getRow()][playerLocation.getColumn()]=BoardSigns.PLAYER;	
	}

		public static enum BoardSigns
		{
			
			BLANK,COMPUTER,PLAYER;
			 public char getSign()
			 {
				 if(this.equals(BLANK))
					 return 'B';
				 else if(this.equals(COMPUTER)) {
					 return 'C';}
				 return 'P'; 
	
			 }
		}
		@Override
		public char[][]	getBoardState()
		{
			char [][] tempBord= new char[9][9];
			
			
			for(int row=0;row<board.length;row++)
				for(int col=0;col<board[0].length;col++)
				{
					tempBord[row][col]=board[row][col].getSign();
				}
		return tempBord;
		}
		
		
		
		



		@Override
		public boolean	updatePlayerMove(GameBoard.GameMove move)
		{
		//		computerLocation
		//	playerLocation
			
			if(move.getRow()<0||move.getRow()>=board.length||move.getColumn()<0||move.getColumn()>=board[0].length
			||
			(Math.abs(move.getRow()-playerLocation.getRow())+Math.abs(move.getColumn()-playerLocation.getColumn()))	!=1)
			{
				return false;
			}
				

			else
			{
	
			
				board[playerLocation.getRow()][playerLocation.getColumn()]=BoardSigns.BLANK;

				board[move.getRow()][move.getColumn()]=BoardSigns.PLAYER;
				playerLocation=move;
				numOfMoves--;
				
				
				return true;
			}

			
		}
		private boolean playerWon()//if BoardSigns.COMPUTER couldnt be found on the borad it means the player override it so he won
		{
			boolean flag=true;
			for (int row=0;row<board.length;row++)
			{
				for(int col=0;col<board[0].length;col++)
				{
					if(board[row][col].equals(BoardSigns.COMPUTER))
					{
						flag=false;	
					}
					
					
				}
			}
			return flag;
		}
		@Override
		public GameState getGameState(GameBoard.GameMove move) // ILLEGAL_PLAYER_MOVE,PLAYER_WON,PLAYER_LOST,TIE,IN_PROGRESS;
		{
	
			 if(playerWon())				
				return GameState.PLAYER_WON;
			else if(numOfMoves==0)//PLAYER_LOST
				return GameState.PLAYER_LOST;
			return GameState.IN_PROGRESS;

		}
		
		
}

