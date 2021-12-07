package cn.enjoy.feign;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xujianhao
 * @version 1.0
 * @description: fegin配置设置
 * @date 2021/7/25 21:03
 */
@Configuration
public class FeignClientConfig {
    @Bean
    public BasicAuthRequestInterceptor getBasicAuthRequestInterceptor(){
        return new BasicAuthRequestInterceptor("admin","enjoy");
    }
}
