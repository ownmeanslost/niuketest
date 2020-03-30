import java.math.BigInteger;

/**
 * @ClassName: BTtaijie
 * @Author: shaofan.li
 * @Description:
 * @Date: 2020/1/27 21:06
 */
public class BTtaijie {
    public static int JumpFloorII(int target) {
        BigInteger[] arr = new BigInteger[target + 1];
        if(target == 1){
            return 1;
        }else{
            arr[0] = BigInteger.valueOf(1);
            arr[1] = BigInteger.valueOf(1);
            return floor(target, arr).intValue();
        }
    }

    public static BigInteger floor(int n,BigInteger[] arr){
        if(arr[n]!= null){
            return arr[n];
        }
        BigInteger result =  BigInteger.ZERO;
        for(int i =0; i< n; i++){
            result = result.add(floor(i, arr));
        }
        arr[n] = result;
        return arr[n];
    }

    public static void main(String[] args) {
        JumpFloorII(2);
    }
}
