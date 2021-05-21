package properties;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

@State(name = "properties", storages = {@Storage("properties.xml")})
public class ApplicationService implements PersistentStateComponent<ApplicationService.State> {

    public static class State {

        public String getLangFrom() {
            return langFrom;
        }

        public void setLangFrom(String langFrom) {
            this.langFrom = langFrom;
        }

        public String getLangTo() {
            return langTo;
        }

        public void setLangTo(String langTo) {
            this.langTo = langTo;
        }

        public String langFrom;
        public String langTo;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof State)) return false;
            State state = (State) o;
            if (!Objects.equals(langFrom, state.langFrom)) return false;
            return Objects.equals(langTo, state.langTo);
        }
    }

    private State myState = new State();

    public State getState() {
        return myState;
    }

    public void loadState(@NotNull State state) {
        myState = state;
    }
}