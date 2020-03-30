import java.util.Arrays;

/**
 * @ClassName: kuaipai
 * @Author: shaofan.li
 * @Description:
 * @Date: 2020/1/21 12:59
 */
public class kuaipai {
    public static void main(String[] args) {
        int[] arr = new int[]{3,2,1,5,6,4};
        int i = 0;
        int j = arr.length -1;
        quickSort(i, j, arr);
        printArr(arr);
    }


    /*
    *
     *功能描述 快速排序
     * @author shaofan.li
     * @date
     * @param
     * @return
     */
    private static void quickSort(int i, int j, int[] arr){
        if(i < j){
            int low = i;
            int height = j;
            int temp = arr[i];
            while (i < j){
                //遍历右边，找到比关键数据小的坐标
                while ((i < j) && temp <= arr[j]){
                    j--;
                }
                arr[i] = arr[j];
                while ((i < j) && temp > arr[i]){
                    i++;
                }
                arr[j] = arr[i];
            }
            arr[i] = temp;
            quickSort(low, i - 1, arr);
            quickSort(i + 1, height, arr);
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
        System.out.println(Arrays.toString(arr));
    }
}
