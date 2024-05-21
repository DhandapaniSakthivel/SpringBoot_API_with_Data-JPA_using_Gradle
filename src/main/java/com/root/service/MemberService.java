package com.root.service;

import com.root.model.Member;
import com.root.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepo;

    public List<Member> getAll()
    {
        List<Member> memberList = memberRepo.findAll();
        memberList.stream().filter(i -> i.getAge() > 20). collect(Collectors.toList());
        return memberList;
    }

    public ResponseEntity<String> addAll(List<Member> membersList)
    {
        memberRepo.saveAll(membersList);

        return ResponseEntity.status(HttpStatus.OK).body("Members List inserted in DB");
    }
}
