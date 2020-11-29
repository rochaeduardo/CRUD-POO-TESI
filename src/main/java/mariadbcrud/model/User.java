package mariadbcrud.model;

public class User {
    
    private Integer id;
    private String name;
    private String email;
    private String userName;
    private String password;

    public User(String name, String email, String userName, String password, Integer id) {
        this.name = name;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.id = id;
    }
    
    
    public User(String name, String email, String userName, String password) {
        this.name = name;
        this.email = email;
        this.userName = userName;
        this.password = password;
    }

    public User() {

    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public User setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    @Override
    public String toString() {
        return "User:"
                + "name:'" + name + "\n"
                + "email:'" + email + "\n"
                + "userName:'" + userName + "\n"
                + "password:'" + password + "\n"
                + '}';
    }
}
