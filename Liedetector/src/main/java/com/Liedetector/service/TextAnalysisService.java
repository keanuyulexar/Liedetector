package com.Liedetector.service;

import com.Liedetector.dto.AnalysisResultDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TextAnalysisService {

    public AnalysisResultDTO analyze(String text) {
        List<String> flags = new ArrayList<>();
        int score = 0;

        // 1. Vague words
        String[] vagueWords = {"maybe", "probably", "i think", "i guess", "sort of", "kind of"};
        for (String word : vagueWords) {
            if (text.toLowerCase().contains(word)) {
                flags.add("Vague language: '" + word + "'");
                score += 10;
            }
        }

        // 2. Over-justification
        if (text.toLowerCase().contains("trust me") || text.toLowerCase().contains("because")) {
            flags.add("Over-explaining or justifying");
            score += 15;
        }

        // 3. Passive voice detection
        if (text.toLowerCase().contains("was") && text.toLowerCase().contains("by")) {
            flags.add("Possible passive voice");
            score += 10;
        }

        // 4. Contradictions
        if (text.toLowerCase().contains("i didn't") && text.toLowerCase().contains("but")) {
            flags.add("Contradictory phrase detected");
            score += 25;
        }

        // 5. Too defensive
        if (text.toLowerCase().contains("i swear") || text.toLowerCase().contains("i'm not lying")) {
            flags.add("Defensive language");
            score += 25;
        }

        // Clamp score to max 100
        score = Math.min(score, 100);

        // Mood estimation
        String mood = "Neutral";
        if (score >= 70) mood = "Defensive";
        else if (score >= 50) mood = "Suspicious";
        else if (score >= 25) mood = "Cautious";

        // ✅ Proper builder chaining
        return AnalysisResultDTO.builder()
                .suspicionScore(score)
                .flags(flags)
                .suggestedMood(mood)
                .build();
    }
}
