/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.Comparator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author superlamer
 */
public class ContactsAppController implements Initializable {
    
    @FXML private ListView<Contact> contactsListView;
    @FXML private TextField firstNameTextField;
    @FXML private TextField lastNameTextField;
    @FXML private TextField emailAddressTextField;
    @FXML private TextField phoneTextField;
    @FXML private ImageView avatarImageView;
    
    Contact temp;
    
    // randomizer
    SecureRandom rnd = new SecureRandom();
    
    // list of name
    String[] names = {"John", "Doe", "James", "Penske", "Jason", "Haul", "Adam", "Hine",
        "Lawrence", "Cannon", "Samuel", "Nikon", "Peter", "Smith", "Richard", "Dawson",
        "Victor", "Vicktoriya", "Radoslav", "Radoev", "Michael", "Guetz", "Thomass"};
    
    // store the contacts list
    private final ObservableList<Contact> contacts = 
            FXCollections.observableArrayList();
    


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        generateContacts();
        // sort list by 1st name and by last name
        order(contacts);
        
        contactsListView.setItems(contacts);
        
        contactsListView.getSelectionModel().selectedItemProperty().addListener(
                (observableValue, oldValue, newValue) -> {
                    if (newValue != null) {
                    temp = (Contact) newValue;
                    firstNameTextField.setText(temp.getFirstName());
                    lastNameTextField.setText(temp.getLastName());
                    emailAddressTextField.setText(temp.getEMail());
                    phoneTextField.setText(String.valueOf(temp.getNumber()));
                    avatarImageView.setImage(new Image(temp.getAvatar()));
                    }           
                }
        );
        
        firstNameTextField.textProperty().addListener(
                (obversvableValue, oldValue, newValue) -> {
                    temp.setFirstName(newValue);
                    contactsListView.refresh();
                });
        
        lastNameTextField.textProperty().addListener(
              (obversvableValue, oldValue, newValue) -> {
                    temp.setLasttName(newValue);
                    contactsListView.refresh();
                });  

        emailAddressTextField.textProperty().addListener(
            (obversvableValue, oldValue, newValue) -> {
                temp.seteMail(newValue);
                contactsListView.refresh();
            });  
                
        phoneTextField.textProperty().addListener(
            (obversvableValue, oldValue, newValue) -> {
                temp.setNumber(Long.valueOf(newValue));
                contactsListView.refresh();
            });  
        
        // set custom listivew cell factory
        contactsListView.setCellFactory((listview) -> new ImageTextCell());
    }    
   
    private String generateEmail(String firstname, String lastName) {
        return String.format("%s.%s@gmail.com", firstname, lastName);
    }
    
    private long generateNumber() {
        long number = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
        return number;
    }
    
    private String generatetName() {
        int index = rnd.nextInt(names.length);
        return names[index];
    }
    
    private void generateContacts() {
        String firstName = "";
        String lastName = "";
        String email ="";
        long number = 0;
        String avatar = "/avatars/photo.png";
        for (int i = 0; i < 100; i++) {
            firstName = generatetName();
            lastName = generatetName();
            email = generateEmail(firstName, lastName);
            number = generateNumber();
            
            contacts.add(new Contact(firstName, lastName, email, number, avatar));
        }
    }
    
    private void order(ObservableList<Contact> contacts) {
        Collections.sort(contacts, new Comparator() {
            public int compare(Object o1, Object o2) {
                String name1 = ((Contact) o1).getFirstName();
                String name2 = ((Contact) o2).getFirstName();
                int sComp = name1.compareTo(name2);
                
                if (sComp != 0) {
                    return sComp;
                }
                else {
                    String last1 = ((Contact) o1).getLastName();
                    String last2 = ((Contact) o2).getLastName();
                    return last1.compareTo(last2);
                }
            }
        }); 
    };
}
