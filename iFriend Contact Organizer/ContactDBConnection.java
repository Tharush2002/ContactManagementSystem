import java.util.*;
class ContactDBConnection{
	private contactList ContactList;
	
	private static ContactDBConnection contactDBConnection;
	private ContactDBConnection(){
		ContactList=new contactList(100);
	}
	public static ContactDBConnection getInstance(){
		if(contactDBConnection==null){
			contactDBConnection=new ContactDBConnection();
		}
		return contactDBConnection;
	}
	public contactList getContactList(){
		return ContactList;
	}
}
