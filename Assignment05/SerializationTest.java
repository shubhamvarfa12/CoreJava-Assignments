import java.io.*;
import java.util.*;

class Student implements Serializable {

  String firstName;
  String dateOfBirth;
  Address add;

  Student( String firstName, String dateOfBirth, String city, String State, int pinCode, String country
  ) {
    this.firstName = firstName;
    this.dateOfBirth = dateOfBirth;
    this.add = new Address(city, State, pinCode, country);
  }
}

class Address implements Serializable {

  String city;
  String State;
  int pinCode;
  String country;

  Address(String city, String State, int pinCode, String country) {
    this.city = city;
    this.State = State;
    this.pinCode = pinCode;
    this.country = country;
  }
}

class SerializationTest {

  static String file = "Output1.ser";
  static ObjectOutputStream oos;

  static void writeToFile(List<Object> obj) throws Exception {
    oos = new ObjectOutputStream(new FileOutputStream(file));
    oos.writeObject(obj);
    oos.close();

    System.out.println("Object has been serialized");
  }

  public static void main(String[] args) throws Exception {
    Student s1 = new Student(  "shubham",  "02-04-2000",  "Indore",  "M.P",  452005,  "India" );
    Student s2 = new Student(  "vishal",  "21-04-2000",  "Badnawar",  "M.P",  454660,  "U.S" );
    Student s3 = new Student(  "Ajay",  "23-04-1990",  "Badnawar1",  "M.P",  454661,  "America" );
    Student s4 = new Student(  "shubh",  "01-04-2004",  "Badnawar2",  "M.P",  454663,  "Canada" );
    List<Object> obj = new ArrayList<>();
    obj.add(s1);
    obj.add(s2);
    obj.add(s3);
    obj.add(s4);

    writeToFile(obj);
  }
}
