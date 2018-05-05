package matrixconvolution;

public class MatrixConvolution
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

    public static int[][] muparr(int[][] arr, int[][] brr)      //행렬 곱셈
    {
        int result[][] = new int[arr.length][brr[0].length];

        for(int i = 0; i < result.length; i++)
        {
            for(int j = 0; j < result[0].length; j++)
            {
                for(int k = 0; k < arr[0].length ; k++)
                {
                    result[i][j] += arr[i][k] * brr[k][j];
                }
            }
        }
        return result;
    }

    public static int sumarr(int[][] arr)       //행렬 원소 합
    {
        int sum = 0;
        
        for(int i = 0; i < arr.length; i++)
        {
            for(int j = 0; j < arr[i].length; j++)
            {
                sum += arr[i][j];
            }
        }
        return sum;
    }   

    public static int[][] covarr(int[][] arr, int[][] brr)      //행렬 변환
    {
        int[][] result = new int[arr.length - brr.length + 1][arr[0].length - brr[0].length + 1];
        int[][] temp = new int[result.length][result[0].length];
        
        for(int i = 0; i < result.length; i++)
        {
            for(int j = 0; j < result[0].length; j++)
            {
                temp = mkarr(arr, brr, i, j);
                temp = muparr(temp, brr);
                result[i][j] = sumarr(temp);
            }
        }
        return result;
    }

    public static int[][] mkarr(int[][] arr, int[][] brr, int x, int y)     //행렬 부분 선택
    {
        int[][] crr = new int[brr.length][brr[0].length];
        
        for(int i = x; i < crr.length + x; i++)
        {
            for(int j = y; j < crr[0].length + y; j++)
            {
                crr[i - x][j - y] = arr[i][j];
            }
        }
        return crr;
    }
    
    public static void main(String[] args)
    {
        int[][] arr = {
            {  1,  2,  3,  4 },
            {  5,  6,  7,  8 },
            {  9, 10, 11, 12 },
            { 13, 14, 15, 16 }
        };
        int[][] brr = {
            { 1, 0, 0 },
            { 0, 1, 0 },
            { 0, 0, 1 }
        };

        int[][] result = covarr(arr, brr);
        
        prtarr(result);
    }   
}
