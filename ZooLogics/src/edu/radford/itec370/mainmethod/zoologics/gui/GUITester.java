package edu.radford.itec370.mainmethod.zoologics.gui;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUITester {
	
	public static void launchTestFrame(JPanel panel) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Tester Frame");
		frame.setLayout(new GridLayout(1,1));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setVisible(true);
		frame.pack();
	}
}
