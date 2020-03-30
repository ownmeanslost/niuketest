import java.math.BigInteger;
import java.util.Scanner;

/**
 * @ClassName: ErJinzhi
 * @Author: shaofan.li
 * @Description:
 * @Date: 2020/1/28 14:26
 */

//各位取反+1
public class erjinzhi {

    public static void main(String[] args){

        Scanner cin = new Scanner(System.in);
        while(cin.hasNext()){
            System.out.println(new BigInteger(cin.next()).toString(2));
        }


    }
}
