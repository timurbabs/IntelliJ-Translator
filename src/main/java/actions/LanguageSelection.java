package actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.components.ServiceManager;
import forms.TranslatorForms;
import org.jetbrains.annotations.NotNull;
import properties.AppSettingsState;

public class LanguageSelection extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        TranslatorForms.showDialogWithTwoInputs().ifPresent(stringStringSimpleEntry -> {

        });
    }
}
