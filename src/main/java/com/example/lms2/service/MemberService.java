package com.example.lms2.service;

import com.example.lms2.model.Member;
import com.example.lms2.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Member getMemberById(Long id) {
        return memberRepository.findById(id).orElse(null);
    }

    public Member addMember(Member member) {
        return memberRepository.save(member);
    }

    public Member updateMember(Member member) {
        if (member.getId() != null && memberRepository.existsById(member.getId())) {
            // Retrieve the existing member from the database
            Member existingMember = memberRepository.findById(member.getId())
                    .orElseThrow(() -> new RuntimeException("Member not found"));

            // Update the fields of the existing member
            existingMember.setName(member.getName());
            existingMember.setAddress(member.getAddress());
            existingMember.setPhoneNumber(member.getPhoneNumber());
            existingMember.setEmail(member.getEmail());

            // Save the updated member
            return memberRepository.save(existingMember);
        } else {
            throw new RuntimeException("Member with id " + member.getId() + " not found");
        }
    }

    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }
}