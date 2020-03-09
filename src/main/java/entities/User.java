package entities;


import org.apache.commons.lang3.RandomStringUtils;

public class User {

    public static final User TEST = new User(
            RandomStringUtils.randomAlphanumeric(10) + "@mail.ru",
            RandomStringUtils.randomAlphanumeric(10),
            RandomStringUtils.randomAlphanumeric(10));

    public String email;
    public String username;
    public String password;

    User(String email, String userName, String password) {
        this.email = email;
        this.username = userName;
        this.password = password;
    }
}
