/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.Personne;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.stage.Stage;
import service.PersonneService;
import util.Session;

/**
 * FXML Controller class
 *
 * @author IlyassElfouih
 */
public class TestController implements Initializable {

    /**
     * Initializes the controller class.
     */
   @FXML
    private JFXTextField nom;

    @FXML
    private JFXTextField prenom;

    @FXML
    private JFXTextField age;
    private JFXTextField tel;

    @FXML
    private JFXTextField cin;

    @FXML
    private JFXTextField mdp;

    @FXML
    private JFXCheckBox oui;

    @FXML
    private JFXCheckBox non;

    @FXML
    private JFXTextField retmdp;
    private Label msgErr;
    PersonneService pService = new PersonneService();

    @FXML
    public void modifier(ActionEvent actionEvent) throws IOException {
        if (mdp != retmdp) {
            msgErr.setText("*le mot de passe taper n'est pas identique*");
        } else {
            Personne personne = getParam();
            
            int res = pService.modifierProfil(personne, ((Personne) Session.getAttribut("utilisateur connecter ")).getEmail());
            if (res == 1) {
                Parent root = FXMLLoader.load(getClass().getResource("loginForm.fxml"));
                Scene scene = new Scene(root);
                Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();
            }
        }
    }
        
        
        
    

    public Personne getParam() {
       int res= Integer.valueOf(age.getText());
        Personne p = new Personne(nom.getText(), prenom.getText(), mdp.getText(), tel.getText(), true, res, cin.getText());
        
        if(nom.getText().isEmpty())
        p.setNom(null);
        
        if(prenom.getText().isEmpty())
        p.setPrenom(null);
        
        if(age.getText().isEmpty())
        p.setAge(0);
        
        if(tel.getText().isEmpty())
        p.setTel(null);
        
        if(cin.getText().isEmpty())
        p.setCin(null);
        
        if(mdp.getText().isEmpty())
        p.setPassword(null);
        
        if (oui.isSelected()) {
            p.setFumeur(true);
        } else if (non.isSelected()) {
            p.setFumeur(true);
        }

        return p;

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
}
