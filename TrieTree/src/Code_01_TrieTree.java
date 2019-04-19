public class Code_01_TrieTree {
    public static class TrieNode{
        public int path;
        public int end;
        public TrieNode[] nexts;

        public TrieNode(){
            path=0;//记录走过的次数
            end=0;//记录终点次数
            nexts=new TrieNode[26];//新建长度为26的数组
        }
    }
    public static class Trie{
        private TrieNode root;

        public Trie(){
            root=new TrieNode();
        }

        public void insert(String word){
            if(word==null){
                return;
            }
            char[] chs=word.toCharArray();
            TrieNode node=root;
            int index=0;
            for(int i=0;i<chs.length;i++){
                index=chs[i]-'a';//得到这个字符的index
                if(node.nexts[index]==null){//如果这个字符没有出现过，新建一个节点
                    node.nexts[index]=new TrieNode();
                }
                node=node.nexts[index];//如果这个字符出现过，查找这个字符串的下个节点
                node.path++;//走过的路径+1
            }
            node.end++;//终点+1
        }
        public void delete(String word){
            if(search(word)!=0){
                char[] chs=word.toCharArray();//转换成字符
                TrieNode node=root;
                int index=0;
                for(int i =0;i<chs.length;i++){
                    index=chs[i]-'a';//将每个字符标号
                    if(--node.nexts[index].path==0){//如果一个字符-1后为0，说明下面的都只经过一次
                        node.nexts[index]=null;
                        return;
                    }
                    node=node.nexts[index];//取字符串的下个字符
                }
                node.end--;
            }
        }
        public int search(String word){
            if(word==null){
                return 0;
            }
            char[] chs=word.toCharArray();
            TrieNode node=root;
            int index=0;
            for(int i =0;i<chs.length;i++){
                index=chs[i]-'a';
                if(node.nexts[index]==null){
                    return 0;
                }
                node=node.nexts[index];
            }
            return node.end;
        }
        //一个字符串经过几次
        public int prefixNumber(String pre){
            if(pre==null){
                return 0;
            }
            char[] chs=pre.toCharArray();
            TrieNode node=root;
            int index=0;
            for(int i=0;i<chs.length;i++){
                index=chs[i]-'a';
                if(node.nexts[index]==null){
                    return 0;
                }
                node=node.nexts[index];
            }
            return node.path;
        }
        public static void main(String[] args) {
            Trie trie = new Trie();
            System.out.println(trie.search("zuo"));
            trie.insert("zuo");
            System.out.println(trie.search("zuo"));
            trie.delete("zuo");
            System.out.println(trie.search("zuo"));
            trie.insert("zuo");
            trie.insert("zuo");
            trie.delete("zuo");
            System.out.println(trie.search("zuo"));
            trie.delete("zuo");
            System.out.println(trie.search("zuo"));
            trie.insert("zuoa");
            trie.insert("zuoac");
            trie.insert("zuoab");
            trie.insert("zuoad");
            trie.delete("zuoa");
            System.out.println(trie.search("zuoa"));
            System.out.println(trie.prefixNumber("zuo"));

        }
    }
}
