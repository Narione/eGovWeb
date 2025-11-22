package egovframework.example.register.service;

import java.util.List;

import egovframework.example.member.Member;

public interface RegisterService {
    List<Member> selectAll();

    void register(RegisterRequest request);
}
