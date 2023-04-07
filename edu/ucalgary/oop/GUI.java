package edu.ucalgary.oop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
	/**Startup GUI**/
	public static void main(String[]args) {
		EventQueue.invokeLater(() -> {
		JFrame frame = new JFrame("Schedule Generator");
		frame.setSize(600, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container pane = frame.getContentPane();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		
		addTextEntry("Enter User",pane);
		addTextEntry("Enter Passkey",pane);
		JButton login = addButton("Login",pane);
		login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				app(frame);
			}
		});
		
		frame.setVisible(true);
		});
	}
	/**Reusable method for adding label and text fields in format: text ______ **/
	public static TextField addTextEntry(String text, Container container) {
		JPanel panel = new JPanel();
		panel.setSize(new Dimension(100, 20));
		JLabel label = new JLabel(text);
		TextField field = new TextField("",10);
		panel.add(label);
		panel.add(field);
		container.add(panel);
		return field;
	}
	/**Reuseable method for adding buttons with text as inputted text**/
    private static JButton addButton(String text, Container container) {
        JButton button = new JButton(text);
		container.add(button);
		return button;
	}
	/**main application**/
	private static void app(JFrame frame) {
		EventQueue.invokeLater(() -> {
			frame.removeAll();//removes all - having issues just clearing panels 
			frame.repaint();
		});
	}
}