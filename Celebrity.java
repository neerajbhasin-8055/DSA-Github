import java.util.Arrays;

class Celebrity{
    // Brute force
    public static int celeb(int[][] matrix){
        int  n = matrix.length;
        int[] knowsMe = new int[n];
        int[] iKnow = new int[n];
        for(int i = 0 ; i < n ;i++){
            for(int j = 0 ; j < n; j++){
                if(matrix[i][j] == 1){
                    knowsMe[j]++;
                    iKnow[i]++;
                }
            }
        }
        int celebrity = -1;
        for(int k = 0 ; k < n ; k++){
            if(iKnow[k] == 0 && knowsMe[k]==n-1){
                celebrity = k ;
                break;
            }
        }
        return celebrity;
    }

    // optimal approach 
    public static int celebrityOptimal(int[][] matrix){
        int n = matrix.length;
        int top = 0 ;
        int down = n-1;
        while(top < down){
            if(matrix[top][down] == 1 ){
                top ++; 
            }else if(matrix[down][top] == 1){
                down--;
            }else{
                top ++ ;
                down--;
            }
        }
        if(top > down) return -1;
        for(int i = 0 ; i < n;i++){
            if(i==top)continue;
            if(matrix[top][i] == 1 || matrix[i][top] == 0){
                return -1;
            }
        }
        return top;
    }
    public static void main(String[] args) {
        int[][] matrix = {{0,1,1,0},{0,0,0,0},{1,1,0,0},{0,1,1,0}};
        int c = celebrityOptimal(matrix);
        System.out.println(c);

    }
}