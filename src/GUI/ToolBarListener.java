package GUI;

import us.monoid.json.JSONException;

import java.io.IOException;

public interface ToolBarListener {
    void wraptext(boolean flag);
    void refreshText();
    void saveText() throws IOException;
    void saveAs() throws IOException, JSONException;
}
