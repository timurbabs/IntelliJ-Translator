package actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Caret;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import forms.TranslatorForm;
import org.jetbrains.annotations.NotNull;
import translatorsAPI.GoogleScriptAPI;
import translatorsAPI.Languages;

import java.io.IOException;

public class InputReplaceSelectedText extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent event) {
        final Editor editor = event.getRequiredData(CommonDataKeys.EDITOR);
        final String selectedText = editor.getSelectionModel().getSelectedText();
        final Project project = event.getRequiredData(CommonDataKeys.PROJECT);
        final Document document = editor.getDocument();
        final Caret primaryCaret = editor.getCaretModel().getPrimaryCaret();
        if (selectedText != null) {
            TranslatorForm.showDialogWithTwoInputs().ifPresent(stringStringSimpleEntry ->
                    WriteCommandAction.runWriteCommandAction(project, () -> {
                        try {
                            document.replaceString(
                                    primaryCaret.getSelectionStart(), primaryCaret.getSelectionEnd(),
                                    new GoogleScriptAPI().translate(
                                            Languages.valueOf(stringStringSimpleEntry.getKey()).getTitle(),
                                            Languages.valueOf(stringStringSimpleEntry.getValue()).getTitle(),
                                            selectedText
                                    )
                            );
                        } catch (IOException e) {
                            TranslatorForm.showTranslateErrorMessage();
                        }
                    }));
            primaryCaret.removeSelection();
        } else {
            TranslatorForm.showNoSelectedMessage();
        }
    }
}
