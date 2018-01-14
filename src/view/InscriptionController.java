/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.Personne;
import java.net.URL;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import service.PersonneService;

/**
 * FXML Controller class
 *
 * @author Mouhad Essabbane
 */
public class InscriptionController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private JFXTextField email;

    @FXML
    private JFXTextField nom;

    @FXML
    private JFXTextField prenom;

    @FXML
    private JFXTextField age;

    @FXML
    private JFXTextField tel;

    @FXML
    private JFXTextField cin;

    @FXML
    private JFXCheckBox oui;

    @FXML
    private JFXCheckBox non;

    @FXML
    private JFXPasswordField mdp;

    @FXML
    private JFXPasswordField mdpret;

    @FXML
    private Label msgEr;

    @FXML
    public void inscription(ActionEvent actionEvent) throws IOException {
        if (!mdp.getText().equals(mdpret.getText())) {
            msgEr.setText("*mot de passe retaper incorecte*");
            mdpret.setStyle("-fx-background-color : red;");

        } else {
            Personne p = new Personne();
            p.setEmail(email.getText());
            p.setNom(nom.getText());
            p.setPrenom(prenom.getText());
            p.setAge(Integer.valueOf(age.getText()));
            p.setCin(cin.getText());
            if (oui.isSelected()) {
                p.setFumeur(true);
            } else if (non.isSelected()) {
                p.setFumeur(false);
            }
            p.setPassword(mdp.getText());

            PersonneService personneService = new PersonneService();

            int res = personneService.sinscrire(p);

            if (res == 1) {
                Parent root = FXMLLoader.load(getClass().getResource("loginForm.fxml"));
                Scene scene = new Scene(root);
                Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();

            }

        }

    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final InscriptionController other = (InscriptionController) obj;
        if (!Objects.equals(this.mdp, other.mdp)) {
            return false;
        }
        if (!Objects.equals(this.mdpret, other.mdpret)) {
            return false;
        }
        return true;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
