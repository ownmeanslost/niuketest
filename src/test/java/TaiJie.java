
import java.math.BigInteger;
import java.util.Scanner;

/**
 * @ClassName: TaiJie
 * @Author: shaofan.li
 * @Description:
 * @Date: 2020/1/27 20:34
 */
public class TaiJie {

    public static BigInteger floor(int n,BigInteger[] arr){
        if(arr[n - 1]!= null){
            return arr[n -1];
        }
        arr[n -1] = floor(n-1, arr).add(floor(n-2,arr));
        return arr[n-1];
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        BigInteger[] arr = new BigInteger[n];
        if(n == 1){
            System.out.print(1);
        } else if(n == 2){
            System.out.print(2);
        }else{
            arr[1] = BigInteger.valueOf(2);

            arr[0] = BigInteger.valueOf(1);

            System.out.print(floor(n, arr));
        }

    }
}
