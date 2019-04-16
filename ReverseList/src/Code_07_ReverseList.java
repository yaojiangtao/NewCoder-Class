public class Code_07_ReverseList {
    public static class Node{
        public int value;
        public Node next;

        public Node(int data){
            this.value=value;
        }
    }
    public static Node reverseList(Node head){
        Node pre=null;
        Node next=null;
        while (head!=null){
            next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;

    }

    public static class DoubleNode{
        public int value;
        public DoubleNode last;
        public DoubleNode next;

        public DoubleNode(int data){
            this.value=data;
        }

    }

    public static DoubleNode reverseList(DoubleNode head){
        DoubleNode pre = null;
        DoubleNode next=null;
        while (head!=null){
            next=head.next;
            head.next=pre;
            head.last=next;
            pre=head;
            head=next;
        }
        return pre;
    }

    public static void printLinkedLit(Node head){
        System.out.println("Linked List:");
        while (head!=null){
            System.out.println(head.value+" ");
            head=head.next;
        }
        System.out.println();
    }

    public static void printDoubleLinkedList(DoubleNode head){
        System.out.println("Double Linked List: ");
        DoubleNode end=null;
        while (head!=null){
            System.out.print(head.value+" ");
            end=head;
            head=head.next;
        }
        System.out.println("| ");
        while (end!=null){
            System.out.print(end.value+" ");
            end=end.last;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1=new Node(1);
        head1.next=new Node(2);
        head1.next.next=new Node(3);
        printLinkedLit(head1);
        head1=reverseList(head1);
        printLinkedLit(head1);

        DoubleNode head2 = new DoubleNode(1);
        head2.next = new DoubleNode(2);
        head2.next.last = head2;
        head2.next.next = new DoubleNode(3);
        head2.next.next.last = head2.next;
        head2.next.next.next = new DoubleNode(4);
        head2.next.next.next.last = head2.next.next;
        printDoubleLinkedList(head2);
        printDoubleLinkedList(reverseList(head2));
    }
}
