package matrix.multiplication;

public class MatrixMultiplication 
{
    public static void prtarr(int[][] arr)	//Çà·Ä Ãâ·Â
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

    public static boolean chkarr(int[][] arr, int[][] brr)	//Çà·Ä °ö¼À °¡´É ÆÇ´Ü
    {
        if(arr[0].length == brr.length)
            return true;
        else
            return false;
    }
    
    public static int[][] muparr(int[][] arr, int[][] brr)	//Çà·Ä °ö¼À
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
    
    public static void main(String[] args)
    {
        int[][] arr = {
            { 1, 2, 3 },
            { 3, 4, 5 }
        };
        int[][] brr = {
            { 1, 1 },
            { 1, 1 },
            { 1, 1 }
        };

        int[][] result;    
        
        if(chkarr(arr, brr))
        {
            result = muparr(arr, brr);
            prtarr(result);
        }
        else
        {
            System.out.println("This matrix can not be multiplied.");
        }
    }
}
