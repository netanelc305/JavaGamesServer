package com.hit.util;

import java.beans.PropertyChangeSupport;
import java.io.PrintWriter;
import java.util.Scanner;

public class CLI
extends java.lang.Object
implements java.lang.Runnable
{
	
	PropertyChangeSupport changes=new PropertyChangeSupport(this);
	private Scanner inPut;
	private PrintWriter outPut;
	
	private String value=null;
	public CLI(java.io.InputStream in, java.io.OutputStream out) 
	{
		inPut= new Scanner(in);
		outPut=new PrintWriter(out);

	}

	public	void	addPropertyChangeListener(java.beans.PropertyChangeListener pcl) 
	{

		changes.addPropertyChangeListener(pcl);

	}
	public	void	removePropertyChangeListener(java.beans.PropertyChangeListener pcl) 
	{
		changes.removePropertyChangeListener(pcl);
		
	}
	@Override
	public	void	run() 
	{
		String clientInput = null;
		

		
		while(true)
		{
			writeResponse("please enter your command (START/SHUTDWON/GAME_SERVER_CONFIG <capacity>)");
			clientInput=inPut.nextLine().toLowerCase();
			if(clientInput.equals("start"))
			{
				writeResponse("starting server...");
				setValue("CLIcommand",clientInput);

			}
			else if(clientInput.equals("shutdown"))
			{
				writeResponse("server shutting down...");
				setValue("CLIcommand",clientInput);
			}
			else if(clientInput.contains("game_server_config"))
			{
				String[] temp=clientInput.split(" ");
				if(temp.length!=2)
				{
					writeResponse("not a valid command");
					
				}
				else
				{

	
				writeResponse("server will shutdown in order to change the settings. pelase start again");
				setValue("CLIcommand","shutdown");
				setValue(temp[0],temp[1]);
				}
				
				
				
			}
			else
				writeResponse("not a valid command");

		}
		
		
		
		
	} 
	public void	writeResponse(java.lang.String response) 
	{
		outPut.println(response);
		outPut.flush();
		
	}


	
	
	
	public String getValue() {
		return this.value;
	}




	public void setValue(String command,String value) {
		this.value = value;
		
		if(command.equals("game_server_config"))
		{
			this.changes.firePropertyChange( "game_server_config",null, value);
			
			
		}
		else
		{
		this.changes.firePropertyChange( "CLIcommand",null, value);
		}
	}
	

}
