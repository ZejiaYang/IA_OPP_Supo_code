public class Recordholder {
    private static volatile Recordholder holder;
    private String name;

    public Recordholder(String name){
        this.name = name;
    }
    
    public static Recordholder getRecordholder(String name){
        Recordholder result = holder;

        if(result == null){
            synchronized(Recordholder.class){
                result = holder;
                    if(result == null){
                        result = new Recordholder(name);
                        holder = result;
                        System.out.println(name);
                    }
            }
        }else{
            holder.name = name;
            System.out.println(name);
        }
        return result;
    }
    
    public String getname(){
        return name;
    }
    public static void main(String[] args) {
        Recordholder a = getRecordholder("Zejia");
        a = getRecordholder("Robert");
        String b = a.getname();
        a = getRecordholder("Carol");
        b = a.getname();
        System.out.println(b);
    }
}
