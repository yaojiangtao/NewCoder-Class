import java.util.Comparator;
import java.util.PriorityQueue;

public class Code_03_IPO {
    public static class Node{
        public int p;
        public int c;

        public Node(int p,int c){
            this.p=p;
            this.c=c;
        }
    }
    //收益低
    public static class MinCostComparator implements Comparator<Node>{
        @Override
        public int compare(Node o1, Node o2) {
            return o1.c - o2.c;
        }
    }
    //收益高的
    public static class MaxProfitComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o2.p - o1.p;
        }

    }
    public static int findMaximizedCapital(int k,int w,int[] Profits,int[] Capital){
        Node[] nodes = new Node[Profits.length];
        for(int i=0;i<Profits.length;i++){
            nodes[i]=new Node(Profits[i],Capital[i]);
        }
        PriorityQueue<Node> minCostQ=new PriorityQueue<>(nodes.length,new MinCostComparator());
        PriorityQueue<Node> maxProfitQ = new PriorityQueue<>(nodes.length,new MaxProfitComparator());

        for(int i=0;i<nodes.length;i++){
            minCostQ.add(nodes[i]);
        }
        //最多做k个项目
        for(int i =0;i<k;i++){
            //w初始资金
            while (!minCostQ.isEmpty()&&minCostQ.peek().c<=w){
                maxProfitQ.add(minCostQ.poll());
            }
            if(maxProfitQ.isEmpty()){
                return w;
            }
            w+=maxProfitQ.poll().p;
        }
        return w;
    }

}
