package com.hit.model;

import java.beans.PropertyChangeSupport;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class GamesModel
extends java.lang.Object
implements Model
{
	PropertyChangeSupport changes;
	GamesClient GC=new GamesClient(34567);
	private long id;

	
	public GamesModel() 
	{
		changes=new PropertyChangeSupport(this);
		
	}

	@Override
	public void newGame(String gameType, String opponentType) {
			JSONObject jout = new JSONObject();
			jout.put("type", "New-Game");
			jout.put("game", gameType);
			jout.put("opponent", opponentType);
			String retString = null;
			
			try {
				
			 retString = GC.sendMessage(jout.toString(), true);
			JSONParser parser = new JSONParser();
			
			JSONObject json;

				json = (JSONObject) parser.parse(retString);

			id=(long) json.get("ID");

			
			
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

			changes.firePropertyChange("ModelEvent", null, retString);

	}

	@Override
	public void updatePlayerMove(int row, int col) 
	{
		JSONObject jout=new JSONObject();
		jout.put("type", "Update-Move");
		jout.put("ID", id);
		jout.put("row", row);
		jout.put("col", col);
		String retString= GC.sendMessage(jout.toString(), true);
		changes.firePropertyChange("ModelEvent", null, retString);
	}
	@Override
	public void startGame() {
		JSONObject jout=new JSONObject();
		jout.put("type", "Start-Game");
		jout.put("ID", id);
		String retString= GC.sendMessage(jout.toString(), true);
		changes.firePropertyChange("ModelEvent", null, retString);

	}

	@Override
	public void endGame() {
		JSONObject jout=new JSONObject();
		jout.put("type", "Stop-Game");
		jout.put("ID", id);
		 GC.sendMessage(jout.toString(), false);
		
	}
	public void	addPropertyChangeListener(java.beans.PropertyChangeListener propertyChangeListener) 
	{
		changes.addPropertyChangeListener(propertyChangeListener);
	
	}
	
	
}
