import java.util.HashMap;
import java.util.List;

public class Code_04_UnionFind {
    public static class Node{
      // whatever you like
    }

    public static class UnionFindSet{
        public HashMap<Node,Node>fatherMap;
        public HashMap<Node,Integer>sizeMap;

        public UnionFindSet(){
            fatherMap=new HashMap<Node,Node>();
            sizeMap = new HashMap<Node,Integer>();//整个集合一共有多少个节点
        }
        public void makeSets(List<Node> nodes){
            fatherMap.clear();
            sizeMap.clear();
            for(Node node:nodes){
                fatherMap.put(node,node);//将自己设置为自己的父节点
                sizeMap.put(node,1);//设置为第一个节点
            }
        }
        private  Node findHead(Node node){
            Node father=fatherMap.get(node);
            if(father!=node){//如果一个节点的父节点不为自己，递归向上找父节点
                father=findHead(father);
            }
            fatherMap.put(node,father);//父节点为自己
            return father;
        }
        public boolean isSameSet(Node a,Node b){
            return findHead(a)==findHead(b);//代表集合一样是属于一个集合
        }
        public void union(Node a,Node b){
            if(a==null||b==null){
                return;
            }
            Node aHead=findHead(a);
            Node bHead=findHead(b);
            if(aHead!=bHead){
                int aSetSize=sizeMap.get(aHead);
                int bSetSize=sizeMap.get(bHead);
                if(aSetSize<=bSetSize){
                    fatherMap.put(aHead,bHead);
                    sizeMap.put(bHead,aSetSize+bSetSize);
                }else{
                    fatherMap.put(bHead,aHead);
                    sizeMap.put(aHead,aSetSize+bSetSize);
                }
            }
        }
    }
}
