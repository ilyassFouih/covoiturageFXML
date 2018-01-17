/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import bean.Notification;
import java.util.List;
import javafx.scene.control.TableView;

public class NotificationFxHelper extends AbstractFxHelper<Notification>{
    private static AbstractFxHelperItem[] titres;

    static {

        titres = new AbstractFxHelperItem[]{
            new AbstractFxHelperItem("VOYAGE", "voyage"),
            
        };
    }

    public NotificationFxHelper(TableView<Notification> table, List<Notification> list) {
        super(titres, table, list);
    }

    public NotificationFxHelper(TableView<Notification> table) {
        super(titres, table);
    }

}
