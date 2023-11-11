/*
Imagine you have two classes: Employee (which represents being an employee) and Ninja (which
represents being a Ninja). An Employee has both state and behaviour; a Ninja has only behaviour. You
need to represent an employee who is also a ninja (a common problem in the real world). By creating
only one interface and only one class (NinjaEmployee), show how you can do this without having to
copy method implementation code from either of the original classes.
 */

public class Employee{
    protected  String name;
    protected  int EmployeeID;
    public void work(){
        System.out.println("Employee " + name + " is working");
    }

    public int getEmployeeID(){
        return this.EmployeeID;
    }

    public String getEmployeename(){
        return this.name;
    }
}

public class Ninja{
    public void assassinate(String name){
        System.out.println("Target: " + name + " being Assassinated!");
    }
    public void martialArts(int days){
        System.out.println("Practise Martial Arts for " + days + " days.");
    }
}

public interface NinjaInterface(){
    public default void assassinate(String name){
        System.out.println("Target: " + name + " being Assassinated!");
    }
    public default void martialArts(int days){
        System.out.println("Practise Martial Arts for " + days + " days.");
    }
}
public class NinjaEmployee extends Employee implements NinjaInterface{
    @Override
    public void work(){
        System.out.println("NinjaEmployee " + name + " is working");
    }

    @Override
    public void assassinate(String name) {
        NinjaInterface.super.assassinate(name);
    }

    @Override
    public void martialArts(int days) {
        NinjaInterface.super.martialArts(days);
    }
}