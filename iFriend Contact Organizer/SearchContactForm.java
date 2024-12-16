import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class SearchContactForm extends JFrame{	
	private JLabel titleLabel;
	
	private JButton btnHome;
	private JButton btnSearch;

	private JLabel lblID;
	private JLabel lblName;
	private JLabel lblNumber;
	private JLabel lblCompany;
	private JLabel lblSalary;
	private JLabel lblBirthDay;
	private JLabel emptyLabel1=new JLabel(" ");
	private JLabel emptyLabel2=new JLabel(" ");
	private JLabel emptyLabel3=new JLabel(" ");
	private JLabel detailID;
	private JLabel detailName;
	private JLabel detailNumber;
	private JLabel detailCompany;
	private JLabel detailSalary;
	private JLabel detailBirthDay;
	
	private JTextField txtFieldSearch;
	
	private int searchDataIndex=0;
	
	SearchContactForm(){
		setSize(500,628);
		setTitle("Search Contact Form");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel titlePanel=new JPanel(new GridLayout(3,1));
		titlePanel.setBackground(new Color(153,205,253));
		titlePanel.add(emptyLabel1);
		titleLabel=new JLabel("SEARCH CONTACT");
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setFont(new Font("",1,30));
		titlePanel.add(titleLabel);
		
		add("North",titlePanel);
		
		JPanel buttonPanel=new JPanel(new GridLayout(2,1,1,1));
		buttonPanel.add(emptyLabel2);
		
		JPanel homePanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		btnHome=new JButton("         Back To HomePage         ");
		btnHome.setFont(new Font("",1,18));
		btnHome.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				SearchContactForm.this.dispose();
				ContactOrganizerHomePage.main(null);
			}
		});
		homePanel.add(btnHome);
		buttonPanel.add(homePanel);		
				
		add("South",buttonPanel);
		
		JPanel txtPanel=new JPanel(new BorderLayout());
		
		JPanel topPanel=new JPanel(new GridLayout(3,1));
		topPanel.add(emptyLabel3);
		JPanel searchPanel=new JPanel(new FlowLayout());
		txtFieldSearch=new JTextField(15);
		txtFieldSearch.setFont(new Font("",1,20));
		searchPanel.add(txtFieldSearch);
		btnSearch=new JButton("  Search  ");
		btnSearch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				String details=txtFieldSearch.getText();
				int searchDataIndex=ContactController.search(details);
				if(searchDataIndex==-1){
					JOptionPane.showMessageDialog(null, "No Contact Found .....");
					txtFieldSearch.setText("");
				}else{
					Contact result=ContactDBConnection.getInstance().getContactList().getObject(searchDataIndex);
					detailID.setText("       "+result.getID());
					detailName.setText("       "+result.getName());
					detailNumber.setText("       "+result.getNumber());
					detailCompany.setText("       "+result.getCompany());
					detailSalary.setText("       "+result.getSalary()+"");
					detailBirthDay.setText("       "+result.getB_day());
				}
			}
		});
		btnSearch.setFont(new Font("",1,18));
		searchPanel.add(btnSearch);
		topPanel.add(searchPanel);
		
		txtPanel.add("North",topPanel);	

		JPanel labelPanel=new JPanel(new GridLayout(6,1));
		lblID=new JLabel("     Contact ID ");
		lblID.setFont(new Font("",1,20));
		labelPanel.add(lblID);		
		
		lblName=new JLabel("     Name ");
		lblName.setFont(new Font("",1,20));
		labelPanel.add(lblName);
		
		lblNumber=new JLabel("     Contact Number ");
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

		JPanel detailPanel=new JPanel(new GridLayout(6,1));
		
		detailID=new JLabel("");
		detailID.setFont(new Font("",1,20));
		JPanel idTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT)); 
		idTextPanel.add(detailID);
		detailPanel.add(idTextPanel);
		
		detailName=new JLabel("");
		detailName.setFont(new Font("",1,20));
		JPanel nameTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT)); 
		nameTextPanel.add(detailName);
		detailPanel.add(nameTextPanel);
		
		detailNumber=new JLabel("");
		detailNumber.setFont(new Font("",1,20));
		JPanel numberTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT)); 
		numberTextPanel.add(detailNumber);
		detailPanel.add(numberTextPanel);
		
		detailCompany=new JLabel("");
		detailCompany.setFont(new Font("",1,20));
		JPanel companyTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT)); 
		companyTextPanel.add(detailCompany);
		detailPanel.add(companyTextPanel);		
		
		detailSalary=new JLabel("");
		detailSalary.setFont(new Font("",1,20));
		JPanel salaryTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT)); 
		salaryTextPanel.add(detailSalary);
		detailPanel.add(salaryTextPanel);
		
		detailBirthDay=new JLabel("");
		detailBirthDay.setFont(new Font("",1,20));
		JPanel birthdayTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT)); 
		birthdayTextPanel.add(detailBirthDay);
		detailPanel.add(birthdayTextPanel);	

		txtPanel.add("Center",detailPanel);
		add("Center",txtPanel);
	}
}


