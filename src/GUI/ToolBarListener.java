package GUI;

import java.io.IOException;

public interface ToolBarListener {
    void wraptext(boolean flag);

    void refreshText();

    void saveText() throws IOException;
}
