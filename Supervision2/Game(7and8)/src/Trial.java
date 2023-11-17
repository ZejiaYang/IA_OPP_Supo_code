public class Trial {
    public interface A{
        int x = 5;
        int y = 6;
    }

    public interface B{
        int x = 3;
        int y = 2;
    }

    public static class C implements A, B{
        private static Object y;

        public void output(){
            System.out.println("A" + A.x + "B"+ B.y);
        }
    }

    public static void main(String[] args) {
        C c = new C();
        c.output();
    }
}
