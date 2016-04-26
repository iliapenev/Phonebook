package bg.penev.phonebook;

public class MainProgram {
	public static void main(String [] args)
	{
		PhoneBook pb = new PhoneBook();	      
	    pb.importPhones("phones.txt");
	    System.out.println(pb);
	    
	    CallLog cl = new CallLog();
	    //Fill some call log data 
	    cl.logCall(pb.getPhone("Ana Ivanova"), 50);
	    cl.logCall(pb.getPhone("Asen Petrov"), 20);
	    cl.logCall(pb.getPhone("Dragan Ivanov"), 21);
	    cl.logCall(pb.getPhone("Ivan Stoyanov"), 3);
	    cl.logCall(pb.getPhone("Nikolai Ivanov"), 12);
	    cl.logCall(pb.getPhone("Stoyan Petrov"), 1);
	    cl.logCall(pb.getPhone("Ivan Ivanov"), 0);
	    
	    pb.deleteEntry("Ivan Ivanov");
	    System.out.println("---After Delete ---");
	    System.out.println(pb);
	    
	    System.out.println(pb.getPhone("Asen Petrov"));
	    
	    System.out.println("--- Most Called ---");
	    
	    System.out.println(cl.getMostCalled());	  

	}
}

