/**
 * @ClassName: HuiWen
 * @Author: shaofan.li
 * @Description:
 * @Date: 2020/1/27 11:58
 */
public class HuiWen {

    public static void huiWenArr(int[] huiwen){
        int min = 0;
        for(int i =0; i< huiwen.length; i++){
            //以huiwen[i]为中心，分奇数回文与偶数回文
            int[] leftArr = new int[i];
            for(int j =0;j < i; j++){
                leftArr[j] = huiwen[j];
            }
            int[] rightArr = new int[huiwen.length - i];
            for(int j =i;j < huiwen.length; j++){
                rightArr[j - i] = huiwen[j];
            }
            //奇数回文
            if(leftArr.length != 0){
                int result = 0;
                //计算以huiwen[i]为中心，奇数回文最小值
                for (int j = leftArr.length -1; j >=0; j--){
                    if(rightArr.length == 1){
                       result += leftArr[j];
                    }else {
                        for(int m = 1; m<rightArr.length; m++){
                            //if(leftArr[j] != )
                        }
                    }

                }
            }
            if(leftArr.length == 0){
                //计算以huiwen[i]为中心，奇数回文最小值
                int result = 0;
                for(int j = 0;i< rightArr.length; i++) {
                    result += rightArr[j];
                }
            }
            int temp = 0;


        }
    }
}
