package forms;

public enum Titles {

    DEFAULT("Select default languages"),
    SELECT("Select languages");

    private final String title;

    Titles(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
