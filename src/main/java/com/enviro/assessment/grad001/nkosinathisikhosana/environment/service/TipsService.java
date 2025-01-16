package com.enviro.assessment.grad001.nkosinathisikhosana.environment.service;

import org.springframework.stereotype.Service;
import com.enviro.assessment.grad001.nkosinathisikhosana.environment.api.model.Tips;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TipsService {

    private List<Tips> tipsList;

    public TipsService() {
        tipsList = new ArrayList<>();
        // Sample data for demonstration purposes
        tipsList.add(new Tips(1, "Reduce, reuse, and recycle to minimize waste."));
        tipsList.add(new Tips(2, "Turn off lights and electronics when not in use to save energy."));
    }

    public Tips getTipById(int id) {
        return tipsList.stream()
                .filter(tip -> tip.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Tips> getAllTips() {
        return new ArrayList<>(tipsList);
    }

    public Tips saveTip(Tips tip) {
        tipsList.add(tip);
        return tip;
    }

    public Tips updateTip(int id, Tips updatedTip) {
        Optional<Tips> existingTipOpt = tipsList.stream()
                .filter(tip -> tip.getId() == id)
                .findFirst();

        if (existingTipOpt.isPresent()) {
            Tips existingTip = existingTipOpt.get();
            existingTip.setDescription(updatedTip.getDescription());
            return existingTip;
        } else {
            return null;
        }
    }

    public boolean deleteTip(int id) {
        return tipsList.removeIf(tip -> tip.getId() == id);
    }
}
