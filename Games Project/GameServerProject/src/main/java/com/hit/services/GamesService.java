package com.hit.services;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

import com.hit.exception.UnknownIdException;
import com.hit.gameAlgo.IGameAlgo.GameState;
import com.hit.gameHandler.BoardGameHandler;
import com.hit.games.CatchTheBunnyRandom;
import com.hit.games.CatchTheBunnySmart;
import com.hit.games.TicTacTowRandom;
import com.hit.games.TicTacTowSmart;



public class GamesService {
	private final int capacity;
	private int numOfGames=0;
	
	
	BoardGameHandler game;
	HashMap<Integer,BoardGameHandler> GameServerHandler;	
	
	
	
	public GamesService(int capacity) 
	{
		this.capacity=capacity;
		GameServerHandler=new HashMap<Integer,BoardGameHandler>(capacity);
		
		
	}
	
	public char[][]	computerStartGame(java.lang.Integer gameId) throws UnknownIdException
	{
		if(!GameServerHandler.containsKey(gameId))
		{
			throw new UnknownIdException(new Exception(),"unknown ID"+ gameId);
		}
		else
			
		return GameServerHandler.get(gameId).computerStartGame();

	}

	public void	endGame(java.lang.Integer gameId) throws UnknownIdException
	{
		if(!GameServerHandler.containsKey(gameId))
		{

		
			throw new UnknownIdException(new Exception(),"unknown ID"+ gameId);
		
		}
		else
		{
		GameServerHandler.remove(gameId);
		numOfGames--;
		}
		
	}
	
	public char[][]	getBoardState(java.lang.Integer gameId) throws UnknownIdException 
	{
		if(!GameServerHandler.containsKey(gameId))
		{
			throw new UnknownIdException(new Exception(),"unknown ID"+ gameId);
		}
		else
		{
		return GameServerHandler.get(gameId).getBoardState();
		
		}
		
	}
	public 	int	newGame(java.lang.String gameType, java.lang.String opponent) 
	{
		if(numOfGames==this.capacity)
			return -1;

		
		BoardGameHandler game = null;
		if(gameType.equals("Tic Tac Toe"))
		{

			switch(opponent)
			{
			case "Smart":
				game=new BoardGameHandler(new TicTacTowSmart(3,3));
				break;
			case "Random":
				game=new BoardGameHandler(new TicTacTowRandom(3, 3));
				break;
			}
		}
		else if(gameType.equals("Catch The Bunny"))
		{
			switch(opponent)
			{
		case "Smart":
			game=new BoardGameHandler(new CatchTheBunnySmart(9,9));
			break;
		case "Random":
			game=new BoardGameHandler(new CatchTheBunnyRandom(9, 9));
			break;
			}
		}
		Random rand=new Random();
		int id;
		do
		{
			id=rand.nextInt(capacity)+1;
		}
		while(GameServerHandler.containsKey(id));
		GameServerHandler.put(id, game);
		numOfGames++;


		return id;
		
		
	}
	public 	com.hit.gameAlgo.IGameAlgo.GameState	updateMove(java.lang.Integer gameId, com.hit.gameAlgo.GameBoard.GameMove playerMove) throws UnknownIdException
	{
		if(!GameServerHandler.containsKey(gameId))
		{
			throw new UnknownIdException(new Exception(),"unknown ID"+ gameId);
		}
		else
		{
		com.hit.gameAlgo.IGameAlgo.GameState event;
		event= GameServerHandler.get(gameId).playOneRound(playerMove);
		return event;
		}

	}
	
	

}
