package quarter1.javaCoreAdvancedLevel.lesson04.chat;
import javafx.scene.image.ImageView;

import java.util.HashMap;
import java.util.Map;



public class IcoSmiley {
    private static Map<String,String> ico = new HashMap<>();
    public IcoSmiley() {
        init();
    }

    private void init(){
        ico.put("friendSmiley","quarter1\\javaCoreAdvancedLevel\\lesson04\\chat\\ico\\friendSmiley.png");
    }

    public ImageView getIco(String id) {
        return new ImageView(ico.get(id));
    }


}
