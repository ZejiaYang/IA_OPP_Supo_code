/*
Explain the differences between a class, an abstract class and an interface in Java (please provide
example code to illustrate your understanding of each)
*/

public class Show {
    public class NormalPerson{
        private String name = "";
        private int age = 0;
        private boolean gender = true;
        private double height = 0;
        private double weight = 0;
        public NormalPerson(String name, int age, boolean gender, double height, double weight){
            this.name = name;
            this.age = age;
            this.gender = gender;
            this.height = height;
            this.weight = weight;
        }
        public void learn(){
            System.out.println("Learning...");
        }
        public void sleep(){
            System.out.println("Sleeping...");
        }
        public void eat(){
            System.out.println("Eating");
        }
    }
    abstract class AbstractPerson{
        private String name = "";
        private int age = 0;
        private boolean gender = true;
        private double height = 0;
        private double weight = 0;
        public AbstractPerson(String name, int age, boolean gender, double height, double weight){
            this.name = name;
            this.age = age;
            this.gender = gender;
            this.height = height;
            this.weight = weight;
        }
        abstract void learn();
        abstract void sleep();
        abstract void eat();
    }

    public interface Person {
        String name = "";
        int age = 0;
        boolean gender = true;
        double height = 0;
        double weight = 0;
        void learn();
        void sleep();
        void eat();
    }
    public static void main(String[] args) {
        return;
    }
}
