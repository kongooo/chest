package kcf.controller;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import kcf.view.mainPanel;

public class Listlistener implements ListSelectionListener {

	private int type = 0;
	private JList<String> list;
	private mainPanel mPanel;

	public Listlistener(int T, JList<String> L, mainPanel m) {
		this.type = T;
		this.list = L;
		this.mPanel = m;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!list.isSelectionEmpty() && !e.getValueIsAdjusting()) {
			if (type == 1) {
				int index = list.getSelectedIndex();
				mPanel.Updatedata(mPanel.GetGame().getShips().get(index).getCannonPower(),
						mPanel.GetGame().getShips().get(index).getDefense(),
						mPanel.GetGame().getShips().get(index).getTorpedoPower(),
						mPanel.GetGame().getShips().get(index).getEndurance());
			}
			if (type == 2) {
				int index = list.getSelectedIndex();
				mPanel.Updatedata(mPanel.GetGame().getShips().get(index + 10).getCannonPower(),
						mPanel.GetGame().getShips().get(index + 10).getDefense(),
						mPanel.GetGame().getShips().get(index + 10).getTorpedoPower(),
						mPanel.GetGame().getShips().get(index + 10).getEndurance());
			}
		}

	}

}
