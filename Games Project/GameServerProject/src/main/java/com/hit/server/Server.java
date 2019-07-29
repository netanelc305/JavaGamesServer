package com.hit.server;

import java.beans.PropertyChangeEvent;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.hit.services.GameServerController;

public class Server
extends java.lang.Object
implements java.beans.PropertyChangeListener, java.lang.Runnable
{
	private int numOfSockets=5;// default number of games
	private ServerSocket server;
	private Executor executor;
	private int port;
	private boolean power;
	GameServerController controller;
	
	

	Server(int port) 
	{
		this.port=port;
		executor=null;
		power=false;

	
		
		
	}
	
	@Override
	public void run() {

		try
		{
		
			
			controller=new GameServerController(numOfSockets);
		server = new ServerSocket(this.port);
		executor = Executors.newFixedThreadPool(this.numOfSockets);	
			while(power)
			{
			
				Socket socket = server.accept();
				executor.execute(new HandleRequest(socket, controller));

			}
		}
		catch(SocketException e) { }
		catch (IOException e) {
		e.printStackTrace();
		}
		finally {
			try {
			if(server != null)
				server.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
			
			
	}


	@Override
	public void propertyChange(PropertyChangeEvent evt)
	{

		String action = evt.getPropertyName();
		if (action.equals("CLIcommand")) 
		{
			action = (String) evt.getNewValue();
			switch (action) {
			case "start":
				if (!power) {
					power = true;
					System.out.println("server ON");
					new Thread(this).start();
					
					break;
				} else {
					System.out.println("server allready ON");
					break;
				}

			case "shutdown":
				if (!power)
				{
					System.out.println("server allready off");
					break;
				} else {

					try {
						power = false;
						server.close();
						System.out.println("server closed");
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				}

			}
			
			

		

		}
		else if(action.equals("game_server_config"))
		{
			
			numOfSockets= Integer.parseInt((String) evt.getNewValue());
		}
	}
	
	
	
	
	

}
