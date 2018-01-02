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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import util.Session;

/**
 * FXML Controller class
 *
 * @author IlyassElfouih
 */
public class HomeController implements Initializable {
    
    @FXML
    private Label nomPrenom ;
   
    @FXML
    private void chercherTrajet(ActionEvent actionEvent) throws IOException{
        
        Parent root = FXMLLoader.load(getClass().getResource("ChercherTrajet.fxml"));
        Scene scene= new Scene(root);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
        
        
    }
    @FXML
    private void deconexione(ActionEvent actionEvent) throws IOException{
        
        Parent root = FXMLLoader.load(getClass().getResource("loginForm.fxml"));
        Scene scene= new Scene(root);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
        
        
    }
    @FXML
    private void modifierProfile(ActionEvent actionEvent) throws IOException{
        
        Parent root = FXMLLoader.load(getClass().getResource("ModifierProfile.fxml"));
        Scene scene= new Scene(root);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
        
        
    }
    @FXML
    private void proposerTrajet(ActionEvent actionEvent) throws IOException{
        
        Parent root = FXMLLoader.load(getClass().getResource("ProposerTrajet.fxml"));
        Scene scene= new Scene(root);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
        
        
    }
    @FXML
    private void notification(ActionEvent actionEvent) throws IOException{
        
        Parent root = FXMLLoader.load(getClass().getResource("Notification.fxml"));
        Scene scene= new Scene(root);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
        
        
    }
    @FXML
    private void tableauDeBord(ActionEvent actionEvent) throws IOException{
        
        Parent root = FXMLLoader.load(getClass().getResource("TableauDeBord.fxml"));
        Scene scene= new Scene(root);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
        
        
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        nomPrenom.setText( ((Personne) Session.getAttribut("utilisateur connecter ")).getNom() + " "+((Personne) Session.getAttribut("utilisateur connecter ")).getPrenom() 
                );
    }    

    public Label getNomPrenom() {
        return nomPrenom;
    }

    public void setNomPrenom(Label nomPrenom) {
        this.nomPrenom = nomPrenom;
    }
    
}
