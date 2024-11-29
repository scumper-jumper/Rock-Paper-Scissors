package rockPaperScissor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUIClass extends JFrame implements ActionListener{
	JButton rockButton,paperButton,scissorsButton;
	JLabel computerChoice;
	JLabel computerScoreLabel,playerScoreLabel;
	BackendClass BackendClass;
	
	public GUIClass() {
		super("Rock Paper Scissor");
		setSize(450,574);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		BackendClass = new BackendClass();
		addGuiComponents();
	}
	private void addGuiComponents() {
		computerScoreLabel = new JLabel("Computer: 0");
		computerScoreLabel.setBounds(0,43,450,30);
		computerScoreLabel.setFont(new Font("Dialog", Font.BOLD,26));
		computerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(computerScoreLabel);
		computerChoice = new JLabel("?");
		computerChoice.setBounds(175,118,98,81);
		computerChoice.setFont(new Font("Dialog", Font.PLAIN, 18));
		computerChoice.setHorizontalAlignment(SwingConstants.CENTER);
		computerChoice.setBorder(BorderFactory.createLineBorder(Color.black));
		add(computerChoice);
		playerScoreLabel = new JLabel("Player: 0");
		playerScoreLabel.setBounds(0,317,450,30);
		playerScoreLabel.setFont(new Font("Dialog",Font.BOLD,26));
		playerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(playerScoreLabel);
		rockButton = new JButton("Rock");
		rockButton.setBounds(40,387,105,81);
		rockButton.setFont(new Font("Dialog", Font.PLAIN, 18));
		rockButton.addActionListener(this);
		add(rockButton);
		paperButton = new JButton("Paper");
		paperButton.setBounds(165,387,105,81);
		paperButton.setFont(new Font("Dialog", Font.PLAIN, 18));
		paperButton.addActionListener(this);
		add(paperButton);
		scissorsButton = new JButton("Scissors");
		scissorsButton.setBounds(290,387,105,81);
		scissorsButton.setFont(new Font("Dialog", Font.PLAIN, 18));
		scissorsButton.addActionListener(this);
		add(scissorsButton);
	
	}
	
	private void showDialog(String message) {
		JDialog resultDialog = new JDialog(this,"Result",true);
		resultDialog.setSize(227,124);
		resultDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		resultDialog.setResizable(false);
		JLabel resultLabel = new JLabel(message);
		resultLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
		resultDialog.add(resultLabel, BorderLayout.CENTER);
		JButton tryAgainButton = new JButton("Try Again?");
		tryAgainButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				computerChoice.setText("?");
				resultDialog.dispose();
			}
			
		});
		resultDialog.add(tryAgainButton, BorderLayout.SOUTH);
		resultDialog.setLocationRelativeTo(this);
		resultDialog.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String playerChoice = e.getActionCommand().toString();
		String result = BackendClass.playRockPaperScissor(playerChoice);
		computerChoice.setText(BackendClass.getComputerChoice());
		computerScoreLabel.setText("Computer: "+BackendClass.getComputerChoice());
		playerScoreLabel.setText("Player: "+BackendClass.getPlayerScore());
		showDialog(result);
	}
}
