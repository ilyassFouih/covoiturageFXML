/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.Conducteur;
import bean.Personne;
import bean.Voyage;
import helper.VoyageFxHelper;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import service.ConducteurService;
import service.NotificationService;
import service.VoyageService;
import util.Session;

/**
 * FXML Controller class
 *
 * @author Mouhad Essabbane
 */
public class ResultatRechercheController implements Initializable {

    @FXML
    private TableView<Voyage> tableResult;
    @FXML
    private Label notLabel;

    VoyageFxHelper voyageFxHelper;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        VoyageService voyageService = new VoyageService();
        Voyage voyage = (Voyage) Session.getAttribut("voyageRechercher");
        System.out.println(voyage);
        List<Voyage> voyages = voyageService.chercherVoyage(voyage.getVilleDepart(), voyage.getVilleArriver()
                , (String) Session.getAttribut("dateString"));
        voyageFxHelper = new VoyageFxHelper(tableResult, voyages);
           // ----------------------------------------notification-----------------------------------
       NotificationService notificationService = new NotificationService();
        ConducteurService conducteurService = new ConducteurService();
        int res =0;
         res = notificationService.nbrDeNotificationNonLu(((Personne) Session.getAttribut("utilisateur connecter ")));
        if(res!=0){
            notLabel.setText(String.valueOf(res));}
           
        //------------------------------------------notifier passager confirmation du trajet ------------------------  
            List<Voyage> lesVoyages = notificationService
                    .voyagesConfirmationTrajet(((Personne) Session.getAttribut("utilisateur connecter ")).getEmail());
            if(voyages.size()!=0){
                for (Voyage ligne : lesVoyages) {
                    Conducteur conducteur = conducteurService.findConducteurbyVoyage(ligne);
                    Notifications notifications = Notifications.create()
                 .title("confirmation du voyage")
                 .text("le conducteur "+conducteur.getPersonne().getNom()+" "+conducteur.getPersonne().getNom()+" vous a accepter pour le voyage de la date "+voyage.getDateVoyage())
                 .graphic(null)
                 .hideAfter(Duration.seconds(10))
                 .position(Pos.BOTTOM_RIGHT);
                notifications.darkStyle();   
                notifications.showConfirm();
                    notificationService.edditerVuPourUnVoyage(ligne, ((Personne) Session.getAttribut("utilisateur connecter ")).getEmail());
                }
            }
    }

    @FXML
    public void jtableMouseClicked(Event actionEvent) throws IOException {
        Voyage voyage = voyageFxHelper.getSelected();
        Session.updateAttribute(voyage, "voyageClicked");

        Parent root = FXMLLoader.load(getClass().getResource("AfficherCondCircuit.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    public void chercherTrajet(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ChercherTrajet.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

    }

    @FXML
    public void deconexion(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("loginForm.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    public void home(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    public void modifierProfile(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ModifierProfile.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    public void notification(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Notification.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    public void proposerTrajet(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ProposerTrajet.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    public void tableauDeBord(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("TableauDeBord.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

}
