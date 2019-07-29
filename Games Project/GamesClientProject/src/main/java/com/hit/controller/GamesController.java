package com.hit.controller;

import java.beans.PropertyChangeEvent;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.hit.model.Model;
import com.hit.view.View;

public class GamesController
extends java.lang.Object
implements Controller
{
	private Model model;
	private View view;


	
	public GamesController(Model model, View view) 
	{
		this.model=model;
		this.view=view;
		
	}

	@Override
	public void propertyChange(PropertyChangeEvent event)
	{
		String [] splited=event.getNewValue().toString().split("_");
		if("View Event".equals(event.getPropertyName()))
		{
			if(splited[0].equals("newgame"))// new game string:"newgame gametype opponent"
			{
			 model.newGame(splited[1], splited[2]);
			}//returns an event not an object
			if(splited[0].equals("endgame"))
			{
				model.endGame();	
			}
			if(splited[0].equals("startgame"))
			{
				model.startGame();	
			}
			if(splited[0].equals("updateplayermove"))
			{
			model.updatePlayerMove(Integer.parseInt(splited[1]), Integer.parseInt(splited[2]));
			}
		}
		else if("ModelEvent".equals(event.getPropertyName()))
		{
			try {
				Character[] nboard=null;
				JSONParser parser = new JSONParser();

				JSONObject json;

					json = (JSONObject) parser.parse((String) event.getNewValue());


				String type=(String) json.get("type");
				
				if(type.equals("New-Game"))
				{
					
					Long id=(long) json.get("ID");
					if(id==-1)//in case the server couldnt create a new game it returns a new "game state -1" that will be handled at GamesView
					{
						view.updateViewGameMove(-1, nboard);
						
					}
					else
					{
					nboard=jsonToChar(json);
					
					view.updateViewNewGame(nboard);
					}

				}
				else if(type.equals("Update-Move"))
				{
					int gs=((Long) json.get("state")).intValue();
					if (gs != 0) 
					{
						nboard=jsonToChar(json);
					}
					view.updateViewGameMove(gs, nboard);
				}
				else if(type.equals("Start-Game"))
				{
					nboard=jsonToChar(json);
					view.updateViewGameMove(4, nboard);
					
					
				}
				
				
		
		}
	 catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();}
		}

	}
	private Character[] jsonToChar(JSONObject json)
	{
		Character[] nboard=null;
		JSONArray board = (JSONArray) json.get("board");
		nboard = new Character[board.size()];
		int i = 0;
		Iterator<String> iterator = board.iterator();

		while (iterator.hasNext()) {
			nboard[i] = iterator.next().charAt(0);

			i++;

		}
		return nboard;
		
		
	}
	
	
	
	
}