package com.example.splash;

public class CropHelper {

    private String crpName;
    private String crpID;
    private String crpDes;

    public CropHelper() {
    }

    public String getCrpName() {
        return crpName;
    }

    public void setCrpName(String crpName) {
        this.crpName = crpName;
    }

    public String getCrpID() {
        return crpID;
    }

    public void setCrpID(String crpID) {
        this.crpID = crpID;
    }

    public String getCrpDes() {
        return crpDes;
    }

    public void setCrpDes(String crpDes) {
        this.crpDes = crpDes;
    }

    public Boolean validateCropName(String cropName){

        if( cropName.matches("")){
            return false;
        }else{
            return true;
        }

    }

    public Boolean validateCropDescription(String cropName){

        if( cropName.matches("")){
            return false;
        }else{
            return true;
        }

    }

    public Boolean validateCropID(String cropID){

        if( cropID.matches("")){
            return false;
        }else{
            return true;
        }

    }

}
