package com.hit.gameHandler;

public class BoardGameHandler {
	private com.hit.gameAlgo.IGameAlgo game;
	public BoardGameHandler(com.hit.gameAlgo.IGameAlgo game)
	{
		this.game=game;
		
	}
	public char[][]	computerStartGame(){
		game.calcComputerMove();
		char [][] board= game.getBoardState();
		return board;
		
	}
	
	public com.hit.gameAlgo.IGameAlgo.GameState	playOneRound(com.hit.gameAlgo.GameBoard.GameMove playerMove)
	{
		if(!game.updatePlayerMove(playerMove))
			return com.hit.gameAlgo.IGameAlgo.GameState.ILLEGAL_PLAYER_MOVE;
		else if(game.getGameState(playerMove).equals(com.hit.gameAlgo.IGameAlgo.GameState.IN_PROGRESS))//in progress after player move
		{
			game.calcComputerMove();
			return game.getGameState(playerMove); //after computer move and end of round
			
			
		}
		//player move ended the game
		else
			return game.getGameState(playerMove);
			
			
	}
	public char[][]	getBoardState() 
	{
		return
		game.getBoardState();
		
		
		
	}
	
	
	
	
	
	
	
}
