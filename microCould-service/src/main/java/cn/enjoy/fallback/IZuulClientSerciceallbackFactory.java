package cn.enjoy.fallback;

import cn.enjoy.service.IZUUlClientService;
import cn.enjoy.vo.Product;
import cn.enjoy.vo.User;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author xujianhao
 * @version 1.0
 * @description: TODO
 * @date 2021/9/9 22:09
 */
@Component
public class IZuulClientSerciceallbackFactory implements FallbackFactory<IZUUlClientService> {
    @Override
    public IZUUlClientService create(Throwable throwable) {
        return new IZUUlClientService() {
            @Override
            public Product getProduct(long id) {
                return null;
            }

            @Override
            public List<Product> listProduct() {
                return null;
            }

            @Override
            public boolean addPorduct(Product product) {
                return false;
            }

            @Override
            public User getUsers(String name) {
                User user = new User();
                user.setSex("F");
                user.setAge(17);
                user.setName("zuul-fllback："+name);
                return user;
            }
        };
    }
}
