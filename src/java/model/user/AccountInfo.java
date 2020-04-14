
package model.user;

/**
 * Class for the implementation of the DB table account_info. It has to be 
 * initialized during the session and saved as a session attribute.
 * 
 */
public class AccountInfo extends User {

    private String username;
    private double accBalance;
    private double accCredit;
    private String accEmail;

    public AccountInfo(String username, String password) {
        super(username, password);
    }
    
    public double getAccBalance() {
        
        return this.accBalance;
    }
    
    public double getAccCredit() {
        
        return this.accCredit;
    }
    
    public String getAccEmail() {
        
        return this.accEmail;
    }
    
    public void setAccBalance(double new_balance) {
        
        this.accBalance = new_balance;
    }
    
    public void setAccCredit(double new_credit) {
        
        this.accCredit = new_credit;
    }
    
    public void setAccEmail(String new_email) {
        
        this.accEmail = new_email;
    }
    
    
   

    
    
    
}
