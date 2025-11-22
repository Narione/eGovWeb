package egovframework.example.login.service.impl;

import egovframework.example.login.service.LoginRequest;
import egovframework.example.member.Member;
import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

@Mapper
public interface LoginMapper {
    Member findMember(LoginRequest login);
}
