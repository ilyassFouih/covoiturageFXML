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
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
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
import service.VoyageService;
import util.DateUtil;
import util.Session;

/**
 * FXML Controller class
 *
 * @author IlyassElfouih
 */
public class ProposerTrajetController implements Initializable {
    
    @FXML
    private Label notLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        VilleService villeService = new VilleService();
        List<Ville> villes = villeService.getAllvilles();
            villeDepart.setItems(FXCollections.observableArrayList(villes));
            villeArriver.setItems(FXCollections.observableArrayList(villes));
               
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
    private JFXComboBox<Ville> villeDepart;

    @FXML
    private JFXComboBox<Ville> villeArriver;

    @FXML
    private JFXDatePicker dateDepart;

    @FXML
    private JFXTextField nbrPlaceMax;

    @FXML
    private JFXTextField prix;
    @FXML
    private JFXTextField typeVoiture;
    
    VilleService villeService = new VilleService();

    @FXML
    public Voyage getVoyage() {
        Ville villedep = villeService.find(villeDepart.getValue().getId());
        Ville villearr = villeService.find(villeArriver.getValue().getId());
        Date date = DateUtil.convert(dateDepart.getValue().toString());
        // System.out.println(date);
        Voyage voyage = new Voyage(villedep, villearr, date);
        return voyage;
    }

    @FXML
    public Conducteur getConducteur() {

        Conducteur conducteur = new Conducteur();
        conducteur.setNbrPlaceMax(new Integer(nbrPlaceMax.getText()));
        conducteur.setPrix(new Double(prix.getText()));
        conducteur.setTypeVoiture(typeVoiture.getText());
//      conducteur.setPersonne(new Personne(((Personne) Session.getAttribut("utilisateur connecter ")).getEmail()));

        return conducteur;
    }

    @FXML
    void suivant(ActionEvent actionEvent) throws IOException {
//        ConducteurService instance = new ConducteurService();
//      VoyageService voyageService = new VoyageService();
        Voyage voyage = getVoyage();
        Conducteur conducteur = getConducteur();

//        ---------------------------creation BD---------------------------------------------------
//       instance.proposerTrajet((((Personne) Session.getAttribut("utilisateur connecter ")).getEmail()), voyage, conducteur);
        
//        --------------------session update--------------------------------------------
//            VoyageService voyageService = new VoyageService();
//            voyage.setId(voyageService.generateId("Voyage", "id"));
//            System.out.println(voyage);
//            voyageService.create(voyage);
            Session.updateAttribute(voyage, "voyage");
            Session.updateAttribute(conducteur, "conducteur");
            
            
            
//         -----------------------passer au page suivante------------------------------
            Parent root = FXMLLoader.load(getClass().getResource("ChoixVilleCircuit.fxml"));
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

    public JFXComboBox<?> getVilleDepart() {
        return villeDepart;
    }

    public void setVilleDepart(JFXComboBox<Ville> villeDepart) {
        this.villeDepart = villeDepart;
    }

    public JFXComboBox<?> getVilleArriver() {
        return villeArriver;
    }

    public void setVilleArriver(JFXComboBox<Ville> villeArriver) {
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
