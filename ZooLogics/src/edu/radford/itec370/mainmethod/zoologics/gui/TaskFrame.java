package edu.radford.itec370.mainmethod.zoologics.gui;

import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import edu.radford.itec370.mainmethod.zoologics.Application;
import edu.radford.itec370.mainmethod.zoologics.Task;

public class TaskFrame extends JFrame implements Navigable {

	private static final long serialVersionUID = 6640903267745319370L;

	protected ArrayList<Task> tasks;
	protected int currentIndex;
	
	private TaskFrame () {
		setIconImage(Application.getAppImage());
		setTitle("Task");
		setBounds(100, 100, 481, 341);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		NavigatorBar naviBar = new NavigatorBar(this);
		naviBar.setNewButtonVisible(false);
		naviBar.setSearchBoxVisible(false);
		getContentPane().add(naviBar, BorderLayout.SOUTH);
		this.addWindowListener(new MyWindowListener());

	}
	
	public TaskFrame(ArrayList<Task> tasks) {
		super();
		this.tasks = tasks;
	}
	
	public static void main(String[] args) {
		ArrayList<Task> tasks = new ArrayList<Task>();
		TaskFrame frame = new TaskFrame();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		dispose();
	}
	
	@Override
	public void firstRecord() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void previousRecord() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void nextRecord() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void lastRecord() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void newRecord() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void applyFilter(String filter) {
		// TODO Auto-generated method stub
		
	}

	class MyWindowListener implements WindowListener {
		@Override
		public void windowClosing(WindowEvent e) {
			closeWindow();
		}
		@Override public void windowActivated(WindowEvent e) {}
		@Override public void windowClosed(WindowEvent e) {}
		@Override public void windowDeactivated(WindowEvent e) {}
		@Override public void windowDeiconified(WindowEvent e) {}
		@Override public void windowIconified(WindowEvent e) {}
		@Override public void windowOpened(WindowEvent e) {}
	}

	
}
