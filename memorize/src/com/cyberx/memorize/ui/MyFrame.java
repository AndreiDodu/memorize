package com.cyberx.memorize.ui;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

public class MyFrame {

	private JFrame frame;
	public JLabel lblNewLabel = new JLabel("");
	public JLabel lblNewLabel_1 = new JLabel("");
	public JLabel lblNewLabel_2 = new JLabel("");
	public JLabel lblNewLabel_3 = new JLabel("");
	public JLabel lblNewLabel_4 = new JLabel("");
	public JLabel lblNewLabel_7 = new JLabel("");
	public JLabel lblNewLabel_10 = new JLabel("");
	public JLabel lblNewLabel_11 = new JLabel("");
	public JLabel lblNewLabel_5 = new JLabel("");
	public JLabel lblNewLabel_8 = new JLabel("");
	public JLabel lblNewLabel_12 = new JLabel("");
	public JLabel lblNewLabel_13 = new JLabel("");
	public JLabel lblNewLabel_6 = new JLabel("");
	public JLabel lblNewLabel_9 = new JLabel("");
	public JLabel lblNewLabel_14 = new JLabel("");
	public JLabel lblNewLabel_15 = new JLabel("");
	private List<JLabel> jlabels = new ArrayList<JLabel>();
	private final JLabel lblScore = new JLabel("Score:");
	private final JLabel lblTime = new JLabel("Timer:");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFrame window = new MyFrame();
					window.frame.setVisible(true);
					window.frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MyFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		TimerThread runnable = new TimerThread(this.lblTime);
		Thread t = new Thread(runnable);
		t.start();
		frame = new JFrame();
		frame.setBounds(100, 100, 248, 240);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 54, 0, 46, 0, 56, 0, 47, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayout);

		List<URL> imageList = new ArrayList<URL>();
		imageList.add(getClass().getResource("./fb.png"));
		imageList.add(getClass().getResource("./googleplus.png"));
		imageList.add(getClass().getResource("./ie.png"));
		imageList.add(getClass().getResource("./linkedin.png"));
		imageList.add(getClass().getResource("./linux.png"));
		imageList.add(getClass().getResource("./soundcloud.png"));
		imageList.add(getClass().getResource("./twitter.png"));
		imageList.add(getClass().getResource("./youtube.png"));

		Map<URL, Integer> imageListCount = new HashMap<URL, Integer>();
		for (int i = 0; i < imageList.size(); i++) {
			imageListCount.put(imageList.get(i), 2);
		}

		List<URL> images = new ArrayList<URL>();
		Random rn = new Random();
		for (int i = 0; i < 16; i++) {
				int number = rn.nextInt(imageListCount.keySet().size());
				URL url = (URL) imageListCount.keySet().toArray()[number];
				images.add(url);
				if (imageListCount.get(url) == 1)
					imageListCount.remove(url);
				else
					imageListCount.put(url, 1);
		}

		jlabels.add(lblNewLabel);
		jlabels.add(lblNewLabel_1);
		jlabels.add(lblNewLabel_2);
		jlabels.add(lblNewLabel_3);
		jlabels.add(lblNewLabel_4);
		jlabels.add(lblNewLabel_5);
		jlabels.add(lblNewLabel_6);
		jlabels.add(lblNewLabel_7);
		jlabels.add(lblNewLabel_8);
		jlabels.add(lblNewLabel_9);
		jlabels.add(lblNewLabel_10);
		jlabels.add(lblNewLabel_11);
		jlabels.add(lblNewLabel_12);
		jlabels.add(lblNewLabel_13);
		jlabels.add(lblNewLabel_14);
		jlabels.add(lblNewLabel_15);

		MouseAdapter mouseAdapter = new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (!((JLabel) e.getSource()).getIcon().toString()
						.equals(getClass().getResource("./sun.png").toString()))
					return;
				resetIconsOneByOne();

				for (int i = 0; i < jlabels.size(); i++) {
					if (e.getSource() == jlabels.get(i)) {
						jlabels.get(i).setIcon(new ImageIcon(images.get(i)));
					}
				}
				if (updateScore() == 8) {
					runnable.stop();
				}
			}
		};

		lblNewLabel.addMouseListener(mouseAdapter);
		lblNewLabel_1.addMouseListener(mouseAdapter);
		lblNewLabel_2.addMouseListener(mouseAdapter);
		lblNewLabel_3.addMouseListener(mouseAdapter);
		lblNewLabel_4.addMouseListener(mouseAdapter);
		lblNewLabel_5.addMouseListener(mouseAdapter);
		lblNewLabel_6.addMouseListener(mouseAdapter);
		lblNewLabel_7.addMouseListener(mouseAdapter);
		lblNewLabel_8.addMouseListener(mouseAdapter);
		lblNewLabel_9.addMouseListener(mouseAdapter);
		lblNewLabel_10.addMouseListener(mouseAdapter);
		lblNewLabel_11.addMouseListener(mouseAdapter);
		lblNewLabel_12.addMouseListener(mouseAdapter);
		lblNewLabel_13.addMouseListener(mouseAdapter);
		lblNewLabel_14.addMouseListener(mouseAdapter);
		lblNewLabel_15.addMouseListener(mouseAdapter);

		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);

		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 0;
		frame.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);

		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 4;
		gbc_lblNewLabel_2.gridy = 0;
		frame.getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);

		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 6;
		gbc_lblNewLabel_3.gridy = 0;
		frame.getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);

		GridBagConstraints gbc_lblScore = new GridBagConstraints();
		gbc_lblScore.insets = new Insets(0, 0, 5, 0);
		gbc_lblScore.gridx = 9;
		gbc_lblScore.gridy = 0;
		frame.getContentPane().add(lblScore, gbc_lblScore);

		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 2;
		frame.getContentPane().add(lblNewLabel_4, gbc_lblNewLabel_4);

		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 2;
		gbc_lblNewLabel_7.gridy = 2;
		frame.getContentPane().add(lblNewLabel_7, gbc_lblNewLabel_7);

		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_10.gridx = 4;
		gbc_lblNewLabel_10.gridy = 2;
		frame.getContentPane().add(lblNewLabel_10, gbc_lblNewLabel_10);

		GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
		gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_11.gridx = 6;
		gbc_lblNewLabel_11.gridy = 2;
		frame.getContentPane().add(lblNewLabel_11, gbc_lblNewLabel_11);

		GridBagConstraints gbc_lblTime = new GridBagConstraints();
		gbc_lblTime.insets = new Insets(0, 0, 5, 0);
		gbc_lblTime.gridx = 9;
		gbc_lblTime.gridy = 2;
		frame.getContentPane().add(lblTime, gbc_lblTime);

		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 4;
		frame.getContentPane().add(lblNewLabel_5, gbc_lblNewLabel_5);

		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 2;
		gbc_lblNewLabel_8.gridy = 4;
		frame.getContentPane().add(lblNewLabel_8, gbc_lblNewLabel_8);

		GridBagConstraints gbc_lblNewLabel_12 = new GridBagConstraints();
		gbc_lblNewLabel_12.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_12.gridx = 4;
		gbc_lblNewLabel_12.gridy = 4;
		frame.getContentPane().add(lblNewLabel_12, gbc_lblNewLabel_12);

		GridBagConstraints gbc_lblNewLabel_13 = new GridBagConstraints();
		gbc_lblNewLabel_13.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_13.gridx = 6;
		gbc_lblNewLabel_13.gridy = 4;
		frame.getContentPane().add(lblNewLabel_13, gbc_lblNewLabel_13);

		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 6;
		frame.getContentPane().add(lblNewLabel_6, gbc_lblNewLabel_6);

		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_9.gridx = 2;
		gbc_lblNewLabel_9.gridy = 6;
		frame.getContentPane().add(lblNewLabel_9, gbc_lblNewLabel_9);

		GridBagConstraints gbc_lblNewLabel_14 = new GridBagConstraints();
		gbc_lblNewLabel_14.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_14.gridx = 4;
		gbc_lblNewLabel_14.gridy = 6;
		frame.getContentPane().add(lblNewLabel_14, gbc_lblNewLabel_14);

		GridBagConstraints gbc_lblNewLabel_15 = new GridBagConstraints();
		gbc_lblNewLabel_15.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_15.gridx = 6;
		gbc_lblNewLabel_15.gridy = 6;
		frame.getContentPane().add(lblNewLabel_15, gbc_lblNewLabel_15);

		resetIcons();

	}

	public void resetIcons() {
		for (int i = 0; i < jlabels.size(); i++) {
			jlabels.get(i).setIcon(new ImageIcon(getClass().getResource("./sun.png")));
		}
	}

	public void resetIconsOneByOne() {
		Set<String> processed = new HashSet<String>();
		int count = 0;
		for (int i = 0; i < jlabels.size(); i++) {
			JLabel label = jlabels.get(i);
			if (!label.getIcon().toString().equals(getClass().getResource("./sun.png").toString()) && !processed.contains(label.getIcon().toString())) {
				processed.add(label.getIcon().toString());
				boolean trovato = false;
				for (int j = 0; j < jlabels.size(); j++) {
					if (j != i) {
						if (jlabels.get(j).getIcon().toString().equals(label.getIcon().toString())) {
							trovato = true;
						}
					}
				}
				if (trovato == false) {
					count++;
				} else {
				}
			}
		}
		processed = new HashSet<String>();
		if (count >= 2) {
			for (int i = 0; i < jlabels.size(); i++) {
				JLabel label = jlabels.get(i);
				if (!label.getIcon().toString().equals(getClass().getResource("./sun.png").toString()) && !processed.contains(label.getIcon().toString())) {
					processed.add(label.getIcon().toString());
					boolean trovato = false;
					for (int j = 0; j < jlabels.size(); j++) {
						if (j != i) {
							if (jlabels.get(j).getIcon().toString().equals(label.getIcon().toString())) {
								trovato = true;
							}
						}
					}
					if (trovato == false) {
						label.setIcon(new ImageIcon(getClass().getResource("./sun.png")));
					} else {

					}
				}
			}
		}

	}

	public int updateScore() {
		Set<String> processed = new HashSet<String>();
		int score = 0;
		for (int i = 0; i < jlabels.size(); i++) {
			JLabel label = jlabels.get(i);
			if (!label.getIcon().toString().equals(getClass().getResource("./sun.png").toString()) && !processed.contains(label.getIcon().toString())) {
				processed.add(label.getIcon().toString());
				boolean trovato = false;
				for (int j = 0; j < jlabels.size(); j++) {
					if (j != i) {
						if (jlabels.get(j).getIcon().toString().equals(label.getIcon().toString())) {
							trovato = true;
						}
					}
				}
				if (trovato == false) {
				} else {
					score++;
					lblScore.setText("Score: " + score);
				}
			}
		}
		return score;
	}
}
