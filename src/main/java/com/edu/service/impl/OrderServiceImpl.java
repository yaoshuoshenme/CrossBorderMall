package com.edu.service.impl;

import com.edu.mapper.CartitemMapper;
import com.edu.mapper.OrderItemMapper;
import com.edu.mapper.OrderListMapper;
import com.edu.pojo.Cartitem;
import com.edu.pojo.OrderItem;
import com.edu.pojo.OrderList;
import com.edu.service.OrderService;
import com.edu.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderListMapper olm;
    @Autowired
    private OrderItemMapper oim;
    @Autowired
    private CartitemMapper cit;

    //保存订单
    @Override
    public boolean save(OrderList record) {
        return false;
    }
    //通过订单id查询订单详情
    @Override
    public OrderVo queryByOid(Integer oid) {
        return olm.selectByOid(oid);
    }



    //查询所有订单
    @Override
    public List<OrderList> queryByUid(Integer uid) {
        return olm.selectByUid(uid);
    }
    //更新订单状态
    @Override
    public boolean updateFlag(Integer oid, Integer flag) {
        return false;
    }

    @Override
    public boolean createOrder(Integer uid, String ciids, int aid) {

        try{
            //查询详情
            List<Cartitem> items = cit.selectByCiids(ciids);
            //总金额
            int money = 0;
            for(Cartitem item:items
                    ) {
                money += item.getCount() * item.getGoods().getGprice().intValue();
            }
            //新增订单
            OrderList order = new OrderList();
            order.setFlag(0);
            order.setAid(aid);
            order.setUid(uid);
            order.setMoney(money);
            olm.insert(order);
            //新增订单详情
            for(Cartitem citem:items){
                OrderItem oitem = new OrderItem();
                oitem.setCount(citem.getCount());
                oitem.setGid(citem.getGoods().getGid());
                oitem.setOid(order.getOid());
                oitem.setMoney(citem.getCount() * citem.getGoods().getGprice().intValue());

                oim.insert(oitem);
            }
            //删除详情,生成订单后购物车会删除
            cit.deleteByCiids(ciids);

            return true;
        }catch (Exception e){
            return false;
        }

    }
}
