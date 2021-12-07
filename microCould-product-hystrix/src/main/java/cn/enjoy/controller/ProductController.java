package cn.enjoy.controller;

import cn.enjoy.service.IProductService;
import cn.enjoy.vo.Product;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/prodcut")
public class ProductController {
    @Resource
    private IProductService iProductService;
    @Resource
    private DiscoveryClient client; //进行Eureka的发现服务

    @RequestMapping(value = "/get/{id}")
    @HystrixCommand(fallbackMethod = "getFallback")
    public Object get(@PathVariable("id") long id){
        Product product = iProductService.get(id);
        if(product == null){
            throw  new RuntimeException("该产品已下架");
        }
        return product;
    }

    public Object getFallback( long id){
        Product product = new Product();
        product.setProductId(0L);
        product.setProductName("HystrixName");
        product.setProductDesc("HystrixDesc");
        return product;
    }

    @RequestMapping(value = "/add")
    public Object add(@RequestBody Product product){
        return iProductService.add(product);
    }

    @RequestMapping(value = "list")
    public Object list(){
        return iProductService.list();
    }

    @RequestMapping("distory")
    public Object discover(){ return this.client;}

}
