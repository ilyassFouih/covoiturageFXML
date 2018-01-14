/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.Conducteur;
import bean.Personne;
import com.jfoenix.controls.JFXTabPane;
import helper.ConducteurFxHelper;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import service.ConducteurService;
import util.Session;

/**
 * FXML Controller class
 *
 * @author IlyassElfouih
 */
public class TrajetCommeConducteurController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
      @FXML
    private TableView<Conducteur> jtableConducteur;
     @FXML
    private JFXTabPane table;
      
    ConducteurService conducteurService = new ConducteurService();
    ConducteurFxHelper conducteurFxHelper ;
      
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
      conducteurFxHelper =  new ConducteurFxHelper(jtableConducteur, conducteurService
              .getConducteurByEmail(((Personne) Session.getAttribut("utilisateur connecter ")).getEmail()));
    }   
    
     @FXML
    void jtableMouseClicked(Event event) throws IOException  {
        
          Conducteur conducteur = conducteurFxHelper.getSelected();
          System.out.println(conducteur);
          Session.updateAttribute(conducteur.getVoyage(), "voyage selectione");
        
        Parent root = FXMLLoader.load(getClass().getResource("ListeDesPassagers.fxml"));
        Scene scene= new Scene(root);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
    
    @FXML
    void retour(ActionEvent actionEvent) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("TableauDeBord.fxml"));
        Scene scene= new Scene(root);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
        
    }
    @FXML
    void chercherTrajet(ActionEvent actionEvent) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("ChercherTrajet.fxml"));
        Scene scene= new Scene(root);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
        
    }

    @FXML
    void deconexion(ActionEvent actionEvent) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("loginForm.fxml"));
        Scene scene= new Scene(root);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    void home(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene scene= new Scene(root);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    void modifierProfile(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ModifierProfile.fxml"));
        Scene scene= new Scene(root);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    void notification(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Notification.fxml"));
        Scene scene= new Scene(root);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    void proposerTrajet(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ProposerTrajet.fxml"));
        Scene scene= new Scene(root);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

   

    @FXML
    void tableauDeBord(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("TableauDeBord.fxml"));
        Scene scene= new Scene(root);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}
