package com.hit.server;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import com.hit.exception.UnknownIdException;
import com.hit.gameAlgo.GameBoard.GameMove;
import com.hit.gameAlgo.IGameAlgo.GameState;
import com.hit.services.GameServerController;

public class HandleRequest extends java.lang.Object implements java.lang.Runnable {

	private Socket socket;
	GameServerController controller;

	HandleRequest(java.net.Socket s, GameServerController controller) {
		this.socket = s;
		this.controller = controller;

	}

	@Override
	public void run() 
	{
		try {
			ObjectInputStream reader = new ObjectInputStream(socket.getInputStream());
			ObjectOutputStream writer = new ObjectOutputStream(socket.getOutputStream());
			JSONObject jsonIn = null;

			
			jsonIn= (JSONObject) reader.readObject();
		


		
		    	JSONObject jsonOut=new JSONObject();
		    	JSONArray arrOut=new JSONArray();
		    
			    char[][] arr = null;

	
		    	switch(jsonIn.get("type").toString())
		    	{
		    	   case "New-Game":
		    	   {
		    		jsonOut.put("type", (String)jsonIn.get("type").toString());
		    		
		    		String game =(String) jsonIn.get("game");
		    		String opponent=(String) jsonIn.get("opponent");;
		    		
		    		
		    		int id=controller.newGame(game, opponent);
		   
		    		jsonOut.put("ID",id);		    		
		    		if(id!=-1)
		    		{
		    			try {
							arr=controller.getBoardState(id);
						} catch (UnknownIdException e) {e.printStackTrace();}
		    			arrOut=arrToJsonarr(arr);
		    		}
		    		else
		    		{
		    			
		    			arrOut=null;
		    		}
		    		jsonOut.put("board", arrOut);
	
		    		writer.writeObject(jsonOut);
		    		writer.flush();

		    	   }
		    	   break;
		          	
		    	case "Update-Move":
		    	{
		    		jsonOut.put("type", (String)jsonIn.get("type").toString());//type
			    	 int id=((Long) jsonIn.get("ID")).intValue();
			    	 jsonOut.put("ID", (String)jsonIn.get("ID").toString());//type+ID
			    	 int row=((Long) jsonIn.get("row")).intValue();
			    	 int col=((Long) jsonIn.get("col")).intValue();
			    	 GameMove move =new GameMove(row,col);
			    	 
			    	 
			       GameState gs=null;
				try {
			
					
					gs = controller.updateMove(id, move);
					
		
				} catch (UnknownIdException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			    	jsonOut.put("state",gs.getRate());//type+ID+state
			    	if(gs.getRate()==0)
			    	{
				    	arrOut=null;
							
			    	}
			    	else
			      	{
			    		try {
							arr=controller.getBoardState(id);
						} catch (UnknownIdException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			    		arrOut=arrToJsonarr(arr);
			    	}
			    	jsonOut.put("board", arrOut);
		
		    		writer.writeObject(jsonOut);
			    	
			    	writer.writeObject(jsonOut);
			    	writer.flush();

		    	}
		    	break;
		    	case "Start-Game":
		    	{
			    	int id=((Long) jsonIn.get("ID")).intValue();
			    	jsonOut.put("type", jsonIn.get("type"));
			    	jsonOut.put("ID", id);//type+id
			    	
			    	try {
						arr=controller.computerStartGame(id);
					} catch (UnknownIdException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    	arrOut=arrToJsonarr(arr);
			    	jsonOut.put("board", arrOut);
			    	writer.writeObject(jsonOut);
			    	writer.flush();
		      	}
		    	break;
		    	
	    		case "Stop-Game":
	    		{
		    		int id = ((Long) jsonIn.get("ID")).intValue();

		    		try {
						controller.endGame(id);
					} catch (UnknownIdException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

		  
		    	 }
	    		break;
		    	}
		    	
		
		    	

		    	
		    	reader.close();
		    	writer.close();

	    		
		} catch (IOException | ClassNotFoundException e) {e.printStackTrace();}
		finally
		{
			

			try {

				
				
				
				this.socket.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private JSONArray arrToJsonarr(char [][] oarr)
	{
		String[] arr;
		int size=0;
	
		if(oarr.length==9)
		{
		    arr = new String[9*9];
			for (int row = 0; row < 9; row++) {
				for (int col = 0; col < 9; col++) {
					if (oarr[row][col] == 'C')
						arr[size] = Character.toString('B');
					else if (oarr[row][col] == 'P')
						arr[size] = Character.toString('K');
					else
						arr[size] = Character.toString('-');
					size++;
				}
			}
		}
		else
		{
			 arr = new String[3*3];
			
			for (int row = 0; row < 3; row++) {
				for (int col = 0; col < 3; col++) {
					if (oarr[row][col] == 'C')
						arr[size] =Character.toString('o');
					else if (oarr[row][col] == 'P')
						arr[size] = Character.toString('x');
					else
					{
						arr[size] = Character.toString('-');
					}
					size++;
				}
			}
		}
		JSONArray jarr = new JSONArray();
		for (int i = 0; i < size; i++) {

			
			jarr.add(arr[i]);
		}
		return jarr;
		
		
	}






}
