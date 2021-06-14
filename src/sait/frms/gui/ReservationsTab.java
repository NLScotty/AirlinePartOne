package sait.frms.gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

import sait.frms.manager.ReservationManager;
import sait.frms.manager.ReservationManager;
import sait.frms.problemdomain.Reservation;

/**
 * Holds the components for the Reservations tab.
 * 
 */
public class ReservationsTab extends TabBase 
{
	/**
	 * Instance of Reservation manager.
	 */
	private ReservationManager ReservationManager;
	
	/**
	 * Instance of reservation manager.
	 */
	private ReservationManager reservationManager;
	
	/**
	 * List of Reservations.
	 */
	private JList<Reservation> ReservationsList;
	
	private DefaultListModel<Reservation> ReservationsModel;
	
	/**
	 * Creates the components for Reservations tab.
	 */
	/**
	 * Creates the components for Reservations tab.
	 * 
	 * @param ReservationManager Instance of ReservationManager.
	 * @param reservationManager Instance of ReservationManager
	 */
	
	public ReservationsTab(ReservationManager reservationManager) {
		this.reservationManager = reservationManager;
		
		panel.setLayout(new BorderLayout());
		
		JPanel northPanel = createNorthPanel();
		panel.add(northPanel, BorderLayout.NORTH);
		
		JPanel centerPanel = createCenterPanel();
		panel.add(centerPanel, BorderLayout.CENTER);
		
		JPanel southPanel = createSouthPanel();
		panel.add(southPanel,BorderLayout.SOUTH);
		
		JPanel eastPanel = createEastPanel();
		panel.add(eastPanel,BorderLayout.EAST);
	}
	
	/**
	 * Creates the north panel.
	 * @return JPanel that goes in north.
	 */
	private JPanel createNorthPanel() 
	{
		JPanel panel = new JPanel();
		
		JLabel title = new JLabel("Reservations", SwingConstants.CENTER);
		title.setFont(new Font("serif", Font.PLAIN, 29));
		panel.add(title);
		
		return panel;
	}
	
	/**
	 * Creates the center panel.
	 * @return JPanel that goes in center.
	 */
	private JPanel createCenterPanel() 
	{
		JPanel panel = new JPanel();
		
		panel.setLayout(new BorderLayout());
		
		ReservationsModel = new DefaultListModel<>();
		ReservationsList = new JList<>(ReservationsModel);
		
		// User can only select one item at a time.
		ReservationsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		// Wrap JList in JScrollPane so it is scrollable.
		JScrollPane scrollPane = new JScrollPane(this.ReservationsList);
		
		ReservationsList.addListSelectionListener(new MyListSelectionListener());
		
		panel.add(scrollPane);
		
		return panel;
	}
	
	//create south panel
	private JPanel createSouthPanel() {
		JPanel masterPanel = new JPanel();
		masterPanel.setLayout(new BorderLayout());
		
		JPanel titlePanel = new JPanel();
		JPanel inputPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		
		//Title Panel
		
		JLabel title = new JLabel("Search", SwingConstants.CENTER);
		title.setFont(new Font("serif", Font.PLAIN, 29));
		titlePanel.add(title);
		
		//Input Panel
		
		inputPanel.setLayout(new GridLayout(3,2));
		JLabel codeLabel = new JLabel("Code:");
		JLabel airlineLabel = new JLabel("Airline:");
		JLabel nameLabel = new JLabel("Name:");

		JTextField codeTextField = new JTextField();
		JTextField airlineTextField = new JTextField();
		JTextField nameTextField = new JTextField();
		
		//Button Panel
		
		buttonPanel.setLayout(new GridLayout(1,1));
		JButton findReservationButton = new JButton("Find Reservations");
		buttonPanel.add(findReservationButton);
		
		inputPanel.add(codeLabel);
		inputPanel.add(codeTextField);
		
		inputPanel.add(airlineLabel);
		inputPanel.add(airlineTextField);
		
		inputPanel.add(nameLabel);
		inputPanel.add(nameTextField);
		
		masterPanel.add(titlePanel, BorderLayout.NORTH);
		masterPanel.add(inputPanel, BorderLayout.CENTER);
		masterPanel.add(buttonPanel, BorderLayout.SOUTH);
		
		
		
		return masterPanel;
	}
	//create East Panel
	private JPanel createEastPanel() {
		JPanel masterPanel = new JPanel();
		masterPanel.setLayout(new BorderLayout());
		
		JPanel titlePanel = new JPanel();
		JPanel inputPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		
		//Title Panel
		titlePanel.setLayout(new GridLayout(2,1));
		JLabel title = new JLabel("Reserve", SwingConstants.CENTER);
		title.setFont(new Font("serif", Font.PLAIN, 29));
		titlePanel.add(title);
		
		//Input Panel
		
		inputPanel.setLayout(new GridLayout(8,2));
		JLabel codeLabel = new JLabel("Code:");
		JLabel flightLabel = new JLabel("Flight:");
		JLabel airlineLabel = new JLabel("Airline:");
		JLabel costLabel = new JLabel("Cost:");
		JLabel nameLabel = new JLabel("Name:");
		JLabel citizenshipLabel = new JLabel("Citizenship:");
		JLabel statusLabel = new JLabel("Status:");

		String[] statusOptions = {"Active","Inactive"};
		
		JTextField codeTextField = new JTextField();
		codeTextField.setEditable(false);
		JTextField flightTextField = new JTextField();
		flightTextField.setEditable(false);
		JTextField airlineTextField = new JTextField();
		airlineTextField.setEditable(false);
		JTextField costTextField = new JTextField();
		costTextField.setEditable(false);
		JTextField nameTextField = new JTextField();
		JTextField citizenshipTextField = new JTextField();
		JComboBox statusComboBox = new JComboBox(statusOptions);

		
		//Button Panel
		
		buttonPanel.setLayout(new GridLayout(1,1));
		JButton updateButton = new JButton("Update");
		buttonPanel.add(updateButton);
		
		inputPanel.add(codeLabel);
		inputPanel.add(codeTextField);
		inputPanel.add(flightLabel);
		inputPanel.add(flightTextField);
		inputPanel.add(airlineLabel);
		inputPanel.add(airlineTextField);
		inputPanel.add(costLabel);
		inputPanel.add(costTextField);
		inputPanel.add(nameLabel);
		inputPanel.add(nameTextField);
		inputPanel.add(citizenshipLabel);
		inputPanel.add(citizenshipTextField);
		inputPanel.add(statusLabel);
		inputPanel.add(statusComboBox);
		
		
		masterPanel.add(titlePanel, BorderLayout.NORTH);
		masterPanel.add(inputPanel, BorderLayout.CENTER);
		masterPanel.add(buttonPanel, BorderLayout.SOUTH);
		
		
		
		return masterPanel;
	}
	
	private class MyListSelectionListener implements ListSelectionListener 
	{
		/**
		 * Called when user selects an item in the JList.
		 */
		@Override
		public void valueChanged(ListSelectionEvent e) {
			
		}
		
	}
}