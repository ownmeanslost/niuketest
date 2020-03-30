/**
 * @ClassName: Ncifang
 * @Author: shaofan.li
 * @Description:
 * @Date: 2020/1/28 15:45
 */
public class N次方 {

    public static double Power(double base, int exponent) {
        double[] cache = new double[Math.abs(exponent)];
        cache[0] = base;
        double result = aa(base, Math.abs(exponent), cache);
        if(exponent < 0){
            result = 1/result;
        }
        return result;

    }

    public static double aa(double base, int exponent, double[] cache){
        if(exponent == 0){
            return 1;
        }
        if(cache[exponent -1]!= 0.0){
            return cache[exponent -1];
        }
        if(exponent %2 == 0){
            double result = aa(base, exponent/2, cache) * aa(base, exponent/2, cache);
            cache[exponent -1] = result;
            return result;
        }
        if(exponent %2 == 1){

            double result = aa(base, (exponent -1)/2, cache) * base * aa(base, (exponent -1)/2, cache);
            cache[exponent -1] = result;
            return result;
        }

        return 0.0;

    }

    public static void main(String[] args) {
        Power(2, -3);
    }
}
