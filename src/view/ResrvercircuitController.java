/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.CircuitVoyage;
import bean.Conducteur;
import bean.Notification;
import bean.Personne;
import bean.Voyage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import service.ConducteurService;
import service.NotificationService;
import service.VoyageService;
import util.Session;

/**
 * FXML Controller class
 *
 * @author IlyassElfouih
 */
public class ResrvercircuitController implements Initializable {
    
    
      @FXML
    private Label villeDepCircuit;

    @FXML
    private Label villeArrCircuit;

    @FXML
    private Label prixCircuit;

    @FXML
    private Label conducteurCircuit;
    
   ViewLuncherLoging viewLuncherLoging = new ViewLuncherLoging();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
            ConducteurService conducteurService = new ConducteurService();
            CircuitVoyage circuitVoyage = (CircuitVoyage) Session.getAttribut("circuitVoyageSelectionner");
            villeDepCircuit.setText(circuitVoyage.getVilleDep().getNom());
            villeArrCircuit.setText(circuitVoyage.getVilleArr().getNom());
            //            Conducteur conducteur1 = (Conducteur) circuitVoyage.getVoyage().getConducteurs();
            Conducteur conducteur1 = conducteurService.findConducteurbyVoyage(circuitVoyage.getVoyage());
            prixCircuit.setText(""+ new Double(conducteur1.getPrix()));
            conducteurCircuit.setText(conducteur1.getPersonne().getNom()+" "+conducteur1.getPersonne().getPrenom());
    }    
    
     @FXML
    void reserverUnCircuit(ActionEvent event) throws IOException {
        Notification notification = new Notification();
        ConducteurService conducteurService = new ConducteurService();
         NotificationService notificationService = new NotificationService();
       Voyage voyage = (Voyage) Session.getAttribut("voyageClicked");
       notification.setIdCircuitVoyage(((CircuitVoyage) Session.getAttribut("circuitVoyageSelectionner")).getId());
       notification.setPersonne(((Personne) Session.getAttribut("utilisateur connecter ")));
       notification.setQui("p");
       notification.setVoyage(((CircuitVoyage) Session.getAttribut("circuitVoyageSelectionner")).getVoyage());
        notificationService.create(notification);
        
        Notifications notifications = Notifications.create()
                 .title("notification ajouter")
                 .text("votre demande a etait envoyer au conducteur "+conducteurService
                         .findConducteurbyVoyage(((Voyage) Session.getAttribut("voyageClicked"))).getPersonne()
                          .getPrenom()+" "+conducteurService
                         .findConducteurbyVoyage(((Voyage) Session.getAttribut("voyageClicked"))).getPersonne()
                          .getNom())
                 .graphic(null)
                 .hideAfter(Duration.seconds(5))
                 .position(Pos.TOP_LEFT);
                notifications.darkStyle();   
                notifications.showConfirm();
                
                viewLuncherLoging.forWardMousePrecedentTab(event, "AfficherCondCircuit.fxml", this.getClass());

    }
    
}
