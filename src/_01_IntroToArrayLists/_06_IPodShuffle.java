package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//Copyright The League of Amazing Programmers, 2015

public class _06_IPodShuffle implements ActionListener {
	ArrayList<Song> songs = new ArrayList<Song>();
	Random ran = new Random();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button = new JButton("Surprise Me!");
	JButton button1 = new JButton("Stop");
	int songPlaying=99;

	public _06_IPodShuffle() {
		// 1. Use the Song class the play the demo.mp3 file.

		frame.add(panel);
		panel.add(button);
		panel.add(button1);
		frame.setVisible(true);
		frame.pack();
		button.addActionListener(this);
		button1.addActionListener(this);

		songs.add(new Song("A.mp3"));
		songs.add(new Song("FB.mp3"));
		songs.add(new Song("SW.mp3"));

		/**
		 * 2. Congratulations on completing the sound check! * Now we want to make an
		 * iPod Shuffle that plays random music. * Create an ArrayList of Songs and a
		 * "Surprise Me!" button that will play a random song when it is clicked. * If
		 * you're really cool, you can stop all the songs, before playing a new one on
		 * subsequent button clicks.
		 */

	}

	public static void main(String[] args) {
		new _06_IPodShuffle();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==button1&&songPlaying!=99) {
			songs.get(songPlaying).stop();
		}
		songPlaying= ran.nextInt(3);

			songs.get(songPlaying).play();
		
	}
}