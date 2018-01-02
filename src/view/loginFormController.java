/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.Personne;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import service.PersonneService;
import util.Session;

/**
 *
 * @author IlyassElfouih
 */
public class loginFormController implements Initializable {

    @FXML
    private Label errorEmail;
    @FXML
    private Label errorPass;
    @FXML
    private JFXTextField emailScene;
    @FXML
    private JFXPasswordField passwordScene;
    @FXML
    private Hyperlink sinscrire;
    @FXML
    private JFXButton connecter;

    PersonneService personneService = new PersonneService();

   
    public void connexion(ActionEvent actionEvent) throws IOException{
        Personne personne = new Personne();
        personne.setEmail(emailScene.getText());
        personne.setPassword(passwordScene.getText());
        int res = personneService.seConnecter(personne);
        switch (res) {
            case -1:
                errorEmail.setText("*l'email n'existe pas ");
                break;
            case -2:
                errorPass.setText("*password incorrecte ");
                break;
            default:
                JOptionPane.showMessageDialog(null, res, "connextion avec succe ", res);
                Personne utilisateur= personneService.find(emailScene.getText());
                Session.updateAttribute(utilisateur, "utilisateur connecter ");
                Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
                Scene scene= new Scene(root);
                Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();
                break;
        }
    }
    
    public void inscription(ActionEvent actionEvent)throws IOException{
                Parent root = FXMLLoader.load(getClass().getResource("inscription.fxml"));
                Scene scene= new Scene(root);
                Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    public Label getErrorEmail() {
        return errorEmail;
    }

    public void setErrorEmail(Label errorEmail) {
        this.errorEmail = errorEmail;
    }

    public Label getErrorPass() {
        return errorPass;
    }

    public void setErrorPass(Label errorPass) {
        this.errorPass = errorPass;
    }

    public JFXTextField getEmailScene() {
        return emailScene;
    }

    public void setEmailScene(JFXTextField emailScene) {
        this.emailScene = emailScene;
    }

    public JFXPasswordField getPasswordScene() {
        return passwordScene;
    }

    public void setPasswordScene(JFXPasswordField passwordScene) {
        this.passwordScene = passwordScene;
    }

    public Hyperlink getSinscrire() {
        return sinscrire;
    }

    public void setSinscrire(Hyperlink sinscrire) {
        this.sinscrire = sinscrire;
    }

    public JFXButton getConnecter() {
        return connecter;
    }

    public void setConnecter(JFXButton connecter) {
        this.connecter = connecter;
    }

    public PersonneService getPersonneService() {
        return personneService;
    }

    public void setPersonneService(PersonneService personneService) {
        this.personneService = personneService;
    }

}
