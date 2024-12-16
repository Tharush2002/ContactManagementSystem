class Contact{
	private String id;
	private String name;
	private String number;
	private String company;
	private double salary;
	private String birthday;
	
	public Contact(){		
	}
	
	public Contact(String id, String name, String number, String company, double salary, String birthday){
		this.id=id;
		this.name=name;
		this.number=number;
		this.company=company;
		this.salary=salary;	
		this.birthday=birthday;	
	}
	
	public void setID(String id){
		this.id=id;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public void setNumber(String number){
		this.number=number;
	}
	
	public void setCompany(String company){
		this.company=company;
	}
	
	public void setSalary(double salary){
		this.salary=salary;
	}
	
	public void setB_day(String birthday){
		this.birthday=birthday;
	}	
	
	public String getID(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	public String getNumber(){
		return number;
	}
	
	public String getCompany(){
		return company;
	}
	
	public double getSalary(){
		return salary;
	}
	
	public String getB_day(){
		return birthday;
	}
}
	



