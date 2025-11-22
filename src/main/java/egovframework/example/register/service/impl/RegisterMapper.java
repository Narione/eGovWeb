package egovframework.example.register.service.impl;

import org.apache.ibatis.annotations.Mapper;

import egovframework.example.member.Member;
import egovframework.example.register.service.RegisterRequest;

import java.util.List;

@Mapper
public interface RegisterMapper {
    List<Member> selectAll();
    Member selectByEmail(String email);
    Member selectById(String id);
    void insert(RegisterRequest request);
}
