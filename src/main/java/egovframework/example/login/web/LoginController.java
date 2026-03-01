package egovframework.example.login.web;

import egovframework.example.exception.MemberNotFoundException;
import egovframework.example.login.service.LoginRequest;
import egovframework.example.login.service.LoginService;
import egovframework.example.member.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@Slf4j
public class LoginController {
    private final LoginService service;

    @GetMapping("/login")
    public String loginView(String location, Model model) {
        model.addAttribute("location", location);
        return "common/login";
    }

//    @PostMapping("/login")
//    public String login(LoginRequest login, HttpSession session, Model model) {
//        Member member = service.findMember(login);
//        if (member == null) {
//            throw new MemberNotFoundException();
//        }
//        session.setAttribute("member", member);
//        return "redirect:/";
//    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        //세션의 모든 데이터 지우기
        session.invalidate();
        return "redirect:/index";
    }

    @PostMapping("/ajaxLogin")
    @ResponseBody
    public Map<String, String> ajaxLogin(LoginRequest login, @RequestParam(required = false) String location, HttpSession session) {

        log.debug("location: {}", location);
        HashMap<String, String> map = new HashMap<>();
        Member member = service.findMember(login);
        if (member == null) {
//            throw new MemberNotFoundException();
        	map.put("msg", "failure");
            return map;
        }

        // 2. 스프링 시큐리티 전용 인증 토큰 생성
        // (member.getUserId(), password, 권한리스트 순서)
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                member
                ,null// 비밀번호는 이미 위에서 검증했으므로 null 처리 가능
                ,List.of(new SimpleGrantedAuthority("ROLE_USER")) // 사용자의 실제 권한을 넣으세요
        );

        // 3. SecurityContext에 인증 정보 강제 등록 (이걸 해야 jsp sec 태그가 작동함)
        SecurityContext context = SecurityContextHolder.getContext();
        context.setAuthentication(token);

        // 4. 세션에 SecurityContext 저장 (로그인 상태 유지)
//        session = request.getSession(true);
//        session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, context);
        
        // 기존 세션 유지 (선택 사항)
        session.setAttribute("member", member);

        
        
        if (location != null && !"".equals(location)) {
            map.put("msg", location);
        } else {
            map.put("msg", "/");
        }

        return map;
    }

    @ExceptionHandler(MemberNotFoundException.class)
    @ResponseBody
    public Map<String, String> memberNotFound(Model model) {
        HashMap<String, String> map = new HashMap<>();
        map.put("msg", "failure");
        return map;
    }


}
