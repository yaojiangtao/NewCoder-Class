import java.util.Arrays;

public  class Code_00_BubbleSort {
    public static void bubbleSort(int[] arr){
        if(arr==null || arr.length < 2){
            return;
        }
        for(int e=arr.length-1;e>0;e--){
            for(int j=0;j<e;j++){
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
    }
    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void main(String[] args) {
        int[] arr={4,5,8,2,3,9,6};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
