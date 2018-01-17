/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import bean.Personne;
import java.util.List;
import javafx.scene.control.TableView;

public class PersonneFxHelper extends AbstractFxHelper<Personne>{
    private static AbstractFxHelperItem[] titres;

    static {

        titres = new AbstractFxHelperItem[]{
            new AbstractFxHelperItem("Nom", "nom"),
            new AbstractFxHelperItem("Prenom", "prenom"),
            new AbstractFxHelperItem("Email", "email"),
            new AbstractFxHelperItem("Age", "age"),
            new AbstractFxHelperItem("Tel", "tel"),
           
        };
    }

    public PersonneFxHelper(TableView<Personne> table, List<Personne> list) {
        super(titres, table, list);
    }

    public PersonneFxHelper(TableView<Personne> table) {
        super(titres, table);
    }

}
