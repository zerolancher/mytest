import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-redis.xml"})
public class HashTest {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testAdd() {
        redisTemplate.boundHashOps("11").put("name", "张飞");
        redisTemplate.boundHashOps("11").put("age", "69");
        redisTemplate.boundHashOps("11").put("sex", "男的");
        redisTemplate.boundHashOps("11").put("sex", "女的");
    }

    @Test
    public void testFind() {
       /* Map<String,String> entries = redisTemplate.boundHashOps("11").entries();
        Set<Map.Entry<String, String>> entrySet = entries.entrySet();
        for (Map.Entry<String, String> entry : entrySet) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key+"--"+value);

        }*/

        Set<String> keys = redisTemplate.boundHashOps("11").keys();
        for (String key : keys) {

            String value = (String) redisTemplate.boundHashOps("11").get(key);
            System.out.println(key+"--"+value);
        }
    }

    @Test
    public void testDelete() {
       redisTemplate.boundHashOps("11").delete("sex","age");
    }

}
