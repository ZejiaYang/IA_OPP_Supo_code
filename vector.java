public class vector {
    public static void main(String[] args) {
        int[] vec = new int[2];
        vec[0] = 0;
        vec[1] = 2;
        vectorAdd(vec,1,1);
        System.out.println(vec[0] + " " + vec[1]);
        }

     public static void vectorAdd(int[] vec ,int dx, int dy) {
        vec[0] += dx;
        vec[1] += dy;
        }
}