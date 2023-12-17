package com.example.restservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.restservice.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {
}
