package egovframework.example.login.service;

import egovframework.example.member.Member;

public interface LoginService {
    Member findMember(LoginRequest login);
}
