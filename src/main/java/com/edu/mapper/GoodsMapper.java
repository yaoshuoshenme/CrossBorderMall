package com.edu.mapper;

import com.edu.commons.GoodsDynaSqlProvider;
import com.edu.pojo.Goods;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface GoodsMapper {

    @Select("select g.*, gt.gtname from goods g left join goodtype gt on g.gtid = gt.gtid where g.gtid = #{tid}")
    List<Goods> queryByTid(Integer tid);


    @SelectProvider(type = GoodsDynaSqlProvider.class,method = "selectWithParam")
    @ResultType(Goods.class)
    List<Goods> selectAll(Map param);

    @Select("select * from goods where gid = #{gid}")
    @ResultType(Goods.class)
    Goods queryById(Integer gid);

}