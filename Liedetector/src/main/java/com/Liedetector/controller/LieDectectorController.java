package com.Liedetector.controller;



import com.Liedetector.dto.AnalysisResultDTO;
import com.Liedetector.dto.TextInputDTO;
import com.Liedetector.service.TextAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LieDectectorController {

    @Autowired
    private TextAnalysisService analysisService;

    @PostMapping("/analyze")
    public AnalysisResultDTO analyzeText(@RequestBody TextInputDTO input) {
        return analysisService.analyze(input.getText());
    }
}
