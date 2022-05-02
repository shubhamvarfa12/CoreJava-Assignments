// import java.io.*;
import java.util.*;

class Geometry {

  float PI = 3.142f;
  float area, area1, area2, circumference;
  float ch, length, breadth, height, side, diagonal1, radius, diagonal2;

  void Circle(Scanner sc) {
    System.out.print("Enter the radius of a Circle \n");
    try {
      radius = sc.nextInt();
      area = radius * radius * 22 / 7;
      circumference = 2 * PI * radius;
    } catch (InputMismatchException e) {
      System.out.println(e);
    }

    System.out.println(
      "Area of the Circle with radius " + radius + " is =" + area + "\n"
    );
    System.out.println(
      "circumference of Circle with radius " +
      radius +
      " is =" +
      circumference +
      "\n\n"
    );
  }

  void Rectangle(Scanner sc) {
    System.out.print("Enter the length of a Rectangle \n");
    try {
      length = sc.nextInt();
      System.out.print("Enter the breadth of the Rectangle \n");
      breadth = sc.nextInt();
      area = length * breadth;
    } catch (Exception e) {}
    System.out.println(
      "Area of the Rectangle with length " +
      length +
      " and breadth " +
      breadth +
      " is=" +
      area +
      "\n\n"
    );
  }

  void Triangle(Scanner sc) {
    System.out.print("Enter the height of Triangle \n");
    try {
      height = sc.nextInt();
      System.out.print("Enter the base of Triangle \n");
      breadth = sc.nextInt();
      area = (height * breadth) / 2;
    } catch (InputMismatchException e) {
      System.out.println(e);
    }
    System.out.println(
      "Area of the Triangle with height " +
      height +
      " and breadth " +
      breadth +
      " is= " +
      area +
      "\n\n"
    );
  }

  void Square(Scanner sc) {
    System.out.print("Enter the side of a Square \n");
    try {
      side = sc.nextInt();
      area = side * side;
    } catch (InputMismatchException e) {
      System.out.println(e);
    }
    System.out.println(
      "Area of the Square with side " + side + " is= " + area + "\n\n"
    );
  }

  void sphere(Scanner sc) {
    System.out.print("Enter the radius of sphere \n");
    try {
      radius = sc.nextInt();
      area = 4 * PI * (radius * radius);
    } catch (InputMismatchException e) {
      System.out.println(e);
    }
    System.out.println(
      "Area of sphere with " + radius + " is = " + area + "\n"
    );
    System.out.println(
      "Surface area of sphere: " + (4.0 * Math.PI * Math.pow(radius, 2))
    );
  }

  void Cylinder(Scanner sc) {
    System.out.print("Enter the radius of Cylinder \n");
    try {
      radius = sc.nextInt();
      System.out.print("Enter the height of Cylinder \n");
      height = sc.nextInt();
      area = 2 * PI * radius * height;
      area1 = 2 * PI * radius * radius;
      area2 = area + area1;
    } catch (InputMismatchException e) {
      System.out.println(e);
    }

    System.out.println(
      "Area of Cylinder with radius " +
      radius +
      " and height " +
      height +
      " is= " +
      area2 +
      "\n\n"
    );
  }
}

class MenuArea {

  void show1(Scanner sc) {
    System.out.println("1: Area of Circle");
    System.out.println("2: Area of Rectangle");
    System.out.println("3: area of Triangle");
    System.out.println("4: Area of Square");
    System.out.println("5: Area of Sphare");
    System.out.println("6: Area of Cylinder");
    System.out.println("7: termination point");
    Geometry obj = new Geometry();
    try {
      k:while (true) {
        System.out.print("select one of them:");

        int x = sc.nextInt();

        switch (x) {
          case 1:
            obj.Circle(sc);
            break;
          case 2:
            obj.Rectangle(sc);
            break;
          case 3:
            obj.Triangle(sc);
            break;
          case 4:
            obj.Square(sc);
            break;
          case 5:
            obj.sphere(sc);
            break;
          case 6:
            obj.Cylinder(sc);
            break;
          case 7:
            break k;
        }
      }
    } catch (InputMismatchException e) {
      System.out.println(e);
    }
  }
}

class Assignment02 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    MenuArea ma = new MenuArea();
    ma.show1(sc);
  }
}
