package com.atguigu.pojo;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 购物车对象---->后续改进:把购物车做成数据库版本
 * @author abel
 * @create 2023-09-18 14:24
 */
public class Cart {

//    private Integer totalCount;
//    private BigDecimal totalPrice;
    /**
     *  key是商品编号，
     *  value，是商品信息
     */
    private Map<Integer,CartItem> items = new LinkedHashMap<Integer, CartItem>();

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    /**
     *添加商品项
     * @param cartItem
     */
    public void addItem(CartItem cartItem){
        // 先查看购物车中是否已经添加过此商品，如果已添加，则数量累加，总金额更新，
        // 如果没有添加过，直接放到集合中即可
        CartItem item = items.get(cartItem.getId());

        if(item == null){
            // 之前没添加过此商品
            items.put(cartItem.getId(),cartItem);
        }else {
            // 已经 添加过的情况
            item.setCount(item.getCount()+1);
            item.setTotalPrice(item.getPrice().multiply((new BigDecimal(item.getCount()))));
        }

    }

    /**
     *删除商品项
     * @param id
     */
    public void deleteItem(Integer id){
        items.remove(id);
    }

    /**
     *清空购物车
     */
    public void clear(){
        items.clear();
    }

    /**
     *修改商品数量
     * @param id
     * @param count
     */
    public void updateCount(Integer id,Integer count){
        // 先查看购物车中是否有此商品。如果有，修改商品数量，更新总金额
        CartItem cartItem = items.get(id);
        if(cartItem != null){
            cartItem.setCount(count);
            cartItem.setTotalPrice(cartItem.getPrice().multiply((new BigDecimal(cartItem.getCount()))));
        }

    }

    public Integer getTotalCount() {
        Integer totalCount = 0;
        for(Map.Entry<Integer,CartItem>entry:items.entrySet()){
            totalCount += entry.getValue().getCount();
        }
        return totalCount;
    }

    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        for(Map.Entry<Integer,CartItem>entry:items.entrySet()){
            totalPrice = totalPrice.add(entry.getValue().getTotalPrice());
        }
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }


}
