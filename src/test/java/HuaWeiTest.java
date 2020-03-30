import com.sun.deploy.util.StringUtils;

/**
 * @ClassName: HuaWeiTest
 * @Author: shaofan.li
 * @Description:给定一个包含大小写字母和空格的字符串，返回其最后一个单词的长度
 * 如果不存在最后一个单词返回0
 *
 * split（" "）
 * @Date: 2020/2/26 15:29
 */
public class HuaWeiTest {


    public static void main(String[] args) {
        String s =" Hello Wold ";
        System.out.print(lengthOfLastWord(s));

    }

    public static int lengthOfLastWord(String s){
        int result = 0;
        int indexBlank = 0;
        for (int i = s.length() -1; i >=0 ; i--) {
            if(indexBlank == 2){
                break;
            }
            if (s.charAt(i) != 32) {
                //判断字母大小写
                if ((s.charAt(i) <= 'z' && s.charAt(i) >= 'a') || (s.charAt(i) <= 'Z' && s.charAt(i) >= 'A')) {
                    result ++;
                }
            } else {
                indexBlank++;
            }
        }
        return result;
    }
}


