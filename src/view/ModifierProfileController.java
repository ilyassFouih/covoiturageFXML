/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.Conducteur;
import bean.Personne;
import bean.Voyage;
import com.jfoenix.controls.JFXProgressBar;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
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
 * @author IlyassElfouih
 */
public class ModifierProfileController implements Initializable {

    /**
     * Initializes the controller class.
     */
    ViewLuncherLoging viewLuncherLoging =new  ViewLuncherLoging();
        @FXML
    private ImageView image;

    @FXML
    private Label nom;
    
    @FXML
    private Label prenom;

    @FXML
    private Label age;

    @FXML
    private Label email;

    @FXML
    private Label cin;

    @FXML
    private Label fumeur;

    @FXML
    private Label tel;

    @FXML
    private JFXProgressBar  parfait;

    @FXML
    private JFXProgressBar  tresBien;

    @FXML
    private JFXProgressBar  bien;

    @FXML
    private JFXProgressBar  aEviter;
    
     @FXML
    private Label nbrParfait;

    @FXML
    private Label nbrTresBien;

    @FXML
    private Label nbrBien;

    @FXML
    private Label nbrAeviter;
    @FXML
    private Label notLabel;
    
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        nom.setText(((Personne) Session.getAttribut("utilisateur connecter ")).getNom());
        prenom.setText(((Personne) Session.getAttribut("utilisateur connecter ")).getPrenom());
        email.setText(((Personne) Session.getAttribut("utilisateur connecter ")).getEmail()) ;
        tel.setText(((Personne) Session.getAttribut("utilisateur connecter ")).getTel()) ;
        cin.setText(((Personne) Session.getAttribut("utilisateur connecter ")).getCin()) ;
        age.setText(String.valueOf(((Personne) Session.getAttribut("utilisateur connecter ")).getAge())) ;
        if(((Personne) Session.getAttribut("utilisateur connecter ")).isFumeur())
            fumeur.setText(" oui ");
        else if(false==((Personne) Session.getAttribut("utilisateur connecter ")).isFumeur())
            fumeur.setText(" non ");
        else 
            fumeur.setText("fumeur : *n'est pas definer* ");
//        -------------------------------progresse Bar-------------------------------------------
            AvisService avisService = new AvisService();
            List<Integer> rep=avisService.listeAvisByPersonne(((Personne) Session.getAttribut("utilisateur connecter ")));
            nbrParfait.setText(""+rep.get(0));
            nbrTresBien.setText(""+rep.get(1));
            nbrBien.setText(""+rep.get(2));
            nbrAeviter.setText(""+rep.get(3));
           
            float res =avisService.calculeProgresseBar(((Personne) Session.getAttribut("utilisateur connecter ")), 4);
            parfait.setProgress(res);
            System.out.println(res);
            res =avisService.calculeProgresseBar(((Personne) Session.getAttribut("utilisateur connecter ")), 3);
            tresBien.setProgress(res);
            System.out.println(res);
            res =avisService.calculeProgresseBar(((Personne) Session.getAttribut("utilisateur connecter ")), 2);
            bien.setProgress(res);
            System.out.println(res);
            res =avisService.calculeProgresseBar(((Personne) Session.getAttribut("utilisateur connecter ")), 1);
            aEviter.setProgress(res);
             System.out.println(res);
               // ----------------------------------------notification-----------------------------------
       NotificationService notificationService = new NotificationService();
        ConducteurService conducteurService = new ConducteurService();
        int resnotification =0;
         resnotification = notificationService.nbrDeNotificationNonLu(((Personne) Session.getAttribut("utilisateur connecter ")));
        if(resnotification!=0){
            notLabel.setText(String.valueOf(resnotification));}
           
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
    
//    -------------------les methodes--------------------

    @FXML
    void chercherTrajet(ActionEvent actionEvent)throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("ChercherTrajet.fxml"));
        Scene scene= new Scene(root);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    void deconexion(ActionEvent actionEvent) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("loginForm.fxml"));
        Scene scene= new Scene(root);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    void edditerProfil(ActionEvent event)throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("EditerProfile.fxml"));
         viewLuncherLoging.forWardNewTab(event, "EditerProfile.fxml", this.getClass());
        
    }

    @FXML
    void home(ActionEvent actionEvent) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene scene= new Scene(root);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    void notification(ActionEvent actionEvent) throws IOException{
         Parent root = FXMLLoader.load(getClass().getResource("Notification.fxml"));
        Scene scene= new Scene(root);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    void proposerTrajet(ActionEvent actionEvent)throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("ProposerTrajet.fxml"));
        Scene scene= new Scene(root);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    void tableauDeBord(ActionEvent actionEvent)throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("TableauDeBord.fxml"));
        Scene scene= new Scene(root);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
    
    
    @FXML
    void retour(ActionEvent actionEvent) throws IOException {
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
     

 

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

   

    public Label getAge() {
        return age;
    }

    public void setAge(Label age) {
        this.age = age;
    }

    public Label getEmail() {
        return email;
    }

    public void setEmail(Label email) {
        this.email = email;
    }

    public Label getCin() {
        return cin;
    }

    public void setCin(Label cin) {
        this.cin = cin;
    }

    public Label getFumeur() {
        return fumeur;
    }

    public void setFumeur(Label fumeur) {
        this.fumeur = fumeur;
    }

    public Label getTel() {
        return tel;
    }

    public void setTel(Label tel) {
        this.tel = tel;
    }


    
    
    
}
