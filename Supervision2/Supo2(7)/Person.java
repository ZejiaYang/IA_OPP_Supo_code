/*Explain (with an example) how you could change the output of the following code without changing
the testOutput() function:*/

public class Person {
    private String name;
    private String socialmedia;
    public Person(String _name, String _social){
        this.name = _name;
        this.socialmedia = _social;
    }

    public static void testOutput() {
        Person p = new Person("Joe", "Bloggs");
        System.out.println("Person details: "+ p);
    }

    @Override
    public String toString(){
        return name + " has " + socialmedia;
    }
    public static void main(String[] args) {
        testOutput();
    }
}

