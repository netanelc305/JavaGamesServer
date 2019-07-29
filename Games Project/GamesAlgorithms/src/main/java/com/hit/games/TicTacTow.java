package com.hit.games;

import com.hit.gameAlgo.GameBoard;

public abstract class TicTacTow
extends GameBoard
{
	BoardSigns [][]board;
	

	
	public TicTacTow(int rowLength, int colLength) {
		super(rowLength,colLength);
		
		board = new BoardSigns[rowLength][colLength];
		for(int row=0;row<rowLength;row++)
			for(int col=0;col<colLength;col++)
			{
				board[row][col]=BoardSigns.BLANK;
			}
	
	}
	 public static enum  BoardSigns
	{
		 BLANK,COMPUTER,PLAYER ;
		 public char getSign()
		 {
			 if(this.equals(BLANK))
				 return 'B';
			 else if(this.equals(COMPUTER))
				 return 'C';
			 else  return 'P'; 
		 }
		
	}


	@Override
	public char[][] getBoardState() {
		
		
		
		char [][] temp=new char[rowLength][colLength];
		for(int i=0;i<rowLength;i++)
			for(int j=0;j<colLength;j++)
			{
				temp[i][j]=board[i][j].getSign();
			}
		return temp;
		
		
		
		
	}
	@Override
	public GameState getGameState(GameMove move) //PLAYER_WON \ PLAYER_LOST \ TIE \ IN PROGRESS
	{
		if(whoWon(BoardSigns.PLAYER))
			return GameState.PLAYER_WON;
		else if(whoWon(BoardSigns.COMPUTER))
			return GameState.PLAYER_LOST;
		else if(!tieOrProgress())
		{

			return GameState.TIE;
		}

		return  GameState.IN_PROGRESS;
	
	}
	
	


	@Override
	public boolean	updatePlayerMove(GameBoard.GameMove move)
	{
		if(move.getRow()>2||move.getRow()<0||move.getRow()>2||move.getColumn()<0||!board[move.getRow()][move.getColumn()].equals(BoardSigns.BLANK))
			return false;
		else
		{
			board[move.getRow()][move.getColumn()]=BoardSigns.PLAYER;
			return true;
		}

	}
	
	private boolean whoWon(BoardSigns sign)
	{
		int score=0;
		
		for(int i =0;i<3;i++)//alachson
		{
			if(board[i][i].equals(sign))
				score++;
		}
		if(score==3)
			return true;
		score=0;
		for(int col=0;col<3;col++)//row 0
		{
			if(board[0][col].equals(sign))
				score++;
		}
		if(score==3)
			return true;
		score=0;
		for(int col=0;col<3;col++)//row 1
		{
			if(board[1][col].equals(sign))
				score++;
		}
		if(score==3)
			return true;
		score=0;
		for(int col=0;col<3;col++)//row 2
		{
			if(board[2][col].equals(sign))
				score++;
		}
		if(score==3)
			return true;
		score=0;
		for(int row=0;row<3;row++)//col 0
		{
			if(board[row][0].equals(sign))
				score++;
		}
		if(score==3)
			return true;
		score=0;
		for(int row=0;row<3;row++)//col 1
		{
			if(board[row][1].equals(sign))
				score++;
		}
		if(score==3)
			return true;
		score=0;
		for(int row=0;row<3;row++)
		{
			if(board[row][2].equals(sign))
				score++;
		}
		if(score==3)
			return true;
		if(board[2][0].equals(sign)&&board[1][1].equals(sign)&&board[0][2].equals(sign))
			return true;
		return false;

	}
	
	private boolean tieOrProgress()//PROGRESS=true, tie=false
	{
		for(int row=0;row<3;row++)
			for(int col=0;col<3;col++)
			{
				if(board[row][col].equals(BoardSigns.BLANK))
					return true;
				
				
			}
		return false;
		
		
	}
	
}
