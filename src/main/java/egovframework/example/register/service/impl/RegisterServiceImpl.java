package egovframework.example.register.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.example.exception.DuplicateMemberException;
import egovframework.example.member.Member;
import egovframework.example.register.service.RegisterRequest;
import egovframework.example.register.service.RegisterService;
import egovframework.example.register.service.impl.RegisterMapper;

import java.util.DuplicateFormatFlagsException;
import java.util.List;

@Service
@Slf4j
public class RegisterServiceImpl implements RegisterService {
//    private static final Logger logger = LoggerFactory.getLogger(RegisterService.class);
    private RegisterMapper mapper;
//    public RegisterServiceImpl(RegisterMapper mapper) {
//        this.mapper = mapper;
//    }
    public List<Member> selectAll() {
        return mapper.selectAll();
    }

    public void register(RegisterRequest request) {
        log.debug("id: {}", request.getId());
        Member member = mapper.selectById(request.getId());
        if (member != null) {
            throw new DuplicateMemberException("아이디 중복: "+request.getId());
        }
        mapper.insert(request);

    }
}
