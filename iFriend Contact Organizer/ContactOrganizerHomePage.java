import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

class ContactOrganizerHomePage extends JFrame{
	public static int contactID=1;
	
	private AddContactForm addContactForm;
	private UpdateContactForm updateContactForm;
	private SearchContactForm searchContactForm;
	private DeleteContactForm deleteContactForm;
	private ViewContactForm viewContactForm;
	 
	private JButton btnAddContact;	
	private JButton btnUpdateContact;	
	private JButton btnSearchContact;	
	private JButton btnDeleteContact;	
	private JButton btnViewContact;	
	private JButton btnExit;
	
	private JLabel AppTitle1;
	private JLabel AppTitle2;
	private JLabel HomeTitle;
	private JLabel imgLabel;
	private JLabel emptyLabel1=new JLabel(" ");
	private JLabel emptyLabel2=new JLabel(" ");
	
	ContactOrganizerHomePage(){
		setTitle("iFriend Contact Manager");
		setSize(900,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel titlePanel=new JPanel(new GridLayout(2,1));
		
		AppTitle1=new JLabel("iFRIEND");
		AppTitle1.setHorizontalAlignment(JLabel.CENTER);
		AppTitle1.setFont(new Font("",1,40));
		
		AppTitle2=new JLabel("Contact Organizer");
		AppTitle2.setHorizontalAlignment(JLabel.CENTER);
		AppTitle2.setFont(new Font("",1,40));
		
		titlePanel.add(AppTitle1);
		titlePanel.add(AppTitle2);
		titlePanel.setBackground(Color.WHITE);
		
		JPanel leftPanel=new JPanel(new BorderLayout());
		leftPanel.setBackground(Color.WHITE);
		leftPanel.add("North",titlePanel);
		
		JLabel imgLabel = new JLabel(new ImageIcon("img/HomePage_img.png"));
		leftPanel.add("South",imgLabel);
		
		JPanel rightPanel=new JPanel(new BorderLayout());
		rightPanel.setBackground(new Color(153,205,253));
		
		JPanel homePanel=new JPanel(new GridLayout(3,1));
		homePanel.setBackground(new Color(153,205,253));
		homePanel.add(emptyLabel1);
		HomeTitle=new JLabel("Home Page");
		HomeTitle.setHorizontalAlignment(JLabel.CENTER);
		HomeTitle.setFont(new Font("",3,35));
		homePanel.add(HomeTitle);
		
		rightPanel.add("North",homePanel);

		JPanel buttonPanel=new JPanel(new FlowLayout());
		buttonPanel.setBackground(new Color(153,205,253));

		JPanel rightPanelCenter=new JPanel(new GridLayout(5,1,30,30));
		rightPanelCenter.setBackground(new Color(153,205,253));
		
		
			//================================ADD CONTACTS====================================
		
		btnAddContact=new JButton("                      Add New Contact                      ");
		btnAddContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				setVisible(false);
				if(addContactForm==null){
					addContactForm=new AddContactForm();
				}
				addContactForm.setVisible(true);
			}
		});
		btnAddContact.setFont(new Font("",1,18));
		rightPanelCenter.add(btnAddContact);
		
		
			//================================UPDATE CONTACTS====================================
		
		btnUpdateContact=new JButton("Update Contact");
		btnUpdateContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				setVisible(false);
				if(updateContactForm==null){
					updateContactForm=new UpdateContactForm();
				}
				updateContactForm.setVisible(true);
			}
		});
		btnUpdateContact.setFont(new Font("",1,18));
		rightPanelCenter.add(btnUpdateContact);
		
		
			//================================SEARCH CONTACTS====================================
		
		btnSearchContact=new JButton("Search Contact");
		btnSearchContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				setVisible(false);
				if(searchContactForm==null){
					searchContactForm=new SearchContactForm();
				}
				searchContactForm.setVisible(true);
			}
		});
		btnSearchContact.setFont(new Font("",1,18));
		rightPanelCenter.add(btnSearchContact);
		
		
			//================================DELETE CONTACTS====================================
		
		btnDeleteContact=new JButton("Delete Contact");
		btnDeleteContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				setVisible(false);
				if(deleteContactForm==null){
					deleteContactForm=new DeleteContactForm();
				}
				deleteContactForm.setVisible(true);
			}
		});
		btnDeleteContact.setFont(new Font("",1,18));
		rightPanelCenter.add(btnDeleteContact);
		
		
			//================================VIEW CONTACTS====================================
		
		btnViewContact=new JButton("View Contact");
		btnViewContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				setVisible(false);
				if(viewContactForm==null){
					viewContactForm=new ViewContactForm();
				}
				viewContactForm.setVisible(true);
			}
		});
		btnViewContact.setFont(new Font("",1,18));
		rightPanelCenter.add(btnViewContact);
			
				 
		buttonPanel.add("Center",rightPanelCenter);
		rightPanel.add("Center",buttonPanel);
		
		
			//================================EXIT====================================
		
		JPanel exitPanel=new JPanel(new GridLayout(3,2));
		exitPanel.setBackground(new Color(153,205,253));
		exitPanel.add(emptyLabel2);
		
		btnExit=new JButton("Exit");
		btnExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("",1,18));
		exitPanel.add(btnExit);
		
		
		JPanel exitPanelFlow=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		exitPanelFlow.setBackground(new Color(153,205,253));
		exitPanelFlow.add(exitPanel);
		
		rightPanel.add("South",exitPanelFlow);
		
		add("West",leftPanel);
		add("Center",rightPanel);		
	}
	
	public static void main(String args[]){
		new ContactOrganizerHomePage().setVisible(true);
	}
}
