package com.dark_tech.pandemian.pojo;

import android.graphics.drawable.Drawable;

public class Vaccine {

    private String brand;
    private String name;
    private String type;
    private String cant;
    private String supply;
    private String notContent;
    private String suggest;
    private String notSuggest;
    private String effects;
    private String ref;
    private Drawable img;
    private String refLink;
    public Vaccine() {
    }

    public Vaccine(String brand, String name, String type, String cant, String supply, String notContent, String suggest, String notSuggest, String effects) {
        this.brand = brand;
        this.name = name;
        this.type = type;
        this.cant = cant;
        this.supply = supply;
        this.notContent = notContent;
        this.suggest = suggest;
        this.notSuggest = notSuggest;
        this.effects = effects;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCant() {
        return cant;
    }

    public void setCant(String cant) {
        this.cant = cant;
    }

    public String getSupply() {
        return supply;
    }

    public void setSupply(String supply) {
        this.supply = supply;
    }

    public String getNotContent() {
        return notContent;
    }

    public void setNotContent(String notContent) {
        this.notContent = notContent;
    }

    public String getSuggest() {
        return suggest;
    }

    public void setSuggest(String suggest) {
        this.suggest = suggest;
    }

    public String getNotSuggest() {
        return notSuggest;
    }

    public void setNotSuggest(String notSuggest) {
        this.notSuggest = notSuggest;
    }

    public String getEffects() {
        return effects;
    }

    public void setEffects(String effects) {
        this.effects = effects;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public Drawable getImg() {
        return img;
    }

    public void setImg(Drawable img) {
        this.img = img;
    }

    public String getRefLink() {
        return refLink;
    }

    public void setRefLink(String refLink) {
        this.refLink = refLink;
    }
}
