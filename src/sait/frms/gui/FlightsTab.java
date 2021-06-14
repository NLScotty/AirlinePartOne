package sait.frms.gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

import sait.frms.manager.FlightManager;
import sait.frms.manager.ReservationManager;
import sait.frms.problemdomain.Flight;

/**
 * Holds the components for the flights tab.
 * 
 */
public class FlightsTab extends TabBase 
{
	/**
	 * Instance of flight manager.
	 */
	private FlightManager flightManager;
	
	/**
	 * Instance of reservation manager.
	 */
	private ReservationManager reservationManager;
	
	/**
	 * List of flights.
	 */
	private JList<Flight> flightsList;
	
	private DefaultListModel<Flight> flightsModel;
	
	/**
	 * Creates the components for flights tab.
	 */
	/**
	 * Creates the components for flights tab.
	 * 
	 * @param flightManager Instance of FlightManager.
	 * @param reservationManager Instance of ReservationManager
	 */
	public FlightsTab(FlightManager flightManager, ReservationManager reservationManager) {
		this.flightManager = flightManager;
		this.reservationManager = reservationManager;
		
		panel.setLayout(new BorderLayout());
		
		JPanel northPanel = createNorthPanel();
		panel.add(northPanel, BorderLayout.NORTH);
		
		JPanel centerPanel = createCenterPanel();
		panel.add(centerPanel, BorderLayout.CENTER);
		
		JPanel southPanel = createSouthPanel();
		panel.add(southPanel,BorderLayout.SOUTH);
		
		JPanel eastPanel = createEastPanel();
		panel.add(eastPanel, BorderLayout.EAST);
	}
	
	/**
	 * Creates the north panel.
	 * @return JPanel that goes in north.
	 */
	private JPanel createNorthPanel() 
	{
		JPanel panel = new JPanel();
		
		JLabel title = new JLabel("Flights", SwingConstants.CENTER);
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
		
		flightsModel = new DefaultListModel<>();
		flightsList = new JList<>(flightsModel);
		
		// User can only select one item at a time.
		flightsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		// Wrap JList in JScrollPane so it is scrollable.
		JScrollPane scrollPane = new JScrollPane(this.flightsList);
		
		flightsList.addListSelectionListener(new MyListSelectionListener());
		
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
		
		JLabel title = new JLabel("Flight Finder", SwingConstants.CENTER);
		title.setFont(new Font("serif", Font.PLAIN, 29));
		titlePanel.add(title);
		
		//Input Panel
		
		inputPanel.setLayout(new GridLayout(3,2));
		JLabel fromLabel = new JLabel("From:");
		JLabel toLabel = new JLabel("To:");
		JLabel dayLabel = new JLabel("Day:");
		String[] values1 = {"YYC"};
		String[] values2 = {"Any"};
		JComboBox fromBox = new JComboBox(values1);
		JComboBox toBox = new JComboBox(values1);
		JComboBox dayBox = new JComboBox(values2);
		
		//Button Panel
		
		buttonPanel.setLayout(new GridLayout(1,1));
		JButton findFlightButton = new JButton("Find Flights");
		buttonPanel.add(findFlightButton);
		
		inputPanel.add(fromLabel);
		inputPanel.add(fromBox);
		
		inputPanel.add(toLabel);
		inputPanel.add(toBox);
		
		inputPanel.add(dayLabel);
		inputPanel.add(dayBox);
		
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
		JLabel flightLabel = new JLabel("Flight:");
		JLabel airlineLabel = new JLabel("Airline:");
		JLabel dayLabel = new JLabel("Day:");
		JLabel timeLabel = new JLabel("Time:");
		JLabel costLabel = new JLabel("Cost:");
		JLabel nameLabel = new JLabel("Name:");
		JLabel citizenshipLabel = new JLabel("Citizenship:");
		
		JTextField flightTextField = new JTextField();
		flightTextField.setEditable(false);
		JTextField airlineTextField = new JTextField();
		airlineTextField.setEditable(false);
		JTextField dayTextField = new JTextField();
		dayTextField.setEditable(false);
		JTextField timeTextField = new JTextField();
		timeTextField.setEditable(false);
		JTextField costTextField = new JTextField();
		costTextField.setEditable(false);
		JTextField nameTextField = new JTextField();
		JTextField citizenshipTextField = new JTextField();

		
		//Button Panel
		
		buttonPanel.setLayout(new GridLayout(1,1));
		JButton reserveButton = new JButton("Reserve");
		buttonPanel.add(reserveButton);
		
		inputPanel.add(flightLabel);
		inputPanel.add(flightTextField);
		inputPanel.add(airlineLabel);
		inputPanel.add(airlineTextField);
		inputPanel.add(dayLabel);
		inputPanel.add(dayTextField);
		inputPanel.add(timeLabel);
		inputPanel.add(timeTextField);
		inputPanel.add(costLabel);
		inputPanel.add(costTextField);
		inputPanel.add(nameLabel);
		inputPanel.add(nameTextField);
		inputPanel.add(citizenshipLabel);
		inputPanel.add(citizenshipTextField);
		
		
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