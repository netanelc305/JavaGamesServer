package com.hit.gameAlgo;

public interface IGameAlgo {
	
	
	public enum GameState{
		
		 ILLEGAL_PLAYER_MOVE(0),PLAYER_WON(1),PLAYER_LOST(2),TIE(3),IN_PROGRESS(4);
	
		private int rate;
		private GameState(int myRate) {
			rate=myRate;
		}
		public int getRate()
		{
			return rate;
		}
	}
		
		
	

	
	void	calcComputerMove();
	
	char[][]	getBoardState();
	
	IGameAlgo.GameState	getGameState(GameBoard.GameMove move);
	
	
	boolean	updatePlayerMove(GameBoard.GameMove move);
	
	

	
}
