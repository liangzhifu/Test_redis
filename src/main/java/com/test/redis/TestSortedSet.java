package com.test.redis;

import redis.clients.jedis.Jedis;

/**
 * 测试Redis有序集合
 *
 * @author lzf
 **/

public class TestSortedSet {
    public static void main( String[] args ){
        //连接Redis 服务
        Jedis jedis = new Jedis("47.93.244.157", 6379);

        try{
            //jedis 排序
            //注意，此处的rpush和lpush是List的操作。是一个双向链表（但从表现来看的）
            jedis.del("sortedset_key");//先清除数据，再加入数据进行测试
            jedis.rpush("sortedset_key", "1");
            jedis.lpush("sortedset_key","6");
            jedis.lpush("sortedset_key","3");
            jedis.lpush("sortedset_key","9");
            System.out.println(jedis.lrange("sortedset_key",0,-1));// [9, 3, 6, 1]
            System.out.println(jedis.sort("sortedset_key")); //[1, 3, 6, 9]  //输入排序后结果
            System.out.println(jedis.lrange("sortedset_key",0,-1));
        }catch (Exception e){
            
        }
        //退出连接
        jedis.quit();
    }
}
