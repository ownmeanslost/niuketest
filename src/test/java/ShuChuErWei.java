import java.util.Scanner;

/**
 * @ClassName: ShuChuErWei
 * @Author: shaofan.li
 * @Description:
 * @Date: 2020/1/28 12:49
 */
public class ShuChuErWei {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String arr = scanner.nextLine();
        int n = Integer.valueOf(arr.split(" ")[0]);
        int m = Integer.valueOf(arr.split(" ")[1]);
        int[][] str = new int[n][m];
        for(int i = 0; i< n; i++){
            String str1 = scanner.nextLine();
            for(int j = 0;j < m; j++){
                switch(str1.charAt(j)){
                    case 'Y' : str[i][j] = 1;
                        break;
                    case 'X' : str[i][j] = 0;
                        break;
                    case 'G' : str[i][j] = 2;
                        break;
                    case 'B' : str[i][j] = -1;
                        break;
                    default:
                        break;
                }
            }
        }
        int count = 0;
        //“/”方向遍历str[][],找出线条 蓝色斜线
        for(int k =0 ;k < m; k++){
            boolean flag =false;
            int  j =k;
            int i =0;
            if(str[i][j] == -1 || str[i][j] == 2){
                flag = true;
            }
            while(i != n-1 && j != 0){
                i++; j--;
                if(str[i][j] == -1 || str[i][j] == 2){
                    flag = true;
                }
            }
            if(flag){
                count ++;
            }
        }

        for(int k =1 ;k < n; k++){
            boolean flag =false;
            int  i =k;
            int j = m -1;
            if(str[i][j] == -1 || str[i][j] == 2){
                flag = true;
            }
            while(i != n-1 && j != 0){
                i++; j--;
                if(str[i][j] == -1 || str[i][j] == 2){
                    flag = true;
                }
            }
            if(flag){
                count ++;
            }
        }

        //“\”方向遍历str[][],找出线条 黄色斜线
        for(int k = m-1 ;k >= 0; k--){
            boolean flag =false;
            int  j = k;
            int i =0;
            if(str[i][j] == 1 || str[i][j] == 2){
                flag = true;
            }
            while(i != n -1 && j != m-1){
                i++; j++;
                if(str[i][j] == 1 || str[i][j] == 2){
                    flag = true;
                }
            }
            if(flag){
                count ++;
            }
        }


        for(int k =1 ;k < n; k++){
            boolean flag =false;
            int  j = 0;
            int i =k;
            if(str[i][j] == 1 || str[i][j] == 2){
                flag = true;
            }
            while(i != n -1 && j != m-1){
                i++; j++;
                if(str[i][j] == 1 || str[i][j] == 2){
                    flag = true;
                }
            }
            if(flag){
                count ++;
            }
        }
        System.out.print(count);
    }
}
