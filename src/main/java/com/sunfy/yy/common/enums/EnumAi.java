package com.sunfy.yy.common.enums;

public enum EnumAi {

    OCR_APP_ID("15273490"),
    OCR_API_KEY("RiOVsyO7V4cN9O6KzBVS114e"),
    OCR_SECRET_KEY("VoCLcg2LBsIVd4hlcd29W55wEbKIjxi9");

    private String value;

    EnumAi(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
