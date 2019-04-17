public class Code_08_CompleteTreeNodeNumber {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data){
            this.value=data;
        }
    }
    public static int nodeNum(Node head){
        if(head==null){
            return 0;
        }
        return bs(head,1,mostLeftLevel(head, 1));
    }

    //node :当前节点  level:当前节点的高度(其实为根节点的高度，即为1)  h：总的高度
    public static int bs(Node node,int level,int h){
        if(level==h){
            return 1;
        }
        if(mostLeftLevel(node.right,level+1)==h){
            return (1<<(h-level))+bs(node.right,level+1,h);//1<<(h-1)为2的h-1次方

        }else{
            return (1<<(h-level-1))+bs(node.left,level+1,h);
        }
    }
    public static int mostLeftLevel(Node node, int level) {
        while (node != null) {
            level++;
            node = node.left;
        }
        return level - 1;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        System.out.println(nodeNum(head));

    }
}
