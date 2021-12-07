package cn.enjoy.service;

import cn.enjoy.fallback.IZuulClientSerciceallbackFactory;
import cn.enjoy.feign.FeignClientConfig;
import cn.enjoy.vo.Product;
import cn.enjoy.vo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author xujianhao
 * @version 1.0
 * @description: TODO
 * @date 2021/9/9 22:05
 */
@FeignClient(name = "MICROCLOUD-ZUUL-GATEWAY",configuration = FeignClientConfig.class,
fallbackFactory = IZuulClientSerciceallbackFactory.class)
public interface IZUUlClientService {
    @RequestMapping("/enjoy-api/product-proxy/prodcut/get/{id}")
    public Product getProduct(@PathVariable("id")long id);

    @RequestMapping("/enjoy-api/product-proxy/prodcut/list")
    public List<Product> listProduct() ;

    @RequestMapping("/enjoy-api/product-proxy/prodcut/add")
    public boolean addPorduct(Product product) ;

    @RequestMapping("/enjoy-api/user-proxy/users/get/{name}")
    public User getUsers(@PathVariable("name")String name);
}
