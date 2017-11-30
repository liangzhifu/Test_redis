package com.test.redis;

import redis.clients.jedis.Jedis;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //连接Redis 服务
        Jedis jedis = new Jedis("47.93.244.157", 6379);
        System.out.println("Connection to server sucessfully");
        //查看服务是否运行
        System.out.println("Server is running: "+jedis.ping());
        //退出连接
        jedis.quit();
    }
}
