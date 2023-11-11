public class Polymorphism{
public static void main(String[] args) {
    Hello c = new Chinese();
    Hello e = new English();
    Hello j = new Japanese();
    c.sayhello();
    e.sayhello();
    j.sayhello();
}
}

abstract class Hello{
    abstract void sayhello();
}

class Chinese extends Hello{
    public void sayhello(){
        System.out.println("你好！");
    }
}

class English extends Hello{
    public void sayhello(){
        System.out.println("Hello!");
    }
}

class Japanese extends Hello{
    public void sayhello(){
        System.out.println("こんにちは!");
    }
}
