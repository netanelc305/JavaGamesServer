package com.hit.view;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeSupport;

 public class GamesView
        extends java.lang.Object
        implements View,ActionListener
{
	 
	 private boolean gameInProgress=false;
	private PropertyChangeSupport changes;
	 


	//buttons and radio buttons declarations
	private JButton startJB =new JButton();
	private JButton endgameJB =new JButton();
	private  JRadioButton catchTheBunny = new JRadioButton("Catch The Bunny");
	private JRadioButton ticTacTow = new JRadioButton("Tic Tac Toe");
	private JRadioButton randomJR = new JRadioButton("Random");
	private  JRadioButton smartJR = new JRadioButton("Smart");
	private JButton computerStarts=new JButton();
	private  JButton [][] tictacArray;
	private  JButton [][] catchtheArray;
	
	//labels and panels
	private JLabel errorLog = new JLabel("");
	private JPanel tictacJP=new JPanel(new GridLayout(3, 3));
	private  JPanel catchtheJP=new JPanel(new GridLayout(9, 9));
	private JPanel gameButtonsJP=new JPanel();
	
	
	//pics for catch the bunny
	private ImageIcon bunnyPic= new ImageIcon("images/BunnyPicsmall.jpg");
	private ImageIcon grassPic= new ImageIcon("images/grasspicsmall.jpg");
	private ImageIcon kidPic= new ImageIcon("images/kidPicture.jpg");
	//pic for tic tac toe
	private ImageIcon xLatter= new ImageIcon("images/Xlatter.jpg");
	private ImageIcon oLatter= new ImageIcon("images/Olatter.jpg");
	private ImageIcon blank= new ImageIcon("images/blank.jpg");
	
	//buttons icons
	private ImageIcon startP= new ImageIcon("images/start.jpg");
	private ImageIcon computerstartsP= new ImageIcon("images/computerstarts.jpg");
	private ImageIcon endgameP= new ImageIcon("images/endgame.jpg");
	//log pics
	private ImageIcon blankLog= new ImageIcon("images/blankLog.jpg");
	private ImageIcon illegalLog= new ImageIcon("images/illegalLog.jpg");
	private ImageIcon lostLog= new ImageIcon("images/lostLog.jpg");
	private ImageIcon catchMovesLog= new ImageIcon("images/movesLog.jpg");
	private ImageIcon progressLog= new ImageIcon("images/progressLog.jpg");
	private ImageIcon tieLog= new ImageIcon("images/tieLog.jpg");
	private ImageIcon wonLog= new ImageIcon("images/wonLog.jpg");
	private ImageIcon fullServer= new ImageIcon("images/serverFull.jpg");
	private ImageIcon newGameLog= new ImageIcon("images/newGame.jpg");
	

     //used inside the "actionPreformed"
	private String gametype="";
	private String opponent="";
    
    public GamesView()
    {
    	changes=new PropertyChangeSupport(this);

    }
    @Override
    public void	start()
    {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
    }

    public void	addPropertyChangeListener(java.beans.PropertyChangeListener propertyChangeListener)
    {
        changes.addPropertyChangeListener(propertyChangeListener);

    }
    protected void createAndShowGUI() {
    
    	///main frame build
        JFrame mainFrame=new JFrame("Games Algorithms by Ben Ouahba & Netanel Cohen");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         mainFrame.setSize(1800,900);
         mainFrame.setResizable(true);
         mainFrame.setLayout(new BorderLayout());
         mainFrame.setContentPane(new JLabel(new ImageIcon("images/mainframe.jpg")));
         mainFrame.getContentPane().setLayout(  new BoxLayout(mainFrame.getContentPane(), BoxLayout.PAGE_AXIS));
         mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); //sets mainframe to full screen with exit option
     
         mainFrame.addWindowListener(new WindowAdapter() {

             @Override
             public void windowClosing(WindowEvent e) {
            	 endgameJB.doClick();
           
             }
           });
          
         
         ///managing the games boards

		tictacArray = new JButton[3][3];
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				tictacArray[row][col] = new JButton();
				tictacArray[row][col].setMaximumSize(new Dimension(200,200));
				tictacArray[row][col].setIcon(blank);
				tictacArray[row][col].addActionListener(this);
				tictacArray[row][col].setActionCommand("updateplayermove" + "_" + row + "_" + col);
				tictacJP.add(tictacArray[row][col]);

				
			}
		} // bunnyPic grassPic
		
		catchtheArray = new JButton[9][9];
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				catchtheArray[row][col] = new JButton();
				catchtheArray[row][col].setMaximumSize(new Dimension(66,66));
				catchtheArray[row][col].setIcon(grassPic);
				catchtheArray[row][col].addActionListener(this);
				catchtheArray[row][col].setActionCommand("updateplayermove" + "_" + row + "_" + col);
				catchtheJP.add(catchtheArray[row][col]);
			}
		}
         

		

		endgameJB.setMaximumSize(new Dimension(150, 30));
		endgameJB.setIcon(endgameP);
		endgameJB.setEnabled(false);
		

		computerStarts.setMaximumSize(new Dimension(150, 30));
		computerStarts.setIcon(computerstartsP);
		computerStarts.setEnabled(false);

		startJB.setPreferredSize(new Dimension(150, 50));
		startJB.setEnabled(false);
		startJB.setIcon(startP);

         ticTacTow.setSelected(true);
         ticTacTow.doClick();
         errorLog.setIcon(blankLog);
         
        /////////setActionCommand//////
         endgameJB.setActionCommand("endgame");
         startJB.setActionCommand("newgame");
         catchTheBunny.setActionCommand("Catch The Bunny");
         ticTacTow.setActionCommand("Tic Tac Toe");
         randomJR.setActionCommand("Random");
         smartJR.setActionCommand("Smart");
         computerStarts.setActionCommand("startgame");
         
         ///action listeners
 		endgameJB.addActionListener(this);
         computerStarts.addActionListener(this);
         startJB.addActionListener(this);
         catchTheBunny.addActionListener(this);
         ticTacTow.addActionListener(this);
         smartJR.addActionListener(this);
         randomJR.addActionListener(this);
   
         ////////////////radio buttons group
         ButtonGroup gameType = new ButtonGroup();
         gameType.add(catchTheBunny);
         gameType.add(ticTacTow);
         ButtonGroup opponent = new ButtonGroup();
         opponent.add(smartJR);
         opponent.add(randomJR);

		/////////////// panels
		JPanel textPanel = new JPanel();
		textPanel.setLayout(new FlowLayout());
		textPanel.setMaximumSize(new Dimension(600, 200));
		textPanel.add(errorLog);

		JPanel typeP = new JPanel();
		typeP.setLayout(new BoxLayout(typeP, BoxLayout.PAGE_AXIS));
		typeP.add(ticTacTow);
		typeP.add(catchTheBunny);

		JPanel oponnentP = new JPanel();
		oponnentP.setLayout(new BoxLayout(oponnentP, BoxLayout.PAGE_AXIS));
		oponnentP.add(smartJR);
		oponnentP.add(randomJR);

		JPanel buttonP = new JPanel();
		buttonP.add(startJB);

		JPanel compStarJP = new JPanel();
		compStarJP.setLayout(new BoxLayout(compStarJP, BoxLayout.PAGE_AXIS));

		compStarJP.add(computerStarts);
		compStarJP.add(endgameJB);

		tictacJP.setVisible(true);
		tictacJP.setMaximumSize(new Dimension(600, 600));
		catchtheJP.setVisible(false);
		catchtheJP.setMaximumSize(new Dimension(600, 600));

		gameButtonsJP.setLayout(new CardLayout());
		gameButtonsJP.setMaximumSize(new Dimension(600, 600));
		gameButtonsJP.add(tictacJP);
		gameButtonsJP.add(catchtheJP);

		JPanel allbuttonsJP = new JPanel();
		allbuttonsJP.setLayout(new FlowLayout());
		allbuttonsJP.setMaximumSize(new Dimension(600, 70));

		// so you could see my pretty background
		typeP.setOpaque(false);
		oponnentP.setOpaque(false);
		compStarJP.setOpaque(false);
		buttonP.setOpaque(false);
		smartJR.setOpaque(false);
		randomJR.setOpaque(false);
		catchTheBunny.setOpaque(false);
		ticTacTow.setOpaque(false);
		allbuttonsJP.setOpaque(false);

		allbuttonsJP.add(typeP);
		allbuttonsJP.add(oponnentP);
		allbuttonsJP.add(compStarJP);
		allbuttonsJP.add(buttonP);

		// adds everything to the mainframe
		mainFrame.add(allbuttonsJP);
		mainFrame.add(gameButtonsJP);
		mainFrame.add(textPanel);
		mainFrame.pack();
		mainFrame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if ("newgame".equals(event.getActionCommand())) 
		{
			if ((!gametype.isEmpty()) && (!opponent.isEmpty())) {
				endgameJB.doClick();

				

				
				endgameJB.setEnabled(true);
				gameInProgress = true;
				computerStarts.setEnabled(true);
				String mainString = "newgame" + "_" + gametype + "_" + opponent;
				catchTheBunny.setEnabled(false);
				ticTacTow.setEnabled(false);
				randomJR.setEnabled(false);
				smartJR.setEnabled(false);
				changes.firePropertyChange("View Event", null, mainString);
			}

		} else if ("startgame".equals(event.getActionCommand())) {
			computerStarts.setEnabled(false);
			changes.firePropertyChange("View Event", null, event.getActionCommand());

		} else if ("Tic Tac Toe".equals(event.getActionCommand())) {

			gametype = event.getActionCommand();
			catchtheJP.setVisible(false);
			tictacJP.setVisible(true);
			errorLog.setIcon(blankLog);

		} else if ("Catch The Bunny".equals(event.getActionCommand())) {
			gametype = event.getActionCommand();
			tictacJP.setVisible(false);
			catchtheJP.setVisible(true);
			errorLog.setIcon(catchMovesLog);

		} else if ("Smart".equals(event.getActionCommand()) || "Random".equals(event.getActionCommand())) {
			opponent = event.getActionCommand();

		} else if (event.getActionCommand().contains("updateplayermove")) {

			if (gameInProgress) {
				computerStarts.setEnabled(false);
				changes.firePropertyChange("View Event", null, event.getActionCommand());
			}
		} else if ("endgame".equals(event.getActionCommand())) {
			wipeBoards();
			endgameJB.setEnabled(false);
			computerStarts.setEnabled(false);
			gameInProgress = false;
			catchTheBunny.setEnabled(true);
			ticTacTow.setEnabled(true);
			randomJR.setEnabled(true);
			smartJR.setEnabled(true);
			
			changes.firePropertyChange("View Event", null, event.getActionCommand());

		}

		if ((!gametype.isEmpty()) && (!opponent.isEmpty())) {

			startJB.setEnabled(true);
		}

	}
	private void wipeBoards()
	{
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				tictacArray[row][col].setIcon(blank);
	
			}
		}

		
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				catchtheArray[row][col].setIcon(grassPic);
			}
		}
		
		
	}

	@Override
	public void updateViewGameMove(int gameState, java.lang.Character[] board) {
		if (gameState == 0) {
			errorLog.setIcon(illegalLog);
		}

		else if (gameState == 1) {
			errorLog.setIcon(wonLog);
			endgameJB.doClick();

		} else if (gameState == 2) {
			errorLog.setIcon(lostLog);
			endgameJB.doClick();

		} else if (gameState == 3) {

			errorLog.setIcon(tieLog);
			endgameJB.doClick();
		} else if (gameState == 4) {

			errorLog.setIcon(progressLog);
		}
		else if(gameState==-1)
		{

			errorLog.setIcon(fullServer);
			computerStarts.setEnabled(false);
			
			endgameJB.setEnabled(false);
			catchTheBunny.setEnabled(true);
			ticTacTow.setEnabled(true);
			randomJR.setEnabled(true);
			smartJR.setEnabled(true);

			
			
		}
		if (gameState >0) {
			int loc = 0;
			if (board.length == 3 * 3)// tic tac toe
			{
				for (int row = 0; row < 3; row++)
					for (int col = 0; col < 3; col++) {
						if (String.valueOf(board[loc]).equals("-")) {
							tictacArray[row][col].setIcon(blank);

						} else if (String.valueOf(board[loc]).equals("o")) {
							tictacArray[row][col].setIcon(oLatter);
						} else if (String.valueOf(board[loc]).equals("x")) {
							tictacArray[row][col].setIcon(xLatter);

						}
						loc++;
					}
			} else// catch the bunny
			{
				for (int row = 0; row < 9; row++)
					for (int col = 0; col < 9; col++) {
						if (String.valueOf(board[loc]).equals("-")) {
							catchtheArray[row][col].setIcon(grassPic);

						} else if (String.valueOf(board[loc]).equals("B")) {
							catchtheArray[row][col].setIcon(bunnyPic);
						} else if (String.valueOf(board[loc]).equals("K")) {
							catchtheArray[row][col].setIcon(kidPic);

						}
						loc++;
					}
			}
			Dimension dm=computerStarts.getSize();
	
		}
	}

	@Override
	public void updateViewNewGame(java.lang.Character[] board) {

		int loc = 0;

		if (board.length == 3 * 3) {

			for (int row = 0; row < 3; row++)
				for (int col = 0; col < 3; col++) {
					if (board[loc].equals('-')) {
						tictacArray[row][col].setIcon(blank);

					} else if (board[loc].equals('x')) {
						tictacArray[row][col].setIcon(xLatter);

					} else if (board[loc].equals('o')) {
						tictacArray[row][col].setIcon(oLatter);
					}
					loc++;
				}

		} else {

			for (int row = 0; row < 9; row++)
				for (int col = 0; col < 9; col++) {

					if (board[loc].equals('-')) {
						catchtheArray[row][col].setIcon(grassPic);

					} else if (board[loc].equals('K')) {
						catchtheArray[row][col].setIcon(kidPic);

					} else if (board[loc].equals('B')) {

						catchtheArray[row][col].setIcon(bunnyPic);
					}
					loc++;

				}

		}
		errorLog.setIcon(newGameLog);

	}

}
