package com.edu.mapper;

import com.edu.pojo.Cartitem;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartitemMapper {
    int deleteByPrimaryKey(Integer ciid);
    int deleteByCid(Integer cid);
    int insert(Cartitem record);


    Cartitem selectByCiid(Integer ciid);

    List<Cartitem> selectByCid(Integer cid);

    Cartitem selectByGidAndCid(@Param("gid") Integer gid, @Param("cid") Integer cid);
    int updateByCiid(@Param("ciid") Integer ciid,@Param("count") int count);

    List<Cartitem> selectByCiids(@Param("ciids")String ciids);

    int deleteByCiids(@Param("ciids") String ciids);
}