package com.edu.commons;

import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class GoodTypeDynaSqlProvider {



        public String selectWithParam(Map<String, Object> param){

            return new SQL(){
                {
                    SELECT("g.*, gt.gtname gtparentname");
                    FROM("goodtype as g");
                    LEFT_OUTER_JOIN("goodtype as gt on g.gtparentid = gt.gtid");
                    if(param.get("gtname") != null){
                        WHERE("g.gtname=#{gtname}");
                    }
                    if(param.get("gtlevel") != null){
                        WHERE("g.gtlevel=#{gtlevel}");
                    }
                }

            }.toString();

        }
    }


