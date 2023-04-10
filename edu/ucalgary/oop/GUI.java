package edu.ucalgary.oop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Year;

public class GUI {
	/**Reusable method for adding label and text fields in format: text ______ **/
	public static TextField addTextEntry(String text, Container container) {
		JPanel panel = new JPanel();
		panel.setSize(new Dimension(100, 50));
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
	/**Reuseable method for adding a number spinner with a label**/
	private static JSpinner addSpin(String text, int init, int min, int max, Container container) {
		JPanel panel = new JPanel();
		panel.setSize(new Dimension(100, 50));
		JLabel label = new JLabel(text);
		SpinnerModel model = new SpinnerNumberModel(init,min,max,1);
		JSpinner spin = new JSpinner(model);
		panel.add(label);
		panel.add(spin);
		container.add(panel);
		return spin;
	}
	/**Reuseable method for making popups**/
	private static void popupBox(String info, String title) {
		JOptionPane.showMessageDialog(null,info,"Popup: "+title,JOptionPane.INFORMATION_MESSAGE);
	}
	/**main application - contains date picker**/
	private static void app(JFrame frame) {
		EventQueue.invokeLater(() -> {
			Container pane = frame.getContentPane();
			pane.removeAll();
			pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
			frame.repaint();
			JLabel label = new JLabel("Enter Date");
			pane.add(label);
			int y = Year.now().getValue();
			JSpinner year = addSpin("Year:",y,y-15,y+15,pane);//Year is capped at the current year+-15
			JSpinner mon = addSpin("Month:",1,1,12,pane);
			JSpinner day = addSpin("Day:",1,1,31,pane);
			JButton gen = addButton("Generate",pane);
			gen.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int y = (Integer)year.getValue();
					int m = (Integer)mon.getValue();
					int d = (Integer)day.getValue();
					LocalDate date = null;
					try {
						date = LocalDate.of(y,m,d);
					} catch (Exception exc) {//catches invalid dates
						popupBox("Invalid Date(y/m/d): "+y+"/"+m+"/"+d, "Invalid Date");
					}
					if (date!=null) {
						//Generate schedule
						genSchedule(frame, date);
					}
				}
			});
			
		});
	}
	/**Generates Schedule and contains display and download functionality**/
	private static void genSchedule(JFrame frame, LocalDate date) {
		EventQueue.invokeLater(() -> {
			Container pane = frame.getContentPane();
			pane.removeAll();
			pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
			frame.repaint();
			JLabel label = new JLabel("Choose Display Method");
			pane.add(label);
			JButton disp = addButton("Display Schedule",pane);
			JButton down = addButton("Download Schedule",pane);
			disp.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					//Display schedule
					popupBox("Schedule disp","Display");
				}
			});
			down.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					//Download schedule
					popupBox("Schedule downloaded","Download");
				}
			});
			
		});
	}
	/**Opens new window with text of schedule shown**/
	private static void dispSchedule(JFrame frame) {
		
	}
	/**Startup GUI and database connection**/
	public static void main(String[]args) {
		EventQueue.invokeLater(() -> {
		JFrame frame = new JFrame("Schedule Generator");
		frame.setSize(300, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container pane = frame.getContentPane();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		//genSchedule(frame,null);//for testing
		/**
		TextField user = addTextEntry("Enter User",pane);
		TextField pass = addTextEntry("Enter Passkey",pane);
		JButton login = addButton("Login",pane);
		login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//DB connection here
				//genSchedule(frame,null);
			}
		});
		**/
		frame.setVisible(true);
		});
	}
}