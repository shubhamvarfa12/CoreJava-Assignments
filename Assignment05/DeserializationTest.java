import java.io.*;
import java.util.*;

class Student implements Serializable {

  String firstName;
  String dateOfBirth;
  Address add;

  Student(  String firstName, String dateOfBirth, String city, String State, int pinCode, String country ) {
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

class DeserializationTest {

  static String file = "Output1.ser";
  static ObjectInputStream ois;

  public static void readFile() throws ClassNotFoundException, IOException {
    ois = new ObjectInputStream(new FileInputStream(file));

    List<Object> input = (List<Object>) ois.readObject();
    List<Object> checkList = new ArrayList<>();

    for (Object Obj : input) {
      if (Obj instanceof Student) {
        Student s1 = (Student) Obj;
        System.out.println(s1.firstName);
        System.out.println(s1.dateOfBirth);
      }
    }
    ois.close();
  }

  public static void main(String[] args) throws Exception {
    readFile();
    System.out.println("Object has been De-serialized");
  }
}
