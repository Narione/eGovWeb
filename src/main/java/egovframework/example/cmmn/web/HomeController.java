package egovframework.example.cmmn.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

//    @RequestMapping(value = "/", method = RequestMethod.GET)
    @GetMapping({"/","/index"})
    public String index(String name, Model model) {
        // request.getParameter()를 통해 데이터를 받을 수 있고,
        // request.setAttribute()를 통해 값을 저장해서 응답해줄 수 있다.
        model.addAttribute("greeting", "안녕하세요, "+ name+"님!");
        return "index";
    }




}
