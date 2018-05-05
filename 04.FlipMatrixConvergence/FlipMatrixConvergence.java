package flipmatrixconvergence;

public class FlipMatrixConvergence 
{
    public static void prtarr(int[][] arr)      //행렬 출력
    {
        for(int i = 0; i < arr.length; i++)
        {
            for(int j = 0; j < arr[i].length; j++)
            {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }   
    
    public static int[][] chxarr(int[][] arr)       //행렬 x축 반전
    {
        int[][] temp = new int[arr.length][arr[0].length];
        for(int i = 0; i < arr.length; i++)
        {
            for(int j = 0; j < arr[i].length; j++)
            {
                temp[i][j] = arr[arr.length -1 - i][j]; 
            }
        }
        return temp;
    }
    

    public static int[][] chyarr(int[][] arr)       //행렬 y축 반전
    {
        int[][] temp = new int[arr.length][arr[0].length];
        for(int i = 0; i < arr.length; i++)
        {
            for(int j = 0; j < arr[i].length; j++)
            {
                temp[i][j] = arr[i][arr[i].length -1 -j]; 
            }
        }
        return temp;
    }
    
    public static int[][] choarr(int[][] arr)       //행렬 원점 반전
    {
        int[][] temp = new int[arr.length][arr[0].length];
        for(int i = 0; i < arr.length; i++)
        {
            for(int j = 0; j < arr[i].length; j++)
            {
                temp[i][j] = arr[arr.length -1 - i][arr[0].length -1 - j]; 
            }
        }
        return temp;
    }
 
    public static int[][] convarr(int[][] arr)       //반전 행렬 융합
    {
        int[][] result = new int[arr.length * 2][arr[0].length * 2];
        int[][] temp = new int[arr.length][arr[0].length];
        
        for(int i = 0; i < arr.length; i++)
        {
            for(int j = 0; j < arr[0].length; j++)
            {
                result[i][j] = arr[i][j];
            }
        }
        
        temp = chyarr(arr);
        for(int i = 0; i < arr.length; i++)
        {
            for(int j = 0; j < arr[0].length; j++)
            {
                result[i][arr[0].length + j] = temp[i][j];
            }
        }
        
        temp = chxarr(arr);
        for(int i = 0; i < arr.length; i++)
        {
            for(int j = 0; j < arr[0].length; j++)
            {
                result[arr.length + i][j] = temp[i][j];
            }
        }
        
        temp = choarr(arr);
        for(int i = 0; i < arr.length; i++)
        {
            for(int j = 0; j < arr[0].length; j++)
            {
                result[arr.length + i][arr[0].length + j] = temp[i][j];
            }
        }
        return result;
    }    
    
    public static void main(String[] args)
    {
        int[][] arr = {
            {  1,  2,  3 },
            {  4,  5,  6 },
            {  7,  8,  9 },
            { 10, 11, 12 }
        };

        int[][] result = convarr(arr);
 
        prtarr(result);
    }
    
}
