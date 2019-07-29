package com.hit.services;

import com.hit.exception.UnknownIdException;

public class GameServerController
extends java.lang.Object
{
	
	GamesService games;
	
	public GameServerController(int capacity) 
	{
		games=new GamesService(capacity);

	}
	
	
	
	public	char[][]	computerStartGame(java.lang.Integer gameId) throws UnknownIdException 
	{
		return games.computerStartGame(gameId);
		
	}
	public void	endGame(java.lang.Integer gameId) throws UnknownIdException 
	{
		 games.endGame(gameId);
		
	}
	public char[][]	getBoardState(java.lang.Integer gameId) throws UnknownIdException 
	{
		return games.getBoardState(gameId);
		
	}
	public	int	newGame(java.lang.String gameType, java.lang.String opponent) 
	{
		return games.newGame(gameType, opponent);
		
	}
	public com.hit.gameAlgo.IGameAlgo.GameState	updateMove(java.lang.Integer gameId, com.hit.gameAlgo.GameBoard.GameMove playerMove) throws UnknownIdException 
	{
		return games.updateMove(gameId, playerMove);
		
	}
	
	

}
