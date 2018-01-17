/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.MouseEvent;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author IlyassElfouih
 */
public class ViewLuncherLoging extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("loginForm.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("votre application de covoiturage");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("icons.png")));
        stage.setScene(scene);
        stage.show();

    }

    public static void forward(ActionEvent actionEvent, String pageName, Class myClass) throws IOException {
        Parent parent = FXMLLoader.load(myClass.getResource(pageName));
        Scene scene = new Scene(parent);
        Stage app_stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(scene);
        app_stage.show();
    }

    public static void forWardNewTab(Event actionEvent, String pageName, Class myClass) throws IOException {
        Parent chefEmpDEp_page_parent = FXMLLoader.load(myClass.getResource(pageName));
        Scene chefEmpDEp_page_scene = new Scene(chefEmpDEp_page_parent);
//        Stage app_stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
//        app_stage.setScene(chefEmpDEp_page_scene);
//        app_stage.show();

        Stage stage = new Stage();
        stage.setScene(chefEmpDEp_page_scene);
        stage.show();
    }

    public static void forWardMouse(Event event, String pageName, Class myClass) throws IOException {
        Parent chefEmpDEp_page_parent = FXMLLoader.load(myClass.getResource(pageName));
        Scene chefEmpDEp_page_scene = new Scene(chefEmpDEp_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(chefEmpDEp_page_scene);
        app_stage.show();
    }

    public static void forWardMousePrecedentTab(Event mouseEvent, String pageName, Class myClass) throws IOException {
        Parent chefEmpDEp_page_parent = FXMLLoader.load(myClass.getResource(pageName));
        Stage app_stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        app_stage.hide();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
