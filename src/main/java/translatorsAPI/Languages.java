package translatorsAPI;

import java.util.Arrays;

public enum Languages {
    English ("en"),
    German ("de"),
    Russian ("ru"),
    French ("fr"),
    Korean ("ko"),
    Chinese_simplified ("zh"),
    Chinese_traditional ("zh-TW"),
    Czech ("cs"),
    Italian ("it"),
    Japanese ("ja");

    private final String title;

    Languages(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public static String[] names() {
        return Arrays.toString(Languages.values())
                .replaceAll("^.|.$", "")
                .replaceAll("_", " ").split(", ");
    }
}
