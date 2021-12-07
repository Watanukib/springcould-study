package cn.xiangxue.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;

/**
 * @author xujianhao
 * @version 1.0
 * @description:
 * @date 2021/7/18 18:03
 */
public class RibbonConfig {
    @Bean
    public IRule ribbonRule(){
        return new RandomRule();
    }

}
