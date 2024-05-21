package com.root.controller;

import com.root.model.Member;
import com.root.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberPoliciesController {

    @Autowired
    MemberService memberService;
    @GetMapping("/member/policies/")
    public List<Member> getMemberDetailsByAge() {
        return memberService.getAll();
    }

    @PostMapping("/add-members")
    public ResponseEntity<String> addMemberDetails(@RequestBody List<Member> membersList)
    {
        if(membersList != null) {
           return memberService.addAll(membersList);
        }

        else
        {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Request body is null");
        }
    }
}