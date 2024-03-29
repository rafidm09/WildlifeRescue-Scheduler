package edu.ucalgary.oop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.Year;
import java.sql.*;

/**
generates and runs the graphical user interface for the ENSF 380 Final Project
requires the assossiated schedule classes
@author Joshua Froese
@version 1.2
**/
public class GUI {
	static JPanel cards = null;
	static LocalDate date = null;
	static Schedule sched = new Schedule(date);
	static Connection connection = null;
	/**
	@param text			text for the label
	@param container	the container that the label is being added to
	Reusable method for adding labels**/
	public static void addLabel(String text, Container container) {
		JPanel panel = new JPanel();
		JLabel label = new JLabel(text);
		panel.add(label);
		container.add(panel);
	}
	/**
	@param text			text for the label infront of the field
	@param container	the container that the field is being added to
	@return field		returns the text field generated
	Reusable method for adding label and text fields in format: text ______ **/
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
	/**
	@param text			text for the inside of the button
	@param container	the continer that the button is being added to
	@return button		returns the button generated
	Reuseable method for adding buttons with text as inputted text**/
    private static JButton addButton(String text, Container container) {
        JPanel panel = new JPanel();
		JButton button = new JButton(text);
		panel.add(button);
		container.add(panel);
		return button;
	}
	/**
	@param text			text for the label infront of the spinner
	@param init			inital value for the spinner
	@param min			minimum value for the spinner
	@param max			maximum value for the spinner
	@param conainer		the container that the spinner is beiing added to
	@return spin		returns the spinner generated
	Reuseable method for adding a number spinner with a label**/
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
	/**
	@param info			text in the popup
	@param title		title in the bar of the popup
	Reuseable method for making general popups**/
	private static void infoPop(String info, String title) {
		JOptionPane.showMessageDialog(null,info,"Popup: "+title,JOptionPane.INFORMATION_MESSAGE);
	}
	/**
	@param info			text in the popup
	@return response	returns true if the response is yes, returns false otherwise
	Reuseable method for confirmation popup**/
	private static boolean inputPop(String info) {
		int a=JOptionPane.showConfirmDialog(null,info);
		if(a==JOptionPane.YES_OPTION){  
			return true;
		}
		return false;
	}
	/**
	@param resume	used to resume generation after interruption
	Method for generating the schedule**/
	private static void scheduleBuilder(boolean resume) {
		try {
			if (!resume) {
				//generate schedule
				sched.initializeData();
				sched.makeSchedule();
			} else {
				sched.makeSchedule();
				//resume generation
			}
		} catch (Exception e) {//catch illegal volunteer add
			e.printStackTrace();
			boolean volun = inputPop("An additional volunteer is needed. Confirmation is required to continue.");
			if (volun) {
				scheduleBuilder(true);
			} else {
				CardLayout cl = (CardLayout) (cards.getLayout());
				cl.show(cards, "Date");
			}
		}
	}
	/**
	@return pane	returns the generated JPanel
	Method for editing database**/
	private static JPanel genEdit() {
		JPanel pane = new JPanel();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		
		addLabel("Enter Treatment to modify",pane);
		JSpinner id = addSpin("ID:", 0, 0, 50,pane);
		JSpinner hour = addSpin("New start hour", 0, 0, 23,pane);
		JButton regen = addButton("Regenerate with changes",pane);
		JButton change = addButton("Perform additional changes",pane);
		JButton cancel = addButton("Cancel Modification of Database",pane);
		JButton reject = addButton("Cancel Generation",pane);
		
		regen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = (Integer)id.getValue();
				int h = (Integer)hour.getValue();
				sched.update(h,i);
				scheduleBuilder(false);
				CardLayout cl = (CardLayout) (cards.getLayout());
				cl.show(cards, "App");
			}
		});
		change.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = (Integer)id.getValue();
				int h = (Integer)hour.getValue();
				sched.update(h,i);
				infoPop("Database Changed","Display Message");
			}
		});
		cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) (cards.getLayout());
				cl.show(cards, "App");
			}
		});
		reject.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) (cards.getLayout());
				cl.show(cards, "Date");
			}
		});
		
		return pane;
	}
	/**
	@return pane	returns the generated JPanel
	Date picker**/
	private static JPanel genDate() {
		JPanel pane = new JPanel();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		
		addLabel("Enter Date",pane);
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
				date = null;
				try {
					date = LocalDate.of(y,m,d);
					sched.setDate(date);
				} catch (Exception exc) {//catches invalid dates
					infoPop("Invalid Date(y/m/d): "+y+"/"+m+"/"+d, "Invalid Date");
				}
				if (date!=null) {
					scheduleBuilder(false);
					CardLayout cl = (CardLayout) (cards.getLayout());
					cl.show(cards, "App");
				}
			}
		});
		return pane;
	}
	/**
	@return pane	returns the generated JPanel
	Generates Schedule and contains display and download functionality**/
	private static JPanel genApp() {
		JPanel pane = new JPanel();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		
		addLabel("Choose Display Method",pane);
		JButton disp = addButton("Display Schedule",pane);
		JButton down = addButton("Download Schedule",pane);
		JButton back = addButton("Pick new Date",pane);
		JButton mod = addButton("Modify Database",pane);
		
		disp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Display schedule
				infoPop(sched.toText(),"Display Message");
			}
		});
		down.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sched.toFile();
				infoPop("Schedule downloaded","Download Message");
			}
		});
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) (cards.getLayout());
				cl.show(cards, "Date");				
			}
		});
		mod.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) (cards.getLayout());
				cl.show(cards, "Edit");				
			}
		});
		return pane;
	}
	/**
	@return pane	returns the generated JPanel
	connects to database - unused as connection is hardcoded**/
	private static JPanel genConn() {
		JPanel pane = new JPanel();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		
		TextField user = addTextEntry("Enter User",pane);
		TextField pass = addTextEntry("Enter Passkey",pane);
		JButton login = addButton("Login",pane);
		
		login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String name = user.getText();
					String password = pass.getText();
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/EWR",name,password);//sql address here
					connection = conn;
					CardLayout cl = (CardLayout) (cards.getLayout());
					cl.show(cards, "Date");
				} catch(Exception exc) {
					infoPop("Connection Error", "Connection Error");
				}
			}
		});
		return pane;
	}
	/**Startup sequence**/
	public static void main(String[]args) {
		EventQueue.invokeLater(() -> {
			JFrame frame = new JFrame("Schedule Generator");
			frame.setSize(300, 400);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Container pane = frame.getContentPane();
			
			JPanel card1 = genDate();
			JPanel card2 = genApp();
			JPanel card3 = genEdit();
			
			cards = new JPanel(new CardLayout());
			cards.add(card1, "Date");
			cards.add(card2, "App");
			cards.add(card3, "Edit");
			
			pane.add(cards, BorderLayout.CENTER);
			
			frame.setVisible(true);
		});
	}
}