package actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.components.ServiceManager;
import forms.TranslatorForms;
import org.jetbrains.annotations.NotNull;
import properties.ApplicationService;

public class LanguageSelection extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        TranslatorForms.showDialogWithTwoInputs().ifPresent(stringStringSimpleEntry -> {
            var state = new ApplicationService.State();
            state.setLangFrom(stringStringSimpleEntry.getKey());
            state.setLangTo(stringStringSimpleEntry.getValue());
            ServiceManager.getService(ApplicationService.class).loadState(state);
        });
    }
}
