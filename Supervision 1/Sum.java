public class Sum {
    public static int sum(int[] a){
        int sum = 0;
        for(int num : a) //for loop
            sum += num;
        return sum;
    }

    public static int[] cumsum(int[] a){
        int[] ans = new int[a.length];
        int temp = 0, i = 0;
        do{
            temp += a[i];
            ans[i] = temp;
            i++;
        }while(i < a.length);
        return ans;
    }

    public static int[] positives(int[] a){
        int posnum = 0;
        for(int num: a)
            if(num > 0) //If statement
                posnum += 1;
        
        int[] ans = new int[posnum];
        int i = 0, j = 0;
        while(i != posnum){ //while loop
            if(a[j] > 0){
                ans[i] = a[j];
                i++;
            }
            j++;
        }
        return ans;
    }

    public static void main(String[] args){

        int[] array = {10, -99, -2, 8302, 345, -88};
     
        int totalSum = sum(array);
        System.out.println("Sum: " + totalSum);

        int[] cumuSum = cumsum(array);
        System.out.println("Cumulative Sum:");
        for (int num : cumuSum) {
            System.out.println(num);
        }

        int[] positives = positives(array);
        System.out.println("Positive Numbers:");
        for (int num : positives) {
            System.out.println(num);
        }
    }
}