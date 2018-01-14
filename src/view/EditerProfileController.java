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
import java.io.IOException;
import java.util.Objects;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import service.PersonneService;
import util.Session;

/**
 * FXML Controller class
 *
 * @author IlyassElfouih
 */
public class EditerProfileController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private JFXTextField nom;

    @FXML
    private JFXTextField prenom;

    @FXML
    private JFXTextField age;

    @FXML
    private JFXTextField cin;

    @FXML
    private JFXPasswordField  mdp;
    
    @FXML
    private JFXTextField tel;

    @FXML
    private JFXCheckBox oui;

    @FXML
    private JFXCheckBox non;

    @FXML
    private JFXPasswordField  retmdp;

    @FXML
    private Label msgErr;

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EditerProfileController other = (EditerProfileController) obj;
        if (!Objects.equals(this.mdp, other.mdp)) {
            return false;
        }
        if (!Objects.equals(this.retmdp, other.retmdp)) {
            return false;
        }
        return true;
    }

    @FXML
    public void modifier(ActionEvent actionEvent) throws IOException {
        
        PersonneService personneService = new PersonneService();
        Personne personne = getParam();
            if ((!mdp.getText().equals(retmdp.getText())) && personne.getPassword()!=null) {
            msgErr.setText("*le mot de passe taper n'est pas identique*");
            retmdp.setStyle("-fx-background-color : red;");
        } else {
            
            
            int res = personneService.modifierProfil(personne,((Personne) Session.getAttribut("utilisateur connecter ")).getEmail());
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
        
//        if(nom.getText().isEmpty())
//        p.setNom(null);
//        
//        if(prenom.getText().isEmpty())
//        p.setPrenom(null);
//        
//        if(age.getText().isEmpty())
//        p.setAge(0);
//        
//        if(tel.getText().isEmpty())
//        p.setTel(null);
//        
//        if(cin.getText().isEmpty())
//        p.setCin(null);
//        
//        if(mdp.getText().isEmpty())
//        p.setPassword(null);
//        
//        if (!oui.isSelected()) {
//            p.setFumeur(false);
//        } else if (!non.isSelected()) {
//            p.setFumeur(false);
//        }

        return p;

    }
}
