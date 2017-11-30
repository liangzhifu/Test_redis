package com.test.redis;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 测试Redis哈希
 *
 * @author lzf
 **/

public class TestHash {

    public static void main( String[] args ){
        //连接Redis 服务
        Jedis jedis = new Jedis("47.93.244.157", 6379);

        //-----添加数据----------
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "xinxin");
        map.put("age", "22");
        map.put("qq", "123456");
        jedis.hmset("hash_key",map);
        //取出hash_key中的name，执行结果:[minxr]-->注意结果是一个泛型的List
        //第一个参数是存入redis中map对象的key，后面跟的是放入map中的对象的key，后面的key可以跟多个，是可变参数
        List<String> rsmap = jedis.hmget("hash_key", "name", "age", "qq");
        System.out.println(rsmap);

        //删除map中的某个键值
        jedis.hdel("hash_key","age");
        System.out.println(jedis.hmget("hash_key", "age")); //因为删除了，所以返回的是null
        System.out.println(jedis.hlen("hash_key")); //返回key为hash_key的键中存放的值的个数2
        System.out.println(jedis.exists("hash_key"));//是否存在key为hash_key的记录 返回true
        System.out.println(jedis.hkeys("hash_key"));//返回map对象中的所有key
        System.out.println(jedis.hvals("hash_key"));//返回map对象中的所有value

        Iterator<String> iter=jedis.hkeys("hash_key").iterator();
        while (iter.hasNext()){
            String key = iter.next();
            System.out.println(key+":"+jedis.hmget("hash_key",key));
        }

        //退出连接
        jedis.quit();
    }
}
