/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.Personne;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import util.Session;

/**
 * FXML Controller class
 *
 * @author IlyassElfouih
 */
public class ModifierProfileController implements Initializable {

    /**
     * Initializes the controller class.
     */
        @FXML
    private ImageView image;

    @FXML
    private Label nomPrenom;

    @FXML
    private Label age;

    @FXML
    private Label email;

    @FXML
    private Label cin;

    @FXML
    private Label fumeur;

    @FXML
    private Label tel;

    @FXML
    private Label parfait;

    @FXML
    private Label tresBien;

    @FXML
    private Label bien;

    @FXML
    private Label aEviter;
    
//    -------------------les methodes--------------------

    @FXML
    void chercherTrajet(ActionEvent actionEvent)throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("ChercherTrajet.fxml"));
        Scene scene= new Scene(root);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    void deconexion(ActionEvent actionEvent) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("loginForm.fxml"));
        Scene scene= new Scene(root);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    void edditerProfil(ActionEvent actionEvent)throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("EditerProfile.fxml"));
        Scene scene= new Scene(root);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    void home(ActionEvent actionEvent) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene scene= new Scene(root);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    void notification(ActionEvent actionEvent) throws IOException{
         Parent root = FXMLLoader.load(getClass().getResource("Notification.fxml"));
        Scene scene= new Scene(root);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    void proposerTrajet(ActionEvent actionEvent)throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("ProposerTrajet.fxml"));
        Scene scene= new Scene(root);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    void tableauDeBord(ActionEvent actionEvent)throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("TableauDeBord.fxml"));
        Scene scene= new Scene(root);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        nomPrenom.setText(((Personne) Session.getAttribut("utilisateur connecter ")).getNom() + " "+((Personne) Session.getAttribut("utilisateur connecter ")).getPrenom() );
        email.setText(((Personne) Session.getAttribut("utilisateur connecter ")).getEmail()) ;
        tel.setText(((Personne) Session.getAttribut("utilisateur connecter ")).getTel()) ;
        cin.setText(((Personne) Session.getAttribut("utilisateur connecter ")).getCin()) ;
        age.setText(String.valueOf(((Personne) Session.getAttribut("utilisateur connecter ")).getAge())) ;
        if(((Personne) Session.getAttribut("utilisateur connecter ")).isFumeur())
            fumeur.setText("fumeur : oui ");
        else if(false==((Personne) Session.getAttribut("utilisateur connecter ")).isFumeur())
            fumeur.setText("fumeur : non ");
        else 
            fumeur.setText("fumeur : *n'est pas definer* ");
        
        
    }   

    public Label getaEviter() {
        return aEviter;
    }

    public void setaEviter(Label aEviter) {
        this.aEviter = aEviter;
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

    public Label getNomPrenom() {
        return nomPrenom;
    }

    public void setNomPrenom(Label nomPrenom) {
        this.nomPrenom = nomPrenom;
    }

    public Label getAge() {
        return age;
    }

    public void setAge(Label age) {
        this.age = age;
    }

    public Label getEmail() {
        return email;
    }

    public void setEmail(Label email) {
        this.email = email;
    }

    public Label getCin() {
        return cin;
    }

    public void setCin(Label cin) {
        this.cin = cin;
    }

    public Label getFumeur() {
        return fumeur;
    }

    public void setFumeur(Label fumeur) {
        this.fumeur = fumeur;
    }

    public Label getTel() {
        return tel;
    }

    public void setTel(Label tel) {
        this.tel = tel;
    }

    public Label getParfait() {
        return parfait;
    }

    public void setParfait(Label parfait) {
        this.parfait = parfait;
    }

    public Label getTresBien() {
        return tresBien;
    }

    public void setTresBien(Label tresBien) {
        this.tresBien = tresBien;
    }

    public Label getBien() {
        return bien;
    }

    public void setBien(Label bien) {
        this.bien = bien;
    }
    
    
    
}
