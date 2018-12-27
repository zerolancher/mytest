import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * String类型  字符串类型  添加 修改 删除  查询
 * Hash类型     散列类型
 * List类型    列表类型
 * Set类型     集合类型
 * StoredSet类型  有序集合类型
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-redis.xml"})
public class ValueTest {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void  testAdd(){
      redisTemplate.boundValueOps("name").set("张飞");
      redisTemplate.boundValueOps("age").set(23);
      redisTemplate.boundValueOps("name").set("张辽");
    }

    @Test
    public void testFind(){
        Integer age = (Integer)redisTemplate.boundValueOps("age").get();
        System.out.println(age);
        String name = (String) redisTemplate.boundValueOps("name").get();
        System.out.println(name);
    }

    @Test
    public void  testDelete(){
        redisTemplate.delete("name");
    }

}
