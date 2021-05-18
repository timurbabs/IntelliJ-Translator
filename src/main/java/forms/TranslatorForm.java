package forms;

import com.intellij.openapi.ui.ComboBox;
import translatorsAPI.Languages;

import javax.swing.*;
import java.util.AbstractMap;
import java.util.Objects;
import java.util.Optional;

public class TranslatorForm {

    private static final String TITLE = "Translator";

    public Optional<AbstractMap.SimpleEntry<String, String>> showDialogWithTwoInputs() {
        String[] languages = Languages.names();
        ComboBox<String> from = new ComboBox<>(languages);
        ComboBox<String> to = new ComboBox<>(languages);
        JPanel myPanel = new JPanel();

        myPanel.add(new JLabel("from:"));
        myPanel.add(from);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("to:"));
        myPanel.add(to);

        if (JOptionPane.showConfirmDialog(null, myPanel,
                TITLE, JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            String langFrom = Objects.requireNonNull(from.getSelectedItem()).toString();
            String langTo = Objects.requireNonNull(to.getSelectedItem()).toString();
            return Optional.of(new AbstractMap.SimpleEntry<>(langFrom, langTo));
        } else {
            return Optional.empty();
        }
    }
}

