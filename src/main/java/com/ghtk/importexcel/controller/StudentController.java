package com.ghtk.importexcel.controller;

import com.ghtk.importexcel.entity.Student;
import com.ghtk.importexcel.service.StudentService;
import com.ghtk.importexcel.util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @PostMapping("/importFile")
    public String importFile(@RequestParam("files") MultipartFile multipartFile) throws IOException {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        String uploadDir = new File("D:/").getAbsolutePath();
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        studentService.importExcelFile(multipartFile);
        return "redirect:" + "/search";
    }

    @GetMapping("/search")
    public String search(Model model) {
        List<Student> listStudent = studentService.findALl();
        model.addAttribute("listStudent", listStudent);
        return "search";
    }

    @PostMapping("/searchOne")
    public String searchOne(@RequestParam("fullname") String textSearch, Model model) {
        List<Student> listStudentByName = studentService.search(textSearch);
        model.addAttribute("listStudent", listStudentByName);
        return "search";
    }
    }
