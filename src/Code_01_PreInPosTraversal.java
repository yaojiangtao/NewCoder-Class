import java.util.Stack;
public class Code_01_PreInPosTraversal {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void preOrderUnRecur(Node head){
        System.out.println("pre-order");
        if(head!=null){
            Stack<Node> stack=new Stack<>();
            stack.add(head);
            while (!stack.isEmpty()){
                head=stack.pop();
                System.out.println(head.value+" ");
                if(head.right!=null){
                    stack.push(head.right);
                }
                if (head.left!=null){
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }

    public static void inOrderUnRecur(Node head){
        System.out.println("in-order: ");
        if(head!=null){
            Stack<Node>stack=new Stack<Node>();
            while (!stack.isEmpty()||head!=null){
                if(head!=null){//左子树全部压栈
                    stack.push(head);
                    head=head.left;//到叶子节点，head为空走下面

                }else{//从栈中出来赋值给head
                    head=stack.pop();
                    System.out.println(head.value + " ");
                    head=head.right;//走右子节点为空，继续弹出栈中的下个节点
                }
            }
        }
        System.out.println();
    }

    public static void posOrderUnRecur1(Node head){
        System.out.print("pos-order: ");
        if(head!=null){
            Stack<Node> s1 = new Stack<Node>();
            Stack<Node> s2 = new Stack<Node>();
            s1.push(head);
            while (!s1.isEmpty()){
                head=s1.pop();
                s2.push(head);
                if(head.left!=null){
                    s1.push(head.left);
                }
                if (head.right!=null){
                    s1.push(head.right);
                }
            }
            while (!s2.isEmpty()){
                System.out.println(s2.pop().value + " ");
            }
        }
        System.out.println();
    }
}
