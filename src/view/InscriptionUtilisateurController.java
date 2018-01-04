/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.Personne;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import service.PersonneService;

/**
 * FXML Controller class
 *
 * @author IlyassElfouih
 */
public class InscriptionUtilisateurController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private JFXTextField email;

    @FXML
    private JFXTextField nom;

    @FXML
    private JFXTextField prenom;

    @FXML
    private JFXTextField age;

    @FXML
    private JFXTextField tel;

    @FXML
    private JFXTextField cin;

    @FXML
    private JFXPasswordField mdp;

    @FXML
    private JFXCheckBox oui;

    @FXML
    private JFXCheckBox non;

    @FXML
    private JFXPasswordField retmdp;

    @FXML
    private Label msgErr;
    
    PersonneService personneService = new PersonneService();
    
    public Personne getParam() {
        Personne p = new Personne();
        p.setEmail(email.getText());
        p.setNom(nom.getText());
        p.setPrenom(prenom.getText());
        p.setAge(Integer.valueOf(age.getText()));
        p.setTel(tel.getText());
        p.setCin(cin.getText());
        p.setPassword(mdp.getText());
        if (oui.isSelected()) {
            p.setFumeur(true);
        } else if (non.isSelected()) {
            p.setFumeur(true);
        }

        return p;

    }
    
     @FXML
         public void insc(ActionEvent actionEvent) throws IOException{
        if (mdp != retmdp) {
            msgErr.setText("*le mot de passe taper n'est pas identique*");
        }
        
        Personne personne=getParam();
        int res=personneService.sinscrire(personne);
        if(res==1){
          Parent root= FXMLLoader.load(getClass().getResource("loginForm.fxml"));
          Scene scene = new Scene(root);
          Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
          window.setScene(scene);
          window.show();
        }
        
    }
}
