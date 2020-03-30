
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        MoreThanHalfNum_Solution(new int[]{1,2,3,2,2,2,5,4,2});
    }
    public static int MoreThanHalfNum_Solution(int [] array) {
        if(array.length == 0){
            return 0;
        }
        int[] countArr = new int[array.length];
        String str = "";
        int j =0;
        for(int i =0;i<array.length;i++){
            if(str.contains(String.valueOf(array[i]))){
                for(int m =0; m<str.length(); m++){
                    if(str.charAt(m)-'0' == array[i]){
                        countArr[m]++;
                    }
                }
            }else {
                str += String.valueOf(array[i]);
                countArr[j++] = 1;
            }
        }

        for(int m =0; m<countArr.length; m++){
            if(countArr[m] > array.length/2){
                return str.charAt(m) - '0';
            }
        }

        return 0;
    }
}


