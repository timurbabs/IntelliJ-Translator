package TranslatorsAPI;

import java.io.IOException;
import java.net.MalformedURLException;

public interface Translator {
    String translate(String langFrom, String langTo, String text) throws IOException;
}
