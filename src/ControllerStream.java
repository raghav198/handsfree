package com.raghav.congress;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
public class ControllerStream {
	public static Robot robot;
	public static Classifier classifier;
	public static void main(String args[]) throws AWTException {
		classifier = new Classifier();
		classifier.setSize(200, 200);
		classifier.setVisible(true);
		robot = new Robot();
		String serverName = "localhost";
		int port = 6066;
		try {
			@SuppressWarnings("resource")
			Socket client = new Socket(serverName, port);
			DataInputStream in = new DataInputStream(client.getInputStream());
			System.out.println("Waiting...");
			while (true) {
				byte data = in.readByte();
				System.out.println(data);
				if (data == (byte)'o')
					openCallback();
				else if (data == (byte)'c')
					closedCallback();
			}
		} catch (EOFException e) {
			System.out.println("The server exited");
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}
	public static void openCallback() {
		//TODO: implement
		System.out.println("Opened");
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		classifier.c = Color.GREEN;
		classifier.repaint();
	}
	public static void closedCallback() {
		//TODO: implement
		System.out.println("Closed");
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		//robot.mouseMove(100, 100);
		classifier.c = Color.RED;
		classifier.repaint();
	}
}