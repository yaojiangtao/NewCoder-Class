public class Code_02_Hanoi {
    public static void hanoi(int n){
        if(n>0){
            func(n,"left","mid","right");
        }
    }

    public static void func(int N,String from,String help, String to){
        if(N==1){
            System.out.println("move"+1+"from" + from + " to " + to);
        }else {
            func(N - 1,  from, to, help);
            System.out.println("move"+N+"from"+from+"to"+to);
            func(N-1,help,to,from);
        }
    }

    public static void main(String[] args) {
        int n=3;
        hanoi(3);
    }
}
