package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class RouteDaoImpl implements RouteDao {
    JdbcTemplate jdbcTemplate = JDBCUtils.getJdbcTemplate();

    @Override
    public Integer queryCountByCid( int cid ){
        return jdbcTemplate.queryForObject("select count(*) from tab_route where cid = ?",Integer.class,cid);
    }

    @Override
    public List<Route> queryRouteList( int cid,int begin, int rows ){
        return jdbcTemplate.query("select * from tab_route where cid = ? limit ? , ?",new BeanPropertyRowMapper<>(Route.class),cid,begin,rows);
    }
}