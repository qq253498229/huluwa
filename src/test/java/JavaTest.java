import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

/**
 * https://www.zhihu.com/question/298769574
 */
public class JavaTest {


    @Test
    public void test() {

        int count = 0;
        for (int i = 0; i < 10; i++) {
            List<Map<String, Object>> list = new ArrayList<>();
            for (int j = 0; j < 50; j++) {
                Map<String, Object> map = new HashMap<>();
                if (j == 0) {
                    map.put("count", 0);
                    map.put("name", "老爷爷");
                } else {
                    map.put("count", j);
                    map.put("flag", true);
                    map.put("name", "葫芦娃" + j);
                }
                list.add(map);
            }
            count += test1(list);
        }
        BigDecimal average = BigDecimal.valueOf(count).divide(BigDecimal.valueOf(10), 2, BigDecimal.ROUND_HALF_UP);
        System.out.println("平均值是:" + average);

    }

    private int test1(List<Map<String, Object>> list) {
        int count = 1;
        boolean flag = false;
        int alive = 0;
        while (true) {
            // 去1-50之间的随机数
            Random random = new Random();
            int i = random.nextInt(50);
            Map<String, Object> person = list.get(i);
            Integer personCount = (Integer) person.get("count");
            if (personCount == 0) {
                // 老爷爷
                if (flag) {
                    flag = false;
                    alive++;
                }
            } else {
                // 葫芦娃
                if (!flag && (boolean) person.get("flag")) {
                    person.put("flag", false);
                    flag = true;
                }
            }
            if (alive == 49) {
                break;
            }

            count++;
        }
        System.out.println("第" + count + "天的时候，老爷爷知道了其余49个葫芦娃都还健在。");
        return count;
    }

}
