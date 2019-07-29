package com.hit.catchTheBunny;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import org.junit.Test;

import com.hit.gameAlgo.GameBoard;
import com.hit.gameAlgo.IGameAlgo.GameState;
import com.hit.games.CatchTheBunnyRandom;
import com.hit.games.CatchTheBunnySmart;

public class CatchTheBunnyTest {
	@Test
	public void catchRandomTest() throws IOException {

		CatchTheBunnyRandom starter = new CatchTheBunnyRandom(9, 9);

		Scanner in = new Scanner(System.in);
		GameBoard.GameMove move;
		int x, y;

		char[][] board = null;
		printBoard(board = starter.getBoardState());

		while (true) 
		{
			

			do {
				System.out.println("enter row");
				x = in.nextInt();
				System.out.println("enter col");
				y = in.nextInt();

				move = new GameBoard.GameMove(x, y);
			} while (!starter.updatePlayerMove(move));
			System.out.println(starter.getGameState(move));
			if(starter.getGameState(move)==GameState.IN_PROGRESS)
			{
				starter.calcComputerMove();

			}
			else
			{
				
				System.out.println("game ended");
			}

			printBoard(board = starter.getBoardState());

		}

	}

	private void printBoard(char[][] board) {
		int pr = 0, pc = 0, cr = 0, cc = 0;
		for (int row = 0; row < board.length; row++) {
			System.out.print(row + " ");
			for (int col = 0; col < board[0].length; col++) {
				System.out.print(" " + board[row][col]);

				if (board[row][col] == 'P') {
					pr = row;
					pc = col;
				} else if (board[row][col] == 'C') {
					cr = row;
					cc = col;

				}

			}
			System.out.println();
		}
		System.out.println("   0 1 2 3 4 5 6 7 8");
		System.out.println("\n player position: " + pr + " " + pc + "\ncomputer position: " + cr + " " + cc);

		System.out.println("\n\n\n");

	}

	@Test
	public void catchSmartTest() {

		CatchTheBunnySmart starter = new CatchTheBunnySmart(9, 9);

		Scanner in = new Scanner(System.in);
		GameBoard.GameMove move;
		int x, y;

		char[][] board = null;
		printBoard(board = starter.getBoardState());

		while (true) 
		{
			

			do {
				System.out.println("enter row");
				x = in.nextInt();
				System.out.println("enter col");
				y = in.nextInt();

				move = new GameBoard.GameMove(x, y);
			} while (!starter.updatePlayerMove(move));
			System.out.println(starter.getGameState(move));
			if(starter.getGameState(move)==GameState.IN_PROGRESS)
			{
				starter.calcComputerMove();

			}
			else
			{
				
				System.out.println("game ended");
			}

			printBoard(board = starter.getBoardState());

		}

	}

}
