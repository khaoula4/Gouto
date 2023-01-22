package com.example.gouto;

public class Forage {

   private String X;
   private String Y;
    private String code;
    private String Profendeur;
    private String Debit;//sipos
    private String Pos_neg;
    private String exp_rec;
    private String Province;
    private String Commune;
    private String Date_Realisation;
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Forage() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public Forage(String X, String Y, String code, String Profendeur, String Debit, String Date_Realisation, String Commune, String Province, String exp_rec, String Pos_neg) {
        this.X = X;
        this.Y = Y;
        this.code = code;
        this.Profendeur =Profendeur;
        this.Debit =Debit;
        this.Pos_neg = Pos_neg;
        this.exp_rec =exp_rec;
        this.Province =Province;
        this.Commune =Commune;
        this.Date_Realisation =Date_Realisation;
    }

    public String getX() {
        return X;
    }

    public void setX(String x) {
        X = x;
    }

    public String getY() {
        return Y;
    }

    public void setY(String y) {
        Y = y;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getProfendeur() {
        return Profendeur;
    }

    public void setProfendeur(String profendeur) {
        Profendeur = profendeur;
    }

    public String getDebit() {
        return Debit;
    }

    public void setDebit(String debit) {
        Debit = debit;
    }

    public String getPos_neg() {
        return Pos_neg;
    }

    public void setPos_neg(String pos_neg) {
        Pos_neg = pos_neg;
    }

    public String getExp_rec() {
        return exp_rec;
    }

    public void setExp_rec(String exp_rec) {
        this.exp_rec = exp_rec;
    }

    public String getProvince() {
        return Province;
    }

    public void setProvince(String province) {
        Province = province;
    }

    public String getCommune() {
        return Commune;
    }

    public void setCommune(String commune) {
        Commune = commune;
    }

    public String getDate_Realisation() {
        return Date_Realisation;
    }

    public void setDate_Realisation(String date_Realisation) {
        Date_Realisation = date_Realisation;
    }

}
