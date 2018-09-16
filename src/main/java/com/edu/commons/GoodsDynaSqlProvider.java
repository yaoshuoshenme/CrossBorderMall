package com.edu.commons;

import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class GoodsDynaSqlProvider {

    public String selectWithParam(Map<String, Object> param){

        return new SQL(){
            {
                SELECT("g.*,gt.gtname");
                FROM("goods as g");
                LEFT_OUTER_JOIN("goodtype as gt on g.gtid = gt.gtid");
                if(param.get("gid") != null){
                    WHERE("gid=#{gid}");
                }
                if(param.get("gname") != null){
                    WHERE("gname=#{gname}");
                }
                if(param.get("gtid") != null){
                    WHERE("gtid=#{gtid}");
                }
                if(param.get("gpubdate") != null){
                    WHERE("gpubdate=#{gpubdate}");
                }
                if(param.get("gdowdate") != null){
                    WHERE("gdowdate=#{gdowdate}");
                }
                if(param.get("gcreatedate") != null){
                    WHERE("gcreatedate=#{gcreatedate}");
                }
                if(param.get("gstar") != null){
                    WHERE("gstar=#{gstar}");
                }
                if(param.get("ginfo") != null){
                    WHERE("ginfo=#{ginfo}");
                }

            }

        }.toString();

    }
}
