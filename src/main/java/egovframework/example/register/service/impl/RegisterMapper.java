package egovframework.example.register.service.impl;


import egovframework.example.member.Member;
import egovframework.example.register.service.RegisterRequest;

import java.util.List;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

@Mapper
public interface RegisterMapper {
    List<Member> selectAll();
    Member selectByEmail(String email);
    Member selectById(String id);
    void insert(RegisterRequest request);
}
