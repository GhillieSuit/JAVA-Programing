package temp;

public class Temp
{
   public static int[][] conv(int[][] a, int[][] b)
    {
        int[][] ans = new int[a.length-b.length+1][a[0].length-b[0].length+1];
        
        int sum = 0;
        for(int i=0;i<a.length-b.length+1;i++)
        {
            for(int j=0;j<a[0].length-b[0].length+1;j++)
            {
                sum=0;
                for(int k=0;k<b.length;k++)
                {
                    for(int l=0;l<b[0].length;l++)
                    {
                        sum=sum+a[k+i][l+j]*b[k][l];
                    }
                }
                ans[i][j] = sum;
            }
        }        
        return ans;
    }
    
    public static int[] myRow(int[][] tmp, int k)
    {
        return tmp[k];
    }
    public static int[] myf(int a, int b)
    {
        int[] tmp = new int[b];
        for(int k=0;k<tmp.length;k++)
            tmp[k]=b;
        return tmp;
    }
    
    public static int[][] matrixMul(int[][] a, int[][] b)
    {
        int[][] ans = new int[a.length][b[0].length];
        
        int[][] b1 = myTranspose(b);
        
        for(int t=0;t<a.length;t++)
        {
            for(int s=0;s<b[0].length;s++)
            {
                ans[t][s] = inner(myRow(a, t), myRow(myTranspose(b), s));
            }
        }
        return ans;
    }
    
    public static int inner(int[] a, int[] b)
    {
        int sum=0;
        for(int k=0;k<a.length;k++)
            sum=sum+a[k]*b[k];
        return sum;
    }
    
    public static int[][] myTranspose(int[][] a)
    {
        int[][] trs = new int[a[0].length][a.length];
        
        for(int i=0;i<trs.length;i++)
        {
            for(int j=0;j<trs[i].length;j++)
            {
                trs[i][j] = a[j][i];
                // System.out.print(trs[i][j]+" ");
            }
            //System.out.println();
        }
        return trs;
    }
    
    public static void printArray(int[][] arr)
    {
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[0].length;j++)
            {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args)
    {
        int[] s = myf(10, 5);
        
        int[][] a = {
            {  1,  2,  3,  4 },
            {  5,  6,  7,  8 },
            {  9, 10, 11, 12 },
            { 13, 14, 15, 16 }
        };
        int[][] b = {
            { 1, 1, 1 },
            { 1, 1, 1 },
            { 1, 1, 1 }
        };
        
        int[][] c = conv(a, b);
        printArray(c);
    }  
}
