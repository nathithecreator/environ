package com.enviro.assessment.grad001.nkosinathisikhosana.environment.api.controller;

import org.springframework.web.bind.annotation.*;
import com.enviro.assessment.grad001.nkosinathisikhosana.environment.api.model.guidelines;
import com.enviro.assessment.grad001.nkosinathisikhosana.environment.service.GuidelinesService;

import java.util.List;

@RestController
@RequestMapping("/guidelines")
public class GuidelinesController {

    private final GuidelinesService guidelinesService;

    
    public GuidelinesController(GuidelinesService guidelinesService) {
        this.guidelinesService = guidelinesService;
    }

    @GetMapping("/{id}")
    public guidelines getGuidelineById(@PathVariable int id) {
        return guidelinesService.getGuidelineById(id);
    }

    @GetMapping
    public List<guidelines> getAllGuidelines() {
        return guidelinesService.getAllGuidelines();
    }

    @PostMapping
    public guidelines saveGuideline(@RequestBody guidelines guideline) {
        return guidelinesService.saveGuideline(guideline);
    }

    @PutMapping("/{id}")
    public guidelines updateGuideline(@PathVariable int id, @RequestBody guidelines guideline) {
        return guidelinesService.updateGuideline(id, guideline);
    }

    @DeleteMapping("/{id}")
    public void deleteGuideline(@PathVariable int id) {
        guidelinesService.deleteGuideline(id);
    }
}
