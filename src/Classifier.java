package com.raghav.congress;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Classifier extends JFrame {
	public Color c;
	public Classifier() {
		c = Color.GREEN;
	}
	public void paint(Graphics g) {
		getContentPane().setBackground(c);
	}
}
