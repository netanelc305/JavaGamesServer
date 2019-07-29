package com.hit.games;

import java.util.Random;

import com.hit.gameAlgo.GameBoard;


public class CatchTheBunnyRandom
extends CatchTheBunny
{

	public CatchTheBunnyRandom(int rowLength, int colLength) {
		super(rowLength, colLength);

	}

	@Override
	public void calcComputerMove() 
	{
		
		

		GameMove Plocation=findLocation(BoardSigns.PLAYER);
		GameMove curClocation=findLocation(BoardSigns.COMPUTER);
		GameMove Clocation = null;
		
	
		


		super.board[curClocation.getRow()][curClocation.getColumn()]=BoardSigns.BLANK;
	
		Random rand = new Random();
		do {
		int dir=rand.nextInt(4);
		
		if(dir==0)
			Clocation=new GameMove (curClocation.getRow(),curClocation.getColumn()-1);
		else if(dir==1)
			Clocation=new GameMove (curClocation.getRow()-1,curClocation.getColumn());
		else if(dir==2)
			Clocation=new GameMove (curClocation.getRow(),curClocation.getColumn()+1);
		else if(dir==3)
			Clocation=new GameMove (curClocation.getRow()+1,curClocation.getColumn());
		}
		while(Clocation.getRow()<0||Clocation.getRow()>8||Clocation.getColumn()<0||Clocation.getColumn()>8||
				((Clocation.getRow()==Plocation.getRow()&&Clocation.getColumn()==(Plocation.getColumn()))));
		super.board[Clocation.getRow()][Clocation.getColumn()]=BoardSigns.COMPUTER;
		
	}
	
	private GameBoard.GameMove findLocation(BoardSigns sign )
	{
		
		GameBoard.GameMove move=null;
		
		for(int row=0;row<board.length;row++)
		{
			for (int col=0;col<board[0].length;col++)
			{
				if(super.board[row][col].equals(sign))
						{
					move=new GameBoard.GameMove(row,col);
					
						}

			}
			
			
		}
		return move;
		
		
	}
	
	

	
	
	
}
