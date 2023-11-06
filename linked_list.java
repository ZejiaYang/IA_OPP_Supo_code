import java.util.NoSuchElementException;

public class linked_list{

    public Node head;

    public linked_list(){
        head = null;
    }

    public linked_list(int[] val){
        head = null;
        Node cur = head;
        for(int v: val){
            Node nextnode = new Node(v);

            if(head == null){
                head = nextnode;
                cur = head;
            }else{
                cur.next = nextnode;
                cur = cur.next;
            }
        }
    }
    

    public void add(int a){
        Node tail = new Node(a);
        if(head == null){
            head = new Node(a);
        }else{
            Node cur = head;
            while(cur.next != null)
                cur = cur.next;
            cur.next = tail;
        }
    }

    public void remove(int a){
        if(head == null){
            return;
        }
        else if(head.val == a){
            head = head.next;
        }
        else{
            Node cur = head.next;
            Node pre = head;
            while(cur != null){
                if(cur.val == a){
                    if(cur.next == null)
                        pre.next = null;
                    else{
                        pre.next = cur.next;
                        pre = cur.next;
                        cur = cur.next.next;
                    }
                }else{
                pre = cur;
                cur = cur.next;
                }
            }
        }
    }

    public int query(){
        if(head == null){
            throw new NoSuchElementException("The list is empty");
            // return -1;
        }else{
            return head.val;
        }
    }

    public int index(int n){
        Node cur = head;
        while(cur != null){
            if(n == 1)
                break;
            cur = cur.next;
            n -= 1;
        }
        if(n == 1)
            return cur.val;
        else
            throw new NoSuchElementException("The length of list is shorter than n");
            // return -1;
    }

    public int length(){
        Node cur = head;
        int length = 0;
        while(cur != null){
            length += 1;
            cur = cur.next;
        }
        return length;
    }

    public void show(){
        Node cur = head;
        System.out.print("The singly linked list :");

        while(cur != null){
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public boolean has_cycle(){
        Node fast = head;
        Node slow = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast)
                return true;
        }
        return false;
    }

    public static void main(String[] args){
        int list[] = {1, 2, 34, 5, 4, 9, 10, 11, 43, 3, 88, 56, 7, 45};

        linked_list l = new linked_list(list);

        l.show();

        l.add(100);
        l.show();

        l.remove(9);
        l.show();

        int a  = l.query();
        System.out.println("the head : " + a);

        int len = l.length();
        System.out.println("the length : " + len);

        int b = l.index(9);
        System.out.println("the nth element : " + b);

    }
}