import javax.lang.model.util.ElementScanner14;

class Linkedlist
{

    public static class LLToStackAdapter {
        LinkedList list;

        public LLToStackAdapter() {
            list = new LinkedList  ();
        }


        int size() {
            return list.size();
        }

        void push(int val) {
            list.addFirst(val);
        }

        int pop() {
            if (size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                int val = list.getFirst();
                list.removeFirst();
                return val;
            }
        }

        int top() {
            if (size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                int val = list.getFirst();
                return val;
            }
        }
    }
    public static class LLToQueueAdapter {
        LinkedList  list;

        public LLToQueueAdapter() {
            list = new LinkedList  ();
        }

        int size() {
            return list.size();
        }

        void add(int val) {
            list.addLast(val);
        }

        

        int peek() {
            if (size() == 0) {
                System.out.println("Queue underflow");
                return -1;
            } else {
                return list.getFirst();
            }
        }
    }
public static class Node{
    int data;
    Node next;

}
public static class LinkedList {
    Node head;
    Node tail;
    int size;

    void addLast(int val)
    {
        Node temp=new Node();
        temp.data=val;
        temp.next=null; 
        if(size==0)
        {
            head=tail=temp;   
        }
        else
        {
            tail.next=temp;
            tail=temp;
        }
        size++;

    }
    public int size()
    {
        return size;

    }
    public void display()
    {
        Node temp=head;
        while(temp!=null)
        {
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }

    public void removeFirst()
    {
        if(size==0)
        {
            System.out.println("List is empty.");
        }
        else if(size==1)
        {
            head=tail=null;
            size=0;
        }
        else
        {
        head=head.next;
        size--;
        }
    }

    
    public int getFirst() {
        if(size==0)
        {
            return -1;
        }
        else
        {
            return head.data;
        }
    }

    public int getLast() {
        if(size==0)
        {
            return -1;
        }
        else
        {
            return tail.data;
        }
    }

    public int getAt(int idx) {
        if (size == 0) {
            System.out.println("List is empty");
            return -1;
        } else if (idx < 0 || idx >= size) {
            System.out.println("Invalid arguments");
            return -1;
        } else {
            Node temp = head;
            for (int i = 0; i < idx; i++) {
                temp = temp.next;
            }
            return temp.data;
        }

    }

    public  void addFirst(int val)
    {
        Node temp=new Node();
        temp.data=val;
        
        temp.next=head;
        head=temp;
        if(size==0)
        {
            tail=temp;

        }
        size++;
    }

    public void addAt(int idx, int val) {
        if (idx < 0 || idx > size) {
            System.out.println("Invalid arguments");
        } else if (idx == 0) {
            addFirst(val);
        } else if (idx == size) {
            addLast(val);
        } else {
            Node node = new Node();
            node.data = val;

            Node temp = head;
            for (int i = 0; i < idx - 1; i++) {
                temp = temp.next;
            }
            node.next = temp.next;

            temp.next = node;
            size++;
        }
    }
    public void removeLast() {
        if (size == 0) {
            System.out.println("List is empty");
        } else if (size == 1) {
            head = tail = null;
            size = 0;
        } else {
            Node temp = head;
            for (int i = 0; i < size - 2; i++) {
                temp = temp.next;
            }

            tail = temp;
            tail.next = null;
            size--;
        }
    }

    public void removeAt(int idx) {
        if (idx < 0 || idx >= size) {
            System.out.println("Invalid arguments");
        } else if (idx == 0) {
            removeFirst();
        } else if (idx == size - 1) {
            removeLast();
        } else {
            Node temp = head;
            for (int i = 0; i < idx - 1; i++) {
                temp = temp.next;
            }

            temp.next = temp.next.next;
            size--;
        }
    }


    private void reversePRhelper(Node node)
    {
        if(node==null)
        {
            return;
        }
        reversePRhelper(node.next);
        if(node==tail)
        {}
        else
        {
            node.next.next=tail;
        }
    }
    public void reversePR()
    {
        reversePRhelper(head);
        head.next=null;
        Node temp=head;
        head=tail;
        tail=temp;


    }
    public int kthFromLast(int k) {
        Node s=head;
        Node f=head;
        for(int i=0;i<k;i++)
        {
            f=f.next;
        }
        while(f!=null)
        {
            f=f.next;
            s=s.next;


        }
        return s.data;
    }

    public int mid() {
        Node f = head;
        Node s = head;

        while (f.next != null && f.next.next != null) {
            f = f.next.next;
            s = s.next;
        }

        return s.data;
    }
    public static Node midNode(Node head, Node tail) {
        Node f = head;
        Node s = head;

        while (f != tail && f.next != tail) {
            f = f.next.next;
            s = s.next;
        }

        return s;
    }

    public static LinkedList mergeTwoSortedLists(LinkedList l1,LinkedList l2)
    {
        LinkedList ml=new LinkedList();
        Node one=l1.head;
        Node two=l2.head;

        while(one!=null && two!=null)
        {
            if(one.data<two.data)
            {
                ml.addLast(one.data);
                one=one.next;

            }
            else
            {
                ml.addLast(two.data);
                two=two.next;
            }
            while(one!=null)
            {
                ml.addLast(one.data);
                one=one.next;
            }

            while(two!=null)
            {
                ml.addLast(two.data);
                two=two.next;
            }
        }
        return ml;
    }

    public static LinkedList mergeSort(Node head,Node tail)
    {
if(head==tail)
{
    LinkedList br=new LinkedList();
    br.addLast(tail.data);
    return br;
}

        Node mid= midNode(head,tail);
        LinkedList rs=mergeSort(head, mid);
        LinkedList ls=mergeSort(mid.next, tail);
        LinkedList ml= mergeTwoSortedLists(rs, ls);
        return ml;

    }
    public void removeDuplicates() {
        LinkedList res = new LinkedList();

        while (this.size() > 0) {
            int val = this.getFirst();
            this.removeFirst();

            if (res.size() == 0 || val != res.tail.data) {
                res.addLast(val);
            }
        }

        this.head = res.head;
        this.tail = res.tail;
        this.size = res.size;
    }

    public void oddEven()
    {
        LinkedList odd=new LinkedList();
        LinkedList even=new LinkedList();

        while(this.size()>0)
        {
            int val=this.getFirst();
            this.removeFirst();
            if(val%2==0)
            {
                even.addLast(val);
            }
            else{
                odd.addLast(val);
            }
        }

        if(odd.size>0 && even.size>0)
        {
            odd.tail.next=even.head;

            this.head=odd.head;
            odd.tail.next=even.head;
            this.tail=even.tail;
            this.size=odd.size+even.size;
        }
        else if(odd.size()>0)
        {
            this.head=odd.head;
            this.tail=odd.tail;
            this.size=odd.size;
        }
        else if(even.size()>0)
        {
            this.head=even.head;
            this.tail=even.tail;
            this.size=even.size;
        }
        
    }
    
    public static int  addListHelper(Node one,int pv1,Node two,int pv2,LinkedList res)
    {
        if(one==null&&two==null)
    {return 0;}

        int data=0;
        if(pv1>pv2)
        {
            int oc=addListHelper(one.next, pv1-1, two, pv2, res);
            data=one.data+oc;
        }
        else if(pv2>pv1)
        {
            int oc=addListHelper(one, pv1, two.next, pv2-1, res);
            data=two.data+oc;
        }
        else 
        {
            int oc=addListHelper(one.next, pv1-1, two.next, pv2-1, res);
            data=one.data+two.data+oc;
        }
        int nd=data%10;
        int nc=data/10;

        res.addFirst(nd);
        return nc;

    }

    public static LinkedList addTwoLists(LinkedList one,LinkedList two)
    {
        LinkedList res=new LinkedList();

        int oc=addListHelper(one.head,one.size,two.head,two.size,res);
        if(oc>0)
        {
            res.addFirst(oc);
        }
        return res;
    }

        public static int intersection(LinkedList one,LinkedList two)
        {
            Node t1=one.head;
            Node t2=two.head;
            int delta=Math.abs(one.size-two.size);
            if(one.size>two.size)
            {
               for(int i=0;i<delta;i++) 
               {
                   t1=t1.next;
               }
            }
            else
            {
                for(int i=0;i<delta;i++) 
               {
                   t2=t2.next;
               }
            }


            while(t1!=t2)
            {
                t1=t1.next;
                t2=t2.next;
            }
            return t1.data;
        }
}






    public static void main(String arg[])
    {
        LinkedList ll=new LinkedList();
        ll.addLast(20);
        ll.addLast(30);
        ll.addLast(40);
        ll.addLast(50);

        ll.display();
        ll.addLast(60);
        ll.addLast(70);
        ll.addLast(80);
        ll.addLast(90);

        System.out.println(ll.size());
        ll.removeFirst();
        ll.display();
        System.out.println(ll.getFirst());
        System.out.println(ll.getLast());
        System.out.println(ll.getAt(1));

    }
}