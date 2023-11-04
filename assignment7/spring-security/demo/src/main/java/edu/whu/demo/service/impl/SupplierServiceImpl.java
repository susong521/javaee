package edu.whu.demo.service.impl;

import edu.whu.demo.domain.Supplier;
import edu.whu.demo.dao.SupplierDao;
import edu.whu.demo.service.ISupplierService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author susong
 * @since 2023-10-21
 */
@Service
public class SupplierServiceImpl extends ServiceImpl<SupplierDao, Supplier> implements ISupplierService {

    @Autowired
    SupplierDao supplierDao;

    @Override
    public Supplier addSupplier(Supplier mySupplier) {
        supplierDao.insert(mySupplier);
        return mySupplier;
    }

    @CacheEvict(cacheNames = "product",key = "#id")
    @Override
    public void removeSupplier(int id) {
        supplierDao.deleteById(id);
    }

    @CacheEvict(cacheNames = "product",key = "#mySupplier.id")
    @Override
    public void updateSupplier(Supplier mySupplier) {
        supplierDao.updateById(mySupplier);
    }
    @Cacheable(cacheNames = "supplier",key = "#id",condition = "#id!=null")
    @Override
    public Supplier getSupplier(int id) {
        return supplierDao.selectById(id);
    }
}
