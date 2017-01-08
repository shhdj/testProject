package com.storesales.base;

import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;



public class BaseDao {

//	@Autowired
//	private JdbcTemplate jdbcTemplate;
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <T> List<T> queryList(String sql,Class<T> clz){
//		return jdbcTemplate.query(sql,new BeanPropertyRowMapper(clz));
		return new ArrayList<T>();
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <T> List<T> queryList(String sql,Object[] arg,Class<T> clz){
//		return jdbcTemplate.query(sql,arg ,new BeanPropertyRowMapper(clz));
		return new ArrayList<T>();
	}
	
	public <T> T queryforObject(String sql,Class<T> clz){
//		return jdbcTemplate.queryForObject(sql, clz);
		return null;
	}
	
	public boolean insert(String insertSql,Map paramMap){
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = null;  
		//namedParameterJdbcTemplate =  
//		    new NamedParameterJdbcTemplate(dataSource);  
//		namedParameterJdbcTemplate =  
//		new NamedParameterJdbcTemplate(jdbcTemplate);  
//		    namedParameterJdbcTemplate.update(insertSql, paramMap);  
		return true;
	}
	
	public void update(String sql,final Map<Integer,Object> param){
//		jdbcTemplate.update(sql,   
//                new PreparedStatementSetter(){  
//                    @Override  
//                    public void setValues(PreparedStatement ps) throws SQLException {  
//                    	Set<Integer> keyset = param.keySet();
//                    	for(Integer key:keyset	){
//                    		 ps.setObject(key, param.get(key));  
////                    		 ps.setString(key, param.get(key));  
//                    	}
//                    }  
//                }  
//        );  
	}
	
	/**
     * 将一条记录转成一个对象
     * 
     * @param cls
     *            泛型类型
     * @param rs
     *            ResultSet对象
     * @return 泛型类型对象
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws SQLException
     */
    private static <T> T executeResultSet(Class<T> cls, ResultSet rs)
            throws InstantiationException, IllegalAccessException, SQLException {
        T obj = cls.newInstance();
        ResultSetMetaData rsm = rs.getMetaData();
        int columnCount = rsm.getColumnCount();
        // Field[] fields = cls.getFields();
        Field[] fields = cls.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            String fieldName = field.getName();
            for (int j = 1; j <= columnCount; j++) {
                String columnName = rsm.getColumnName(j);
                if (fieldName.equalsIgnoreCase(columnName)) {
                    Object value = rs.getObject(j);
                    field.setAccessible(true);
                    field.set(obj, value);
                    break;
                }
            }
        }
        return obj;
    }
}
