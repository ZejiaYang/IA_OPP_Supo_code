import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Vector;

public class Car{
    private String manufacturer;
    private int age;

    public Car(String m, int a){
        this.manufacturer = m;
        this.age = a;
    }

    public String getManufacturer(){
        return this.manufacturer;
    }

    public int getAge(){
        return this.age;
    }

    @Override
    public String toString(){
        return "manufacturer: " + manufacturer + " age: " + age;
    }

    public static void main(String[] args) {
       Car a = new Car("a", 1);
       Car b = new Car("b", 1);
       Car c = new Car("a", 2);
       Vector<Car> list = new Vector<>();
       
       list.add(a);
       list.add(b);
       list.add(c);

       list.sort(new Comparecar());

       Iterator<Car> it = list.iterator();

       while(it.hasNext()){
            Car newcar = it.next();
            System.out.println(newcar);
;       }
    }
}

class Comparecar implements Comparator<Car>{
    @Override
    public int compare(Car a, Car b) {
        int result = a.getManufacturer().compareTo(b.getManufacturer());
        if (result == 0) {
            result = Integer.compare(a.getAge(), b.getAge());
        }      
        return result;
    }
}