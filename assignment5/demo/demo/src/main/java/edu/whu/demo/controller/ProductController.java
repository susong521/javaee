package edu.whu.demo.controller;


import edu.whu.demo.domain.Product;
import edu.whu.demo.domain.Supplier;
import edu.whu.demo.exception.TodoException;
import edu.whu.demo.service.IProductService;
import edu.whu.demo.service.impl.ProductServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author susong
 * @since 2023-10-21
 */
@RestController
@Api("商品管理")
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductServiceImpl psl;
    @ApiOperation("提供id和请求体添加商品")
    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@ApiParam("请求体")@RequestBody Product myProduct){
        Product result = null;
        try{
            result=psl.addProduct(myProduct);
        } catch (TodoException e) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(result);
    }
    @ApiOperation("根据id删除对应商品信息")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id){
        try{
            psl.removeProduct(id);
        } catch (TodoException e) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }
    @ApiOperation("根据id更新对应商品信息")
    @PostMapping("/update")
    public ResponseEntity<Void> updateProduct(@RequestBody Product myProduct){
        try{
            psl.updateProduct(myProduct);
        } catch (TodoException e) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }
    @ApiOperation("根据id查找对应商品信息")
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id){
        Product nowProduct = null;
        try{
            nowProduct=psl.getProduct(id);
        } catch (TodoException e) {
            ResponseEntity.badRequest().build();
        }
        return nowProduct==null? ResponseEntity.noContent().build():ResponseEntity.ok(nowProduct);
    }
    @ApiOperation("查找售空的商品信息")
    @GetMapping("/empty")
    public ResponseEntity<List<Product>> findEmptyProduct(){
        List<Product> ProductList = psl.findEmpty();
        return ResponseEntity.ok(ProductList);
    }
    @ApiOperation("查找指定货物的供应商")
    @GetMapping("/{id}/supplier")
    public List<Supplier> findSuppliers(@PathVariable int id){
        List<Supplier> supplierList = psl.findSuppliers(id);
        return supplierList;
    }
    @ApiOperation("查找所有货物的供应商")
    @GetMapping("/allsuppliers")
    public List<Product> findAllSuppliers(){
        List<Product> mapList = psl.findAllSuppliers();
        return mapList;
    }
}

