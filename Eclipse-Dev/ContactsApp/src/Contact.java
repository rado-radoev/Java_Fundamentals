/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author superlamer
 */

public class Contact {
    
    private String firstName;
    private String lastName;
    private String eMail;
    private long number;
    private String avatar;
    
    public Contact(String firstName, String lastName, String eMail, long number, String avatar) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
        this.number = number;
        this.avatar = avatar;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setLasttName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
    
    public String getEMail() {
        return eMail;
    }
    
    public void setNumber(long number) {
        this.number = number;
    }
    
    public long getNumber() {
        return number;
    }
    
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    
    public String getAvatar() {
        return avatar;
    }
    
    @Override
    public String toString() {
        return getFirstName() + " " + getLastName();
    }
}
