import java.util.Arrays;

public class Code_03_HeapSort {
    public static void heapSort(int[] arr){
        if(arr==null||arr.length<2){
            return;
        }
        for(int i =0;i<arr.length;i++){
            heapInsert(arr,i);//建大根堆
        }
        int size =arr.length;
        //将堆顶与最后一个进行交换
        swap(arr,0,--size);
        //继续进行比较
        while(size>0){
            heapify(arr,0,size);
            swap(arr,0,--size);
        }
    }
    public static void heapInsert(int[] arr,int index){
        while (arr[index] > arr[(index-1)/2]) {//如果当前数大于它的父节点
                swap(arr,index,(index-1)/2);
                index=(index-1)/2;//将它的父节点赋值给index继续进行比较
            }
        }
        public static void heapify(int[] arr,int index,int size){
            int left=index*2+1;
            while (left<size){
                //比较左子树和右子树将大的给largest
                int largest=left+1<size && arr[left+1]>arr[left]?left+1:left;
                //将当前值与largest进行比较，将大的给largest
                largest=arr[largest]>arr[index]?largest:index;
                if(largest==index){//说明当前值为最大值
                    break;

                }
                //否则将当前值与largest交换
                swap(arr,largest,index);
                //将largest赋值给当前值
                index=largest;
                left=index*2+1;
            }
        }
        public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        }
    public static void main(String[] args) {
        int[] arr={4,8,9,4,5,3,2,7};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    }

