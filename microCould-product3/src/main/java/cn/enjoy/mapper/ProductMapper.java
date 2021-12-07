package cn.enjoy.mapper;

import cn.enjoy.vo.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

    boolean create(Product product);

    Product findById(Long id);

    List<Product> findAll();

}
