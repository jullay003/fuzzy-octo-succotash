import java.util.*;

public class SpiralMatrix{
    public static List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> result = new ArrayList<>();


    //defensive checks:
    if(matrix ==  null || matrix.length == 0){
        return result;
    }



    //4 pointers:
    int top = 0; //row
    int bottom = matrix.length-1;
    int left = 0; //col
    int right = matrix[0].length-1;


    while(top <= bottom  && left <= right) {


        //traverse from left to right
        for(int i = left; i<=right; i++){
            result.add(matrix[top][i]);
        }
        top++;

        //traverse from top to bottom
        for(int i = top; i<=bottom; i++){
            result.add(matrix[i][right]);
        }
        right--;

        //traverse from right to left
        if(top <= bottom){
            for(int i = right; i>=left; i--){
                result.add(matrix[bottom][i]);
            }
            bottom--;

        }

        //traverse from bottom to top
        if(left <= right) {
            for(int i = bottom; i>=top; i--){
                result.add(matrix[i][left]);
            }
            left++;

        }
       
    }
    return result;

}


public static void main(String[] args) {

    int[][] matrix = {
       { 1,  2,  3,  4 },
        { 5,  6,  7,  8 },
        { 9, 10, 11, 12 }
    };

    List<Integer> spiral = spiralOrder(matrix);
    System.out.println("Spiral order: " + spiral);

}

}