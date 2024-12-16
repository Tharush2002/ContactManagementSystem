import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*; 

class ViewContactForm extends JFrame{
	private JLabel titleLabel;
	
	private JButton btnNameList;
	private JButton btnSalaryList;
	private JButton btnBirthDay;
	
	private JButton btnCancel;
	
	private JLabel emptyLabel1=new JLabel(" ");
	private JLabel emptyLabel2=new JLabel(" ");
	private JLabel emptyLabel3=new JLabel(" ");
	
	private ViewContactFormName viewContactFormName;
	private ViewContactFormSalary viewContactFormSalary; 
	private ViewContactFormBirthDay viewContactFormBirthDay;

	ViewContactForm(){
		setSize(400,470);
		setTitle("View Contact Form");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel titlePanel=new JPanel(new GridLayout(3,1));
		titlePanel.setBackground(new Color(153,205,253));
		titlePanel.add(emptyLabel1);
		titleLabel=new JLabel("CONTACTS LIST");
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setFont(new Font("",1,30));
		titlePanel.add(titleLabel);
		
		add("North",titlePanel);
		
		JPanel buttonPanel=new JPanel(new FlowLayout());
		JPanel centerPanel=new JPanel(new GridLayout(4,1,20,20));
		centerPanel.add(emptyLabel2);
		
			//================================LIST CONTACTS BY NAME====================================
		
		btnNameList=new JButton("                 List by Name                 ");
		btnNameList.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				ViewContactForm.this.dispose();
				if(viewContactFormName==null){
					viewContactFormName=new ViewContactFormName();
				}
				viewContactFormName.setVisible(true);
			}
		});
		btnNameList.setFont(new Font("",1,18));
		centerPanel.add(btnNameList);
		
		
			//================================LIST CONTACTS BY SALARY====================================
		
		btnSalaryList=new JButton("List by Salary");
		btnSalaryList.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				ViewContactForm.this.dispose();
				if(viewContactFormSalary==null){
					viewContactFormSalary=new ViewContactFormSalary();
				}
				viewContactFormSalary.setVisible(true);
			}
		});
		btnSalaryList.setFont(new Font("",1,18));
		centerPanel.add(btnSalaryList);
		
		
			//================================LIST CONTACTS BY BIRTHDAY====================================
		
		btnBirthDay=new JButton("List by BirthDay");
		btnBirthDay.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				ViewContactForm.this.dispose();
				if(viewContactFormBirthDay==null){
					viewContactFormBirthDay=new ViewContactFormBirthDay();
				}
				viewContactFormBirthDay.setVisible(true);
			}
		});
		btnBirthDay.setFont(new Font("",1,18));
		centerPanel.add(btnBirthDay);
				
		buttonPanel.add("Center",centerPanel);
		add("Center",buttonPanel);
		
		
			//================================CANCEL====================================
		
		JPanel cancelPanel=new JPanel(new GridLayout(3,1));
		cancelPanel.add(emptyLabel3);
		
		btnCancel=new JButton("   Cancel   ");
		btnCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				ViewContactForm.this.dispose();
				ContactOrganizerHomePage.main(null);
			}
		});
		btnCancel.setFont(new Font("",1,18));
		cancelPanel.add(btnCancel);
		
		JPanel cancelPanelFlow=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		cancelPanelFlow.add(cancelPanel);
		
		add("South",cancelPanelFlow);
	}	
	
	class ViewContactFormName extends JFrame{
		private JTable tblCustomerDetails;
		private DefaultTableModel dtm;

		private JLabel titleLabel;

		private JLabel nameEmptyLabel1=new JLabel(" ");
		private JLabel nameEmptyLabel2=new JLabel("       ");
		private JLabel nameEmptyLabel3=new JLabel("       ");
		private JLabel nameEmptyLabel4=new JLabel(" ");
		private JLabel nameEmptyLabel5=new JLabel(" ");
		
		private JButton btnHome;

		ViewContactFormName(){
			setSize(1000,700);
			setTitle("List Contacts by Name");
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setLocationRelativeTo(null);
			
			JPanel titlePanel=new JPanel(new GridLayout(3,1));
			titlePanel.setBackground(new Color(153,205,253));
			titlePanel.add(nameEmptyLabel1);
			titleLabel=new JLabel("LIST CONTACTS BY NAME");
			titleLabel.setHorizontalAlignment(JLabel.CENTER);
			titleLabel.setFont(new Font("",1,40));
			titlePanel.add(titleLabel);
			
			add("North",titlePanel);
			
			JPanel westPanel=new JPanel(new GridLayout(1,1,1,1));		
			westPanel.add(nameEmptyLabel2);	
			add("West",westPanel);
			
			JPanel eastPanel=new JPanel(new BorderLayout());			
			eastPanel.add(nameEmptyLabel3);	
			add("East",eastPanel);
			
			
			JPanel centerPanel=new JPanel(new BorderLayout());			
			centerPanel.add("North",nameEmptyLabel4);
			
			String[] columnsName={"Customer Id","Name","Number","Company","Salary","BirthDay"};
			dtm=new DefaultTableModel(columnsName,0);
			
			tblCustomerDetails=new JTable(dtm);
			tblCustomerDetails.getTableHeader().setFont( new Font("Arial", Font.BOLD, 22));
			tblCustomerDetails.getTableHeader().setBackground(new Color(207,212,217));
			tblCustomerDetails.setFont(new Font("Arial",Font.BOLD,18));
			tblCustomerDetails.setRowHeight(tblCustomerDetails.getRowHeight()+20);
			
			JScrollPane tablePane=new JScrollPane(tblCustomerDetails);
			
			centerPanel.add("Center",tablePane);
			add("Center",centerPanel);
			
			ContactController.sortName();
			
			for(int i=0; i< ContactDBConnection.getInstance().getContactList().getLength(); i++){
				Contact contact=ContactDBConnection.getInstance().getContactList().getObject(i);
				Object[] rowData={contact.getID(), contact.getName(),contact.getNumber(),contact.getCompany(),contact.getSalary(),contact.getB_day()};
				dtm.addRow(rowData);
			}
			
			JPanel buttonPanel=new JPanel(new GridLayout(2,1,1,1));
			buttonPanel.add(nameEmptyLabel5);
			
			JPanel homePanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
			btnHome=new JButton("         Back To HomePage         ");
			btnHome.setFont(new Font("",1,18));
			btnHome.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					ViewContactFormName.this.dispose();
					ContactOrganizerHomePage.main(null);
				}
			});
			homePanel.add(btnHome);
			buttonPanel.add(homePanel);		
					
			add("South",buttonPanel);			
		}
	}
	
	class ViewContactFormSalary extends JFrame{
		private JTable tblCustomerDetails;
		private DefaultTableModel dtm;

		private JLabel titleLabel;

		private JLabel salaryEmptyLabel1=new JLabel(" ");
		private JLabel salaryEmptyLabel2=new JLabel("       ");
		private JLabel salaryEmptyLabel3=new JLabel("       ");
		private JLabel salaryEmptyLabel4=new JLabel(" ");
		private JLabel salaryEmptyLabel5=new JLabel(" ");
		
		private JButton btnHome;

		ViewContactFormSalary(){
			setSize(1000,700);
			setTitle("List Contacts by Salary");
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setLocationRelativeTo(null);
			
			JPanel titlePanel=new JPanel(new GridLayout(3,1));
			titlePanel.setBackground(new Color(153,205,253));
			titlePanel.add(salaryEmptyLabel1);
			titleLabel=new JLabel("LIST CONTACTS BY SALARY");
			titleLabel.setHorizontalAlignment(JLabel.CENTER);
			titleLabel.setFont(new Font("",1,40));
			titlePanel.add(titleLabel);
			
			add("North",titlePanel);
			
			JPanel westPanel=new JPanel(new GridLayout(1,1,1,1));		
			westPanel.add(salaryEmptyLabel2);	
			add("West",westPanel);
			
			JPanel eastPanel=new JPanel(new BorderLayout());			
			eastPanel.add(salaryEmptyLabel3);	
			add("East",eastPanel);
			
			
			JPanel centerPanel=new JPanel(new BorderLayout());			
			centerPanel.add("North",salaryEmptyLabel4);
			
			
			String[] columnsName={"Customer Id","Name","Number","Company","Salary","BirthDay"};
			dtm=new DefaultTableModel(columnsName,0);
			
			tblCustomerDetails=new JTable(dtm);
			tblCustomerDetails.getTableHeader().setFont( new Font("Arial", Font.BOLD, 22));
			tblCustomerDetails.getTableHeader().setBackground(new Color(207,212,217));
			tblCustomerDetails.setFont(new Font("Arial",Font.BOLD,18));
			tblCustomerDetails.setRowHeight(tblCustomerDetails.getRowHeight()+20);
			
			JScrollPane tablePane=new JScrollPane(tblCustomerDetails);
			
			centerPanel.add("Center",tablePane);
			add("Center",centerPanel);
			
			ContactController.sortSalary();
			
			for(int i=0; i< ContactDBConnection.getInstance().getContactList().getLength(); i++){
				Contact contact=ContactDBConnection.getInstance().getContactList().getObject(i);
				Object[] rowData={contact.getID(), contact.getName(),contact.getNumber(),contact.getCompany(),contact.getSalary(),contact.getB_day()};
				dtm.addRow(rowData);
			}
			
			JPanel buttonPanel=new JPanel(new GridLayout(2,1,1,1));
			buttonPanel.add(salaryEmptyLabel5);
			
			JPanel homePanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
			btnHome=new JButton("         Back To HomePage         ");
			btnHome.setFont(new Font("",1,18));
			btnHome.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					ViewContactFormSalary.this.dispose();
					ContactOrganizerHomePage.main(null);
				}
			});
			homePanel.add(btnHome);
			buttonPanel.add(homePanel);		
					
			add("South",buttonPanel);			
		}
	}
	
	class ViewContactFormBirthDay extends JFrame{
		private JTable tblCustomerDetails;
		private DefaultTableModel dtm;

		private JLabel titleLabel;

		private JLabel birthdayEmptyLabel1=new JLabel(" ");
		private JLabel birthdayEmptyLabel2=new JLabel("       ");
		private JLabel birthdayEmptyLabel3=new JLabel("       ");
		private JLabel birthdayEmptyLabel4=new JLabel(" ");
		private JLabel birthdayEmptyLabel5=new JLabel(" ");
		
		private JButton btnHome;

		ViewContactFormBirthDay(){
			setSize(1000,700);
			setTitle("List Contacts by BirthDay");
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setLocationRelativeTo(null);
			
			JPanel titlePanel=new JPanel(new GridLayout(3,1));
			titlePanel.setBackground(new Color(153,205,253));
			titlePanel.add(birthdayEmptyLabel1);
			titleLabel=new JLabel("LIST CONTACTS BY BIRTHDAY");
			titleLabel.setHorizontalAlignment(JLabel.CENTER);
			titleLabel.setFont(new Font("",1,40));
			titlePanel.add(titleLabel);
			
			add("North",titlePanel);
			
			JPanel westPanel=new JPanel(new GridLayout(1,1,1,1));		
			westPanel.add(birthdayEmptyLabel2);	
			add("West",westPanel);
			
			JPanel eastPanel=new JPanel(new BorderLayout());			
			eastPanel.add(birthdayEmptyLabel3);	
			add("East",eastPanel);
			
			
			JPanel centerPanel=new JPanel(new BorderLayout());			
			centerPanel.add("North",birthdayEmptyLabel4);
			
			String[] columnsName={"Customer Id","Name","Number","Company","Salary","BirthDay"};
			dtm=new DefaultTableModel(columnsName,0);
			
			tblCustomerDetails=new JTable(dtm);
			tblCustomerDetails.getTableHeader().setFont( new Font("Arial", Font.BOLD, 22));
			tblCustomerDetails.getTableHeader().setBackground(new Color(207,212,217));
			tblCustomerDetails.setFont(new Font("Arial",Font.BOLD,18));
			tblCustomerDetails.setRowHeight(tblCustomerDetails.getRowHeight()+20);
			
			JScrollPane tablePane=new JScrollPane(tblCustomerDetails);
			
			centerPanel.add("Center",tablePane);
			add("Center",centerPanel);
			
			ContactController.sortBirthDay();
			
			for(int i=0; i< ContactDBConnection.getInstance().getContactList().getLength(); i++){
				Contact contact=ContactDBConnection.getInstance().getContactList().getObject(i);
				Object[] rowData={contact.getID(), contact.getName(),contact.getNumber(),contact.getCompany(),contact.getSalary(),contact.getB_day()};
				dtm.addRow(rowData);
			}
			
			JPanel buttonPanel=new JPanel(new GridLayout(2,1,1,1));
			buttonPanel.add(birthdayEmptyLabel5);
			
			JPanel homePanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
			btnHome=new JButton("         Back To HomePage         ");
			btnHome.setFont(new Font("",1,18));
			btnHome.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					ViewContactFormBirthDay.this.dispose();
					ContactOrganizerHomePage.main(null);
				}
			});
			homePanel.add(btnHome);
			buttonPanel.add(homePanel);		
					
			add("South",buttonPanel);			
		}
	}
}

