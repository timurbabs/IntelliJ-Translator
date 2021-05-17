package actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Caret;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import org.jetbrains.annotations.NotNull;
import translatorsAPI.GoogleScriptAPI;

import java.io.IOException;

public class SelectedTextAction extends AnAction {

    private static final String TITLE = "Translator";

    @Override
    public void actionPerformed(@NotNull AnActionEvent event) {

        Editor editor = event.getRequiredData(CommonDataKeys.EDITOR);
        String selectedText = editor.getSelectionModel().getSelectedText();
        Project project = event.getRequiredData(CommonDataKeys.PROJECT);
        Document document = editor.getDocument();
        Caret primaryCaret = editor.getCaretModel().getPrimaryCaret();


        WriteCommandAction.runWriteCommandAction(project, () -> {
                    try {
                        document.replaceString(
                                primaryCaret.getSelectionStart(), primaryCaret.getSelectionEnd(),
                                new GoogleScriptAPI().translate("ru", "en", selectedText));
                    } catch (IOException e) {
                        Messages.showMessageDialog("Failed to translate", TITLE, Messages.getErrorIcon());
                    }
                }
        );

        primaryCaret.removeSelection();
    }
}