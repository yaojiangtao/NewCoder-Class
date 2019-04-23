public class Code_07_MinPath {
    public static int walk(int[][] matrix,int i,int j){
        if(i==matrix.length-1&&j==matrix[0].length-1){
            return matrix[i][j];
        }
        if(i==matrix.length-1){
            return matrix[i][j] + walk(matrix,i,j+1);
        }
        if(j==matrix[0].length-1){
            return matrix[i][j]+walk(matrix,i+1,j);
        }
        int right=walk(matrix,i,j+1);
        int down=walk(matrix,i+1,j);
        return matrix[i][j]+Math.min(right,down);
    }


}
