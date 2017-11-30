package com.test.redis;

import redis.clients.jedis.Jedis;

/**
 * 测试Redis列表
 *
 * @author lzf
 **/

public class TestList {

    public static void main( String[] args ){
        //连接Redis 服务
        Jedis jedis = new Jedis("47.93.244.157", 6379);

        //开始前，先移除所有的内容  
        jedis.del("list_key");
        System.out.println(jedis.lrange("list_key",0,-1));
        //先向key list_key中存放三条数据  
        jedis.lpush("list_key","spring");
        jedis.lpush("list_key","struts");
        jedis.lpush("list_key","hibernate");
        //再取出所有数据jedis.lrange是按范围取出，  
        // 第一个是key，第二个是起始位置，第三个是结束位置，jedis.llen获取长度 -1表示取得所有  
        System.out.println(jedis.lrange("list_key",0,-1));
        
        jedis.del("list_key");
        jedis.rpush("list_key","spring");
        jedis.rpush("list_key","struts");
        jedis.rpush("list_key","hibernate");
        System.out.println(jedis.lrange("list_key",0,-1));

        //退出连接
        jedis.quit();
    }
}
