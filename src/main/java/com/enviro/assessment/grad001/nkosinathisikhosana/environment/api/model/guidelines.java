package com.enviro.assessment.grad001.nkosinathisikhosana.environment.api.model;

public class guidelines {
    private int id;
    private String wasteType;
    private String disposalMethod;
    private String safetyPrecautions;

    // Constructor
    public guidelines(int id, String wasteType, String disposalMethod, String safetyPrecautions) {
        this.id = id;
        this.wasteType = wasteType;
        this.disposalMethod = disposalMethod;
        this.safetyPrecautions = safetyPrecautions;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWasteType() {
        return wasteType;
    }

    public void setWasteType(String wasteType) {
        this.wasteType = wasteType;
    }

    public String getDisposalMethod() {
        return disposalMethod;
    }

    public void setDisposalMethod(String disposalMethod) {
        this.disposalMethod = disposalMethod;
    }

    public String getSafetyPrecautions() {
        return safetyPrecautions;
    }

    public void setSafetyPrecautions(String safetyPrecautions) {
        this.safetyPrecautions = safetyPrecautions;
    }

    @Override
    public String toString() {
        return "guidelines{" +
                "id=" + id +
                ", wasteType='" + wasteType + '\'' +
                ", disposalMethod='" + disposalMethod + '\'' +
                ", safetyPrecautions='" + safetyPrecautions + '\'' +
                '}';
    }
}
