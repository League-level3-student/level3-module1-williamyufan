package _04_HangMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan implements KeyListener {
	Stack<String> words = new Stack<String>();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();

	public static void main(String[] args) {
		HangMan lcc = new HangMan();
		lcc.hangman();
	}

	public void hangman() {

		JOptionPane.showInputDialog("How many words would you like to guess? Enter a number between 1 and 267.");
		frame.add(panel);
		panel.add(label);
		label.addKeyListener(this);
		frame.setVisible(true);
		frame.setLocation(500, 600);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		for (int i = 0; i < words.size(); i++) {
			String h = Utilities.readRandomLineFromFile("dictionary.txt");

			if (!words.contains(h)) {

				words.push(h);

			}

		}
		String u = words.pop();
		int y = Integer.parseInt(u);
		y = u.length();

		String q="";
		for (int i = 0; i < y; i++) {
			q+="_ ";
			label.setText(q);
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		char character=e.getKeyChar();
		String i=label.getText();
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
