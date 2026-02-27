package egovframework.example.register.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import egovframework.example.exception.DuplicateMemberException;
import egovframework.example.member.Member;
import egovframework.example.register.service.RegisterRequest;
import egovframework.example.register.service.RegisterService;

import java.util.List;

import javax.annotation.Resource;

@Controller
@RequestMapping("/register/")
@RequiredArgsConstructor
@Slf4j
public class RegisterController {

	@Resource(name="registerService")
    private final RegisterService service;

	@GetMapping("step1")
    public String step1(){
        return "register/step1";
    }
	
    @PostMapping("step2")
    public String step2(boolean agree){
        log.debug("agree: {}", agree);
        if(agree){
        return "register/step2";
        }
        return "redirect:/register/step1";
    }
    
    @PostMapping("step3")
    public String step3(@ModelAttribute RegisterRequest register){
        try {
            service.register(register);
            return "register/step3";
        } catch (DuplicateMemberException e) {
            return "register/step2";
        }
    }
    
    @GetMapping("list")
    public String selectAll(Model model) {
        List<Member> members = service.selectAll();
        model.addAttribute("members", members);
        return "register/list";
    }
}
