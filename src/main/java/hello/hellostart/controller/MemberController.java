package hello.hellostart.controller;

import hello.hellostart.domain.Member;
import hello.hellostart.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired  //(DI)
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new") // 조회할 때 주로 사용
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")    // createMemberForm.html의 form tag, data 전달할 때 사용
    public String create(MemberForm form){
        Member member = new Member( );
        member.setName(form.getName());

        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping("members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members);
        return "members/memberList";
    }
}
