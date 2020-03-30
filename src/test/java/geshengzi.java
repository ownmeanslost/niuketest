/**
 * @ClassName: 割绳子
 * @Author: shaofan.li
 * @Description:
 * @Date: 2020/2/1 12:45
 */
public class geshengzi {

    public static void main(String[] args) {
        cutRope(5);
    }
    public static int cutRope(int target) {
        if(target == 2){
            return 1;
        }
        if(target == 3){
            return 2;
        }
       int a=   test(target);
       return a;
    }


    public  static int test( int target){
        if(target == 1){
            return 1;
        }
        if(target == 0){
            return 1;
        }
        int[] arr1 = new int[target];
        for(int i =1; i<= target; i++){
            arr1[i -1] = test(target -i)*i;
        }

        int max = arr1[0];
        for(int i =0; i<arr1.length; i++){
            if(max < arr1[i]){
                max = arr1[i];
            }
        }
        return max;
    }
}
