/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.Conducteur;
import bean.Passager;
import bean.Personne;
import bean.Voyage;
import helper.PassagerFxHelper;
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
import service.PassagerService;
import util.Session;

/**
 * FXML Controller class
 *
 * @author IlyassElfouih
 */
public class ListeDesPassagersController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView<Passager> jtablePassager;
    @FXML
    private Label notLabel;
    PassagerFxHelper passagerFxHelper;
    PassagerService passagerService = new PassagerService();
    ViewLuncherLoging viewLuncherLoging = new ViewLuncherLoging();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Voyage voyage = (Voyage) Session.getAttribut("voyage selectione");
        passagerFxHelper = new PassagerFxHelper(jtablePassager, passagerService.getPassagerForVoyage(voyage));
        
         // ----------------------------------------notification-----------------------------------
       NotificationService notificationService = new NotificationService();
        ConducteurService conducteurService = new ConducteurService();
        int rep =0;
         rep = notificationService.nbrDeNotificationNonLu(((Personne) Session.getAttribut("utilisateur connecter ")));
        if(rep!=0){
            notLabel.setText(String.valueOf(rep));}
           
        //------------------------------------------notifier passager confirmation du trajet ------------------------  
            List<Voyage> lesVoyages = notificationService
                    .voyagesConfirmationTrajet(((Personne) Session.getAttribut("utilisateur connecter ")).getEmail());
            if(lesVoyages.size()!=0){
                for (Voyage ligne : lesVoyages) {
                    Conducteur conducteurNotifiant = conducteurService.findConducteurbyVoyage(ligne);
                    Notifications notifications = Notifications.create()
                 .title("confirmation du voyage")
                 .text("le conducteur "+conducteurNotifiant.getPersonne().getNom()+" "+conducteurNotifiant.getPersonne().getNom()+" vous a accepter pour le voyage de la date "+ligne.getDateVoyage())
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
    void jtableMouseClicked(Event event) throws IOException {

        Passager passager = passagerFxHelper.getSelected();
        Session.updateAttribute(passager.getPersonne(), "personne Selectionner");
        System.out.println(passager.getPersonne());
       viewLuncherLoging.forWardNewTab(event, "DonnerAvis.fxml", this.getClass());
    }

    @FXML
    void retour(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("TrajetCommeConducteur.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

    }

    @FXML
    void chercherTrajet(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ChercherTrajet.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

    }

    @FXML
    void deconexion(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("loginForm.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    void home(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    void modifierProfile(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ModifierProfile.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    void notification(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Notification.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    void proposerTrajet(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ProposerTrajet.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    void tableauDeBord(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("TableauDeBord.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}
