package cn.enjoy.service;

import cn.enjoy.vo.Product;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author xujianhao
 * @version 1.0
 * @description: 失败调用(降级处理)
 * @date 2021/8/26 21:42
 */
@Component
public class IProductClientServiceFallbackFactory implements FallbackFactory<IProductClientService> {

    @Override
    public IProductClientService create(Throwable throwable) {
        return new IProductClientService() {
            @Override
            public Product getProduct(long id) {
                Product product = new Product();
                product.setProductId(999999l);
                product.setProductName("feign-hystrixName");
                product.setProductDesc("feign-hystrixDesx");
                return product;
            }

            @Override
            public List<Product> listProduct() {
                return null;
            }

            @Override
            public boolean addPorduct(Product product) {
                return false;
            }
        };
    }
}
