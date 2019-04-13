import java.util.Arrays;

public class Code_04_QuickSort {
    public static void quickSort(int[] arr){
        if(arr==null||arr.length<2){
            return;
        }
        quickSort(arr,0,arr.length-1);
    }
    public static void quickSort(int[] arr,int l,int r){
        if(l<r){
            swap(arr,l+(int)(Math.random()*(r-l+1)),r);//在数组中选择一个随机数,并于最后一个数交换
            int[] p=partition(arr,l,r);
            //产生的随机数与数组中的数进行比较，大的放后面，小的放前面
            //p[0],p[1]为返回的与随机数相同的数，p[0]为数组的开始，p[1]为数组的结束
            quickSort(arr,l,p[0]-1);
            quickSort(arr,p[1]+1,r);
        }
    }
    public static int[] partition(int[] arr,int l,int r){
        int less=l-1;//数组开始位置的前一个位置
        int more=r;//末尾位置
        while (l<more){
            if(arr[l]<arr[r]){//小于
                //l为当前第一个位置的数，如果小于将当前数给less的下一个
                //位置的值，然后让两个指针向后移动
                swap(arr,++less,l++);
            } else if (arr[l]>arr[r]){
                //将大于的数放后边，把后边的数放到当前位置
                //由于当前移动过来的数没有进行比较，所以l不++
                swap(arr,--more,l);
            }else{
                //等于
                l++;
            }
        }
        //最后一个数为随机选取的进行比较的数，把他和more进行交换
        swap(arr,more,r);
        return new int[] {less+1,more};
    }
    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void main(String[] args) {
        int[] arr={4,8,9,1,5,3,2,7};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
