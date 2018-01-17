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
import com.jfoenix.controls.JFXProgressBar;
import helper.CircuitVoyageFxHelper;
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
import service.AvisService;
import service.ConducteurService;
import service.NotificationService;
import util.Session;

/**
 * FXML Controller class
 *
 * @author Mouhad Essabbane
 */
public class AfficherCondCircuitController implements Initializable {
    
    
    
     @FXML
    private Label email;
     
     @FXML
    private Label booleanText;

    @FXML
    private Label fumeur;

    @FXML
    private Label prenom;

    @FXML
    private Label nom;
    
    @FXML
    private Label villedep;

    @FXML
    private Label villeArr;

    @FXML
    private Label dateV;

    @FXML
    private Label prixV;

@FXML
    private JFXProgressBar tBien;

    @FXML
    private JFXProgressBar bien;

    @FXML
    private JFXProgressBar aEviter;

    @FXML
    private JFXProgressBar prafait;

    
     @FXML
    private TableView<CircuitVoyage> tableCircuit;
     @FXML
      private Label notLabel;
     

     ViewLuncherLoging viewLuncherLoging = new ViewLuncherLoging();
     ConducteurService conducteurService = new ConducteurService();
     AvisService  avisService = new AvisService();
     CircuitVoyageFxHelper circuitVoyageFxHelper;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Voyage voyage =(Voyage) Session.getAttribut("voyageClicked");
        System.out.println(voyage);
        circuitVoyageFxHelper=new CircuitVoyageFxHelper(tableCircuit,voyage.getCircuitVoyages());
        Conducteur conducteur=conducteurService.findConducteurbyVoyage(voyage);
        email.setText(conducteur.getPersonne().getEmail());
        nom.setText(conducteur.getPersonne().getNom());
        prenom.setText(conducteur.getPersonne().getPrenom());
        villedep.setText(voyage.getVilleDepart().getNom());
        villeArr.setText(voyage.getVilleArriver().getNom());
        dateV.setText(String.valueOf(voyage.getDateVoyage()));
        prixV.setText(String.valueOf(conducteur.getPrix()));
        
            if(conducteur.getPersonne().isFumeur())
                booleanText.setText("oui");
            else
                booleanText.setText("non");
            
            float res =avisService.calculeProgresseBar(conducteur.getPersonne(), 4);
             prafait.setProgress(res);
             System.out.println(res);
            res =avisService.calculeProgresseBar(conducteur.getPersonne(), 3);
            tBien.setProgress(res);
            System.out.println(res);
            res =avisService.calculeProgresseBar(conducteur.getPersonne(), 2);
            bien.setProgress(res);
            System.out.println(res);
            res =avisService.calculeProgresseBar(conducteur.getPersonne(), 1);
            aEviter.setProgress(res);
             System.out.println(res);
             
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
    
//    @FXML
//    public void methode(){
//        
//    }
    
    @FXML
    public void reserverUnePlace(ActionEvent actionEvent) throws IOException {
        NotificationService notificationService = new NotificationService();
        Voyage voyageClicked = (Voyage) Session.getAttribut("voyageClicked");
        Notification notification = new Notification();
        notification.setQui("p");
        notification.setIdCircuitVoyage(new Long("-1"));
        notification.setVoyage(voyageClicked);
        notification.setPersonne((Personne) Session.getAttribut("utilisateur connecter "));
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
        
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene scene= new Scene(root);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
        

    }
    
    @FXML
 public   void reserverUnCircuitMouseClicked(Event event) throws IOException {
       
        CircuitVoyage circuitVoyage = circuitVoyageFxHelper.getSelected();
        Session.updateAttribute(circuitVoyage, "circuitVoyageSelectionner");
        
         
        viewLuncherLoging.forWardNewTab(event, "Resrvercircuit.fxml", this.getClass());
        
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
    
    @FXML
    void retour(ActionEvent actionEvent)throws IOException  {
        Parent root = FXMLLoader.load(getClass().getResource("ResultatRecherche.fxml"));
        Scene scene= new Scene(root);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
    
}