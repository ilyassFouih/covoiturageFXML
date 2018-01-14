/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import bean.Conducteur;
import bean.Passager;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.util.List;
import javafx.scene.control.TableView;

public class PassagerFxHelper extends AbstractFxHelper<Passager>{
    private static AbstractFxHelperItem[] titres;

    static {

        titres = new AbstractFxHelperItem[]{
            new AbstractFxHelperItem("Utilisateur", "personne"),
           
        };
    }

    public PassagerFxHelper(TableView<Passager> table, List<Passager> list) {
        super(titres, table, list);
    }

    public PassagerFxHelper(TableView<Passager> table) {
        super(titres, table);
    }

}
