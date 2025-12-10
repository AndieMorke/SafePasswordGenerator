package model;

public class PasswordRecord {

    private String platform;
    private String username;
    private String email;
    private String password;

    public PasswordRecord(String platform, String username, String email, String password) {
        this.setPlatform(platform);
        this.setUsername(username);
        this.setEmail(email);
        this.setPassword(password);
    }

    public PasswordRecord(String platform, String email, String password) {
        this.setPlatform(platform);
        this.setUsername("No proporcionado");
        this.setEmail(email);
        this.setPassword(password);
    }
    public PasswordRecord(){}

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform.toUpperCase();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

