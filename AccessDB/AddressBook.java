
package AccessDB;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.*;

import javax.swing.*;

public class AddressBook extends JFrame implements ActionListener
{
	
	public static int WIDTH = 900;
	public static int HEIGHT = 700;
	
	public static int boxHeight = 50;
	public static int boxWidth = 50;
	
	public static int buttonHeight = 50;
	public static int buttonWidth = 50;
	
	static JTextField FirstName, LastName, MiddleInitial, StreetNumber, StreetName, City, State, ZipCode, PhoneNumber, Email  ;
	static String firstname, lastname, middleinitial, streetname, streetnumber, city, state, zipcode, phonenumber, email;
		
	static JButton newButton = new JButton("New");
	static JButton saveButton = new JButton("Save");
	static JButton deleteButton = new JButton("Delete");
	static JButton searchButton = new JButton("Search");
	static JButton printButton = new JButton("Print");
	static JButton clearButton = new JButton("Clear");
	static JButton updateButton = new JButton("Update");
	
	static JPanel EntryPanel = new JPanel();
	
	static JOptionPane message = new JOptionPane();
	
	static Container contentPane;
	
	
	
	// Create the Gui
	
	public AddressBook()
	{
		// Build the GUI framework ​
		
				setSize(WIDTH, HEIGHT);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
				
				 contentPane = getContentPane();
				
				contentPane.setLayout(new BorderLayout());
				
				
			// Creating a panel for GUI features​
			JPanel WestPanel = new JPanel();
			
					WestPanel.setLayout(new FlowLayout());
					//WestPanel.setPreferredSize(new Dimension(800,100));
				
				
			JPanel inputPanel = new JPanel(); // inputs are placed on them. 
			
				inputPanel.setLayout (new FlowLayout());
				
				inputPanel.setPreferredSize(new Dimension(100,800));
				
			JPanel buttonPanel = new JPanel();
			
				buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
				
				
				
			// Creating J text fields to insert text on GUI​
			JLabel FirstNameLable = new JLabel("First Name:");
			 inputPanel.add(FirstNameLable);
			
				 FirstName = new JTextField(5);
					FirstName.getFont();
					FirstName.setBounds(20, 25, boxWidth, boxHeight);
				inputPanel.add(FirstName);
				
				
				
			JLabel LastNameLable = new JLabel("Last Name:");
				inputPanel.add(LastNameLable);
				
				 LastName = new JTextField(5);
				LastName.getFont();
				LastName.setBounds(50, 150, boxWidth, boxHeight);
				inputPanel.add(LastName);
				
				
			JLabel MiddleInitialLable = new JLabel("Middle Initial:");
				inputPanel.add(MiddleInitialLable);
				
				 MiddleInitial = new JTextField(5);
				MiddleInitial.getFont();
				MiddleInitial.setBounds(50, 250, boxWidth, boxHeight);
				inputPanel.add(MiddleInitial);
				
				
			JLabel StreetNumberLable = new JLabel("Street Number:");
				inputPanel.add(StreetNumberLable);
			
				 StreetNumber = new JTextField(5);
				StreetNumber.getFont();
				StreetNumber.setBounds(50, 350, boxWidth, boxHeight);
				inputPanel.add(StreetNumber);
				
			JLabel StreetNameLable = new JLabel("Street Name:");
				inputPanel.add(StreetNameLable);
			
				 StreetName = new JTextField(5);
				StreetName.getFont();
				StreetName.setBounds(50, 450, boxWidth, boxHeight);
				inputPanel.add(StreetName);
				
				
			JLabel CityLable = new JLabel("City   :");
				 inputPanel.add(CityLable);
				 
				  City = new JTextField(5);
					City.getFont();
					City.setBounds(50, 550, boxWidth, boxHeight);
				 inputPanel.add(City);
				 
				 
		    JLabel StateLable = new JLabel("State:");
		    		inputPanel.add(StateLable);
		    		
		    	  State = new JTextField(5);
		    	 	State.getFont();
					State.setBounds(50, 650, boxWidth, boxHeight);
				 inputPanel.add(State);
				 
				 
			JLabel ZipCodeLable = new JLabel("ZipCode:");
		    		inputPanel.add(ZipCodeLable);
		    		
		    	  ZipCode = new JTextField(5);
		    	 	ZipCode.getFont();
					ZipCode.setBounds(50, 750, boxWidth, boxHeight);
				 inputPanel.add(ZipCode);
				 
				 
			JLabel PhoneNumberLable = new JLabel("PhoneNumber:");
		    		inputPanel.add(PhoneNumberLable);
		    		
		    	  PhoneNumber = new JTextField(5);
		    	 	PhoneNumber.getFont();
		    	 	PhoneNumber.setBounds(50, 850, boxWidth, boxHeight);
				 inputPanel.add(PhoneNumber);
				 
				 
			 JLabel EmailLable = new JLabel("Email:");
		    		inputPanel.add(EmailLable);
		    		
		    	  Email = new JTextField(5);
		    	 	Email.getFont();
					Email.setBounds(50, 950, boxWidth, boxHeight);
				 inputPanel.add(Email);
				 
				
					newButton.getFont();
					newButton.setBounds(100, 250, buttonWidth, buttonHeight);
					buttonPanel.add(newButton);
					newButton.addActionListener(this);
					
					
					saveButton.getFont();
					saveButton.setBounds(100, 250, buttonWidth, buttonHeight);
					buttonPanel.add(saveButton);
					saveButton.addActionListener(this);
					
					
					deleteButton.getFont();
					deleteButton.setBounds(100, 250, buttonWidth, buttonHeight);
					buttonPanel.add(deleteButton);
					deleteButton.addActionListener(this);
					
					
					searchButton.getFont();
					searchButton.setBounds(100, 250, buttonWidth, buttonHeight);
					buttonPanel.add(searchButton);
					searchButton.addActionListener(this);
					
					
					printButton.getFont();
					printButton.setBounds(100, 250, buttonWidth, buttonHeight);
					buttonPanel.add(printButton);
					printButton.addActionListener(this);
					
					clearButton.getFont();
					clearButton.setBounds(100, 250, buttonWidth, buttonHeight);
					buttonPanel.add(clearButton);
					clearButton.addActionListener(this);
					
					updateButton.getFont();
					updateButton.setBounds(100, 250, buttonWidth, buttonHeight);
					buttonPanel.add(updateButton);
					updateButton.addActionListener(this);
				 
				 
				
				WestPanel.add(inputPanel);
				
				WestPanel.add(buttonPanel);
				
				//contentPane.add(WestPanel);
				contentPane.add(WestPanel, BorderLayout.WEST);
		
	}
	
	
	public static void main(String[] args)
	{
		AddressBook gui = new AddressBook();
		gui.setVisible(true);
		
		try
		{
			// Connection to database using driver
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			
				//Connecting to AddressBook Database
			
			 	String url = "jdbc:ucanaccess://C:/Users/dalla/OneDrive/Documents/AddressBook.accdb";
				
			 		Connection con = DriverManager.getConnection(url);

		}
		
		catch(SQLException exception)
		{
			exception.getMessage();
		}
		
		 catch(ClassNotFoundException cnfex) {

	          System.out.println("Problem in loading or "
	                  + "registering MS Access JDBC driver");
	          cnfex.printStackTrace();
	      }

	

	newButton.addActionListener(new ActionListener()	 //Clear database
			{
		
		
	public void actionPerformed(ActionEvent New) 
	{
		// Pop up message
		
		 String name = JOptionPane.showInputDialog("New Successful");
			JOptionPane.showMessageDialog(contentPane, "New Command",  
	                "New Successful", JOptionPane.ERROR_MESSAGE); 
		
			try
			{
				// Connection to database using driver
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				
					//Connecting to AddressBook Database
				
				 	String url = "jdbc:ucanaccess://C:/Users/dalla/OneDrive/Documents/AddressBook.accdb";
					
				 		Connection con = DriverManager.getConnection(url);	
				 		
				 	Statement deletePeople = con.prepareStatement("DELETE * FROM People " );
						
					Statement deleteAddress = con.prepareStatement("DELETE * FROM Address " );
						
					Statement deletePhone = con.prepareStatement("DELETE * FROM PhoneNumber " );
						
					Statement deleteEmail = con.prepareStatement("DELETE * FROM Email " );
						
						((PreparedStatement) deleteAddress).executeUpdate();
						((PreparedStatement) deletePhone).executeUpdate();
						((PreparedStatement) deleteEmail).executeUpdate();
						((PreparedStatement) deletePeople).executeUpdate();
				 		
				deleteAddress.close();
				deletePeople.close();
				deleteEmail.close();
				deletePhone.close();
			 	con.close();
		        
	        System.out.println("Executed to Database");
	        
			}
			
		catch(SQLException exception)
		{
			exception.getMessage();
		}
		
		 catch(ClassNotFoundException cnfex)
		{

	          System.out.println("Problem in loading or "
	                  + "registering MS Access JDBC driver");
	          cnfex.printStackTrace();
	     }
			
		}
	});	
		
	
	
	saveButton.addActionListener(new ActionListener()	 
	 	{
			
		
		public void actionPerformed(ActionEvent Save) 
		{	
			 String name = JOptionPane.showInputDialog("Save Successful");
				JOptionPane.showMessageDialog(contentPane, "Save Command",  
		                "Save Successful", JOptionPane.ERROR_MESSAGE); 
				try
				{
					// Connection to database using driver
					 		 
					 	// save values from text fields
					 		 
					 		firstname = FirstName.getText();
					 		lastname = LastName.getText();
					 		middleinitial = MiddleInitial.getText();
					 		streetname = StreetName.getText();
					 		streetnumber = StreetNumber.getText();
					 		city = City.getText();
					 		state = State.getText();
					 		zipcode = ZipCode.getText();
					 		phonenumber = PhoneNumber.getText();
					 		email = Email.getText();
					 		
					 	Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
							
							//Connecting to AddressBook Database
						
						 	String url = "jdbc:ucanaccess://C:/Users/dalla/OneDrive/Documents/AddressBook.accdb";
							
						 		Connection con = DriverManager.getConnection(url);	
						 		
						 	// Inserting to database
						 		
						 		 Statement statement = con.createStatement();
					 		
					 statement.executeUpdate("INSERT INTO People (FirstName, LastName, MiddleInitial) VALUES ('"+firstname+"','"+lastname+"','"+middleinitial+"')");
			 		
			 		ResultSet resultSet = statement.executeQuery("SELECT ContactID FROM People WHERE FirstName = '"+ firstname +  "' AND LastName = '" + lastname+"'");
			 		
			 			
			 			int contactID = 0;
			 			
			 			while(resultSet.next())
			 				contactID = resultSet.getInt("ContactID");
			 			 

			 			statement.executeUpdate("INSERT INTO Address(ContactID, StreetName, StreetNumber, City, State, ZipCode) VALUES ('"+contactID+"','"+streetname+"','"+streetnumber+"','"+city+"','"+state+"','"+zipcode+"')");
			 			statement.executeUpdate("INSERT INTO PhoneNumber (ContactID, PhoneNumber) VALUES ('"+contactID+"','"+phonenumber+"')");
			 			statement.executeUpdate("INSERT INTO Email (ContactID, EmailAddress) VALUES ('"+contactID+"','"+email+"')");
					 		
					 	statement.close();
					 	con.close();
					 		System.out.println("Executed to Database");				
				}
				
				catch(SQLException exception)
				{
					exception.getMessage();
				}
				
				 catch(ClassNotFoundException cnfex)
				{

			          System.out.println("Problem in loading or "
			                  + "registering MS Access JDBC driver");
			          cnfex.printStackTrace();
			      }
				
				
		 	}
	 	});
	
	updateButton.addActionListener(new ActionListener()	 
 	{
		
	
	public void actionPerformed(ActionEvent Update) 
	{	
		 String name = JOptionPane.showInputDialog("Update Successful");
			JOptionPane.showMessageDialog(contentPane, "Update Command",  
	                "Update Successful", JOptionPane.ERROR_MESSAGE); 
			try
			{
				// Connection to database using driver
				 		 
				 	// save values from text fields
				 		 
				 		firstname = FirstName.getText();
				 		lastname = LastName.getText();
				 		middleinitial = MiddleInitial.getText();
				 		streetname = StreetName.getText();
				 		streetnumber = StreetNumber.getText();
				 		city = City.getText();
				 		state = State.getText();
				 		zipcode = ZipCode.getText();
				 		phonenumber = PhoneNumber.getText();
				 		email = Email.getText();
				 		
				 		String firstName = firstname;
				 		String lastName = lastname;
				 		String middleInitial = middleinitial;
				 		String streetName = streetname ;
				 		String streetNumber = streetnumber;
				 		String City = city;
				 		String State = state;
				 		String zipCode = zipcode;
				 		String phoneNumber = phonenumber;
				 		String Email = email;
				 		
				 	Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
						
						//Connecting to AddressBook Database
					
					 	String url = "jdbc:ucanaccess://C:/Users/dalla/OneDrive/Documents/AddressBook.accdb";
						
					 		Connection con = DriverManager.getConnection(url);	
					 		
					 	// Inserting to database
					 		
					 		 Statement statement = con.createStatement();
					 		 
					 		 System.out.println("Made it this far");
					 		 
					 		String query =
									"SELECT * "
									+ "FROM "
									+ "((People INNER JOIN PhoneNumber ON People.ContactID = PhoneNumber.ContactID) "
									+ "INNER JOIN Email ON People.ContactID = Email.ContactID) "
									+ "INNER JOIN Address ON People.ContactID = Address.ContactID "
									+ "WHERE FirstName = '" + name + "'";
					 		
					 		ResultSet resultSet= statement.executeQuery(query);
							resultSet.next();
				 		
							System.out.println("Made it this much futher");
		 		
		 			int contactID = 0;
		 			
		 			ResultSet resultSet2 = statement.executeQuery("SELECT ContactID FROM People WHERE FirstName = '"+ firstname +  "' AND LastName = '" + lastname+"'");
		 			
		 			while(resultSet2.next())
						contactID = resultSet2.getInt("ContactID"); // Obtain contactID from email entered 
		 			
		 			System.out.println("Contact ID " + contactID);
		 			
		 			Statement updatePeople = con.prepareStatement("UPDATE People SET FirstName = ?, LastName = ?, MiddleInitial =?  WHERE ContactID = ?" );
					Statement updateAddress = con.prepareStatement("UPDATE Address SET StreetName = ?, StreetNumber = ?, City = ?, State = ?, ZipCode = ? WHERE  ContactID = ?" );
					Statement updatePhone = con.prepareStatement("UPDATE PhoneNumber SET PhoneNumber = ? WHERE ContactID = ?" );
					Statement updateEmail = con.prepareStatement("UPDATE Email SET EmailAddress = ? WHERE ContactID = ?"  );
					
					System.out.println("Hello 1");
					
					((PreparedStatement) updateAddress).setString(1, streetName);
					((PreparedStatement) updateAddress).setString(2, streetNumber);
					((PreparedStatement) updateAddress).setString(3, City);
					((PreparedStatement) updateAddress).setString(4, State);
					((PreparedStatement) updateAddress).setString(5, zipCode);
					((PreparedStatement) updateAddress).setInt(6, contactID );
					
					((PreparedStatement) updatePeople).setString(1, firstName);
					((PreparedStatement) updatePeople).setString(2, lastName);
					((PreparedStatement) updatePeople).setString(3, middleInitial);
					((PreparedStatement) updatePeople).setInt(4, contactID);

					
					((PreparedStatement) updateEmail).setString(1, Email);
					((PreparedStatement) updateEmail).setInt(2, contactID);

					
					((PreparedStatement) updatePhone).setString(1, phoneNumber);
					((PreparedStatement) updatePhone).setInt(2, contactID);
					
					((PreparedStatement) updateAddress).executeUpdate();
					((PreparedStatement) updatePhone).executeUpdate();
					((PreparedStatement) updateEmail).executeUpdate();
					((PreparedStatement) updatePeople).executeUpdate();
					
					
				 	statement.close();
				 	con.close();
				 		System.out.println("Executed to Database");				
			}
			
			catch(SQLException exception)
			{
				exception.getMessage();
			}
			
			 catch(ClassNotFoundException cnfex)
			{

		          System.out.println("Problem in loading or "
		                  + "registering MS Access JDBC driver");
		          cnfex.printStackTrace();
		      }
			
			
	 	}
 	});
		
		deleteButton.addActionListener(new ActionListener()	 
	 	{
			
		 public void actionPerformed(ActionEvent Delete) 
		 {
			 String email1 = JOptionPane.showInputDialog("Delete Successful");
				JOptionPane.showMessageDialog(contentPane, "Delete Command",  
		                "Delete Successful", JOptionPane.ERROR_MESSAGE); 
				System.out.println("Email" + email1);
			 ; 
			 
			 if(Delete.getActionCommand().contentEquals("Delete"))
			 {
				 try {
					 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
						String url = "jdbc:ucanaccess://C:/Users/dalla/OneDrive/Documents/AddressBook.accdb";
						Connection con = DriverManager.getConnection(url);	
												
						Statement statement = con.createStatement();
						
						String query =
								"SELECT ContactID "
								+ "FROM "
								+ "((People INNER JOIN PhoneNumber ON People.ContactID = PhoneNumber.ContactID) "
								+ "INNER JOIN Email ON People.ContactID = Email.ContactID) "
								+ "INNER JOIN Address ON People.ContactID = Address.ContactID "
								+ "WHERE EmailAddress  = '" + email1 + "'";
						
						int contactID = 0;
						
						ResultSet resultSet = statement.executeQuery(query);
						
						while(resultSet.next())
							contactID = resultSet.getInt("ContactID"); // Obtain contactID from email entered 
						
						System.out.println(contactID);
						
						int emailID = 0;
						
						ResultSet resultSet2 = statement.executeQuery("SELECT emailID FROM Email WHERE ContactID = '"+ contactID +"'");
						
						while(resultSet2.next())
							emailID = resultSet2.getInt("EmailID"); // Obtain emailID from email entered 
						
						System.out.println(emailID);
					
						
						Statement deletePeople = con.prepareStatement("DELETE FROM People WHERE ContactID = ?" );
						
						Statement deleteAddress = con.prepareStatement("DELETE FROM Address WHERE ContactID = ?" );
						
						Statement deletePhone = con.prepareStatement("DELETE FROM PhoneNumber WHERE ContactID = ?" );
						
						Statement deleteEmail = con.prepareStatement("DELETE FROM Email WHERE ContactID = ?" );
						
						((PreparedStatement) deleteAddress).setInt(1, contactID);
						((PreparedStatement) deletePhone).setInt(1, contactID);
						((PreparedStatement) deleteEmail).setInt(1, contactID);
						((PreparedStatement) deletePeople).setInt(1, contactID);
						
						((PreparedStatement) deleteAddress).executeUpdate();
						((PreparedStatement) deletePhone).executeUpdate();
						((PreparedStatement) deleteEmail).executeUpdate();
						((PreparedStatement) deletePeople).executeUpdate();
						
						deletePeople.close();
						deleteAddress.close();
						deletePhone.close();
						deleteEmail.close();
								statement.close();
							 	con.close();
					
						System.out.println("Delete executed");
						

							JOptionPane.showMessageDialog(contentPane, "Delete Command",  
					                "Delete Successful", JOptionPane.ERROR_MESSAGE);
					 
				 	}
				 
				 catch(Exception e)
				 {
					 System.out.println(e);
						
						JOptionPane.showMessageDialog(contentPane, "Delete Command",  
				                "Delete Failed", JOptionPane.ERROR_MESSAGE);
				 }
			 }
			 
		  }

	
		 });

		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent Search) {				
				String name = JOptionPane.showInputDialog("Search Successful");
				System.out.println("Name: " + name);
				
				if (Search.getActionCommand().contentEquals("Search")) {
					try {
						Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
						String url = "jdbc:ucanaccess://C:/Users/dalla/OneDrive/Documents/AddressBook.accdb";
						Connection con = DriverManager.getConnection(url);	
												
						Statement statement = con.createStatement();
												
						String query =
								"SELECT * "
								+ "FROM "
								+ "((People INNER JOIN PhoneNumber ON People.ContactID = PhoneNumber.ContactID) "
								+ "INNER JOIN Email ON People.ContactID = Email.ContactID) "
								+ "INNER JOIN Address ON People.ContactID = Address.ContactID "
								+ "WHERE FirstName = '" + name + "'";
						 																		
						ResultSet resultSet= statement.executeQuery(query);
						resultSet.next();
						
						
						String firstName = resultSet.getString("FirstName");
						String lastName = resultSet.getString("LastName");
						String middleInitial = resultSet.getString("MiddleInitial");
						String streetNumber = resultSet.getString("StreetNumber");
						String streetName = resultSet.getString("StreetName");
						String city = resultSet.getString("City");
						String state = resultSet.getString("State");
						String zipCode = resultSet.getString("ZipCode");
						String phoneNumber = resultSet.getString("PhoneNumber");
						String email = resultSet.getString("EmailAddress");
						
						FirstName.setText(firstName);
						LastName.setText(lastName);
						MiddleInitial.setText(middleInitial);
						StreetNumber.setText(streetNumber);
						StreetName.setText(streetName);
						City.setText(city);
						State.setText(state);
						ZipCode.setText(zipCode);
						PhoneNumber.setText(phoneNumber);
						Email.setText(email);
						
						JOptionPane.showMessageDialog(contentPane, "Search Command",  
				                "Search Successful", JOptionPane.ERROR_MESSAGE);
						
					} catch (Exception e) {
						System.out.println(e);
						
						JOptionPane.showMessageDialog(contentPane, "Search Command",  
				                "Search Failed", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		
		
		 clearButton.addActionListener(new ActionListener()	 
		 	{
			 
			 
				
		  public void actionPerformed(ActionEvent Clear) 
			 {
			  
			  String name = JOptionPane.showInputDialog("Clear Successful");
				JOptionPane.showMessageDialog(contentPane, "Clear Command",  
		                "Print Successful", JOptionPane.ERROR_MESSAGE); 
				
				
				FirstName.setText(" ");
				LastName.setText(" ");
				MiddleInitial.setText(" ");
				StreetNumber.setText(" ");
				StreetName.setText(" ");
				City.setText(" ");
				State.setText(" ");
				ZipCode.setText(" ");
				PhoneNumber.setText(" ");
				Email.setText(" ");
			  
			}
		
	});
				 
		 printButton.addActionListener(new ActionListener()	 
		 	{
			 
			 
				
		  public void actionPerformed(ActionEvent Print) 
			 {
			  
			  String name = JOptionPane.showInputDialog("Print Successful");
				JOptionPane.showMessageDialog(contentPane, "Print Command",  
		                "Print Successful", JOptionPane.ERROR_MESSAGE); 
				
					if (Print.getActionCommand().contentEquals("Print")) {
						
						try {
							
							Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
							String url = "jdbc:ucanaccess://C:/Users/dalla/OneDrive/Documents/AddressBook.accdb";
							Connection con = DriverManager.getConnection(url);
							
							Statement stmt = con.createStatement();
							
							ResultSet rsAddress = stmt.executeQuery("select * from Address");
							ResultSet rsPeople = stmt.executeQuery("select * from People");
							ResultSet rsEmail = stmt.executeQuery("select * from Email");
							ResultSet rsPhone = stmt.executeQuery("select * from PhoneNumber");
							
							System.out.println("Print Entered");
							
							int count = 0;
							
							while(count < 2)
							{
								
							
							while(rsAddress.next())
							{
								System.out.println(  rsAddress.getString(3) + " " 
										+ rsAddress.getString(4) + " " + rsAddress.getString(5) + " " + rsAddress.getString(6) + " " + rsAddress.getString(7) + " ");
								break;
							}
							
							while(rsPeople.next())
							{
								System.out.println( rsPeople.getString(2) + " " + rsPeople.getString(3) + " " 
										+ rsPeople.getString(4) + " " );
								break;
							}
							
							while(rsEmail.next())
							{
								System.out.println( rsEmail.getString(3) + " ");
								break;
							}
							
							while(rsPhone.next())
							{
								System.out.println(rsPhone.getString(3) + " ");
								break;
							}
								
							}

							System.out.println("Print Executed");
							
							JOptionPane.showMessageDialog(contentPane, "Print Command",  
					                "Print Successful", JOptionPane.ERROR_MESSAGE);
							
						} catch (Exception e) {
							System.out.println(e);
							
							JOptionPane.showMessageDialog(contentPane, "Print Command",  
					                "Print Failed", JOptionPane.ERROR_MESSAGE);
						}
					}
				
				  
			  
			}
		
	});

}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	} 

