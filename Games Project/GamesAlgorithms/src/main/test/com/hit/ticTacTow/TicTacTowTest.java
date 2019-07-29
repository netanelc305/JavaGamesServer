package com.hit.ticTacTow;

import java.util.Scanner;

import org.junit.Test;

import com.hit.gameAlgo.GameBoard;
import com.hit.gameAlgo.IGameAlgo.GameState;
import com.hit.games.TicTacTowRandom;
import com.hit.games.TicTacTowSmart;


public class TicTacTowTest {
	@Test 
	public void ticRandomTest()
	{
		GameBoard.GameMove move=null;
		TicTacTowRandom starter=new TicTacTowRandom(3,3);
		
		char[][] board=starter.getBoardState();
		
		printBoard(board);
		

		int r=1; //delete
		Scanner in=new Scanner(System.in);
		
		while(starter.getGameState(move).equals(GameState.IN_PROGRESS))
		{

		
		do
		{
			System.out.println("try num: "+r);
			r++;
			System.out.println("enter row");
			int row=in.nextInt();
			System.out.println("enter column");
			int col=in.nextInt();
			move=new GameBoard.GameMove(row,col);
			System.out.println("row: " +row+"col: "+col);
			
			

		}
		while(!starter.updatePlayerMove(move));
		printBoard(board=starter.getBoardState());
		System.out.println();
		if(starter.getGameState(move).equals(GameState.PLAYER_WON))
		{
			System.out.println("player won");
			break;
		}
		else if(starter.getGameState(move).equals(GameState.PLAYER_LOST))
		{
			System.out.println("player lost");
			break;
		}
		else if(starter.getGameState(move).equals(GameState.TIE))
		{
			System.out.println("Tie");
			break;
			
			
		}
		starter.calcComputerMove();
		printBoard(board=starter.getBoardState());
		
		
		if(starter.getGameState(move).equals(GameState.PLAYER_WON))
		{
			System.out.println("player won");
			break;
		}
		else if(starter.getGameState(move).equals(GameState.PLAYER_LOST))
		{
			System.out.println("player lost");
			break;
		}
		else if(starter.getGameState(move).equals(GameState.TIE))
		{
			System.out.println("Tie");
			break;
			
			
		}
		
		
		
		}
		
		
		
		
		
		
		
		
	}
	
	@Test
	public void ticSmartTest()
	{
		GameBoard.GameMove move=null;
		TicTacTowSmart starter=new TicTacTowSmart(3,3);
		
		char[][] board=starter.getBoardState();
		
		printBoard(board);
		

		int r=1; //delete
		Scanner in=new Scanner(System.in);
		
		while(starter.getGameState(move).equals(GameState.IN_PROGRESS))
		{

		
		do
		{
			System.out.println("try num: "+r);
			r++;
			System.out.println("enter row");
			int row=in.nextInt();
			System.out.println("enter column");
			int col=in.nextInt();
			move=new GameBoard.GameMove(row,col);
			System.out.println("row: " +row+"col: "+col);
			
			

		}
		while(!starter.updatePlayerMove(move));
		printBoard(board=starter.getBoardState());
		System.out.println();
		if(starter.getGameState(move).equals(GameState.PLAYER_WON))
		{
			System.out.println("player won");
			break;
		}
		else if(starter.getGameState(move).equals(GameState.PLAYER_LOST))
		{
			System.out.println("player lost");
			break;
		}
		else if(starter.getGameState(move).equals(GameState.TIE))
		{
			System.out.println("Tie");
			break;
			
			
		}
		starter.calcComputerMove();
		printBoard(board=starter.getBoardState());
		
		
		if(starter.getGameState(move).equals(GameState.PLAYER_WON))
		{
			System.out.println("player won");
			break;
		}
		else if(starter.getGameState(move).equals(GameState.PLAYER_LOST))
		{
			System.out.println("player lost");
			break;
		}
		else if(starter.getGameState(move).equals(GameState.TIE))
		{
			System.out.println("Tie");
			break;
			
			
		}
		
		
		
		}
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	private void printBoard(char[][] board)
	{
		

		for(int row=0;row<3;row++)
		{
			System.out.print("|");
			for(int col=0;col<3;col++)
			{
				System.out.print(board[row][col]);
				System.out.print("|");
				
			}
			System.out.println();
			
			
			
			
		}
		
		
	}
	
	
	

}