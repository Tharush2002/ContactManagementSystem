import java.util.*;
import java.time.*;

class ContactController{
	public static boolean addContact(Contact contact){
		contactList ContactList=ContactDBConnection.getInstance().getContactList();
		if((numCheck(contact.getNumber())==false) && (contact.getSalary()>0) && (birthCheck(contact.getB_day())==false)){
			ContactList.isFull();
			ContactList.set(contact);	
			return true;
		}
		return false;
	}
	
	public static boolean updateContact(int index,Contact contact){
		contactList ContactList=ContactDBConnection.getInstance().getContactList();
		if((numCheck(contact.getNumber())==false) && (contact.getSalary()>0) && (birthCheck(contact.getB_day())==false)){
			ContactList.update(index,contact);
			return true;
		}
		return false;
	}
	
	public static boolean deleteContact(int index){
		ContactDBConnection.getInstance().getContactList().pop(index);
		return true;
	}
	
		//=============================PHONE-NUMBER-VALIDATION==================================
		
	public static boolean numCheck(String a){
		boolean wrong_num=false;
		if(a.length()!=10|a.charAt(0)!='0'){
			wrong_num=true;
		}
							
		L:for (int i = 0; i < a.length(); i++){
		char x=a.charAt(i);
		switch (x){
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
				break;
			default:
				wrong_num=true;
				break L;
			}
		}
		return wrong_num;	
	}
	
	
		//========================BIRTHDAY-VALIDATION=======================
		
	public static boolean birthCheck(String a){
		if(a.length()==10 && a.charAt(4)=='-' && a.charAt(7)=='-'){

			String y=a.substring(0,4);
			int year=Integer.parseInt(y);
			String m=a.substring(5,7);
			int month=Integer.parseInt(m);
			String d=a.substring(8,10);
			int day=Integer.parseInt(d);
			LocalDate currentDate = LocalDate.now();
			int currentMonthValue = currentDate.getMonthValue();
			int currentYear=currentDate.getYear();    
			int currentMonthDate=currentDate.getDayOfMonth();
				
			if(year>currentYear){
				return true;
			}else if(year==currentYear){
				if(month>currentMonthValue){
					return true;
				}else if(month==currentMonthValue){
					if(day>currentMonthDate||day<0) return true;
				}
			}
			if(month>12||month<1) return true;
			switch(month){
				case 4:
				case 6:
				case 9:
				case 11:
					if(day<0||day>30) return true;
					break;
				case 2:
					if(year%100==0){
						if(year%400==0){
							if(day>29||day<0) return true;
						}else{
							if(day>28||day<0) return true;
						}
					}else{
						if(year%4==0){
							if(day>29||day<0) return true;
						}else{
							if(day>28||day<0) return true;
						}
					}
					break;
				default:
					if(day<0||day>31) return true;
			}
		}else{
			return true;
		}
		return false;
	}
		
	
		//=============================SEARCH===================================
		
	public static int search(String a){
		contactList ContactList=ContactDBConnection.getInstance().getContactList();
		boolean b=false;
		b=numCheck(a);
			
		int i=0;
		IF:if(b){
			for (; i < ContactList.getLength(); i++){
				if(ContactList.getName(i).equals(a)){
					break IF;
				}
			}
			return -1;
			
		}else{
			for (; i < ContactList.getLength(); i++){
				if(ContactList.getNumber(i).equals(a)){
					break IF;
				}
			}
			return -1;
		}	
		return i;
	}
	
	
		//============================STRING-TO-CHAR-ARRAY==================================
		
	public static char[] StringtoChar(char[] a,String b){
		for (int j = 0; j < b.length(); j++){
			a[j]=b.charAt(j);
		}
		return a;
	}
	
		
		//============================CAPITAL-TO-SIMPLE=============================
		
	public static char[] CapitaltoSimple(char[] a){
		for (int j = 0; j < a.length; j++){
			if(a[j]>96 & a[j]<123){
				a[j]-=32;
			}
		}
		return a;
	}
	
	
		//===============================SORT-CONTACTS:BY-NAME=====================================
		
	public static void sortName(){
		contactList ContactList=ContactDBConnection.getInstance().getContactList();
		for (int k = 0; k < ContactList.getLength()-1; k++){		
			for (int i = 0; i < ContactList.getLength()-1-k; i++){
				char[] temp1=new char[ContactList.getName(i).length()];
				char[] temp2=new char[ContactList.getName(i+1).length()];
				
				temp1=StringtoChar(temp1,ContactList.getName(i));
				temp2=StringtoChar(temp2,ContactList.getName(i+1));
				
				temp1=CapitaltoSimple(temp1);
				temp2=CapitaltoSimple(temp2);			
				
				int min=ContactList.getName(i).length();
				if(min>ContactList.getName(i).length()) min=ContactList.getName(i+1).length();
				
				L1:for (int j = 0; j < min; j++){
					if(temp1[j]>temp2[j]){
						ContactList.orderReplace(i);						
						break L1;
					}else if(temp1[j]==temp2[j]){
						continue;
					}else{
						break L1;	
					}
				}			
			}
		}
	}
	
	
		//=================================SORT-CONTACTS:BY-SALARY==================================
		
	public static void sortSalary(){
		contactList ContactList=ContactDBConnection.getInstance().getContactList();
		for (int i = 0; i < ContactList.getLength()-1; i++){		
			for (int j = 0; j < ContactList.getLength()-1-i; j++){
				if(ContactList.getSalary(j)>ContactList.getSalary(j+1)){
					ContactList.orderReplace(j);						
				}
			}
		}
	}
	
	
		//===============================SORT-CONTACTS:BY-BIRTHDAY===================================
		
	public static void sortBirthDay(){
		contactList ContactList=ContactDBConnection.getInstance().getContactList();		
		for (int k = 0; k < ContactList.getLength()-1;k++) {        
            for (int i = 0; i < ContactList.getLength()-1-k;i++) {
                String birthDay1 = ContactList.getB_day(i);
                String birthDay2 = ContactList.getB_day(i+1);
                
                LocalDate date1 = LocalDate.parse(birthDay1);
                LocalDate date2 = LocalDate.parse(birthDay2);

                if (date1.isAfter(date2)) {
                    ContactList.orderReplace(i);                        
                }
            }
        }    	
	}	
	
}
