package com.hit.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class GamesClient
extends java.lang.Object {
	
	private int  port;
	private Socket socket;
	public GamesClient(int serverPort) 
	{
		this.port=serverPort;
		
	}
	public void	closeConnection()
	{
		try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void	connectToServer() {
		try {
			socket=new Socket("localhost",this.port);
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public java.lang.String	sendMessage(java.lang.String message, boolean hasResponse)
	{
		String retString = null;
		
		try {
			
			JSONObject jsonIn = null;
			JSONObject jsonOut = null;
			JSONParser parser = new JSONParser();

			jsonOut = (JSONObject) parser.parse(message);
			this.connectToServer();
			ObjectOutputStream writer = new ObjectOutputStream(socket.getOutputStream());getClass();
			ObjectInputStream reader = new ObjectInputStream(socket.getInputStream());
			
			writer.writeObject(jsonOut);
			writer.flush();
			

			if (hasResponse) {
				
				
				jsonIn = (JSONObject) reader.readObject();
	
				retString = jsonIn.toString();

				}
			writer.close();
			reader.close();

			this.closeConnection();
			




		
		
		}catch (IOException | ClassNotFoundException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			closeConnection();
			

		}
		return retString;

	}

}
