package _03_IntroToStacks;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import _01_IntroToArrayLists._05_LongChipCompetition;

public class _02_TextUndoRedo implements KeyListener {
	/* 
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character is erased from the JLabel.
	 * Save that deleted character onto a Stack of Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed, the top Character is popped 
	 * off the Stack and added back to the JLabel.
	 * 
	 * */
	JFrame frame=new JFrame();
	JPanel panel=new JPanel();
	JLabel label=new JLabel();
	Stack<Character> y=new Stack<Character>();
	
	public static void main(String[] args) {
		_02_TextUndoRedo lcc = new _02_TextUndoRedo();
		lcc.work();
	}
	public void work() {
		frame.add(panel);
		panel.add(label);
		frame.addKeyListener(this);
		frame.setVisible(true);
		frame.setLocation(800, 300);
		panel.setPreferredSize(new Dimension(600, 600));
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		
		if(e.getKeyChar()==KeyEvent.VK_BACK_SPACE) {
			y.push(i.charAt(i.length()-1));
			System.out.println(i.charAt(i.length()-1));
			label.setText(i.substring(0, i.length()-1));
		}
		
			
		else if(e.getKeyChar()==KeyEvent.VK_1) {
			
				char q=y.pop();
				label.setText(i+q);
				System.out.println(q);
			
			
			
		}
		else {
			label.setText(i+character);
		}
		frame.pack();
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
