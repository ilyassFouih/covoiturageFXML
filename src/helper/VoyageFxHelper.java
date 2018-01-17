/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import bean.Voyage;
import java.util.List;
import javafx.scene.control.TableView;

public class VoyageFxHelper extends AbstractFxHelper<Voyage>{
    private static AbstractFxHelperItem[] titres;

    static {

        titres = new AbstractFxHelperItem[]{
            new AbstractFxHelperItem("LA DATE", "dateVoyage"),
            new AbstractFxHelperItem("VILLE DE DEPART", "villeDepart"),
            new AbstractFxHelperItem("VILLEARR D'ARRIVER", "villeArriver"),
        };
    }

    public VoyageFxHelper(TableView<Voyage> table, List<Voyage> list) {
        super(titres, table, list);
    }

    public VoyageFxHelper(TableView<Voyage> table) {
        super(titres, table);
    }

}
