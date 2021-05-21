package actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.editor.Caret;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import forms.TranslatorForms;
import org.jetbrains.annotations.NotNull;
import properties.ApplicationService;
import translatorsAPI.GoogleScriptAPI;
import translatorsAPI.Languages;

import java.io.IOException;
import java.util.Objects;

public class Popup extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent event) {
        final Editor editor = event.getRequiredData(CommonDataKeys.EDITOR);
        final String selectedText = editor.getSelectionModel().getSelectedText();
        final Project project = event.getRequiredData(CommonDataKeys.PROJECT);
        final Document document = editor.getDocument();
        final Caret primaryCaret = editor.getCaretModel().getPrimaryCaret();

        if (selectedText != null) {
            TranslatorForms.showDialogWithTwoInputs().ifPresent(stringStringSimpleEntry ->
                    WriteCommandAction.runWriteCommandAction(project, () -> {
                        try {
                            document.replaceString(
                                    primaryCaret.getSelectionStart(), primaryCaret.getSelectionEnd(),
                                    new GoogleScriptAPI().translate(
                                            Languages.valueOf(Objects.requireNonNull(ServiceManager.getService(ApplicationService.class).getState()).getLangFrom()).getTitle(),
                                            Languages.valueOf(Objects.requireNonNull(ServiceManager.getService(ApplicationService.class).getState()).getLangTo()).getTitle(),
                                            selectedText
                                    )
                            );
                        } catch (IOException e) {
                            TranslatorForms.showTranslateErrorMessage();
                        }
                    }));
            primaryCaret.removeSelection();
        } else {
            TranslatorForms.showNoSelectedMessage();
        }
    }
}
