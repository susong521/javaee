package edu.whu.demo.service;

import edu.whu.demo.dao.ProductDao;
import edu.whu.demo.domain.Product;
import com.baomidou.mybatisplus.extension.service.IService;
import edu.whu.demo.domain.Supplier;
import edu.whu.demo.exception.TodoException;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author susong
 * @since 2023-10-21
 */
public interface IProductService extends IService<Product> {
    public Product addProduct(Product myProduct) throws TodoException;

    public void removeProduct(int id) throws TodoException;

    public void updateProduct(Product myProduct) throws TodoException;

    public Product getProduct(int id) throws TodoException;

    public List<Product> findEmpty();

    public List<Product> findAllSuppliers();

    public List<Supplier> findSuppliers(int id);
}