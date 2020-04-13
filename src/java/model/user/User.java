
package model.user;

/**
 * Handles the user, which has an account in the database. After login, this class
 * has to be used as an instance in the session.
 * 
 */
public class User {
    
    private String username;
    private String password;
    
    public User(String username, String password) {
        
        this.username = username;
        this.password = password;
    }
    
    public String getUsername() {
        
        return this.username;
    }
    
    public String getPassword() {
        
        return this.password;
    }
    
}
