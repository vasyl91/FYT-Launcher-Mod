package com.fyt.flow;

public class Triffic {
    private float Percentage;
    private double surplusUsage;
    private double total_usage;

    public Triffic(double total_usage, double surplusUsage, float percentage) {
        this.total_usage = total_usage;
        this.surplusUsage = surplusUsage;
        this.Percentage = percentage;
    }

    public double getTotal_usage() {
        return this.total_usage;
    }

    public void setTotal_usage(double total_usage) {
        this.total_usage = total_usage;
    }

    public double getSurplusUsage() {
        return this.surplusUsage;
    }

    public void setSurplusUsage(double surplusUsage) {
        this.surplusUsage = surplusUsage;
    }

    public float getPercentage() {
        return this.Percentage;
    }

    public void setPercentage(float percentage) {
        this.Percentage = percentage;
    }
}
