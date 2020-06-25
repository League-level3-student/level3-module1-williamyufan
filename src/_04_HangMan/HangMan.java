package _04_HangMan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan implements KeyListener, ActionListener {
	Stack<String> words = new Stack<String>();
	JFrame frame = new JFrame();

	JPanel panel = new JPanel();
	JPanel panel1 = new JPanel();
	JLabel label = new JLabel();
	JLabel label2 = new JLabel("lives: 10");

	JButton yes = new JButton("yes");
	JButton no = new JButton("no");
	int lives = 10;
	String chosenWord = "";

	public static void main(String[] args) {
		HangMan lcc = new HangMan();
		lcc.hangman();
	}

	public void hangman() {

		
		frame.add(panel);

		panel.add(label);
		panel.add(label2);
		panel1.add(yes);
		panel1.add(no);
		frame.addKeyListener(this);
		frame.setVisible(true);
		frame.setLocation(500, 600);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	start();
		
		
		reset();
		frame.pack();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	
	void start()
	{
		words=new Stack<String>();
	
		String v = JOptionPane
				.showInputDialog("How many words would you like to guess? Enter a number between 1 and 267.");
		int x = Integer.parseInt(v);
		
		for (int i = 0; i < x; i++) {
			String h = Utilities.readRandomLineFromFile("dictionary.txt");

			if (!words.contains(h)) {

				words.push(h);

			}

		}
		chosenWord = words.pop();
	}

	void reset() {
		System.out.println(chosenWord);
		lives = 10;
		String q = "";
		for (int i = 0; i < chosenWord.length(); i++) {
			q += "_ ";
			label.setText(q);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		char character = e.getKeyChar();
		String displayText = label.getText();
		String newLabel = "";
		boolean hasMatch = false;
		for (int j = 0; j < chosenWord.length(); j++) {

			if (character == chosenWord.charAt(j)) {
				System.out.println(character);
				newLabel = displayText.substring(0, j * 2);
				newLabel += chosenWord.charAt(j);
				newLabel += displayText.substring(j * 2 + 1, displayText.length());
				displayText = newLabel;
				hasMatch = true;
			}
		}

		if (hasMatch == false) {
			label2.setText("lives: " + --lives);
		} else {
			label.setText(newLabel);
		}

		if (lives == 0) {

			JOptionPane.showMessageDialog(null, "Game over, you are ok.");

			frame.remove(panel);
			frame.add(panel1);
			yes.addActionListener(this);
			no.addActionListener(this);

		}

		if (!label.getText().contains("_")) {
			if (!words.empty()) {
				chosenWord = words.pop();
				reset();

			}
		}

		frame.pack();

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == yes) {
			frame.remove(panel1);
			start();
			frame.add(panel);
			reset();
			frame.pack();

		} else if (e.getSource() == no) {
			System.exit(JFrame.EXIT_ON_CLOSE);
		}
	}
}
