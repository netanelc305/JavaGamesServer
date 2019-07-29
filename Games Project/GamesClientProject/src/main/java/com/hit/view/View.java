package com.hit.view;

public interface View {
	public void	start();
	
	public void	updateViewGameMove(int gameState, java.lang.Character[] board);
	public void	updateViewNewGame(java.lang.Character[] board);

}
