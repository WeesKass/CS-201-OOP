package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

import java.security.CodeSource;

public class Controller {

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField surnameTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField phoneTextField;

    @FXML
    private TextField addressTextField;

    @FXML
    private TextField birthDateTextField;

    @FXML
    private ListView<ContactsInfo> contactsListView;

    @FXML
    private ImageView PhotoImageView;

    private ObservableList<ContactsInfo> contacts = FXCollections.observableArrayList();;

    @FXML
    private void initialize() {
        contacts.add(new ContactsInfo("Amanda", "Watson", "amanda@gmail.com", "+996(534)32-21-22","Bishkek, 3, 15", "03.10.98", "sample/images/amanda_watson.jpg"));
        contacts.add(new ContactsInfo("Doe", "Chester", "chester12@gmail.com", "+996(122)12-12-12","Bishkek, 12, 12", "12.12.92", "sample/images/doe_chester.jpg"));
        contacts.add(new ContactsInfo("John", "Doe", "john.doe@gmail.com", "+996(545)12-54-32","Bishkek, 10, 25", "25.10.88", "sample/images/john_doe.jpeg"));
        contacts.add(new ContactsInfo("Maahmet", "Cho", "maahmet1@gmail.com", "+996(534)44-32-89","Bishkek, 2/a, 11", "01.03.89", "sample/images/maahmet_cho.jpg"));
        contacts.add(new ContactsInfo("Sam", "Cristen", "CrisAm@gmail.com", "+996(702)42-25-10","Bishkek, 35, 2/a", "31.1.00", "sample/images/sam_cristen.jpg"));

        contactsListView.setItems(contacts.sorted());

        contactsListView.getSelectionModel().selectedItemProperty().
                addListener(
                        (observable, oldValue, newValue) -> {
                            PhotoImageView.setImage(
                                    new Image(newValue.getPhoto())
                            );
                            nameTextField.setText(newValue.getName());
                            surnameTextField.setText(newValue.getSurname());
                            emailTextField.setText(newValue.getEmail());
                            phoneTextField.setText(newValue.getPhone());
                            addressTextField.setText(newValue.getAddress());
                            birthDateTextField.setText(newValue.getBirthDate());
                        }
                );

        contactsListView.setCellFactory(
                new Callback<ListView<ContactsInfo>, ListCell<ContactsInfo>>() {
                    @Override
                    public ListCell<ContactsInfo> call(ListView<ContactsInfo> listView) {
                        return new ImageCell();
                    }
                }
        );
    }

}
