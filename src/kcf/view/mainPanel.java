package kcf.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.invoke.ConstantCallSite;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import kcf.controller.ButtonListener;
import kcf.controller.GameListener;
import kcf.controller.Listlistener;
import kcf.model.Game;

public class mainPanel extends JFrame {

	private final int Gridwidth = 40;
	private final int Gridheight = 40;
	private final int Mainwidth = 1600;
	private final int MainHeight = 1000;
	private final int GameWidth = 960;
	private final int Bwidth = 170;
	private final int Bheight = 40;

	private JPanel gamePanel = new JPanel();
	private JPanel namePanel = new JPanel();
	private JPanel detailPanel = new JPanel();
	private JPanel left = new JPanel();
	private JPanel right = new JPanel();
	private GameListener game_listener = new GameListener();

	private String[] name1 = new String[10];
	private String[] name2 = new String[10];
	private String[] T1 = new String[10];
	private String[] T2 = new String[10];
	private JList<String> nameList1 = new JList<String>(name1);
	private JList<String> nameList2 = new JList<String>(name2);
	private Listlistener listener1 = new Listlistener(1, nameList1, this);
	private Listlistener listener2 = new Listlistener(2, nameList2, this);
	private JButton bleft = new JButton("开始部署");
	private JButton bright = new JButton("开始部署");
	private ButtonListener blistener1 = new ButtonListener(1, bleft, this); // 玩家ID
	private ButtonListener blistener2 = new ButtonListener(2, bright, this);

	private JTextArea detailes = new JTextArea();
	private Game game;

	private void initname() {
		for (int i = 0; i < name1.length; i++) {
			name1[i] = game.getShips().get(i).getType() + " " + game.getShips().get(i).getShipName();
			name2[i] = game.getShips().get(i + 10).getType() + " " + game.getShips().get(i + 10).getShipName();
		}
	}

	@Override
	public void paint(Graphics arg0) {
		// TODO Auto-generated method stub
		super.paint(arg0);
		Graphics2D pa = (Graphics2D) arg0;
		pa.setColor(Color.black);
		pa.setStroke(new BasicStroke(1f));
		for (int i = Gridheight; i < MainHeight; i += Gridheight) {
			pa.drawLine(0, i, GameWidth, i);
		}
		for (int j = Gridwidth; j <= GameWidth; j += Gridwidth) {
			pa.drawLine(j, 0, j, MainHeight);
		}
	}

	private void initGamePanel() {
		gamePanel.setBounds(0, 0, GameWidth, MainHeight);
		gamePanel.addMouseListener(game_listener);
		gamePanel.setBackground(new Color(240, 255, 255));

		left.setBounds(0, 0, GameWidth / 4, MainHeight);
		left.setBackground(new Color(200, 255, 255));
		right.setBounds((3 * GameWidth) / 4, 0, GameWidth / 4, MainHeight);
		right.setBackground(new Color(200, 255, 255));

		right.setVisible(false);
		left.setVisible(false);
		this.add(left);
		this.add(right);
		this.add(gamePanel);
	}

	private void initNamePanel() {
		namePanel.setBounds(GameWidth, 0, Mainwidth - GameWidth, MainHeight / 2);
		namePanel.setSize(Mainwidth - GameWidth, MainHeight / 2);
		namePanel.setLayout(null);
		initname();
		nameList1.setBounds(30, 50, (Mainwidth - GameWidth) / 2, MainHeight / 2);
		nameList2.setBounds((Mainwidth - GameWidth) / 2 + 30, 50, (Mainwidth - GameWidth) / 2, MainHeight / 2);

		nameList1.setBackground(new Color(240, 248, 255));
		nameList1.setFont(new Font("SansSerif", Font.BOLD, 30));
		nameList2.setFont(new Font("SansSerif", Font.BOLD, 30));
		nameList1.addListSelectionListener(listener1);
		nameList2.addListSelectionListener(listener2);

		bleft.setBounds(50, 10, Bwidth, Bheight);
		bleft.setFont(new Font("SansSerif", Font.BOLD, 25));
		bleft.addActionListener(blistener1);
		bright.setBounds(360, 10, Bwidth, Bheight);
		bright.setFont(new Font("SansSerif", Font.BOLD, 25));

		bright.addActionListener(blistener2);
		bright.setEnabled(false);

		namePanel.add(nameList1);
		namePanel.add(nameList2);
		namePanel.add(bright);
		namePanel.add(bleft);

		namePanel.setVisible(true);
		this.add(namePanel);
	}

	private void initDetailPanel() {
		detailPanel.setBounds(GameWidth, MainHeight / 2, Mainwidth - GameWidth, MainHeight / 2);
		detailPanel.setBackground(new Color(200, 248, 255));
		detailes.setBounds(0, 0, Mainwidth - GameWidth, MainHeight / 2);
		detailes.setLineWrap(true);
		detailes.setWrapStyleWord(true);
		detailes.setFont(new Font("SansSerif", Font.PLAIN, 27));
		detailes.setEditable(false);
		detailPanel.add(detailes);
		this.add(detailPanel);
	}

	public mainPanel(String name) {
		super(name);
		game = new Game();
		this.setSize(new Dimension(Mainwidth, MainHeight));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocation(0, 0);
		this.setLayout(null);

		initGamePanel();
		initDetailPanel();
		initNamePanel();

		this.setVisible(true);
	}

	public void Updatedata(int cp, int def, int tp, int hp) {
		if (detailes != null)
			detailPanel.remove(detailes);
		detailes = new JTextArea();
		detailes.setBounds(0, 0, Mainwidth - GameWidth, MainHeight / 2);
		detailes.setLineWrap(true);
		detailes.setWrapStyleWord(true);
		detailes.setFont(new Font("SansSerif", Font.PLAIN, 27));
		detailes.setEditable(false);
		detailes.append("火力：" + cp + "\n");
		detailes.append("装甲：" + def + "\n");
		detailes.append("雷装：" + tp + "\n");
		detailes.append("耐久：" + hp + "\n");
		detailPanel.add(detailes);
	}

	public Game GetGame() {
		return this.game;
	}

	public void SetLeftVisible(boolean enable) {
		left.setVisible(enable);
		;
	}

	public void SetRightVisible(boolean enable) {
		right.setVisible(enable);
	}

	public static void main(String[] args) {
		mainPanel mPanel = new mainPanel("战棋");

		mPanel.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		mPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
