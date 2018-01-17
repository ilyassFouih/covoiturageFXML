/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.Notification;
import bean.Personne;
import com.jfoenix.controls.JFXProgressBar;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import service.AvisService;
import service.PassagerService;
import util.Session;

/**
 * FXML Controller class
 *
 * @author IlyassElfouih
 */
public class ConfirmationPassagerController implements Initializable {
    
    
    @FXML
    private JFXProgressBar parfait;

    @FXML
    private JFXProgressBar tresBien;

    @FXML
    private JFXProgressBar bien;

    @FXML
    private JFXProgressBar aEviter;

    @FXML
    private Label nbrParfait;

    @FXML
    private Label nbrTresBien;

    @FXML
    private Label nbrBien;

    @FXML
    private Label nbrAeviter;

    @FXML
    private Label email;

    @FXML
    private Label nom;

    @FXML
    private Label fumeur;

    @FXML
    private Label tel;
    
    PassagerService passagerSevice = new PassagerService();


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Notification notification = (Notification) Session.getAttribut("confirmationNotification");
        Personne personne = notification.getPersonne();
        email.setText(personne.getEmail());
        nom.setText(personne.getNom()+" "+personne.getPrenom());
         if(personne.isFumeur())
            fumeur.setText(" oui ");
        else if(!personne.isFumeur())
            fumeur.setText(" non ");
        else 
            fumeur.setText("fumeur : *n'est pas definer* ");
         tel.setText(""+personne.getTel());
        // -------------------------------progresseBar---------------------------------------
            AvisService avisService = new AvisService();
            List<Integer> rep=avisService.listeAvisByPersonne(personne);
            nbrParfait.setText(""+rep.get(0));
            nbrTresBien.setText(""+rep.get(1));
            nbrBien.setText(""+rep.get(2));
            nbrAeviter.setText(""+rep.get(3));
           
            float res =avisService.calculeProgresseBar(personne, 4);
            parfait.setProgress(res);
            System.out.println(res);
            res =avisService.calculeProgresseBar(personne, 3);
            tresBien.setProgress(res);
            System.out.println(res);
            res =avisService.calculeProgresseBar(personne, 2);
            bien.setProgress(res);
            System.out.println(res);
            res =avisService.calculeProgresseBar(personne, 1);
            aEviter.setProgress(res);
             System.out.println(res);
        
    }    
     @FXML
    void accepterLadDemande(ActionEvent event) {
        passagerSevice.creatPassagerByNotification((Notification) Session.getAttribut("confirmationNotification"));
            Notifications notifications = Notifications.create()
                 .title("passager creere ")
                 .text("le passager "+((Notification) Session.getAttribut("confirmationNotification"))
                         .getPersonne().getNom() +" est creer avec succe ")
                 .graphic(null)
                 .hideAfter(Duration.seconds(5))
                 .position(Pos.TOP_LEFT);
                notifications.darkStyle();   
                notifications.showConfirm();
    }
}
