package com.hit.games;


import java.util.Random;

public class TicTacTowRandom
extends TicTacTow {

	public TicTacTowRandom(int rowLength, int colLength) {
		super(rowLength, colLength);
		
		}
	
	
	
		@Override
		public
		void	calcComputerMove() 
		{
			
			Random rand = new Random();

			int randRow = rand.nextInt(3);
			int randCol = rand.nextInt(3);
			
			while(!board[randRow][randCol].equals(BoardSigns.BLANK))
			{
				randRow = rand.nextInt(3);
				randCol = rand.nextInt(3);
				
			}
			board[randRow][randCol]=BoardSigns.COMPUTER;
		

			
		}
}