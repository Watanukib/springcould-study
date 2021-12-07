package cn.enjoy.controller;

import cn.enjoy.service.IProductService;
import cn.enjoy.vo.Product;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
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
    public Object get(@PathVariable("id") long id){
        return iProductService.get(id);
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
