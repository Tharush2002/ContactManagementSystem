class contactList{
	private Contact[] ContactList;
	int nextIndex;
	
	contactList(int size){
		ContactList=new Contact[size];
		nextIndex=0;
	}
			
	private void extendList(){
		Contact[] A=new Contact[ContactList.length*2];
		for (int i = 0; i < ContactList.length; i++){
			A[i]=ContactList[i];
		}
		ContactList=A;
	}
			
	public int getLength(){
		return nextIndex;
	}
	
	public String getID(int i){
		return ContactList[i].getID();
	}	
	
	public String getName(int i){
		return ContactList[i].getName();
	}
	
	public String getNumber(int i){
		return ContactList[i].getNumber();
	}
	
	public double getSalary(int i){
		return ContactList[i].getSalary();
	}
	
	public String getCompany(int i){
		return ContactList[i].getCompany();
	}
	
	public String getB_day(int i){
		return ContactList[i].getB_day();
	}
	
	public Contact getObject(int i){
		return ContactList[i];
	}
	
	public void isFull(){
		if(nextIndex==ContactList.length) extendList();
	}

	public void updateName(int i,String name){
		ContactList[i].setName(name);
	}

	public void updateNumber(int i,String number){
		ContactList[i].setNumber(number);
	}
	
	public void updateCompany(int i,String company){
		ContactList[i].setCompany(company);
	}
	
	public void updateSalary(int i,double salary){
		ContactList[i].setSalary(salary);
	}
	
	public void pop(int A){
		Contact[] temp=new Contact[ContactList.length-1];
		for (int i = 0; i < A; i++){
			temp[i]=ContactList[i];
		}
		for (int i = A; i < temp.length; i++){
			temp[i]=ContactList[i+1];
		}
		ContactList=temp;
		nextIndex--;
	}
	
	public void set(Contact newContact){
		ContactList[nextIndex] = newContact;
		nextIndex++;
	}
	
	public void update(int index,Contact newContact){
		ContactList[index] = newContact;
	}
	
	public void orderReplace(int i){
		Contact x=new Contact();
		x=ContactList[i+1];
		ContactList[i+1]=ContactList[i];
		ContactList[i]=x;
	}	
}
