package actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.popup.Balloon;
import com.intellij.openapi.ui.popup.JBPopupFactory;
import com.intellij.ui.JBColor;
import com.intellij.ui.awt.RelativePoint;
import forms.Titles;
import forms.TranslatorForms;
import org.jetbrains.annotations.NotNull;
import translatorsAPI.GoogleScriptAPI;
import translatorsAPI.Languages;

import java.io.IOException;

public class InputPopup extends AnAction {

    private static final String TITLE = "";

    @Override
    public void actionPerformed(@NotNull AnActionEvent event) {
        final Editor editor = event.getRequiredData(CommonDataKeys.EDITOR);
        final String selectedText = editor.getSelectionModel().getSelectedText();
        final Project project = event.getRequiredData(CommonDataKeys.PROJECT);

        if (selectedText != null) {
            TranslatorForms.showDialogWithTwoInputs(Titles.SELECT).ifPresent(stringStringSimpleEntry ->
                    WriteCommandAction.runWriteCommandAction(project, () -> {
                        try {
                            final String result = new GoogleScriptAPI().translate(
                                    Languages.valueOf(stringStringSimpleEntry.getKey()).getTitle(),
                                    Languages.valueOf(stringStringSimpleEntry.getValue()).getTitle(),
                                    selectedText
                            );
                            final RelativePoint relPoint = JBPopupFactory.getInstance()
                                    .guessBestPopupLocation(editor.getSelectionModel().getEditor());
                            JBPopupFactory.getInstance().createHtmlTextBalloonBuilder(
                                    result, null, JBColor.LIGHT_GRAY, null
                            )
                                    .createBalloon()
                                    .show(relPoint, Balloon.Position.below);
                        } catch (IOException e) {
                            TranslatorForms.showTranslateErrorMessage();
                        }
                    }));
        } else {
            TranslatorForms.showNoSelectedMessage();
        }
    }
}

