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
	JLabel label = new JLabel();
	JLabel label2 = new JLabel("lives: 10");
	JButton yes = new JButton();
	JButton no = new JButton();
	int lives = 10;
	String u = "";
	

	public static void main(String[] args) {
		HangMan lcc = new HangMan();
		lcc.hangman();
	}

	public void hangman() {

		String v = JOptionPane
				.showInputDialog("How many words would you like to guess? Enter a number between 1 and 267.");
		int x = Integer.parseInt(v);
		frame.add(panel);
		panel.add(label);
		panel.add(label2);
		frame.addKeyListener(this);
		frame.setVisible(true);
		frame.setLocation(500, 600);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		for (int i = 0; i < x; i++) {
			String h = Utilities.readRandomLineFromFile("dictionary.txt");

			if (!words.contains(h)) {

				words.push(h);

			}

		}
		int y = 0;
		u = words.pop();
		y = u.length();

		String q = "";
		for (int i = 0; i < y; i++) {
			q += "_ ";
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
		char character = e.getKeyChar();
		String i = label.getText();
		String newLabel = "";
		boolean hasMatch = false;
		for (int j = 0; j < u.length(); j++) {
			if (character == u.charAt(j)) {
				newLabel = i.substring(0, j * 2);
				newLabel += u.charAt(j);
				newLabel += i.substring(j * 2 + 1, i.length());
				hasMatch = true;

			}

		}
	
		if (hasMatch == false) {
			label2.setText("lives: " + lives--);
		}
		label.setText(newLabel);
	
		if (!label.getText().contains("_")) {
			int y = 0;
			u = words.pop();

			y = u.length();

			String q = "";
			for (int o = 0; o < y; o++) {
				q += "_ ";
				label.setText(q);
				char m = e.getKeyChar();
				String a = label.getText();
				String p = "";
				boolean hasMatch1 = false;
				for (int j = 0; j < u.length(); j++) {
					if (character == u.charAt(j)) {
						p = a.substring(0, j * 2);
						p += u.charAt(j);
						p += a.substring(j * 2 + 1, i.length());
						hasMatch1 = true;

					}

				}
				if (hasMatch1 == false) {
					label2.setText("lives: " + lives--);
				}
				label.setText(p);
			}

		}

		
	System.out.println(lives);
	if (lives == 0) {
		JOptionPane.showMessageDialog(null, "Game over, you are ok.");
		panel.add(yes);
		panel.add(no);
		yes.addActionListener(this);
	}
	}
	

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == yes) {
			hangman();
		} else if (e.getSource() == no) {
			System.exit(JFrame.EXIT_ON_CLOSE);
		}
	}
	}
	

	
