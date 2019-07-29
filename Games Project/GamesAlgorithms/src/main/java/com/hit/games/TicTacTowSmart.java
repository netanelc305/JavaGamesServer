package com.hit.games;

import java.util.Random;



public class TicTacTowSmart
extends TicTacTow
{

	private int counter = 1;
	
	
	public TicTacTowSmart(int rowLength, int colLength) {
		super(rowLength, colLength);

	}

	@Override
	public void calcComputerMove() {
		
		///// checks if computer can win in 1 move
		
		System.out.println(counter);

		switch(counter++) {
		case 1:
			firstMove();
			break;
		case 2:
			if(!defenseMove())secondMove();
			break;
		default:
			 ThirdAndUpMove();
			break;
		
		}
			
		
		
		
	}
	

	private  void firstMove() {
		
		Random rand= new Random();
		int f= rand.nextInt(4)+1;
		
		//System.out.println("FIRST PC MOVE:");

		//If user select a corner -> PC select middle
		for (int i = 0; i < board.length; i+=2) {
			for (int j = 0; j < board.length; j+=2) {
				if(board[i][j].equals(BoardSigns.PLAYER)&&board[1][1].equals(BoardSigns.BLANK)) {
					board[1][1]=BoardSigns.COMPUTER;
				return;
				}
			}
		}
		
		///If the user does not select a corner, the computer selects a corner in a randomly
			switch (f) {
			case 1:
				board[0][0]=BoardSigns.COMPUTER;
				break;
			case 2:
				board[0][2]=BoardSigns.COMPUTER;
				break;
			case 3:
				board[2][0]=BoardSigns.COMPUTER;
				break;
			default:
				board[2][2]=BoardSigns.COMPUTER;
				break;			
			}
	}
	private  void secondMove() {
		//System.out.println("SEC PC MOVE:");

		
		
		//if user select corner across of first selection && PC in the middle 
		if(board[1][1].equals(BoardSigns.COMPUTER)) {
			if((board[0][1].equals(BoardSigns.BLANK))&&(board[2][1].equals(BoardSigns.BLANK)))board[0][1]=BoardSigns.COMPUTER;
			else if((board[1][0].equals(BoardSigns.BLANK))&&(board[1][2].equals(BoardSigns.BLANK)))board[1][2]=BoardSigns.COMPUTER;
		}
		
		
		
		//if player selected middle pc will select across corner
		else if(board[1][1].equals(BoardSigns.PLAYER)){
			if	   ((board[0][0].equals(BoardSigns.COMPUTER))&&(board[2][2].equals(BoardSigns.BLANK)))board[2][2]=BoardSigns.COMPUTER;
			else if((board[2][2].equals(BoardSigns.COMPUTER))&&(board[0][0].equals(BoardSigns.BLANK)))board[0][0]=BoardSigns.COMPUTER;
			else if((board[0][2].equals(BoardSigns.COMPUTER))&&(board[2][0].equals(BoardSigns.BLANK)))board[2][0]=BoardSigns.COMPUTER;
			else if((board[2][0].equals(BoardSigns.COMPUTER))&&(board[0][2].equals(BoardSigns.BLANK)))board[0][2]=BoardSigns.COMPUTER;
		}
		
		//if player selected corner
		else if(board[0][0].equals(BoardSigns.PLAYER)) {
			if	   ((board[2][0].equals(BoardSigns.COMPUTER))&&(board[0][2].equals(BoardSigns.BLANK)))board[0][2]=BoardSigns.COMPUTER;
			else if((board[2][2].equals(BoardSigns.COMPUTER))&&(board[2][0].equals(BoardSigns.BLANK)))board[2][0]=BoardSigns.COMPUTER;
			else if((board[0][2].equals(BoardSigns.COMPUTER))&&(board[2][0].equals(BoardSigns.BLANK)))board[2][0]=BoardSigns.COMPUTER;
		}
		//if player selected corner

		else if(board[0][2].equals(BoardSigns.PLAYER)) {
			if	   ((board[0][0].equals(BoardSigns.COMPUTER))&&(board[2][2].equals(BoardSigns.BLANK)))board[2][2]=BoardSigns.COMPUTER;
			else if((board[2][2].equals(BoardSigns.COMPUTER))&&(board[0][0].equals(BoardSigns.BLANK)))board[0][0]=BoardSigns.COMPUTER;
			else if((board[2][0].equals(BoardSigns.COMPUTER))&&(board[2][2].equals(BoardSigns.BLANK)))board[2][2]=BoardSigns.COMPUTER;
		}
		//if player selected corner

		else if(board[2][0].equals(BoardSigns.PLAYER)) {
			if	   ((board[0][0].equals(BoardSigns.COMPUTER))&&(board[2][2].equals(BoardSigns.BLANK)))board[2][2]=BoardSigns.COMPUTER;
			else if((board[2][2].equals(BoardSigns.COMPUTER))&&(board[0][0].equals(BoardSigns.BLANK)))board[0][0]=BoardSigns.COMPUTER;
			else if((board[0][2].equals(BoardSigns.COMPUTER))&&(board[0][0].equals(BoardSigns.BLANK)))board[0][0]=BoardSigns.COMPUTER;
		}
		//if player selected corner

		else if(board[2][2].equals(BoardSigns.PLAYER)) {
			if	   ((board[2][0].equals(BoardSigns.COMPUTER))&&(board[0][2].equals(BoardSigns.BLANK)))board[0][2]=BoardSigns.COMPUTER;
			else if((board[0][0].equals(BoardSigns.COMPUTER))&&(board[2][0].equals(BoardSigns.BLANK)))board[2][0]=BoardSigns.COMPUTER;
			else if((board[0][2].equals(BoardSigns.COMPUTER))&&(board[2][0].equals(BoardSigns.BLANK)))board[2][0]=BoardSigns.COMPUTER;
		}
		
		
		//If player selected side
		else if(board[0][1].equals(BoardSigns.PLAYER)){
			if	   ((board[0][0].equals(BoardSigns.COMPUTER))&&(board[2][0].equals(BoardSigns.BLANK)))board[2][0]=BoardSigns.COMPUTER;
			else if((board[0][2].equals(BoardSigns.COMPUTER))&&(board[2][2].equals(BoardSigns.BLANK)))board[2][2]=BoardSigns.COMPUTER;
			else if((board[2][0].equals(BoardSigns.COMPUTER))&&(board[0][0].equals(BoardSigns.BLANK)))board[0][0]=BoardSigns.COMPUTER;
			else if((board[2][2].equals(BoardSigns.COMPUTER))&&(board[0][2].equals(BoardSigns.BLANK)))board[0][2]=BoardSigns.COMPUTER;
		}
		//If player selected side
		else if(board[1][0].equals(BoardSigns.PLAYER)){
			if	   ((board[0][0].equals(BoardSigns.COMPUTER))&&(board[0][2].equals(BoardSigns.BLANK)))board[0][2]=BoardSigns.COMPUTER;
			else if((board[2][0].equals(BoardSigns.COMPUTER))&&(board[2][2].equals(BoardSigns.BLANK)))board[2][2]=BoardSigns.COMPUTER;
			else if((board[2][2].equals(BoardSigns.COMPUTER))&&(board[2][0].equals(BoardSigns.BLANK)))board[2][0]=BoardSigns.COMPUTER;
			else if((board[0][2].equals(BoardSigns.COMPUTER))&&(board[0][0].equals(BoardSigns.BLANK)))board[0][0]=BoardSigns.COMPUTER;
		}
		//If player selected side
		else if(board[2][1].equals(BoardSigns.PLAYER)){
			if	   ((board[2][0].equals(BoardSigns.COMPUTER))&&(board[0][0].equals(BoardSigns.BLANK)))board[0][0]=BoardSigns.COMPUTER;
			else if((board[2][2].equals(BoardSigns.COMPUTER))&&(board[0][2].equals(BoardSigns.BLANK)))board[0][2]=BoardSigns.COMPUTER;
			else if((board[0][0].equals(BoardSigns.COMPUTER))&&(board[2][0].equals(BoardSigns.BLANK)))board[2][0]=BoardSigns.COMPUTER;
			else if((board[0][2].equals(BoardSigns.COMPUTER))&&(board[2][2].equals(BoardSigns.BLANK)))board[2][2]=BoardSigns.COMPUTER;
		}
		//If player selected side
		else if(board[1][2].equals(BoardSigns.PLAYER)){
			if	   ((board[0][2].equals(BoardSigns.COMPUTER))&&(board[0][0].equals(BoardSigns.BLANK)))board[0][0]=BoardSigns.COMPUTER;
			else if((board[2][2].equals(BoardSigns.COMPUTER))&&(board[2][0].equals(BoardSigns.BLANK)))board[2][0]=BoardSigns.COMPUTER;
			else if((board[0][0].equals(BoardSigns.COMPUTER))&&(board[0][2].equals(BoardSigns.BLANK)))board[0][2]=BoardSigns.COMPUTER;
			else if((board[2][2].equals(BoardSigns.COMPUTER))&&(board[2][2].equals(BoardSigns.BLANK)))board[2][2]=BoardSigns.COMPUTER;
		}
		
		
		
}
	private  void ThirdAndUpMove() {
		
	//	System.out.println("THIRD PC MOVE:");

		if (checkWin()) return;
		else if (defenseMove()) return;
		else {
			for(int i=0;i<board.length;i+=2) {
				for(int j=0;j<board.length;j+=2) {
					if(board[i][j].equals(BoardSigns.BLANK)) {
						board[i][j]=BoardSigns.COMPUTER;
						return;
					}
				}
			}
		}
	
	
}
	private  boolean defenseMove() {
		//FIRST ROW
	

			
				if((board[0][0].equals(BoardSigns.PLAYER))&&(board[0][1].equals(BoardSigns.PLAYER))&&(board[0][2].equals(BoardSigns.BLANK))){
					board[0][2]=BoardSigns.COMPUTER; return true;
				}
				if((board[0][0].equals(BoardSigns.PLAYER))&&(board[0][2].equals(BoardSigns.PLAYER))&&(board[0][1].equals(BoardSigns.BLANK))){
					board[0][1]=BoardSigns.COMPUTER;
					return true;
				}
				if((board[0][2].equals(BoardSigns.PLAYER))&&(board[0][1].equals(BoardSigns.PLAYER))&&(board[0][0].equals(BoardSigns.BLANK))){
					board[0][0]=BoardSigns.COMPUTER;
					return true;
				}
				
				//SEC ROW
				if((board[1][0].equals(BoardSigns.PLAYER))&&(board[1][1].equals(BoardSigns.PLAYER))&&(board[1][2].equals(BoardSigns.BLANK))){
					board[1][2]=BoardSigns.COMPUTER;
					return true;
				}
				if((board[1][0].equals(BoardSigns.PLAYER))&&(board[1][2].equals(BoardSigns.PLAYER))&&(board[1][1].equals(BoardSigns.BLANK))){
					board[1][1]=BoardSigns.COMPUTER;
					return true;
				}
				if((board[1][2].equals(BoardSigns.PLAYER))&&(board[1][1].equals(BoardSigns.PLAYER))&&(board[1][0].equals(BoardSigns.BLANK))){
					board[1][0]=BoardSigns.COMPUTER;
					return true;
				}
				
				//THIRD ROW
				if((board[2][0].equals(BoardSigns.PLAYER))&&(board[2][1].equals(BoardSigns.PLAYER))&&(board[2][2].equals(BoardSigns.BLANK))){
					board[2][2]=BoardSigns.COMPUTER;
					return true;
				}
				if((board[2][0].equals(BoardSigns.PLAYER))&&(board[2][2].equals(BoardSigns.PLAYER))&&(board[2][1].equals(BoardSigns.BLANK))){
					board[2][1]=BoardSigns.COMPUTER;
					return true;
				}
				if((board[2][2].equals(BoardSigns.PLAYER))&&(board[2][1].equals(BoardSigns.PLAYER))&&(board[2][0].equals(BoardSigns.BLANK))){
					board[2][0]=BoardSigns.COMPUTER;
					return true;
				}
				
				//FIRST COL
				if((board[0][0].equals(BoardSigns.PLAYER))&&(board[1][0].equals(BoardSigns.PLAYER))&&(board[2][0].equals(BoardSigns.BLANK))){
					board[2][0]=BoardSigns.COMPUTER;
					return true;
				}
				if((board[0][0].equals(BoardSigns.PLAYER))&&(board[2][0].equals(BoardSigns.PLAYER))&&(board[1][0].equals(BoardSigns.BLANK))){
					board[1][0]=BoardSigns.COMPUTER;
					return true;
				}
				if((board[2][0].equals(BoardSigns.PLAYER))&&(board[1][0].equals(BoardSigns.PLAYER))&&(board[0][0].equals(BoardSigns.BLANK))){
					board[0][0]=BoardSigns.COMPUTER;
					return true;
				}
				
				//SEC COL
				if((board[0][1].equals(BoardSigns.PLAYER))&&(board[1][1].equals(BoardSigns.PLAYER))&&(board[2][1].equals(BoardSigns.BLANK))){
					board[2][1]=BoardSigns.COMPUTER;
					return true;
				}
				if((board[0][1].equals(BoardSigns.PLAYER))&&(board[2][1].equals(BoardSigns.PLAYER))&&(board[1][1].equals(BoardSigns.BLANK))){
					board[1][1]=BoardSigns.COMPUTER;
					return true;
				}
				if((board[2][1].equals(BoardSigns.PLAYER))&&(board[1][1].equals(BoardSigns.PLAYER))&&(board[0][1].equals(BoardSigns.BLANK))){
					board[0][1]=BoardSigns.COMPUTER;
					return true;
				}
				
				
				//THIRD COL
				if((board[0][2].equals(BoardSigns.PLAYER))&&(board[1][2].equals(BoardSigns.PLAYER))&&(board[2][2].equals(BoardSigns.BLANK))){
					board[2][2]=BoardSigns.COMPUTER;
					return true;
				}
				if((board[0][2].equals(BoardSigns.PLAYER))&&(board[2][2].equals(BoardSigns.PLAYER))&&(board[1][2].equals(BoardSigns.BLANK))){
					board[1][2]=BoardSigns.COMPUTER;
					return true;
				}
				if((board[2][2].equals(BoardSigns.PLAYER))&&(board[1][2].equals(BoardSigns.PLAYER))&&(board[0][2].equals(BoardSigns.BLANK))){
					board[0][2]=BoardSigns.COMPUTER;
					return true;
				}
								
				
				//FIRST DIAGONAL 
				if((board[0][0].equals(BoardSigns.PLAYER))&&(board[1][1].equals(BoardSigns.PLAYER))&&(board[2][2].equals(BoardSigns.BLANK))){
					board[2][2]=BoardSigns.COMPUTER;
					return true;
				}
				if((board[0][0].equals(BoardSigns.PLAYER))&&(board[2][2].equals(BoardSigns.PLAYER))&&(board[1][1].equals(BoardSigns.BLANK))){
					board[1][1]=BoardSigns.COMPUTER;
					return true;
				}
				if((board[2][2].equals(BoardSigns.PLAYER))&&(board[1][1].equals(BoardSigns.PLAYER))&&(board[0][0].equals(BoardSigns.BLANK))){
					board[0][0]=BoardSigns.COMPUTER;
					return true;
				}
				
				//SEC DIAGONAL 
				if((board[0][2].equals(BoardSigns.PLAYER))&&(board[1][1].equals(BoardSigns.PLAYER))&&(board[2][0].equals(BoardSigns.BLANK))){
					board[2][0]=BoardSigns.COMPUTER;
					return true;
				}
				if((board[0][2].equals(BoardSigns.PLAYER))&&(board[2][0].equals(BoardSigns.PLAYER))&&(board[1][1].equals(BoardSigns.BLANK))){
					board[1][1]=BoardSigns.COMPUTER;
					return true;
				}
				if((board[2][0].equals(BoardSigns.PLAYER))&&(board[1][1].equals(BoardSigns.PLAYER))&&(board[0][2].equals(BoardSigns.BLANK))){
					board[0][2]=BoardSigns.COMPUTER;
					return true;
				}
				return false;
	}
	private  boolean checkWin() {
	
		//FIRST ROW
	
	
				if((board[0][0].equals(BoardSigns.COMPUTER))&&(board[0][1].equals(BoardSigns.COMPUTER))&&(board[0][2].equals(BoardSigns.BLANK))){
					board[0][2]=BoardSigns.COMPUTER;return true;
				}
				else if((board[0][0].equals(BoardSigns.COMPUTER))&&(board[0][2].equals(BoardSigns.COMPUTER))&&(board[0][1].equals(BoardSigns.BLANK))){
					board[0][1]=BoardSigns.COMPUTER;return true;
				}
				else if((board[0][2].equals(BoardSigns.COMPUTER))&&(board[0][1].equals(BoardSigns.COMPUTER))&&(board[0][0].equals(BoardSigns.BLANK))){
					board[0][0]=BoardSigns.COMPUTER;return true;
				}
				
				//SEC ROW
				else if((board[1][0].equals(BoardSigns.COMPUTER))&&(board[1][1].equals(BoardSigns.COMPUTER))&&(board[1][2].equals(BoardSigns.BLANK))){
					board[1][2]=BoardSigns.COMPUTER;return true;
				}
				else if((board[1][0].equals(BoardSigns.COMPUTER))&&(board[1][2].equals(BoardSigns.COMPUTER))&&(board[1][1].equals(BoardSigns.BLANK))){
					board[1][1]=BoardSigns.COMPUTER;return true;
				}
				else if((board[1][2].equals(BoardSigns.COMPUTER))&&(board[1][1].equals(BoardSigns.COMPUTER))&&(board[1][0].equals(BoardSigns.BLANK))){
					board[1][0]=BoardSigns.COMPUTER;return true;
				}
				
				//THIRD ROW
				else if((board[2][0].equals(BoardSigns.COMPUTER))&&(board[1][1].equals(BoardSigns.COMPUTER))&&(board[2][2].equals(BoardSigns.BLANK))){
					board[2][2]=BoardSigns.COMPUTER;return true;
				}
				else if((board[2][0].equals(BoardSigns.COMPUTER))&&(board[2][2].equals(BoardSigns.COMPUTER))&&(board[2][1].equals(BoardSigns.BLANK))){
					board[2][1]=BoardSigns.COMPUTER;return true;
				}
				else if((board[2][2].equals(BoardSigns.COMPUTER))&&(board[1][1].equals(BoardSigns.COMPUTER))&&(board[2][0].equals(BoardSigns.BLANK))){
					board[2][0]=BoardSigns.COMPUTER;return true;
				}
				
				//FIRST COL
				else if((board[0][0].equals(BoardSigns.COMPUTER))&&(board[1][0].equals(BoardSigns.COMPUTER))&&(board[2][0].equals(BoardSigns.BLANK))){
					board[2][0]=BoardSigns.COMPUTER;return true;
				}
				else if((board[0][0].equals(BoardSigns.COMPUTER))&&(board[2][0].equals(BoardSigns.COMPUTER))&&(board[1][0].equals(BoardSigns.BLANK))){
					board[1][0]=BoardSigns.COMPUTER;return true;
				}
				else if((board[2][0].equals(BoardSigns.COMPUTER))&&(board[1][0].equals(BoardSigns.COMPUTER))&&(board[0][0].equals(BoardSigns.BLANK))){
					board[0][0]=BoardSigns.COMPUTER;return true;
				}
				
				//SEC COL
				else if((board[0][1].equals(BoardSigns.COMPUTER))&&(board[1][1].equals(BoardSigns.COMPUTER))&&(board[2][1].equals(BoardSigns.BLANK))){
					board[2][1]=BoardSigns.COMPUTER;return true;
				}
				else if((board[0][1].equals(BoardSigns.COMPUTER))&&(board[2][1].equals(BoardSigns.COMPUTER))&&(board[1][1].equals(BoardSigns.BLANK))){
					board[1][1]=BoardSigns.COMPUTER;return true;
				}
				else if((board[2][1].equals(BoardSigns.COMPUTER))&&(board[1][1].equals(BoardSigns.COMPUTER))&&(board[0][1].equals(BoardSigns.BLANK))){
					board[0][1]=BoardSigns.COMPUTER;return true;
				}
				
				
				//THIRD COL
				else if((board[0][2].equals(BoardSigns.COMPUTER))&&(board[1][2].equals(BoardSigns.COMPUTER))&&(board[2][2].equals(BoardSigns.BLANK))){
					board[2][2]=BoardSigns.COMPUTER;return true;
				}
				else if((board[0][2].equals(BoardSigns.COMPUTER))&&(board[2][2].equals(BoardSigns.COMPUTER))&&(board[1][2].equals(BoardSigns.BLANK))){
					board[1][2]=BoardSigns.COMPUTER;return true;
				}
				else if((board[2][2].equals(BoardSigns.COMPUTER))&&(board[1][2].equals(BoardSigns.COMPUTER))&&(board[0][2].equals(BoardSigns.BLANK))){
					board[0][2]=BoardSigns.COMPUTER;return true;
				}
								
				
				//FIRST DIAGONAL 
				else if((board[0][0].equals(BoardSigns.COMPUTER))&&(board[1][1].equals(BoardSigns.COMPUTER))&&(board[2][2].equals(BoardSigns.BLANK))){
					board[2][2]=BoardSigns.COMPUTER;return true;
				}
				else if((board[0][0].equals(BoardSigns.COMPUTER))&&(board[2][2].equals(BoardSigns.COMPUTER))&&(board[1][1].equals(BoardSigns.BLANK))){
					board[1][1]=BoardSigns.COMPUTER;return true;
				}
				else if((board[2][2].equals(BoardSigns.COMPUTER))&&(board[1][1].equals(BoardSigns.COMPUTER))&&(board[0][0].equals(BoardSigns.BLANK))){
					board[0][0]=BoardSigns.COMPUTER;return true;
				}
				
				//SEC DIAGONAL 
				else if((board[0][2].equals(BoardSigns.COMPUTER))&&(board[1][1].equals(BoardSigns.COMPUTER))&&(board[2][0].equals(BoardSigns.BLANK))){
					board[2][0]=BoardSigns.COMPUTER;return true;
				}
				else if((board[0][2].equals(BoardSigns.COMPUTER))&&(board[2][0].equals(BoardSigns.COMPUTER))&&(board[1][1].equals(BoardSigns.BLANK))){
					board[1][1]=BoardSigns.COMPUTER;return true;
				}
				else if((board[2][0].equals(BoardSigns.COMPUTER))&&(board[1][1].equals(BoardSigns.COMPUTER))&&(board[0][2].equals(BoardSigns.BLANK))){
					board[0][2]=BoardSigns.COMPUTER;return true;
				}
				
	return false;
		
	}

		
}
