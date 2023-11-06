import java.util.NoSuchElementException;

public class stack {
    linked_list stack;

    public stack(){
        stack = new linked_list();
    }

    public stack(int[] l){
        stack = new linked_list();
        Node pre = stack.head;
         for(int v: l){
            Node cur = new Node(v);
            cur.next = pre;
            pre = cur;
        }
        stack.head = pre;
    }

    public int size(){
        return stack.length();
    }

    public boolean is_empty(){
        return stack.head == null;
    }

    public void push(int v){
        Node newhead = new Node(v);
        newhead.next = stack.head;
        stack.head = newhead;
    }

    public void pop(){
        if(stack.head == null)
            throw new NoSuchElementException("stack is empty");
        else
            stack.head = stack.head.next;
    }

    public int peek(){
        if(stack.head == null)
            throw new NoSuchElementException("stack is empty");
        else
            return stack.head.val;
    }

    public void show(){
        stack.show();
    }

    public static void main(String[] args) {
        int[] l = {1,5,3,2,10,19,20,27};
        stack mystack = new stack(l);
        mystack.show();

        mystack.push(1000);
        mystack.push(788);
        mystack.push(245);
        mystack.push(26);
        mystack.show();

        for(int i = 0; i < 6; i++)
            mystack.pop();
        mystack.show();

        int head = mystack.peek();
        System.out.println("Current head is " + head);

        int size = mystack.size();
        System.out.println("Current size is " + size);

        boolean is_empty = mystack.is_empty();
        System.out.println("Is empty: " + is_empty);
    }
}