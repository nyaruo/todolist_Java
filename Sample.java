import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.awt.Color.*;
import java.util.*;
import java.io.*;
import javax.imageio.*;

public class Sample extends JFrame {
	public static void main(String[] args) {
		Sample s = new Sample();
		s.setSize(400, 450);
		s.setTitle("タスク管理アプリ");
		s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		s.setVisible(true);
	}

	private JButton createBt;
	private JButton timerBt;
	private JButton helpBt;
	private JButton doBt;
	private AudioClip ac;
	private JPanel tp1 = new JPanel(new GridLayout(10, 1));
	private JPanel tp2 = new JPanel(new GridLayout(10, 1));
	private ArrayList<String> todolist = new ArrayList<String>();
	private ArrayList<String> donelist = new ArrayList<String>();
	private JButton[] button = new JButton[10];
	private JButton[] button1 = new JButton[10];
	private int count = 0;
	private int dele = -1;
	private int count1 = 0;
	private int dele1 = -1;
	private Image img;

	public Sample() {
		setLayout(new BorderLayout());
		JPanel p1 = new JPanel();
		add(p1, BorderLayout.NORTH);

		createBt = new JButton("新規作成");
		createBt.addActionListener(new doSetActionListener());

		timerBt = new JButton("10分タイマー");
		timerBt.addActionListener(new timerActionListener());
		ac = Applet.newAudioClip(getClass().getResource("timer.wav"));

		helpBt = new JButton("ヘルプ");
		helpBt.addActionListener(new helpActionListener());

		p1.add(createBt);
		p1.add(timerBt);
		p1.add(helpBt);

		JPanel p2 = new JPanel();

		JTabbedPane tp = new JTabbedPane();

		

		tp.addTab("TODO", tp1);
		tp.addTab("DONE", tp2);
		
		for (int i = 0; i < 10; i++) {
			button[i] = new JButton();
			button[i].addActionListener(new todoActionListener());
			tp1.add(button[i]);
			button[i].setVisible(false);
		}

		for (int i = 0; i < 10; i++) {
			button1[i] = new JButton();
			button1[i].addActionListener(new doneActionListener());
			tp2.add(button1[i]);
			button1[i].setVisible(false);
		}

		tp.setTabPlacement(JTabbedPane.TOP);

		getContentPane().add(tp, BorderLayout.CENTER);
		Container contentPane = getContentPane();

		tp.setBackground(Color.WHITE);
		tp1.setBackground(new Color(201, 237, 240));
		tp2.setBackground(new Color(201, 237, 240));
		p1.setBackground(Color.WHITE);
		contentPane.setBackground(Color.WHITE);
		createBt.setBackground(new Color(220, 251, 250));
		timerBt.setBackground(new Color(220, 251, 250));
		helpBt.setBackground(new Color(220, 251, 250));
	}

	class doSetActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String ret = JOptionPane.showInputDialog(null, "タスクを入力");
			if (ret != null) {
				todolist.add(ret);
				button[count].setText(ret);
				button[count].setVisible(true);
				count++;
			}
		}
	}

	class todoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			for(int i= 0;i<10;i++)
			{
				if(e.getSource() == button[i])
				{
					dele = i;
				}
			}
			String selectvalues[] = { "Done", "削除" };
			int select = JOptionPane.showOptionDialog(null, "このタスクは終了しましたか？",  "TODO", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, selectvalues, selectvalues[0]);
			if (select == 0) {
				// Done
				count--;
				donelist.add(todolist.get(dele));
				button1[count1].setText(donelist.get(count1));
				button1[count1].setVisible(true);
				count1++;

				todolist.remove(dele);
				for (int i = 0; i < 10; i++) 
				{
					button[i].setVisible(false);
				}
				for(int i = 0;i< count ;i++)
				{
					button[i].setText(todolist.get(i));
					button[i].setVisible(true);
				}
			}
			if (select == 1) {
				// 削除
				count--;
				todolist.remove(dele);
				for (int i = 0; i < 10; i++) 
				{
					button[i].setVisible(false);
				}
				for(int i = 0;i< count ;i++)
				{
					button[i].setText(todolist.get(i));
					button[i].setVisible(true);
				}
			}

		}
	}

	class doneActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			for(int i= 0;i<10;i++)
			{
				if(e.getSource() == button1[i])
				{
					dele1 = i;
				}
			}
			String selectvalues[] = { "削除" };
			int select = JOptionPane.showOptionDialog(null, "このタスクを削除しますか？",  "削除", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, selectvalues, selectvalues[0]);
			if (select == 0) {
				count1--;
				donelist.remove(dele1);
				for (int i = 0; i < 10; i++) 
				{
					button1[i].setVisible(false);
				}
				for(int i = 0;i< count1 ;i++)
				{
					button1[i].setText(donelist.get(i));
					button1[i].setVisible(true);
				}

			}

		}
	}

	class timerActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			ac.play();
		}
	}

	class helpActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			ImageIcon icon = new ImageIcon("help.png");

			JLabel label = new JLabel(icon);
			JOptionPane.showMessageDialog(null, label);
		}
	}
}
