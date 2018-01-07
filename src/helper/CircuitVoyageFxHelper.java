/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import bean.CircuitVoyage;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.util.List;
import javafx.scene.control.TableView;

public class CircuitVoyageFxHelper extends AbstractFxHelper<CircuitVoyage>{
    private static AbstractFxHelperItem[] titres;

    static {

        titres = new AbstractFxHelperItem[]{
            new AbstractFxHelperItem("ORDRE", "num"),
            new AbstractFxHelperItem("PRIX", "prix"),
            new AbstractFxHelperItem("VILLE DE DEPART", "villeDep"),
            new AbstractFxHelperItem("VILLEARR D'ARRIVER", "villeArr"),
        };
    }

    public CircuitVoyageFxHelper(TableView<CircuitVoyage> table, List<CircuitVoyage> list) {
        super(titres, table, list);
    }

    public CircuitVoyageFxHelper(TableView<CircuitVoyage> table) {
        super(titres, table);
    }

}
