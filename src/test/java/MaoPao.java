/**
 * @ClassName: MaoPao
 * @Author: shaofan.li
 * @Description:
 * @Date: 2020/1/21 12:44
 */
public class MaoPao {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 9, 5, 4, 8, 1};

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length - 1 -i; j++){
                if(arr[j] > arr[j+1]){
                    changePosition(j,j+1, arr);
                }
            }

            printArr(arr);
        }

    }


    /*
    *
     *功能描述 交换数组位置
     * @author shaofan.li
     * @date
     * @param
     * @return
     */
    private static void changePosition(int current, int last, int[] arr){
        int temp = arr[current];
        arr[current] = arr[last];
        arr[last] = temp;
    }

    private static void printArr(int[] arr){
       System.out.println(arr);
    }
}
