public class Code_11_MaxGap {
    public static int maxGap(int[] nums){
        //小于两个数就返回
        if(nums==null || nums.length<2){
            return 0;
        }
        int len = nums.length;//数组的大小
        //将整个数组的最大值给min,最小值给max
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        //遍历整个数组，找到最小值和最大值
        for(int i=0;i<len;i++){
            min=Math.min(min,nums[i]);
            max=Math.max(max,nums[i]);
        }
        //最小值等于最大值
        if(min==max){
            return 0;

        }
         boolean[] hasNum = new boolean[len+1];//这个桶是否进过数
        int[] maxs = new int[len+1];//这个桶中的最大值
        int[] mins = new int[len+1];//这个桶中的最小值
        int bid = 0;//新来的一个数应该进哪个桶

        for(int i = 0;i<len;i++){
            bid = bucket(nums[i],len,min,max);//找到在这个数应该进的桶的序号
            mins[bid]=hasNum[bid]?Math.min(mins[bid],nums[i]):nums[i];//比较这个数和当前桶中的最小值
            maxs[bid]=hasNum[bid]?Math.max(maxs[bid],nums[i]):nums[i];//比较这个数和当前桶中的最大值
            hasNum[bid]=true;
        }
        //每次比较当前桶最小值和前一个非空桶的最大值的差值
        int res=0;
        int lastMax=maxs[0];
        int i = 1;
        for(;i<len;i++){
            if(hasNum[i]){
                res=Math.max(res,mins[i]-lastMax);//res为全局最大值
                lastMax=maxs[i];
            }
        }
        return res;
    }

    public static int bucket(long num,long len,long min,long max){
        return (int) ((num-min)*len/(max-min));
        }
}
