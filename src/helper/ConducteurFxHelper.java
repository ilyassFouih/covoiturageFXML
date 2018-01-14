/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import bean.Conducteur;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.util.List;
import javafx.scene.control.TableView;

public class ConducteurFxHelper extends AbstractFxHelper<Conducteur>{
    private static AbstractFxHelperItem[] titres;

    static {

        titres = new AbstractFxHelperItem[]{
            new AbstractFxHelperItem("Voyage", "voyage"),
            new AbstractFxHelperItem("Prix", "prix"),
            new AbstractFxHelperItem("Voiture", "typeVoiture"),
        };
    }

    public ConducteurFxHelper(TableView<Conducteur> table, List<Conducteur> list) {
        super(titres, table, list);
    }

    public ConducteurFxHelper(TableView<Conducteur> table) {
        super(titres, table);
    }


}
