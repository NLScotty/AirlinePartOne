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