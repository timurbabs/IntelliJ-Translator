package translatorsAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class GoogleScriptAPI implements Translator {
    @Override
    public String translate(String langFrom, String langTo, String text) throws IOException {
        final String urlStr = "https://script.google.com/macros/s/AKfycbyr8KmE_zJCBSUFTQzHSbmvUOnhjrE2yQyBlUuA27-n9YdB_SsU_NLLRw5sImlPmk65/exec" +
                "?q=" + URLEncoder.encode(text, StandardCharsets.UTF_8) +
                "&target=" + langTo +
                "&source=" + langFrom;
        final URL url = new URL(urlStr);
        final StringBuilder response = new StringBuilder();
        final HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        final BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String translated = in.lines().map(line -> {
            if (line.contains("&#39;")) {
                line = line.replace("&#39;", "'");
            }
            return line;
        }).collect(Collectors.joining());
        in.close();
        return translated;
    }
}
