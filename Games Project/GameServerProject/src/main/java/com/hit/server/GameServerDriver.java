package com.hit.server;

import com.hit.util.CLI;

public class GameServerDriver
extends java.lang.Object
{
	
	public static void	main(java.lang.String[] args) 
	{
		CLI cli = new CLI(System.in, System.out);
		
		Server server = new Server(34567);
		cli.addPropertyChangeListener(server);
		
		new Thread(cli).start();
		
		
		
	}
	
	
	
}