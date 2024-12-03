package fu.codestyle;

import com.intellij.application.options.TabbedLanguageCodeStylePanel;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import fu.lang.FuLanguage;
import org.jetbrains.annotations.NotNull;

public class FuCodeStyleMainPanel extends TabbedLanguageCodeStylePanel {

    protected FuCodeStyleMainPanel(CodeStyleSettings currentSettings, @NotNull CodeStyleSettings settings) {
        super(FuLanguage.INSTANCE, currentSettings, settings);
    }

    @Override
    protected void initTabs(CodeStyleSettings settings) {
        addTab(new FuCodeStyleAlignmentPanel(settings));
    }

}
