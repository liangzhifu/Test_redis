package com.test.redis;

import redis.clients.jedis.Jedis;

/**
 * 测试Redis集合
 *
 * @author lzf
 **/

public class TestSet {

    public static void main( String[] args ){
        //连接Redis 服务
        Jedis jedis = new Jedis("47.93.244.157", 6379);

        //添加  
        jedis.sadd("set_key","liuling");
        jedis.sadd("set_key","xinxin");
        jedis.sadd("set_key","ling");
        jedis.sadd("set_key","zhangxinxin");
        jedis.sadd("set_key","who");
        //移除noname  
        jedis.srem("set_key","who");
        System.out.println(jedis.smembers("set_key"));//获取所有加入的value  
        System.out.println(jedis.sismember("set_key", "who"));//判断 who 是否是set_key集合的元素  
        System.out.println(jedis.srandmember("set_key"));
        System.out.println(jedis.scard("set_key"));//返回集合的元素个数  
        
        //退出连接
        jedis.quit();
    }
}
