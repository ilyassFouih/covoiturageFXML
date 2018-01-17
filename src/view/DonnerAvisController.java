/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.Avis;
import bean.Personne;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextArea;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.management.Notification;
import org.controlsfx.control.Notifications;
import service.AvisService;
import util.Session;

/**
 * FXML Controller class
 *
 * @author IlyassElfouih
 */
public class DonnerAvisController implements Initializable {
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Personne personne = (Personne) Session.getAttribut("personne Selectionner");
        nom.setText(personne.getNom()+" "+personne.getPrenom() );
        prenom.setText("");
        age.setText(String.valueOf(personne.getAge()));
        tel.setText(String.valueOf(personne.getTel()));
        
    }    
    
    @FXML
    private JFXCheckBox parfait;

    @FXML
    private JFXCheckBox bien;

    @FXML
    private JFXCheckBox tresBien;

    @FXML
    private JFXCheckBox aEviter;

    @FXML
    private JFXTextArea commentaire;

    @FXML
    private Label nom;
    @FXML
    private Label error;
    
    @FXML
    private Label tel;

    @FXML
    private Label prenom;

    @FXML
    private Label age;

    @FXML
    void ajouterAvis(ActionEvent actionEvent) {
       // Image image = new Image("valider.png");
       Avis avis = new Avis();
       Personne personne = (Personne) Session.getAttribut("personne Selectionner");
       avis.setPersonne(personne);
       int var =0;
       
       if(parfait.isSelected() )
       {
           avis.setAvis(4);
           var++;
       }
        if(bien.isSelected())
       {
           avis.setAvis(2);
            var++;
       }
        if(tresBien.isSelected())
       {
           avis.setAvis(3);
            var++;
       }
       if(aEviter.isSelected())
       {
           avis.setAvis(1);
            var++;
       }
       if(var==1){
           error.setText("");
           error.getStyle();
           AvisService avisService = new AvisService();
           avisService.createAvis(avis);
       Notifications notifications = Notifications.create()
                 .title("avis ajouter")
                 .text("vous avez choisit "+avisService.getAvis(avis.getAvis()))
                 .graphic(null)
                 .hideAfter(Duration.seconds(5))
                 .position(Pos.TOP_LEFT);
                notifications.darkStyle();   
                notifications.showConfirm();
                 }
       else {
           error.setText("*veuillier caucher une seule case ");
       }
       
    }

    @FXML
    void ajouterCommentaire(ActionEvent event) {

    }
    @FXML
    void retour(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("TableauDeBord.fxml"));
        Scene scene= new Scene(root);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}
