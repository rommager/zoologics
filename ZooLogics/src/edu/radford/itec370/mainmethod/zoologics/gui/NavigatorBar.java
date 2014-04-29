package edu.radford.itec370.mainmethod.zoologics.gui;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.SwingConstants;

public class NavigatorBar extends JPanel implements FocusListener {
	private static final long serialVersionUID = -7765321196155993760L;
	private static final String SEARCH_TEXT = "Type to Search";

	// Class variables
	private boolean newButtonVisible; 
	private Navigable parentGUI;
	private String currentFilter;

	// GUI elements
	private JButton btnFirst;
	private JButton btnPrevious;
	private JLabel lblRecordCount;
	private JButton btnNext;
	private JButton btnLast;
	private JButton btnNew;
	private JTextField txtSearch;
	private JLabel lblDateTime;


	private NavigatorBar() {
		super();
		currentFilter = "";
		setLayout(new BorderLayout());

		FlowLayout leftFlowLayout = new FlowLayout(FlowLayout.LEFT);
		leftFlowLayout.setVgap(0);
		leftFlowLayout.setHgap(0);

		JPanel leftPanel = new JPanel(new BorderLayout());
		JPanel leftButtonPanel = new JPanel(leftFlowLayout);

		btnFirst = new JButton("|<");
		btnFirst.setPreferredSize(new Dimension(45,20));
		btnFirst.setToolTipText("Skip to First Record");
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				parentGUI.firstRecord();
			}
		});
		leftButtonPanel.add(btnFirst);

		btnPrevious = new JButton("<");
		btnPrevious.setPreferredSize(new Dimension(45,20));
		btnPrevious.setToolTipText("Go To Previous Record");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				parentGUI.previousRecord();
			}
		});
		leftButtonPanel.add(btnPrevious);

		lblRecordCount = new JLabel();
		lblRecordCount.setFont(setFontFace(lblRecordCount.getFont(),Font.ITALIC));
		updateRecordCount(0,0);
		leftButtonPanel.add(lblRecordCount);

		btnNext = new JButton(">");
		btnNext.setPreferredSize(new Dimension(45,20));
		btnNext.setToolTipText("Go To Next Record");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parentGUI.nextRecord();
			}
		});
		leftButtonPanel.add(btnNext);

		btnLast = new JButton(">|");
		btnLast.setPreferredSize(new Dimension(45,20));
		btnLast.setToolTipText("Skip to Last Record");
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parentGUI.lastRecord();
			}
		});
		leftButtonPanel.add(btnLast);

		btnNew = new JButton(">|*");
		btnNew.setPreferredSize(new Dimension(50,20));
		btnNew.setToolTipText("Add New Record");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parentGUI.newRecord();
			}
		});
		newButtonVisible = true;
		leftButtonPanel.add(btnNew);
		leftPanel.add(leftButtonPanel,BorderLayout.WEST);

		FlowLayout leftSearchLayout = new FlowLayout(FlowLayout.RIGHT);
		leftSearchLayout.setVgap(0);
		JPanel leftSearchPanel = new JPanel(leftSearchLayout);
		txtSearch = new JTextField();
		txtSearch.addFocusListener(this);
		txtSearch.setText(SEARCH_TEXT);
		txtSearch.setForeground(Color.GRAY);
		txtSearch.setFont(setFontFace(txtSearch.getFont(),Font.ITALIC));
		txtSearch.setPreferredSize(new Dimension(100,20));
		txtSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				applyFilter(txtSearch,false);
			}
		});
		leftSearchPanel.add(txtSearch);
		leftPanel.add(leftSearchPanel,BorderLayout.EAST);

		lblDateTime = new JLabel("Time");
		lblDateTime.setHorizontalAlignment(SwingConstants.RIGHT);

		setPreferredSize(new Dimension(500,20));
		add(leftPanel,BorderLayout.WEST);
		add(lblDateTime,BorderLayout.EAST);

		refresh();
	}

	public NavigatorBar(Navigable parentGUI){
		this();
		this.parentGUI = parentGUI;
	}

	public void refresh() {
		SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM dd, yyyy h:mm a   ");
		Date now = new Date();
		lblDateTime.setText(sdf.format(now));
	}

	public void updateRecordCount(int index, int total) {
		if (total == 0)
			lblRecordCount.setText("  0 of 0  ");
		else
			lblRecordCount.setText("   " + Integer.toString(index) + " of " + Integer.toString(total) + "   ");
	}

	public Navigable getParentGUI() {
		return parentGUI;
	}

	public void setParentGUI(Navigable parentGUI) {
		this.parentGUI = parentGUI;
	}

	public boolean isNewButtonVisible() {
		return btnNew.isVisible();
	}

	public void setNewButtonVisible(boolean newButtonVisible) {
		btnNew.setVisible(newButtonVisible);
		this.newButtonVisible = newButtonVisible;
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

	@Override
	public void focusGained(FocusEvent e) {
		JTextField field = (JTextField) e.getSource();
		if (field.getText().equals(SEARCH_TEXT)) {
			field.setForeground(Color.BLACK);
			field.setFont(setFontFace(field.getFont(),Font.PLAIN));
			field.setText(null);

		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		JTextField field = (JTextField) e.getSource();
		applyFilter(field,true);
	}

	private Font setFontFace(Font font, int type) {
		return new Font(font.getName(),type,font.getSize());
	}

	private void applyFilter(JTextField field, boolean setSearchTextOnNull) {
		String filter = field.getText().toUpperCase();
		if ((!filter.equals(currentFilter)) || currentFilter.isEmpty()) {
			if (filter.isEmpty() || filter.equals(SEARCH_TEXT) || filter == null) {
				if (setSearchTextOnNull) {
					field.setForeground(Color.GRAY);
					field.setFont(setFontFace(field.getFont(),Font.ITALIC));
					field.setText(SEARCH_TEXT);
				}
				btnNew.setVisible(newButtonVisible);
				currentFilter = "";
				parentGUI.applyFilter(null);
			}
			else {
				btnNew.setVisible(false);
				currentFilter = filter;
				parentGUI.applyFilter(filter);
			}
		}
	}

}
