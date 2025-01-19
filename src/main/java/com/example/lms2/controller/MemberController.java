package com.example.lms2.controller;

import com.example.lms2.model.Member;
import com.example.lms2.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/members")
public class MemberController {
    @Autowired
    private MemberService memberService;

    // Display all members
    @GetMapping
    public String getAllMembers(Model model) {
        model.addAttribute("members", memberService.getAllMembers());
        return "member/list"; // Thymeleaf template for displaying members
    }

    // Show form to add a new member
    @GetMapping("/new")
    public String showAddMemberForm(Model model) {
        model.addAttribute("member", new Member());
        return "member/add"; // Thymeleaf template for adding a member
    }

    // Add a new member
    @PostMapping
    public String addMember(@ModelAttribute Member member) {
        memberService.addMember(member);
        return "redirect:/members"; // Redirect to member list after adding
    }

    // Show form to edit an existing member
    @GetMapping("/edit/{id}")
    public String showEditMemberForm(@PathVariable Long id, Model model) {
        model.addAttribute("member", memberService.getMemberById(id));
        return "member/edit"; // Thymeleaf template for editing a member
    }

    // Update an existing member
    @PostMapping("/update")
    public String updateMember(@ModelAttribute Member member) {
        memberService.updateMember(member);
        return "redirect:/members"; // Redirect to member list after updating
    }

    // Delete a member
    @GetMapping("/delete/{id}")
    public String deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
        return "redirect:/members"; // Redirect to member list after deleting
    }
}