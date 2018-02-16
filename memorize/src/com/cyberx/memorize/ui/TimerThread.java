package com.cyberx.memorize.ui;

import javax.swing.JLabel;

public class TimerThread implements Runnable {
	private JLabel label;
	private int time;
	private boolean run = true;

	public TimerThread(JLabel label) {
		this.label = label;
		this.time = 0;
	}

	public void run() {
		while (this.run) {
			try {
				Thread.sleep(1000);
				this.time++;
				this.label.setText("Time: " + this.time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void stop() {
		this.run = false;
	}
}
