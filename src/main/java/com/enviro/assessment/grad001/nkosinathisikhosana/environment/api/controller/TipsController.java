package com.enviro.assessment.grad001.nkosinathisikhosana.environment.api.controller;


import org.springframework.web.bind.annotation.*;
import com.enviro.assessment.grad001.nkosinathisikhosana.environment.api.model.Tips;
import com.enviro.assessment.grad001.nkosinathisikhosana.environment.service.TipsService;

import java.util.List;

@RestController
@RequestMapping("/tips")
public class TipsController {

    private final TipsService tipsService;

    
    public TipsController(TipsService tipsService) {
        this.tipsService = tipsService;
    }

    @GetMapping("/{id}")
    public Tips getTipById(@PathVariable int id) {
        return tipsService.getTipById(id);
    }

    @GetMapping
    public List<Tips> getAllTips() {
        return tipsService.getAllTips();
    }

    @PostMapping
    public Tips saveTip(@RequestBody Tips tip) {
        return tipsService.saveTip(tip);
    }

    @PutMapping("/{id}")
    public Tips updateTip(@PathVariable int id, @RequestBody Tips tip) {
        return tipsService.updateTip(id, tip);
    }

    @DeleteMapping("/{id}")
    public void deleteTip(@PathVariable int id) {
        tipsService.deleteTip(id);
    }
}
