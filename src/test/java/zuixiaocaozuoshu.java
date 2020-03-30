/**
 * @ClassName: zuixiaocaozuoshu
 * @Author: shaofan.li
 * @Description:
 * @Date: 2020/1/22 13:58
 */
public class zuixiaocaozuoshu {
    /**
     * 返回从源字符串到目标字符串的最小操作数
     * source: 源字符串
     * target：目标字符串
     * 返回：最小操作数
     */
    public int test1(String source, String target){
        int m = source.length();
        int n = target.length();
        if(m == 0 && n == 0){
            return 0;
        }
        int[][] arr = new int[m + 1][n + 1];
        for (int i = 0 ; i <= m ; i++){
            arr[i][0] = i;
        }
        for (int i = 0 ; i <= n ; i++){
            arr[0][i] = i;
        }
        if(m != 0 && n !=0){
            for (int i = 1; i <= m; i++){
                for(int j =1; j<=n; j++){
                    int count = 0;
                    char a = source.charAt(i);
                    char b = target.charAt(j);
                    if(a != b){
                        count = 1;
                    }
                    arr[i][j] = Math.min(arr[i-1][j]+1,Math.min(arr[i][j-1]+1, arr[i - 1][j - 1] + count));
                }
            }
        }

        return arr[m][n];
    }
}
