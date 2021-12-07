package cn.enjoy.service;

import cn.enjoy.feign.FeignClientConfig;
import cn.enjoy.vo.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author xujianhao
 * @version 1.0
 * @description: feign服务接口
 * @date 2021/7/25 20:50
 */
@FeignClient(name = "MICRO-COULD-PRODUCT",configuration = FeignClientConfig.class,
fallbackFactory = IProductClientServiceFallbackFactory.class)
public interface IProductClientService {
    @RequestMapping("/prodcut/get/{id}")
    public Product getProduct(@PathVariable("id")long id);

    @RequestMapping("/prodcut/list")
    public List<Product> listProduct() ;

    @RequestMapping("/prodcut/add")
    public boolean addPorduct(Product product) ;

}
