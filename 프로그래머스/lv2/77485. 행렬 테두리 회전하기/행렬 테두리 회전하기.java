class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] matrix = new int[rows][columns]; 
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                matrix[i][j]=i*columns + j+1;
            }
        }
        
        for(int z=0;z<queries.length;z++){
            int r1 = queries[z][0]-1; 
            int c1 = queries[z][1]-1;
            int r2 = queries[z][2]-1;
            int c2 = queries[z][3]-1;
            
            int temp = matrix[r1][c1];
            int min = temp;
            for(int i = r1; i < r2; i++){
                matrix[i][c1] = matrix[i+1][c1];
                if(min > matrix[i][c1]) min = matrix[i][c1];
            }
            for(int i = c1; i < c2; i++){
                matrix[r2][i] = matrix[r2][i+1];
                if(min > matrix[r2][i]) min = matrix[r2][i];
            }
            for(int i = r2; i > r1; i--){
                matrix[i][c2] = matrix[i-1][c2];
                if(min > matrix[i][c2]) min =matrix[i][c2];
            }
            for(int i = c2; i > c1; i--){
                matrix[r1][i] = matrix[r1][i-1];
                if(min > matrix[r1][i]) min = matrix[r1][i];
            }
            matrix[r1][c1+1] = temp;

            answer[z]=min;
        }

        return answer;
    }
    
    
}