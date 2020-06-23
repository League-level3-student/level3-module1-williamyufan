package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
	/*
	 * Crate a HashMap of Integers for the keys and Strings for the values.
	 *
	 * Create a GUI with three buttons. Button 1: Add Entry When this button is
	 * clicked, use an input dialog to ask the user to enter an ID number. After an
	 * ID is entered, use another input dialog to ask the user to enter a name. Add
	 * this information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID When this button is clicked, use an input dialog to
	 * ask the user to enter an ID number. If that ID exists, display that name to
	 * the user. Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List When this button is clicked, display the entire list in a
	 * message dialog in the following format: ID: 123 Name: Harry Howard ID: 245
	 * Name: Polly Powers ID: 433 Name: Oliver Ortega etc...
	 * 
	 * When this is complete, add a fourth button to your window. Button 4: Remove
	 * Entry When this button is clicked, prompt the user to enter an ID using an
	 * input dialog. If this ID exists in the HashMap, remove it. Otherwise, notify
	 * the user that the ID is not in the list.
	 *
	 */

	HashMap<Integer, String> logsearch = new HashMap<Integer, String>();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton addEntry = new JButton("Add Entry");
	JButton searchUsingID = new JButton("Search Using ID");
	JButton viewList = new JButton("View List (admin only)");
	JButton removeID = new JButton("Remove ID");

	public static void main(String[] args) {
		_02_LogSearch lcc = new _02_LogSearch();
		lcc.runner();
	}

	public void runner() {

		frame.add(panel);
		panel.add(addEntry);
		panel.add(searchUsingID);
		panel.add(viewList);
		panel.add(removeID);
		addEntry.addActionListener(this);
		searchUsingID.addActionListener(this);
		viewList.addActionListener(this);
		removeID.addActionListener(this);
		frame.setVisible(true);
		frame.setLocation(500, 600);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String Name = "";
		int q = 0;
		if (e.getSource() == addEntry) {
			String IDNumber = "";
			IDNumber = JOptionPane.showInputDialog("Enter a ID number. Just numbers, please!");
			q = Integer.parseInt(IDNumber);
			Name = JOptionPane.showInputDialog("Enter your name please.");
			logsearch.put(q, Name);

		} else if (e.getSource() == searchUsingID) {
			String id = "";
			id = JOptionPane.showInputDialog("Enter your ID number to search for your name.");
			int w = Integer.parseInt(id);
			for (int i = 0; i < logsearch.size(); i++) {
				if (q == w) {
					JOptionPane.showMessageDialog(null, "Your name is: " + logsearch.get(q));
				} else {
					JOptionPane.showMessageDialog(null, "You do not have a entry.");
				}

			}

		} else if (e.getSource() == viewList) {
			String password = "";
			String actualPassWord = "givemelist";
			password = JOptionPane.showInputDialog("Enter the password please.");
			if (actualPassWord == password) {

				for (int i = 0; i < logsearch.size(); i++) {

					JOptionPane.showMessageDialog(null, "ID: " + q + "Name: " + logsearch.get(q) + "\n");
				}
			}

		} else if (e.getSource() == removeID) {
			String things="";
			int s=0;
			things=JOptionPane.showInputDialog("Enter your ID to remove.");
			s=Integer.parseInt(things);
			for (int i = 0; i < logsearch.size(); i++) {
				if(s==q) {
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Your ID does not exist.");
				}
			}

		}

	}
}
