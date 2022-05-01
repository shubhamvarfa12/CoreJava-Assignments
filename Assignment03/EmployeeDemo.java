import java.util.*;
import java.io.*;

class Employee implements Serializable
{
	String EName;
	String Eemail;
	int age;
	
	Employee(String EName, String Eemail,int age)
	{
		this.EName = EName;
		this.Eemail = Eemail;
		this.age = age;
	}
	public String toString()
	{
		return EName+" "+Eemail+" "+age; 
	}
}

class EmployeeDemo
{
	static void EmployeeMenu() throws Exception
	{
	
		int choice =-1;
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		File file = new File("employee.txt");
		ArrayList<Employee> al = new ArrayList<Employee>();		
		// ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		ObjectOutputStream oos = null ;
		ObjectInputStream ois = null ;
		ListIterator li = null;
		
		if(file.isFile())
		{
			ois = new ObjectInputStream(new FileInputStream(file));
			al = (ArrayList<Employee>)ois.readObject();
			ois.close();
		}
		
		do{
			System.out.println("1.ADD");
			System.out.println("2.SEARCH DATA IN SORTED ORDER");
			System.out.println("3.SEARCH");
			System.out.println("4.DELETE");
			System.out.println("0.EXIT : ");
		 
		 choice = sc.nextInt();
		switch(choice)
		{
			case 1:
			System.out.print("Enter how many employee you want: ");
			int n  = sc.nextInt();
			
		for(int i=0;i<n;i++){	
			 System.out.print("Enter Employee name: ");
			String EName = sc1.nextLine();
			 System.out.print("Enter Employee Email: ");
			String Eemail = sc1.nextLine();
			 System.out.print("Enter Employee age: ");
			int Eage = sc.nextInt();
		
		  al.add(new Employee(EName,Eemail,Eage));  
			}
			oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(al);
			oos.close();
		
		break;
		case 2:
		if(file.isFile()){
			ois = new ObjectInputStream(new FileInputStream(file));
			al = (ArrayList<Employee>)ois.readObject();
			ois.close();
			
			Collections.sort(al, new Comparator<Employee>(){
				public int compare(Employee e1, Employee e2){
				return e1.EName.compareTo(e2.EName);
				}});
				
		System.out.println("-----------------------------");
		li = al.listIterator();
		while(li.hasNext())
		{
		System.out.println(li.next());
		}
			System.out.println("-----------------------------");
		}
		else{
		System.out.println("File Not Exists------!");
		}
		break;
		
		case 3:
		if(file.isFile()){
			ois = new ObjectInputStream(new FileInputStream(file));
			al = (ArrayList<Employee>)ois.readObject();
			ois.close();
				
				
				
		boolean found = false;
		System.out.print("Enter Employee EName to Sreach: ");
		String EName = sc1.nextLine();
		System.out.println("-----------------------------");
		li = al.listIterator();
		while(li.hasNext())
		{
			Employee e = (Employee)li.next();
			if(e.EName.equals(EName))
			{
				System.out.println(e);
				found = true;
			}
		// System.out.println(li.next());
		}
		if(!found)
		System.out.println("Record Not Found...!");
		System.out.println("-----------------------------");
		}
		else{
			System.out.println("File Not Exists------!");
			}		
			
		break;
		
		case 4:
		if(file.isFile()){
			ois = new ObjectInputStream(new FileInputStream(file));
			al = (ArrayList<Employee>)ois.readObject();
			ois.close();
				
		boolean found = false;
		System.out.print("Enter Employee EName to DELETE: ");
		String EName = sc1.nextLine();
		System.out.println("-----------------------------");
		li = al.listIterator();
		while(li.hasNext())
		{
			Employee e = (Employee)li.next();
			if(e.EName.equals(EName))
			{
				li.remove();
				found = true;
			}
		}
		if(found){
			oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(al);
			oos.close();
		System.out.println("Record Deleted Successfully...!");
		}
	else{
		System.out.println("Record Not Found...!");
	
			
	}
		System.out.println("-----------------------------");
		}
		else{
			System.out.println("File Not Exists------!");
			}		
		break;
		}
	}while(choice!=0);
	}
	
	public static void main(String ar[]) throws Exception
	{
		EmployeeDemo ed = new EmployeeDemo();
		ed.EmployeeMenu();	
}
}	