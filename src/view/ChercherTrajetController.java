/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.Conducteur;
import bean.Personne;
import bean.Ville;
import bean.Voyage;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import service.ConducteurService;
import service.NotificationService;
import service.VilleService;
import util.DateUtil;
import util.Session;

/**
 * FXML Controller class
 *
 * @author Mouhad Essabbane
 */
public class ChercherTrajetController implements Initializable {
    
    
    @FXML
    private JFXComboBox<Ville> villeDep;

    @FXML
    private JFXComboBox<Ville> villeArr;

    @FXML
    private JFXDatePicker dateV;
    @FXML
    private Label notLabel;
    
    VilleService villeService = new VilleService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        List<Ville> villes = new ArrayList();
        
        villes = villeService.getAllvilles();
            
            villeDep.setItems(FXCollections.observableArrayList(villes));
            villeArr.setItems(FXCollections.observableArrayList(villes));
         // ----------------------------------------notification-----------------------------------
       NotificationService notificationService = new NotificationService();
        ConducteurService conducteurService = new ConducteurService();
        int res =0;
         res = notificationService.nbrDeNotificationNonLu(((Personne) Session.getAttribut("utilisateur connecter ")));
        if(res!=0){
            notLabel.setText(String.valueOf(res));}
           
        //------------------------------------------notifier passager confirmation du trajet ------------------------  
            List<Voyage> voyages = notificationService
                    .voyagesConfirmationTrajet(((Personne) Session.getAttribut("utilisateur connecter ")).getEmail());
            if(voyages.size()!=0){
                for (Voyage voyage : voyages) {
                    Conducteur conducteur = conducteurService.findConducteurbyVoyage(voyage);
                    Notifications notifications = Notifications.create()
                 .title("confirmation du voyage")
                 .text("le conducteur "+conducteur.getPersonne().getNom()+" "+conducteur.getPersonne().getNom()+" vous a accepter pour le voyage de la date "+voyage.getDateVoyage())
                 .graphic(null)
                 .hideAfter(Duration.seconds(10))
                 .position(Pos.BOTTOM_RIGHT);
                notifications.darkStyle();   
                notifications.showConfirm();
                    notificationService.edditerVuPourUnVoyage(voyage, ((Personne) Session.getAttribut("utilisateur connecter ")).getEmail());
                }
            }
            
    }


    

   

    @FXML
       public  void chercherVoyage(ActionEvent actionEvent) throws IOException  {
           Ville villedep= new Ville();
           Ville villearr=new Ville();
        villedep = villeService.find(villeDep.getValue().getId());
        villearr = villeService.find(villeArr.getValue().getId());
        Date dateChercher = DateUtil.convert(dateV.getValue().toString());
        Session.updateAttribute(dateV.getValue().toString(), "dateString");
        Voyage voyagerech = new Voyage(villedep, villearr, dateChercher);
        Session.updateAttribute(voyagerech, "voyageRechercher");
        System.out.println(voyagerech);
        
        
        Parent root = FXMLLoader.load(getClass().getResource("ResultatRecherche.fxml"));
        Scene scene= new Scene(root);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

    }

    
     @FXML
    void chercherTrajet(ActionEvent actionEvent) throws IOException  {
        Parent root = FXMLLoader.load(getClass().getResource("ChercherTrajet.fxml"));
        Scene scene= new Scene(root);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

    }
    @FXML
    void deconexion(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ResultatRecherche.fxml"));
        Scene scene= new Scene(root);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

    }

    @FXML
    void home(ActionEvent actionEvent) throws IOException  {
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene scene= new Scene(root);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

    }

    @FXML
    void modifierProfile(ActionEvent actionEvent) throws IOException  {
        Parent root = FXMLLoader.load(getClass().getResource("ModifierProfile.fxml"));
        Scene scene= new Scene(root);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

    }

    @FXML
    void notification(ActionEvent actionEvent)  throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Notification.fxml"));
        Scene scene= new Scene(root);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

    }

    @FXML
    void proposerTrajet(ActionEvent actionEvent)  throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ProposerTrajet.fxml"));
        Scene scene= new Scene(root);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

    }

    @FXML
    void tableauDeBord(ActionEvent actionEvent) throws IOException  {
        Parent root = FXMLLoader.load(getClass().getResource("loginForm.fxml"));
        Scene scene= new Scene(root);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

    }    

    public JFXComboBox<Ville> getVilleDep() {
        return villeDep;
    }

    public void setVilleDep(JFXComboBox<Ville> villeDep) {
        this.villeDep = villeDep;
    }

    public JFXComboBox<Ville> getVilleArr() {
        return villeArr;
    }

    public void setVilleArr(JFXComboBox<Ville> villeArr) {
        this.villeArr = villeArr;
    }
    
}
