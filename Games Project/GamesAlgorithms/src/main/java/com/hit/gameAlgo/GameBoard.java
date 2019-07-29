package com.hit.gameAlgo;


public abstract class GameBoard
extends java.lang.Object
implements IGameAlgo
{
	protected static int rowLength;
	protected static int colLength;
	public GameBoard(int rowLength, int colLength) {GameBoard.rowLength=rowLength;GameBoard.colLength=colLength;	
	}

	public abstract void	calcComputerMove();
	public abstract char[][]	getBoardState();
	public abstract IGameAlgo.GameState	getGameState(GameBoard.GameMove move);
	public abstract boolean	updatePlayerMove(GameBoard.GameMove move);
	
	
	
	
	
	public static class GameMove 
	{
		int row;
		int column;
		public GameMove(int row, int column)
		{
			this.row=row;
			this.column=column;
			
		}
		public int	getColumn() {
			return this.column;
			
		}
		public int	getRow() 
		{
			return this.row;
			
		}
		
	}
	
	
	
	

}
