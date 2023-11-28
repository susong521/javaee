package edu.whu.demo;

import edu.whu.demo.exception.TodoException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CommodityManagementSystem {
    private Map<Long, commodity> commodities=
            Collections.synchronizedMap(new HashMap<Long,commodity>());
    public commodity addCommodity(commodity myCommodity) throws TodoException {
        try{
            commodities.put(myCommodity.getId(),myCommodity);
        } catch (Exception e) {
            throw new TodoException(TodoException.INPUT_ERROR,"添加失败");
        }
        return myCommodity;
    }
    public void removeCommodity(long id) throws TodoException {
        try{
            commodities.remove(id);
        } catch (Exception e) {
            throw new TodoException(TodoException.DELETE_ERROR,"商品不存在");
        }
    }
    public void updateCommodity(long id,commodity myCommodity) throws TodoException {
        try {
            commodity newCommodity = commodities.get(id);
            newCommodity.setName(myCommodity.name);
            newCommodity.setNum(myCommodity.num);
            newCommodity.setPrice(myCommodity.price);
            commodities.put(id, newCommodity);
        } catch (Exception e) {
            throw new TodoException(TodoException.UPDATE_ERROR,"更新失败");
        }
    }
    public commodity getCommodity(long id) throws TodoException {
        commodity c;
       try {
           c = commodities.get(id);
       } catch (Exception e) {
           throw new TodoException(TodoException.GET_ERROR,"查询失败");
       }
       return c;
    }
    public List<commodity> findEmpty(){
        List<commodity> result = new ArrayList<commodity>();
        for(commodity nowCommodity:commodities.values()){
            if(nowCommodity.num==0) result.add(nowCommodity);
        }
        return result;
    }
}
