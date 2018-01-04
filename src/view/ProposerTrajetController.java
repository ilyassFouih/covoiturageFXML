/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import service.VilleService;

/**
 * FXML Controller class
 *
 * @author IlyassElfouih
 */
public class ProposerTrajetController implements Initializable {
    
      /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        VilleService villeService = new VilleService();
//        List<String> villes = villeService.getAllvilles();
//        villeDepart.setItems(FXCollections.observableArrayList(villes));
                
//        pieceJointeComboBox.setItems
//        (FXCollections.observableArrayList(pieceJointeFacade.findPieceJointeByFilierePJF(filiere.getNom())));
        
        
        
        
    }    
      
     @FXML
    private JFXComboBox<?> villeDepart;
      

    @FXML
    private JFXComboBox<?> villeArriver;

    @FXML
    private JFXDatePicker dateDepart;

    @FXML
    private JFXTextField nbrPlaceMax;

    @FXML
    private JFXTextField prix;
    @FXML
    private JFXTextField typeVoiture;
    
     @FXML
    void suivant(ActionEvent actionEvent) throws IOException {
//         Session.updateAttribute(utilisateur, "utilisateur connecter ");
//         Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));

         Parent root = FXMLLoader.load(getClass().getResource("ChoixVilleCircuit.fxml"));
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
        Parent root = FXMLLoader.load(getClass().getResource("loginForm.fxml"));
        Scene scene= new Scene(root);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    public JFXComboBox<?> getVilleDepart() {
        return villeDepart;
    }

    public void setVilleDepart(JFXComboBox<?> villeDepart) {
        this.villeDepart = villeDepart;
    }

    public JFXComboBox<?> getVilleArriver() {
        return villeArriver;
    }

    public void setVilleArriver(JFXComboBox<?> villeArriver) {
        this.villeArriver = villeArriver;
    }

    public JFXDatePicker getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(JFXDatePicker dateDepart) {
        this.dateDepart = dateDepart;
    }

    public JFXTextField getNbrPlaceMax() {
        return nbrPlaceMax;
    }

    public void setNbrPlaceMax(JFXTextField nbrPlaceMax) {
        this.nbrPlaceMax = nbrPlaceMax;
    }

    public JFXTextField getPrix() {
        return prix;
    }

    public void setPrix(JFXTextField prix) {
        this.prix = prix;
    }

    public JFXTextField getTypeVoiture() {
        return typeVoiture;
    }

    public void setTypeVoiture(JFXTextField typeVoiture) {
        this.typeVoiture = typeVoiture;
    }
    
    
    
  
    
    
}
