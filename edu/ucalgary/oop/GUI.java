package edu.ucalgary.oop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.Year;
import java.sql.*;

public class GUI implements ItemListener{
	static JPanel cards = null;
	static LocalDate date = null;
	static Connection connection = null;
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
        JPanel panel = new JPanel();
		JButton button = new JButton(text);
		panel.add(button);
		container.add(panel);
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
	/**Date picker**/
	private static JPanel genDate() {
		JPanel pane = new JPanel();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		
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
				date = null;
				try {
					date = LocalDate.of(y,m,d);
				} catch (Exception exc) {//catches invalid dates
					popupBox("Invalid Date(y/m/d): "+y+"/"+m+"/"+d, "Invalid Date");
				}
				if (date!=null) {
					//generate schedule here with db and LocalDate
					CardLayout cl = (CardLayout) (cards.getLayout());
					cl.show(cards, "App");
				}
			}
		});
		return pane;
	}
	/**Generates Schedule and contains display and download functionality**/
	private static JPanel genApp() {
		JPanel pane = new JPanel();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		
		JLabel label = new JLabel("Choose Display Method");
		pane.add(label);
		JButton disp = addButton("Display Schedule",pane);
		JButton down = addButton("Download Schedule",pane);
		JButton back = addButton("Pick new Date",pane);
		disp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Display schedule
				popupBox("Schedule disp","Display Message");
			}
		});
		down.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Download schedule
				popupBox("Schedule downloaded","Download Message");
			}
		});
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) (cards.getLayout());
				cl.show(cards, "Date");				
			}
		});
		return pane;
	}
	/**connects to database**/
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
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/EWR",name,password);//sql address here
					connection = conn;
					CardLayout cl = (CardLayout) (cards.getLayout());
					cl.show(cards, "Date");
				} catch(Exception exc) {
					popupBox("Connection Error", "Connection Error");
				}
			}
		});
		return pane;
	}
	/**Startup**/
	public static void main(String[]args) {
		EventQueue.invokeLater(() -> {
			JFrame frame = new JFrame("Schedule Generator");
			frame.setSize(300, 400);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Container pane = frame.getContentPane();
			
			JPanel card1 = genConn();
			JPanel card2 = genDate();
			JPanel card3 = genApp();
			
			cards = new JPanel(new CardLayout());
			cards.add(card1, "Connect");
			cards.add(card2, "Date");
			cards.add(card3, "App");
			
			pane.add(cards, BorderLayout.CENTER);
			
			frame.setVisible(true);
		});
	}
	public void itemStateChanged(ItemEvent evt) {
		CardLayout cl = (CardLayout)(cards.getLayout());
		cl.show(cards, (String)evt.getItem());
	}
}