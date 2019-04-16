import java.util.Arrays;

public class Code_02_SelectionSort {
    public static void SelectionSort(int[] arr){
        if(arr==null||arr.length<2){
            return;
        }
        for(int i =0;i<arr.length-1;i++){
            int mid=i;
            for(int j=i+1;j<arr.length;j++){
               // if(arr[mid]>arr[j])
                //swap(arr,mid,j);

               mid = arr[j] < arr[mid] ? j : mid;

            }
            swap(arr,i,mid);
        }
    }
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void main(String[] args) {
        int[] arr={5,4,6,8,2,1,9};
        SelectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
