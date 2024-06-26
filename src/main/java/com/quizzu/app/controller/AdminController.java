package com.quizzu.app.controller;

import com.quizzu.app.dto.CategoryDto;
import com.quizzu.app.dto.QuestionDto;
import com.quizzu.app.dto.QuizDto;
import com.quizzu.app.entity.Category;
import com.quizzu.app.entity.Question;
import com.quizzu.app.entity.Quiz;
import com.quizzu.app.service.CategoryService;
import com.quizzu.app.service.QuestionService;
import com.quizzu.app.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private QuizService quizService;

    @Autowired
    private QuestionService questionService;

    @PostMapping("/addCategory")
    public ResponseEntity<Category> addCategory(@RequestBody CategoryDto categoryDto) throws Exception
    {
        System.out.println("title"+ categoryDto);
        return ResponseEntity.ok(this.categoryService.createCategory(categoryDto));
    }

    @PostMapping("/addQuiz")
    public ResponseEntity<Quiz> createQuiz(@RequestBody QuizDto quizDto) {
        System.out.println("error occurred");
        return ResponseEntity.ok(this.quizService.createQuiz(quizDto));
    }

    @DeleteMapping("/deleteQuiz/{id}")
    public ResponseEntity<String> deleteQuiz(@PathVariable Long id) {
        return ResponseEntity.ok(this.quizService.deleteQuiz(id));
    }

    @PostMapping("/createQuestion")
    public ResponseEntity<Question> createQuestion(@RequestBody QuestionDto questionDto) throws Exception
    {
        return ResponseEntity.ok(this.questionService.addQuestion(questionDto));
    }

    @PostMapping("/addQuestions")
    public ResponseEntity<List<Question>> addQuestions(@RequestBody List<QuestionDto> questionDtos) throws Exception {
        List<Question> questions = questionService.addQuestions(questionDtos);
        return ResponseEntity.ok(questions);
    }
}
