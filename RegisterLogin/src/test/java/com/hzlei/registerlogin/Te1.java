package com.hzlei.registerlogin;

import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * @author hzlei
 * @Package com.hzlei.registerlogin
 * @date 2019/10/19 19:42
 * @Description: TODO
 */
public class Te1 {


    @Test
    public void t1() {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        System.out.println(jedis.hget("code", "code"));
    }

}
