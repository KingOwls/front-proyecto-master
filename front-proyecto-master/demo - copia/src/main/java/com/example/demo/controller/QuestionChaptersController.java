package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.QuestionChaptersService;
import com.example.demo.model.QuestionChaptersEntity;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/question-chapters")
public class QuestionChaptersController {
    private final QuestionChaptersService questionChaptersService;

    public QuestionChaptersController(QuestionChaptersService questionChaptersService) {
        this.questionChaptersService = questionChaptersService;
    }

   
}
