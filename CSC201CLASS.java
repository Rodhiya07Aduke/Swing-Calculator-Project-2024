import java.util.Scanner;

public class CSC201CLASS {
    public static void main (String[] args) {
        Scanner scanner= new Scanner(System.in);
        int age;
        String name;
        Double height;
        String department;
        String State; 
        String MatricNo;

        System.out.println ("Enter your name: ");
         name = scanner.nextLine();

         System.out.println ("Enter your department: ");
         department = scanner.nextLine();
         

         System.out.println ("Enter your age : ");
         age = scanner.nextInt();

         System.out.println ("Enter your height : ");
         height= scanner.nextDouble();

         scanner.nextLine(); 

        System.out.println("Enter your state : ");
         State = scanner.nextLine();

         System.out.println("Enter your matric number : ");
         MatricNo = scanner.nextLine();

        System.out.println("Results of the operations :");
        System.out.println("My name is :" + name);
        System.out.println("I'm from " + department + " department");
        System.out.println("My Matric number is :" + MatricNo);
        System.out.println("My age is :" + age);
        System.out.println("I'm " + height +" tall");
        System.out.println("I'm from " + State + " state");
        
        scanner.close();
    }
}
