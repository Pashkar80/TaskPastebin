package entity;

/**
 * Created by user on 13.10.2019.
 */
public  class Paste {
    private  String code;
    private  String highlighting;
    private  String valueExpiration ;
    private  String namePaste;

    public Paste(String code, String highlighting, String valueExpiration, String namePaste) {
        this.code = code;
        this.highlighting = highlighting;
        this.valueExpiration = valueExpiration;
        this.namePaste = namePaste;
    }

    public Paste(String code,String valueExpiration, String namePaste) {
        this.code = code;
        this.valueExpiration = valueExpiration;
        this.namePaste = namePaste;
    }

    public String getCode() {
        return code;
    }

    public String getHighlighting() {
        return highlighting;
    }

    public String getValueExpiration() {
        return valueExpiration;
    }

    public String getNamePaste() {
        return namePaste;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setHighlighting(String highlighting) {
        this.highlighting = highlighting;
    }

    public void setValueExpiration(String valueExpiration) {
        this.valueExpiration = valueExpiration;
    }

    public void setNamePaste(String namePaste) {
        this.namePaste = namePaste;
    }
}
