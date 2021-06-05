package translators;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.stream.Collectors;

public class GoogleScriptAPI implements Translator {

    @Override
    public String translate(String langFrom, String langTo, String text) throws IOException {
        final Map<String, String> env = System.getenv();
        final String urlStr = env.get("URL") +
                "?q=" + URLEncoder.encode(text, StandardCharsets.UTF_8) +
                "&target=" + langTo +
                "&source=" + langFrom;
        final URL url = new URL(urlStr);
        final HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("User-Agent", "Mozilla/8.0");
        final BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8));
        String translated = (in.lines().collect(Collectors.joining("\n")));
        in.close();
        return translated;
    }
}