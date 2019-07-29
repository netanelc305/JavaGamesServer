package com.hit.games;

import java.util.HashMap;
import java.util.LinkedList;

import java.util.Queue;
import java.util.Random;



public class CatchTheBunnySmart
extends CatchTheBunny
{


	public CatchTheBunnySmart(int rowLength, int colLength) {
		super(rowLength, colLength);
		// TODO Auto-generated constructor stub
	}
	public static enum direction
	{
		
		LEFT,UP,RIGHT,DOWN;

	}

	@Override
	public void calcComputerMove() 
	{
		HashMap<direction,Integer> directions=new HashMap<direction,Integer>();

		//insert directions that the computer can move inside the matrix
		if(computerLocation.getRow()>0)
			directions.put(direction.UP,1);	
		if(computerLocation.getRow()<8)
			directions.put(direction.DOWN, 1);	
		if(computerLocation.getColumn()>0)
			directions.put(direction.LEFT, 1);
		if(computerLocation.getColumn()<8)
			directions.put(direction.RIGHT, 1);
		
		////////////cancels the direction that the player is in///////////
		if (playerLocation.getRow() == computerLocation.getRow()) 
		{
			if(computerLocation.getColumn()+1==playerLocation.getColumn())
				directions.remove(direction.LEFT);
			else if(computerLocation.getColumn()-1==playerLocation.getColumn())
				directions.remove(direction.RIGHT);
		}
		else if(playerLocation.getColumn() == computerLocation.getColumn())
		{
			if(computerLocation.getRow()+1==playerLocation.getRow())
				directions.remove(direction.UP);
			else 	if(computerLocation.getRow()-1==playerLocation.getRow())
				directions.remove(direction.DOWN);
		}
		

		////////////////////////////
		
		GameMove temp;
		if (directions.containsKey(direction.UP)) {

			temp = new GameMove(computerLocation.getRow() - 1, computerLocation.getColumn());

			if ((Math.abs(computerLocation.getRow() - 1 - playerLocation.getRow())
					+ Math.abs(computerLocation.getColumn() - playerLocation.getColumn())) > 2) {

				directions.replace(direction.UP, 2);
			}

			else if ((playerLocation.getRow() - 1 == temp.getRow()
					&& playerLocation.getColumn() - 1 == temp.getColumn())
					|| (playerLocation.getRow() + 1 == temp.getRow()
							&& playerLocation.getColumn() - 1 == temp.getColumn())
					|| (playerLocation.getRow() - 1 == temp.getRow()
							&& playerLocation.getColumn() + 1 == temp.getColumn())
					|| (playerLocation.getRow() + 1 == temp.getRow()
							&& playerLocation.getColumn() + 1 == temp.getColumn())) {
				directions.replace(direction.UP, 3);

			}

			if (computerLocation.getRow() == playerLocation.getRow()) {
				directions.replace(direction.UP, 3);

			}
				
		}
		if(directions.containsKey(direction.DOWN))
		{
			temp=new GameMove(computerLocation.getRow()+1,computerLocation.getColumn());
			if ((Math.abs(computerLocation.getRow() + 1 - playerLocation.getRow())
					+ Math.abs(computerLocation.getColumn() - playerLocation.getColumn()))> 2) 
			{
				directions.replace(direction.DOWN, 2);
			}
			
			else if((playerLocation.getRow()-1==temp.getRow()&&playerLocation.getColumn()-1==temp.getColumn())
					|| (playerLocation.getRow()+1==temp.getRow()&&playerLocation.getColumn()-1==temp.getColumn())
					|| (playerLocation.getRow()-1==temp.getRow()&&playerLocation.getColumn()+1==temp.getColumn())
					|| (playerLocation.getRow()+1==temp.getRow()&&playerLocation.getColumn()+1==temp.getColumn()))
			{
				directions.replace(direction.DOWN, 3);

			}	
			if (computerLocation.getRow() == playerLocation.getRow()) {
				directions.replace(direction.DOWN, 3);

			}

		}
		if(directions.containsKey(direction.LEFT))
		{
			temp=new GameMove(computerLocation.getRow(),computerLocation.getColumn()-1);
			if ((Math.abs(computerLocation.getRow() - playerLocation.getRow())
					+ Math.abs(computerLocation.getColumn() -1- playerLocation.getColumn()))> 2) 
			{
				directions.replace(direction.LEFT, 2);
			}
			
			
			else if((playerLocation.getRow()-1==temp.getRow()&&playerLocation.getColumn()-1==temp.getColumn())
					|| (playerLocation.getRow()+1==temp.getRow()&&playerLocation.getColumn()-1==temp.getColumn())
					|| (playerLocation.getRow()-1==temp.getRow()&&playerLocation.getColumn()+1==temp.getColumn())
					|| (playerLocation.getRow()+1==temp.getRow()&&playerLocation.getColumn()+1==temp.getColumn()))
			{
				directions.replace(direction.LEFT, 3);

			}
			if (computerLocation.getColumn() == playerLocation.getColumn()) {
				directions.replace(direction.LEFT, 3);

			}

		}
		if(directions.containsKey(direction.RIGHT))
		{
			temp=new GameMove(computerLocation.getRow(),computerLocation.getColumn()+1);
			if ((Math.abs(computerLocation.getRow() - playerLocation.getRow())
					+ Math.abs(computerLocation.getColumn() +1- playerLocation.getColumn()))> 2) 
			{
				directions.replace(direction.RIGHT, 2);
			}
			else if((playerLocation.getRow()-1==temp.getRow()&&playerLocation.getColumn()-1==temp.getColumn())
					|| (playerLocation.getRow()+1==temp.getRow()&&playerLocation.getColumn()-1==temp.getColumn())
					|| (playerLocation.getRow()-1==temp.getRow()&&playerLocation.getColumn()+1==temp.getColumn())
					|| (playerLocation.getRow()+1==temp.getRow()&&playerLocation.getColumn()+1==temp.getColumn()))
			{
				directions.replace(direction.RIGHT, 3);

			}
			if (computerLocation.getColumn() == playerLocation.getColumn()) {
				directions.replace(direction.RIGHT, 3);

			}
			

		}
		Queue<direction> q=new LinkedList<>();
		
		int max=0;
		direction tempdir = null;
		

		while (!directions.isEmpty())
		{

			if(directions.containsKey(direction.UP))
			{
				int tempmax=directions.get(direction.UP);
				if(tempmax>=max)
				{
					max=tempmax;
					tempdir=direction.UP;	
				}				
				else
				{
					directions.remove(direction.UP);
					
					
				}
				
				
			}
			if(directions.containsKey(direction.DOWN))
			{
				int tempmax=directions.get(direction.DOWN);
				if(tempmax>=max)
				{
					max=tempmax;
					tempdir=direction.DOWN;	
				}				
				else
				{
					directions.remove(direction.DOWN);	
				}
			}
			if(directions.containsKey(direction.LEFT))
			{
				int tempmax=directions.get(direction.LEFT);
				if(tempmax>=max)
				{
					max=tempmax;
					tempdir=direction.LEFT;	
				}				
				else
				{
					directions.remove(direction.LEFT);	
				}
			}
			if(directions.containsKey(direction.RIGHT))
			{
				int tempmax=directions.get(direction.RIGHT);
				if(tempmax>=max)
				{
					max=tempmax;
					tempdir=direction.RIGHT;	
				}				
				else
				{
					directions.remove(direction.RIGHT);	
				}
			}
			q.add(tempdir);
			directions.remove(tempdir);	
		}
		
		int size=q.size();
		Random rand=new Random();
		int n=rand.nextInt(size)+1;
		for(int i=1; i<=n;i++)
		{
			tempdir=q.poll();
		}
		
		
	
		board[computerLocation.getRow()][computerLocation.getColumn()]=BoardSigns.BLANK;//deletes the old value at the board
		
		if(tempdir==direction.UP)
		{
			computerLocation=new GameMove(computerLocation.getRow()-1,computerLocation.getColumn());

		}
		else if(tempdir==direction.DOWN)
		{
			computerLocation=new GameMove(computerLocation.getRow()+1,computerLocation.getColumn());

		}
		else if(tempdir==direction.LEFT)
		{
			computerLocation=new GameMove(computerLocation.getRow(),computerLocation.getColumn()-1);

		}
		else if(tempdir==direction.RIGHT)
		{
			computerLocation=new GameMove(computerLocation.getRow(),computerLocation.getColumn()+1);

		}
		board[computerLocation.getRow()][computerLocation.getColumn()]=BoardSigns.COMPUTER;


	}
	

	
}
