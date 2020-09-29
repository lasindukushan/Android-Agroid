package com.example.splash;

public class districtncrop {

        private String district;
        private String crops;

        public districtncrop() {
        }

    public districtncrop(String district, String crops) {
        this.district = district;
        this.crops = crops;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCrops() {
        return crops;
    }

    public void setCrops(String crops) {
        this.crops = crops;
    }
}
