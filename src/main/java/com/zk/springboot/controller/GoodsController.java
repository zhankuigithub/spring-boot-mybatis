package com.zk.springboot.controller;


import com.zk.springboot.manager.Single;
import com.zk.springboot.packet.CommonResult;
import com.zk.springboot.packet.IPacket;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("goods")
public class GoodsController {

    private static final String LOCK = "GOOD_LOCK";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Value("${server.port}")
    private String port;

    @Autowired
    private Redisson redisson;


    @GetMapping("test")
    public IPacket buyGoods() {
        RLock lock = redisson.getLock(LOCK);
        lock.lock();
        // synchronized (LOCK) {
        try {
            String result = stringRedisTemplate.opsForValue().get("goods:001");
            int goodsNumber = result == null ? 0 : Integer.parseInt(result);
            if (goodsNumber > 0) {

                int realNumber = goodsNumber - 1;
                stringRedisTemplate.opsForValue().set("goods:001", String.valueOf(realNumber));
                System.out.println("成功买到商品，库存还剩下：" + realNumber + " \t server port：" + port);

            } else {
                System.out.println("商品没了 server port：" + port);
            }
        } finally {
            lock.unlock();
        }
        //  }
        return new CommonResult<>("结束：port ：" + port);
    }


    @GetMapping("single")
    public IPacket single() {
        RLock lock = redisson.getLock(LOCK);
        lock.lock();
        try {
            Single.getInstance();
        } finally {
            lock.unlock();
        }
        return new CommonResult<>();
    }

}
