import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collections;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-redis.xml"})
public class ListTest {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testAdd(){
        redisTemplate.boundListOps("list").leftPush("刘备");
        redisTemplate.boundListOps("list").leftPush("张飞");
        redisTemplate.boundListOps("list").leftPush("张大飞");
        redisTemplate.boundListOps("list").rightPush("1");
        redisTemplate.boundListOps("list").rightPush("2");
        redisTemplate.boundListOps("list").rightPush("3");
    }

    @Test
    public void testFind(){
        List list = redisTemplate.boundListOps("list").range(0, -1);
        System.out.println(list.toString());
       /* System.out.println(redisTemplate.boundListOps("list").rightPop());
        System.out.println(redisTemplate.boundListOps("list").leftPop());*/

    }

    @Test
    public void testSet(){
        redisTemplate.boundListOps("list").set(2,"曹操");
    }

    @Test
    public void  testDelete(){
        redisTemplate.boundListOps("list").remove(-6,"张大飞");
    }
}
