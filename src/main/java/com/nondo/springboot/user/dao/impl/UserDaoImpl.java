package com.nondo.springboot.user.dao.impl;

import com.nondo.springboot.user.bean.User;
import com.nondo.springboot.user.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int addUser(User user) {
        String sql = "insert into user(username,password,birthday) values(?,?,?)";
        return this.jdbcTemplate.update(sql,user.getUserName(),user.getPassword(),user.getBirthDay());
    }

    @Override
    public int deleteUserById(int id) {
        String sql = "delete from user where id=?";
        return this.jdbcTemplate.update(sql,id);
    }

    @Override
    public int updateUser(User user) {
        String sql ="update user set username=?,password=?,birthday=? where id=?";
        return this.jdbcTemplate.update(sql,user.getUserName(),user.getPassword(),user.getBirthDay(),user.getId());
    }

    @Override
    public User queryUserById(int id) {
        String sql = "select * from user where id=?";
        RowMapper<User> rowMapper = new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUserName(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setBirthDay(resultSet.getDate("birthday"));
                return user;
            }
        };
        try {
            User user = this.jdbcTemplate.queryForObject(sql,rowMapper,id);
            return user;
        }catch (EmptyResultDataAccessException e){
            return null;
        }

//        return this.jdbcTemplate.queryForObject(sql, new RowMapper<User>() {
//            @Override
//            public User mapRow(ResultSet resultSet, int i) throws SQLException {
//                User user = new User();
//                user.setId(resultSet.getInt("id"));
//                user.setUserName(resultSet.getString("username"));
//                user.setPassword(resultSet.getString("password"));
//                user.setBirthDay(resultSet.getDate("birthday"));
//                return user;
//            }
//        },id);
    }
}
