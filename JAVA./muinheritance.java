import java.util.*;
class Employee{
    String name;
    String employeeid;
    String department;
    public Employee(String name,String employeeid,String department){
        this.name=name;
        this.employeeid=employeeid;
        this.department=department;
    }
    void display(){
        System.out.println("Name: "+ name);
        System.out.println("Employee ID: "+employeeid);
        System.out.println("Department: "+department);
    }
}
class Manager extends Employee{
    int numofteammembers;
    String projectname;
    public Manager(String name,String employeeid,String department,int numofteammembers,String projectname){
        super(name,employeeid,department);
        this.numofteammembers=numofteammembers;
        this.projectname=projectname;
    }
    void display(){
        super.display();
        System.out.println("Number of team members: "+numofteammembers);
        System.out.println("Project name: "+projectname);
    }
}
class Intern extends Employee{
    String university;
    int duration;
    double monthlystipend;
    public Intern(String name,String employeeid,String department,String university,int duration,double monthlystipend){
        super(name,employeeid,department);
        this.university=university;
        this.duration=duration;
        this.monthlystipend=monthlystipend;
    }
    void display(){
        super.display();
        System.out.println("University Name: "+university);
        System.out.println("Duration in months: "+duration);
        System.out.println("Monthly Stipend:$ "+monthlystipend);
        double totalstipend=duration*monthlystipend;
        System.out.println("Total Stipend:$ "+totalstipend);
    }
}
class muinheritance{
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter Manager details: ");
        System.out.println("Name: ");
        String managername=s.nextLine();
        System.out.println("Manager ID: ");
        String managerid=s.nextLine();
        System.out.println("Department: ");
        String managerdepartment=s.nextLine();
        System.out.println("Numer of team members: ");
        int managernumofteammembers=s.nextInt();
        s.nextLine();
        System.out.println("Project name: ");
        String managerprojectname=s.nextLine();
        Manager manager=new Manager(managername, managerid, managerdepartment, managernumofteammembers, managerprojectname);
        System.out.println("Enter Intern details: ");
        System.out.println("Name: ");
        String internname=s.nextLine();
        System.out.println("Intern ID: ");
        String internid=s.nextLine();
        System.out.println("Department: ");
        String interndepartment=s.nextLine();
        System.out.println("University: ");
        String internuniversity=s.nextLine();
        System.out.println("Duration: ");
        int internduration=s.nextInt();
        s.nextLine();
        System.out.println("Monthly Stipend: ");
        double internstipend=s.nextDouble();
        Intern intern=new Intern(internname, internid, interndepartment, internuniversity, internduration, internstipend);
        System.out.println("Manager Details: ");
        manager.display();
        System.out.println("Intern details: ");
        intern.display();        
    }
}