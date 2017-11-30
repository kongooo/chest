package kcf.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import kcf.view.mainPanel;

public class ButtonListener implements ActionListener {

	private int Ptype = 0;
	private static int currentPlayer = 1;
	private JButton button;
	private mainPanel mPanel;

	public ButtonListener(int TP, JButton B, mainPanel M) {
		this.Ptype = TP;
		this.button = B;
		this.mPanel = M;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (currentPlayer == 1) {
			mPanel.SetLeftVisible(true);
			mPanel.repaint();
		}
		if (currentPlayer == 2) {
			mPanel.SetLeftVisible(false);
			mPanel.SetRightVisible(true);
			mPanel.repaint();
		}
	}

}
