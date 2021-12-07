package cn.enjoy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author xujianhao
 * @version 1.0
 * @description: zuul启动类
 * @date 2021/9/7 23:04
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulApp {
    public static void main(String[] args){
        SpringApplication.run(ZuulApp.class,args);
    }
}
