import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class RPG {
	
	JFrame window;
	Container con;
	JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
	JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 70);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
	JButton startButton, choice1, choice2, choice3, choice4;
	JTextArea mainTextArea;
	int playerHP, gaylordHP, goldRing;
	String weapon, position;
	
	TitleScreenHandler tsHandler = new TitleScreenHandler();
	ChoiceHandler choiceHandler = new ChoiceHandler();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new RPG();
		
	}
	
	public  RPG() {
		
		window = new JFrame();
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		window.setVisible(true);;
		con = window.getContentPane();
		
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(100, 100, 600, 150);
		titleNamePanel.setBackground(Color.black);
		titleNameLabel = new JLabel("Paradise!!");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);
		
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(300, 400, 200, 100);
		startButtonPanel.setBackground(Color.black);
		
		startButton = new JButton("Start Quest");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(normalFont);
		startButton.addActionListener(tsHandler);
		startButton.setFocusPainted(false);
		
		titleNamePanel.add(titleNameLabel);
		startButtonPanel.add(startButton);
		
		con.add(titleNamePanel);
		con.add(startButtonPanel);
	}
	
	public void createRPGGameScreen(){
		
		titleNamePanel.setVisible(false);
		startButtonPanel.setVisible(false);
		
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(100, 100, 600, 250);
		mainTextPanel.setBackground(Color.black);
		con.add(mainTextPanel);
		
		mainTextArea = new JTextArea("This is the main text area! This is gonna be baller asf!! PLAY NOW!!!");
		mainTextArea.setBounds(100, 100, 600, 250);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextPanel.add(mainTextArea);
		
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(250, 350, 300, 150);
		choiceButtonPanel.setBackground(Color.white);
		choiceButtonPanel.setLayout(new GridLayout(4, 1));
		con.add(choiceButtonPanel);
		
		choice1 = new JButton("Choice 1");
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.white);
		choice1.setFont(normalFont);
		choice1.setFocusPainted(false);
		choice1.addActionListener(choiceHandler);
		choice1.setActionCommand("c1");
		choiceButtonPanel.add(choice1);
		choice2 = new JButton("Choice 2");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.white);
		choice2.setFont(normalFont);
		choice2.setFocusPainted(false);
		choice2.addActionListener(choiceHandler);
		choice2.setActionCommand("c2");
		choiceButtonPanel.add(choice2);
		choice3 = new JButton("Choice 3");
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.white);
		choice3.setFont(normalFont);
		choice3.setFocusPainted(false);
		choice3.addActionListener(choiceHandler);
		choice3.setActionCommand("c3");
		choiceButtonPanel.add(choice3);
		choice4 = new JButton("Choice 4");
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.white);
		choice4.setFont(normalFont);
		choice4.setFocusPainted(false);
		choice4.addActionListener(choiceHandler); 
		choice4.setActionCommand("c4");
		choiceButtonPanel.add(choice4);
		
		playerPanel = new JPanel();
		playerPanel.setBounds(100, 15, 600, 50);
		playerPanel.setBackground(Color.black);
		playerPanel.setLayout(new GridLayout(1,4));
		con.add(playerPanel);
		hpLabel = new JLabel("HP: ");
		hpLabel.setFont(normalFont);
		hpLabel.setForeground(Color.white);
		playerPanel.add(hpLabel);
		hpLabelNumber = new JLabel();
		hpLabelNumber.setFont(normalFont);
		hpLabelNumber.setForeground(Color.white);
		playerPanel.add(hpLabelNumber);
		weaponLabel = new JLabel("Weapon: ");
		weaponLabel.setFont(normalFont);
		weaponLabel.setForeground(Color.white);
		playerPanel.add(weaponLabel);
		weaponLabelName = new JLabel();
		weaponLabelName.setForeground(Color.white);
		playerPanel.add(weaponLabelName);
		
		playerSetup();
	}
	public void playerSetup(){
		playerHP = 100;
		gaylordHP = 1000000;
		weapon = "Sword";
		weaponLabelName.setText(weapon);
		hpLabelNumber.setText("" + playerHP);
		
		townGate();
	}
	public void townGate(){
		position = "townGate";
		mainTextArea.setText("You are at the gate of the town! \nA guard is standing in your way. \n\nWhat would you wish to do?");
		
		choice1.setText("Talk to the guard");
		choice2.setText("Attack the guard");
		choice3.setText("Leave");
		choice4.setText("");
	}
	public void talkGuard(){
		position = "talkGuard";
		mainTextArea.setText("Guard: Hello stranger, I've never seen you around these vast lands! \nWho are you and what do you wish of this?");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void attackGuard(){
		position = "attackGuard";
		mainTextArea.setText("Hey Big BOI! Don't be stupid!!\n\n*The guard fights back with a big hit!*\n(You receive 10 damage)");
		playerHP = playerHP - 10;
		hpLabelNumber.setText(""+playerHP);
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void crossRoad(){
		position = "crossRoad";
		mainTextArea.setText("*You come across a Cross Road*\nIf you desire to go back to The Town, Go South!");
		choice1.setText("Go North");
		choice2.setText("Go South");
		choice3.setText("Go East");
		choice4.setText("Go West");
	}
	public void north(){
		position = "north";
		mainTextArea.setText("There is a river. \n*You drink the water and rest at the riverside.* \n(Your HP is recovered by 5)");
		playerHP = playerHP + 5;
		hpLabelNumber.setText(""+playerHP);
		choice1.setText("Go South");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void east(){
		position = "east";
		mainTextArea.setText("*You walk into a forest*\n*You look around and something shines and glistens in the distance*\n*You look closer and find a Katana!!*\n\n(You obtained a New Weapon)");
		weapon = "Katana";
		weaponLabelName.setText(weapon);
		choice1.setText("Go West");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void west(){
		position = "west";
		mainTextArea.setText("*You encounter a one of the Royal Gaylords!*");
		choice1.setText("Fight");
		choice2.setText("Run");
		choice3.setText("");
		choice4.setText("");
	}
	public void fight(){
		position = "fight";
		mainTextArea.setText("Royal Gaylord's HP: " + gaylordHP + "\nWhat are you gonna do!?");
		choice1.setText("SLAY");
		choice2.setText("Be a GAYLORD!");
	}
	public void playerAttack(){
		position = "playerAttack";
		
		int playerDamage = 0;
		
		if(weapon.equals("Sword")){
			playerDamage = new java.util.Random().nextInt(25000);
		}
		else if(weapon.equals("Katana")){
			playerDamage = new java.util.Random().nextInt(1000000);
		}
		
		mainTextArea.setText("*You attacked The Gaylord and gave " + playerDamage + " damage!*");
		
		gaylordHP = gaylordHP - playerDamage;
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
	}
	public void gaylordAttack(){
		position = "gaylordAttack";
		
		int gaylordDamage = 0;
		gaylordDamage = new java.util.Random().nextInt(20);
		
		mainTextArea.setText("*The Gaylord attacked you and gave " + gaylordDamage + " damage!*");
		
		playerHP = playerHP - gaylordDamage;
		hpLabelNumber.setText(""+playerHP);
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void win(){
		position = "win";
		
		mainTextArea.setText("You defeated the GAYLORD!!! \nCONGRATS YOU WON! \n\n(You obtained a Gold Ring.)");
		
		goldRing = 1;
		
		choice1.setText("Go East");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void lose(){
		position = "lose";
		
		mainTextArea.setText("You suck, you died!! \n\nStop playing this game, get out of my presence.");
		
		choice1.setText("");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice1.setVisible(false);
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
		
		
	}
	public void ending(){
		position = "ending";
		
		mainTextArea.setText("Guard: OH you killed the Almighty Gaylord!?\nThank you so much. You are a true hero!\nWelcome to Paradise!\n\n<THE END>");
		choice1.setText("");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	
	
	public class TitleScreenHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			
			createRPGGameScreen();
		}
	}
	public class ChoiceHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
		
			String yourChoice = event.getActionCommand();
			
			switch(position){
			case "townGate":
				switch(yourChoice){
				case "c1": 
					if(goldRing==1) {
						ending();
						
					}
					else talkGuard();
					break;
				case "c2": attackGuard(); break;
				case "c3": crossRoad(); break;
				}
				break;
			case "talkGuard":
				switch(yourChoice){
				case "c1": townGate(); break;
				}
				break;
			case "attackGuard":
				switch(yourChoice){
				case "c1": townGate(); break;
			}
			break;
		case "crossRoad":
			switch(yourChoice){
			case "c1": north(); break;
			case "c2": townGate(); break;
			case "c3": east(); break;
			case "c4": west(); break;
			}
			break;
		case "north":
			switch(yourChoice){
			case "c1": crossRoad(); break;
			}
			break;
		case "east":
			switch(yourChoice){
			case "c1": crossRoad(); break;
			}
			break;
		case "west":
			switch(yourChoice){
			case "c1": fight(); break;
			case "c2": crossRoad(); break;
			}
			break;
		case "fight":
			switch(yourChoice){
			case "c1": playerAttack(); break;
			case "c2": crossRoad();  break;
			}
			break;
		case "playerAttack":
			switch(yourChoice){
			case "c1": 
				if(gaylordHP<1){
					win();
				}
				else {
					gaylordAttack();
				}
				break;
			}
			break;
		case "gaylordAttack":
			switch(yourChoice){
			case "c1": 
				if(playerHP<1){
					lose();
				}
				else
					fight();
				
				break;
			}
			break;
		case "win":
			switch(yourChoice){
			case "c1": crossRoad(); break;
			}
			break;
			}
				
		}
		
		
	}
	
}
