package com.university.controller;

import com.university.model.Student;
import com.university.service.GroupService;
import com.university.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private GroupService groupService;

    @GetMapping("/menu")
    public String getMenu() {
        return "/menu";
    }

    @GetMapping("/list")
    public String getListStudent(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "/studentList";
    }

    @GetMapping("/add")
    public String createStudent(Model model) {
        model.addAttribute("groups", groupService.findAll());
        return "/add";
    }

    @PostMapping("/add")
    public String addStudent(@ModelAttribute("student") Student student) {
        studentService.add(student);
        return "redirect:/list";
    }

    @GetMapping("/update/{id}")
    public String createUpdateStudent(@PathVariable("id") Long id, Model model) {
        model.addAttribute("student", studentService.findById(id));
        model.addAttribute("groups", groupService.findAll());
        return "/update";
    }

    @PostMapping("/update/{id}")
    public String updateStudent(@ModelAttribute("student") Student student) {
        studentService.update(student);
        return "redirect:/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        studentService.delete(id);
        return "redirect:/list";
    }

    @PostMapping("/filter")
    public String filter(@RequestParam String filter, Model model) {
        model.addAttribute("students", studentService.findByFullNameStartingWith(filter));
        return "/studentList";
    }
}
