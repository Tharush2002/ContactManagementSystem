import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class AddContactForm extends JFrame{	
	private JLabel titleLabel;
	
	private JButton btnAdd;
	private JButton btnCancel;
	private JButton btnHome;

	private JLabel lblID;
	private JLabel lblName;
	private JLabel lblNumber;
	private JLabel lblCompany;
	private JLabel lblSalary;
	private JLabel lblBirthDay;
	private JLabel emptyLabel1=new JLabel(" ");
	private JLabel emptyLabel2=new JLabel(" ");
	private JLabel emptyLabel3=new JLabel(" ");
	
	private JTextField txtFieldName;
	private JTextField txtFieldNumber;
	private JTextField txtFieldCompany;
	private JTextField txtFieldSalary;
	private JTextField txtFieldBirthDay;
	
	private int contactID=ContactOrganizerHomePage.contactID;
	
	AddContactForm(){
		setSize(500,560);
		setTitle("Add Contact Form");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		String IDstring=String.format("B"+"%04d",contactID);
		
		JPanel titlePanel=new JPanel(new GridLayout(3,1));
		titlePanel.setBackground(new Color(153,205,253));
		titlePanel.add(emptyLabel1);
		titleLabel=new JLabel("ADD CONTACT");
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setFont(new Font("",1,30));
		titlePanel.add(titleLabel);
		
		add("North",titlePanel);
		
		JPanel buttonPanel=new JPanel(new GridLayout(3,1,1,1));
		buttonPanel.add(emptyLabel2);
		
		JPanel buttonPanelTop=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		btnAdd=new JButton("ADD Contact");
		btnAdd.setFont(new Font("",1,18));
		btnAdd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				String id=String.format("B"+"%04d",contactID);
				String name=txtFieldName.getText();
				String number=txtFieldNumber.getText();
				String company=txtFieldCompany.getText();
				double salary=Double.parseDouble(txtFieldSalary.getText());
				String birthday=txtFieldBirthDay.getText();
				Contact contact=new Contact(id,name,number,company,salary,birthday);
				if(ContactController.addContact(contact)==true){
					JOptionPane.showMessageDialog(null, "Contact Number Saved Successfully .....");
					contactID=++ContactOrganizerHomePage.contactID;
					String tempIDstring=String.format("B"+"%04d",contactID);
					lblID.setText("  Contact ID - "+tempIDstring);
				}else{
					JOptionPane.showMessageDialog(null, "Invalid Data .....");
				}
				txtFieldName.setText("");
				txtFieldNumber.setText("");
				txtFieldCompany.setText("");
				txtFieldSalary.setText("");
				txtFieldBirthDay.setText("");
			}
		});
		buttonPanelTop.add(btnAdd);
	
		btnCancel=new JButton("     Cancel     ");
		btnCancel.setFont(new Font("",1,18));
		btnCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				txtFieldName.setText("");
				txtFieldNumber.setText("");
				txtFieldCompany.setText("");
				txtFieldSalary.setText("");
				txtFieldBirthDay.setText("");
			}
		});
		buttonPanelTop.add(btnCancel);
		buttonPanel.add(buttonPanelTop);
		
		JPanel buttonPanelBottom=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		btnHome=new JButton("         Back To HomePage         ");
		btnHome.setFont(new Font("",1,18));
		btnHome.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				AddContactForm.this.dispose();
				ContactOrganizerHomePage.main(null);
			}
		});
		buttonPanelBottom.add(btnHome);
		buttonPanel.add(buttonPanelBottom);		
				
		add("South",buttonPanel);
		
		JPanel txtPanel=new JPanel(new BorderLayout());
		
		JPanel IDPanel=new JPanel(new GridLayout(3,1));
		IDPanel.add(emptyLabel3);
		
		lblID=new JLabel("  Contact ID - "+IDstring);
		lblID.setFont(new Font("",3,25));
		IDPanel.add(lblID);
		
		txtPanel.add("North",IDPanel);
		
		JPanel labelPanel=new JPanel(new GridLayout(5,1));
		lblName=new JLabel("     Name ");
		lblName.setFont(new Font("",1,20));
		labelPanel.add(lblName);
		
		lblNumber=new JLabel("     Number ");
		lblNumber.setFont(new Font("",1,20));
		labelPanel.add(lblNumber);
		
		lblCompany=new JLabel("     Company ");
		lblCompany.setFont(new Font("",1,20));
		labelPanel.add(lblCompany);
		
		lblSalary=new JLabel("     Salary ");
		lblSalary.setFont(new Font("",1,20));
		labelPanel.add(lblSalary);
		
		lblBirthDay=new JLabel("     BirthDay ");
		lblBirthDay.setFont(new Font("",1,20));
		labelPanel.add(lblBirthDay);
		
		txtPanel.add("West",labelPanel);

		JPanel textPanel=new JPanel(new GridLayout(5,1));
		
		txtFieldName=new JTextField(20);
		txtFieldName.setFont(new Font("",1,20));
		JPanel nameTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT)); 
		nameTextPanel.add(txtFieldName);
		textPanel.add(nameTextPanel);
		
		txtFieldNumber=new JTextField(20);
		txtFieldNumber.setFont(new Font("",1,20));
		JPanel numberTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT)); 
		numberTextPanel.add(txtFieldNumber);
		textPanel.add(numberTextPanel);
		
		txtFieldCompany=new JTextField(20);
		txtFieldCompany.setFont(new Font("",1,20));
		JPanel companyTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT)); 
		companyTextPanel.add(txtFieldCompany);
		textPanel.add(companyTextPanel);		
		
		txtFieldSalary=new JTextField(15);
		txtFieldSalary.setFont(new Font("",1,20));
		JPanel salaryTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT)); 
		salaryTextPanel.add(txtFieldSalary);
		textPanel.add(salaryTextPanel);
		
		txtFieldBirthDay=new JTextField(15);
		txtFieldBirthDay.setFont(new Font("",1,20));
		JPanel birthdayTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT)); 
		birthdayTextPanel.add(txtFieldBirthDay);
		textPanel.add(birthdayTextPanel);	
		
		txtPanel.add("Center",textPanel);

		add("Center",txtPanel);
	}
}
