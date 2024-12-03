package fu.codestyle;

import com.intellij.application.options.codeStyle.OptionTreeWithPreviewPanel;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.LanguageCodeStyleSettingsProvider;
import fu.FuFileType;
import fu.lang.FuLanguage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class FuCodeStyleAlignmentPanel extends OptionTreeWithPreviewPanel {

    public FuCodeStyleAlignmentPanel(CodeStyleSettings settings) {
        super(settings);
        init();
    }

    @Override
    protected void initTables() {
        this.initCustomOptions("Some…");
        this.initCustomOptions("A completely…");
    }

    @Override
    public LanguageCodeStyleSettingsProvider.SettingsType getSettingsType() {
        return LanguageCodeStyleSettingsProvider.SettingsType.LANGUAGE_SPECIFIC;
    }

    @Override
    protected @NotNull FileType getFileType() {
        return FuFileType.INSTANCE;
    }

    @Override
    public com.intellij.lang.@Nullable Language getDefaultLanguage() {
        return FuLanguage.INSTANCE;
    }

    @Override
    protected String getPreviewText() {
        return "fun fu";
    }

}
