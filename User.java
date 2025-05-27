package onlineExam;

public class User {
    String username;
    String password;
    String name;
    String email;

    public User(String username, String password, String name, String email) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
    }

    public boolean login(String user, String pass) {
        return this.username.equals(user) && this.password.equals(pass);
    }

    public void updateProfile(String name, String email) {
        this.name = name;
        this.email = email;
        System.out.println("✅ Profile updated successfully!");
    }

    public void updatePassword(String oldPass, String newPass) {
        if (this.password.equals(oldPass)) {
            this.password = newPass;
            System.out.println("✅ Password updated successfully!");
        } else {
            System.out.println("❌ Incorrect old password!");
        }
    }
}

