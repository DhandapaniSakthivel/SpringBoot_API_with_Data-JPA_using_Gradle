package com.root.service;

import com.root.exception.ApplicationException;
import com.root.model.Member;
import com.root.repository.MemberRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepo;
    Logger logger;

    public List<Member> getAll() throws ApplicationException {
        List<Member> memberList = memberRepo.findAll();
        List<Member> membersList = memberList.stream().filter(i -> i.getAge() > 20 && i.getAddress().getZipCode().equals("90012")). collect(Collectors.toList());
        for(Member mem : memberList)
        {
            if(mem.getNoOfHOMPolicies() != null || mem.getNoOfRENPolicies() != null || mem.getNoOfRPIPolicies() != null )
            {
               List<Member> responseMembersList = new ArrayList<>();
               responseMembersList.add(mem);
            }
            else {
                logger.error("Member don't have Homeowner policies "+mem.getMemberNumber());
                throw new ApplicationException("There is HOM policies for the member");
            }
        }
        return memberList;
    }

    public ResponseEntity<String> addAll(List<Member> membersList)
    {
        memberRepo.saveAll(membersList);

        return ResponseEntity.status(HttpStatus.OK).body("Members List inserted in DB");
    }
}
