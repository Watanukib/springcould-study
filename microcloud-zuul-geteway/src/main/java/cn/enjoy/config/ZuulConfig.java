package cn.enjoy.config;

import cn.enjoy.fiter.ZuulAppFiter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xujianhao
 * @version 1.0
 * @description: TODO
 * @date 2021/9/9 22:00
 */
@Configuration
public class ZuulConfig {

    @Bean
    public ZuulAppFiter getZuulAppFiter(){
        return new ZuulAppFiter();
    }
}
