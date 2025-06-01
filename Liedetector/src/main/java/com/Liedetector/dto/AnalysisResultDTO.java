package com.Liedetector.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder

public class AnalysisResultDTO {
private int suspicionScore;
private List<String> flags;
private String suggestedMood;
}
