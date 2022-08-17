package save_email.model;

public class Email {
    private String language;
    private String size;
    private boolean spams;
    private String signature;

    public Email() {
    }

    public Email(String language, String size, boolean spams, String signature) {

        this.language = language;
        this.size = size;
        this.spams = spams;
        this.signature = signature;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean isSpams() {
        return spams;
    }

    public void setSpams(boolean spams) {
        this.spams = spams;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
