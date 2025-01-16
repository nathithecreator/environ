package com.enviro.assessment.grad001.nkosinathisikhosana.environment.service;

import org.springframework.stereotype.Service;
import com.enviro.assessment.grad001.nkosinathisikhosana.environment.api.model.guidelines;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GuidelinesService {

    private List<guidelines> guidelinesList;

    public GuidelinesService() {
        guidelinesList = new ArrayList<>();
        // Sample data for demonstration purposes
        guidelinesList.add(new guidelines(1, "Plastic", "Recycle", "Avoid burning as it releases toxins"));
        guidelinesList.add(new guidelines(2, "Batteries", "Dispose at hazardous waste collection site", "Wear gloves to avoid contact with chemicals"));
    }

    public guidelines getGuidelineById(int id) {
        return guidelinesList.stream()
                .filter(guideline -> guideline.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<guidelines> getAllGuidelines() {
        return new ArrayList<>(guidelinesList);
    }

    public guidelines saveGuideline(guidelines guideline) {
        guidelinesList.add(guideline);
        return guideline;
    }

    public guidelines updateGuideline(int id, guidelines updatedGuideline) {
        Optional<guidelines> existingGuidelineOpt = guidelinesList.stream()
                .filter(guideline -> guideline.getId() == id)
                .findFirst();

        if (existingGuidelineOpt.isPresent()) {
            guidelines existingGuideline = existingGuidelineOpt.get();
            existingGuideline.setWasteType(updatedGuideline.getWasteType());
            existingGuideline.setDisposalMethod(updatedGuideline.getDisposalMethod());
            existingGuideline.setSafetyPrecautions(updatedGuideline.getSafetyPrecautions());
            return existingGuideline;
        } else {
            return null;
        }
    }

    public boolean deleteGuideline(int id) {
        return guidelinesList.removeIf(guideline -> guideline.getId() == id);
    }
}
