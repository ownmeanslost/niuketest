/**
 * @ClassName: TestCount
 * @Author: shaofan.li
 * @Description:
 * @Date: 2020/2/3 23:47
 */
public class TestCount {


    public static void main(String args[]) {

        Count count = new Count( );

        count.count(count.getCount( )).getCount( );

        new Count( ).count(count.getCount( ));
    }

    public static class Count {
        volatile Integer count = 2018;



        public Count count(Integer count) {

            System.out.println(++count);

            return this;

        }

        public Integer getCount( ) {

            System.out.println(++count);

            return count;

        }
    }
}
