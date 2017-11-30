package com.test.redis;

import redis.clients.jedis.Jedis;

/**
 * 测试Redis字符串
 * @author lzf
 **/

public class TestString {

    public static void main( String[] args ){
        //连接Redis 服务
        Jedis jedis = new Jedis("47.93.244.157", 6379);

        //setResult结果为OK，代表返回成功
        String setResult = jedis.set("test_key2", "测试3");
        System.out.println(setResult);
        String keyValue = jedis.get("test_key2");
        System.out.println(keyValue);

        //退出连接
        jedis.quit();
    }
}
