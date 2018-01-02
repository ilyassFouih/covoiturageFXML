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
import javafx.stage.Stage;
import service.PersonneService;

/**
 * FXML Controller class
 *
 * @author Mouhad Essabbane
 */
public class InscriptionController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private JFXTextField email;
    private JFXTextField prenom;
    private JFXTextField nom;
    private JFXTextField age;
    private JFXTextField tel;
    private JFXTextField cin;
    private JFXTextField mdp;
    private JFXTextField retmdp;
    private JFXTextField msgErr;
    private JFXCheckBox oui;
    private JFXCheckBox non;
    
    PersonneService pService = new PersonneService();

    public void inscription(ActionEvent actionEvent) throws IOException{
        if (mdp != retmdp) {
            msgErr.setText("*le mot de passe taper n'est pas identique*");
        }
        
        Personne personne=getParam();
        int res=pService.sinscrire(personne);
        if(res==1){
          Parent root= FXMLLoader.load(getClass().getResource("loginForm.fxml"));
          Scene scene = new Scene(root);
          Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
          window.setScene(scene);
          window.show();
        }
        
    }

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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public JFXTextField getEmail() {
        return email;
    }

    public void setEmail(JFXTextField email) {
        this.email = email;
    }

    public JFXCheckBox getOui() {
        return oui;
    }

    public void setOui(JFXCheckBox oui) {
        this.oui = oui;
    }

    public JFXCheckBox getNon() {
        return non;
    }

    public void setNon(JFXCheckBox non) {
        this.non = non;
    }

    public JFXTextField getPrenom() {
        return prenom;
    }

    public void setPrenom(JFXTextField prenom) {
        this.prenom = prenom;
    }

    public JFXTextField getNom() {
        return nom;
    }

    public void setNom(JFXTextField nom) {
        this.nom = nom;
    }

    public JFXTextField getAge() {
        return age;
    }

    public void setAge(JFXTextField age) {
        this.age = age;
    }

    public JFXTextField getTel() {
        return tel;
    }

    public void setTel(JFXTextField tel) {
        this.tel = tel;
    }

    public JFXTextField getCin() {
        return cin;
    }

    public void setCin(JFXTextField cin) {
        this.cin = cin;
    }

    public JFXTextField getMdp() {
        return mdp;
    }

    public void setMdp(JFXTextField mdp) {
        this.mdp = mdp;
    }

    public JFXTextField getRetmdp() {
        return retmdp;
    }

    public void setRetmdp(JFXTextField retmdp) {
        this.retmdp = retmdp;
    }

}
