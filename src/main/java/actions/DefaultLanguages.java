package actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.project.Project;
import forms.Titles;
import forms.TranslatorForms;
import org.jetbrains.annotations.NotNull;
import properties.AppSettingsState;

public class DefaultLanguages extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent event) {
        final Project project = event.getRequiredData(CommonDataKeys.PROJECT);
        TranslatorForms.showDialogWithTwoInputs(Titles.DEFAULT).ifPresent(stringStringSimpleEntry ->
                WriteCommandAction.runWriteCommandAction(project, () -> {
                    final AppSettingsState settings = AppSettingsState.getInstance();
                    settings.languageFrom = stringStringSimpleEntry.getKey();
                    settings.languageTo = stringStringSimpleEntry.getValue();
                })
        );
    }
}