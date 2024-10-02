package library_management.Obj;

import java.util.Date;

public class User {

    private int id;
    private String username;
    private String email;
    private String password;
    private String phone;
    private Permission permission;
    private Date account_created;

    // Constructor of User
    public User(int id, String username, String email, String password, String phone, Permission permission, Date account_created) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.permission = permission;
        this.account_created = account_created;
    }

    /**
     * @return int return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return String return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return String return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return String return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return String return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return Permission return the permission
     */
    public Permission getPermission() {
        return permission;
    }

    /**
     * @param permission the permission to set
     */
    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    /**
     * @return Date return the account_created
     */
    public Date getAccount_created() {
        return account_created;
    }

    /**
     * @param account_created the account_created to set
     */
    public void setAccount_created(Date account_created) {
        this.account_created = account_created;
    }

}