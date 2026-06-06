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
    public static void main(String[] args) {
        int[][] matrix = {{0,1,1,0},{0,0,0,0},{1,1,0,0},{0,1,1,0}};
        int c = celeb(matrix);
        System.out.println(c);

    }
}