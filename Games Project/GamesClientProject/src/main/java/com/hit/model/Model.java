package com.hit.model;

public interface Model
{
	public void	newGame(java.lang.String gameType, java.lang.String opponentType);
	public void	updatePlayerMove(int row, int col);
	public void startGame();
	public void endGame(); 
	
	
	
}
