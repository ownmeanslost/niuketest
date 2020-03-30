/**
 * @ClassName: 深度优先遍历
 * @Author: shaofan.li
 * @Description:
 * @Date: 2020/2/1 15:38
 */
public class shenduyouxianbianli {
    public static void main(String[] args) {
        System.out.println(movingCount(15, 20,20));
    }

    public static int count = 0;
    public static int movingCount(int threshold, int rows, int cols)
    {
        if(threshold == 0 && rows != 0 && cols !=0){
            return 1;
        }
        if(threshold != 0 && (rows == 0 || cols ==0)){
            return 0;
        }
        int[][] arr = new int[rows][cols];
        dsf(arr, 0,0, threshold);
        return  count;
    }

    public static void dsf(int[][] arr, int i, int j, int threshold){
        //校验不通过
        if(!check(i, j, threshold)){
            arr[i][j] = 1;
            return;
        }
        //访问过
        if(arr[i][j] == 1){
            return;
        }
        //可访问
        count++;
        arr[i][j] = 1;
        //访问上下左右
        if(i-1 >=0){
            dsf(arr, i - 1, j, threshold);
        }

        if(j + 1 < arr[0].length){
            dsf(arr, i, j+1, threshold);
        }

        if(i+1 < arr.length){
            dsf(arr, i+1, j, threshold);
        }
        if(j - 1 >= 0){
            dsf(arr, i, j-1, threshold);
        }



    }

    public static boolean check(int i, int j, int threshold){
        /*String value1 = String.valueOf(i);
        String value2 = String.valueOf(j);

        int num = 0;
        for(int k = 0; k< value1.length(); k++){
            num += (value1.charAt(k) - '0');
        }
        for(int k = 0; k< value2.length(); k++){
            num += (value2.charAt(k) - '0');
        }*/

        int sum = 0;
        while(i > 0) {
            sum += i % 10;
            i /= 10;
        }
        while(j > 0) {
            sum += j % 10;
            j /= 10;
        }
        return sum <= threshold;
    }
}
