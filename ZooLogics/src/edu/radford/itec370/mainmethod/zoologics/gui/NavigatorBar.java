package edu.radford.itec370.mainmethod.zoologics.gui;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.SwingConstants;

public class NavigatorBar extends JPanel {
	private static final long serialVersionUID = -7765321196155993760L;
	private Navigable parentGUI;
	private JTextField txtSearch;
	private JButton btnFirst;
	private JButton btnPrevious;
	private JButton btnNext;
	private JButton btnLast;
	private JButton btnNew;
	private JLabel lblDateTime;

	private NavigatorBar() {
		super();
		setLayout(new BorderLayout());

		FlowLayout leftFlowLayout = new FlowLayout(FlowLayout.LEFT);
		leftFlowLayout.setVgap(0);
		leftFlowLayout.setHgap(0);
		
		JPanel leftPanel = new JPanel(leftFlowLayout);
		
		btnFirst = new JButton("[<");
		btnFirst.setPreferredSize(new Dimension(45,20));
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				parentGUI.firstRecord();
			}
		});
		leftPanel.add(btnFirst);
		
		btnPrevious = new JButton("<");
		btnPrevious.setPreferredSize(new Dimension(45,20));
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				parentGUI.previousRecord();
			}
		});
		leftPanel.add(btnPrevious);
		
		txtSearch = new JTextField();
		leftPanel.add(txtSearch);
		//txtSearch.setColumns(10);
		txtSearch.setPreferredSize(new Dimension(100,20));
		txtSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parentGUI.applyFilter(txtSearch.getText());
			}
		});
		
		btnNext = new JButton(">");
		btnNext.setPreferredSize(new Dimension(45,20));
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parentGUI.nextRecord();
			}
		});
		leftPanel.add(btnNext);
		
		btnLast = new JButton(">]");
		btnLast.setPreferredSize(new Dimension(45,20));
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parentGUI.lastRecord();
			}
		});
		leftPanel.add(btnLast);
		
		btnNew = new JButton(">]*");
		btnNew.setPreferredSize(new Dimension(50,20));
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parentGUI.newRecord();
			}
		});
		leftPanel.add(btnNew);
		
		JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		lblDateTime = new JLabel("Time");
		lblDateTime.setHorizontalAlignment(SwingConstants.RIGHT);
		rightPanel.add(lblDateTime);
		
		setPreferredSize(new Dimension(500,20));
		add(leftPanel,BorderLayout.WEST);
		add(rightPanel,BorderLayout.EAST);
		
		refresh();
	}
	
	public NavigatorBar(Navigable parentGUI){
		this();
		this.parentGUI = parentGUI;
	}
		
	public void refresh() {
		SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM dd, yyyy h:mm a");
		Date now = new Date();
		lblDateTime.setText(sdf.format(now));
	}

	public Navigable getParentGUI() {
		return parentGUI;
	}

	public void setParentGUI(Navigable parentGUI) {
		this.parentGUI = parentGUI;
	}

	public boolean isNewRecordVisible() {
		return btnNew.isVisible();
	}

	public void setNewRecordVisible(boolean newRecordVisible) {
		btnNew.setVisible(newRecordVisible);
	}

	public boolean isSearchBoxVisible() {
		return txtSearch.isVisible();
	}

	public void setSearchBoxVisible(boolean searchBoxVisible) {
		txtSearch.setVisible(searchBoxVisible);
	}

	public JTextField getTextField() {
		return txtSearch;
	}

	public void setTextField(JTextField textField) {
		this.txtSearch = textField;
	}

}
