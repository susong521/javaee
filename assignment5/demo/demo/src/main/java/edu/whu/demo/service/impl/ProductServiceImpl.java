package edu.whu.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import edu.whu.demo.domain.Product;
import edu.whu.demo.dao.ProductDao;
import edu.whu.demo.domain.Supplier;
import edu.whu.demo.exception.TodoException;
import edu.whu.demo.service.IProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author susong
 * @since 2023-10-21
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductDao, Product> implements IProductService {
    @Autowired
    private ProductDao productDao;
    @Override
    public Product addProduct(Product myProduct) throws TodoException {
        try {
            productDao.insert(myProduct);
        } catch (Exception e) {
            throw new TodoException(TodoException.INPUT_ERROR,"添加失败");
        }
        return myProduct;
    }

    @Override
    public void removeProduct(int id) throws TodoException {
        try{
            productDao.deleteById(id);
        } catch (Exception e) {
            throw new TodoException(TodoException.DELETE_ERROR,"商品不存在");
        }

    }

    @Override
    public void updateProduct(Product myProduct) throws TodoException {
        try{
            productDao.updateById(myProduct);
        } catch (Exception e) {
            throw new TodoException(TodoException.UPDATE_ERROR,"更新失败");
        }
    }

    @Override
    public Product getProduct(int id) throws TodoException {
        Product product;
        try{
            product=productDao.selectById(id);
        } catch (Exception e) {
            throw new TodoException(TodoException.GET_ERROR,"查询失败");
        }
        return product;
    }

    @Override
    public List<Product> findEmpty() {
        LambdaQueryWrapper<Product> qw = new LambdaQueryWrapper<>();
        qw.eq(Product::getNum,0);
        List<Product> emptyProductList= productDao.selectList(qw);
        return emptyProductList;
    }

    @Override
    public List<Product> findAllSuppliers() {
        List<Product> list = productDao.findAllProductSuppliers();
        return list;
    }

    @Override
    public List<Supplier> findSuppliers(int id) {
        List<Supplier> supplierList=productDao.findAllSupplierByproductId(id);
        return supplierList;
    }
}
