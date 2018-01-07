/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.CircuitVoyage;
import bean.Conducteur;
import bean.Personne;
import bean.Ville;
import bean.Voyage;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableView;
import helper.CircuitVoyageFxHelper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import service.CircuitVoyageService;
import service.ConducteurService;
import service.VilleService;
import util.Session;

/**
 * FXML Controller class
 *
 * @author IlyassElfouih
 */
public class ChoixVilleCircuitController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        VilleService villeService = new VilleService();
        List<String> villes = villeService.getAllvilles();
//        for (int i = 0; i < villes.size(); i++) {
//            villeDepCircuit.getItems().add(villes.get(i));
//            villeArrCircuit.getItems().add(villes.get(i));
//        }
            villeDepCircuit.setItems(FXCollections.observableArrayList(villes));
            villeArrCircuit.setItems(FXCollections.observableArrayList(villes));
 
    }    
    @FXML
    private JFXComboBox<String> villeDepCircuit;

    @FXML
    private JFXComboBox<String> villeArrCircuit;

    @FXML
    private JFXTextField prixVilleCircuit;
    
    @FXML
    private  TableView<CircuitVoyage> jTable;
    
    private int i=0;
    private List<CircuitVoyage> circuitVoyages =new ArrayList();
    
    public CircuitVoyage getCircuitVoyage(){
        CircuitVoyage circuitVoyage = new CircuitVoyage();
        VilleService villeService = new VilleService();
        circuitVoyage.setPrix(Double.valueOf(prixVilleCircuit.getText()));
        
        Ville villeDEP = new Ville();
        villeDEP.setNom((String) villeDepCircuit.getSelectionModel().getSelectedItem());
        villeDEP.setId(villeService.getId((String) villeDepCircuit.getSelectionModel().getSelectedItem()));
        circuitVoyage.setVilleDep(villeDEP);
     
        Ville villeARR = new Ville();
        villeARR.setNom((String) villeArrCircuit.getSelectionModel().getSelectedItem());  
        villeARR.setId(villeService.getId((String) villeArrCircuit.getSelectionModel().getSelectedItem()));
        circuitVoyage.setVilleArr(villeARR);
        
        return circuitVoyage;
    }

    @FXML
    void ajouterAmonTrajet(ActionEvent event) {
             i++;
            jTable.getColumns().clear();
            CircuitVoyage circuitVoyage = getCircuitVoyage();
            circuitVoyage.setNum(i);
            circuitVoyages.add(circuitVoyage);
            System.out.println(circuitVoyage);
            new CircuitVoyageFxHelper(jTable, circuitVoyages);
            jTable.refresh();
//            List<Ville> item = (List<Ville>) circuitVoyageFxHelper.getSelected().getVilleDep();
//              villeDepCircuit.setItems(FXCollections.observableArrayList(item));

    }
        @FXML
      void valider(ActionEvent actionEvent) throws IOException {
  //        ---------------------creation du Conducteur Voyage et circuit  ------------------------
  
                System.out.println(((Personne) Session.getAttribut("utilisateur connecter ")));
                System.out.println(circuitVoyages);
                System.out.println(((Conducteur) Session.getAttribut("conducteur")));
             CircuitVoyageService circuitVoyageService = new CircuitVoyageService();
             ConducteurService conducteurService = new ConducteurService();
             
              circuitVoyageService.creerCircuit(((Voyage) Session.getAttribut("Voyage")), circuitVoyages);
              conducteurService.proposerTrajet(((Personne) Session.getAttribut("utilisateur connecter ")).getEmail(),
                      ((Voyage) Session.getAttribut("Voyage")), ((Conducteur) Session.getAttribut("conducteur")));//ta proposer ?? 
  //          -------------------------redirection---------------------------------  
          Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
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

    public JFXComboBox<?> getVilleDepCircuit() {
        return villeDepCircuit;
    }

    public void setVilleDepCircuit(JFXComboBox<String> villeDepCircuit) {
        this.villeDepCircuit = villeDepCircuit;
    }

    public JFXComboBox<String> getVilleArrCircuit() {
        return villeArrCircuit;
    }

    public void setVilleArrCircuit(JFXComboBox<String> villeArrCircuit) {
        this.villeArrCircuit = villeArrCircuit;
    }

    public JFXTextField getPrixVilleCircuit() {
        return prixVilleCircuit;
    }

    public void setPrixVilleCircuit(JFXTextField prixVilleCircuit) {
        this.prixVilleCircuit = prixVilleCircuit;
    }

    
}
