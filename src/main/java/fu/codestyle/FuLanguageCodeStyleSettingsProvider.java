package fu.codestyle;

import com.intellij.application.options.CodeStyleAbstractConfigurable;
import com.intellij.application.options.CodeStyleAbstractPanel;
import com.intellij.psi.codeStyle.*;
import fu.lang.FuLanguage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class FuLanguageCodeStyleSettingsProvider extends LanguageCodeStyleSettingsProvider {

    @Override
    public CustomCodeStyleSettings createCustomSettings(CodeStyleSettings settings) {
        return new FuCodeStyleSettings(settings);
    }

    @Override
    public String getConfigurableDisplayName() {
        return "Fu";
    }

    @Override
    public @Nullable String getCodeSample(@NotNull SettingsType settingsType) {
        return "fun fu";
    }

    @Override
    public @NotNull FuLanguage getLanguage() {
        return FuLanguage.INSTANCE;
    }

    @Override
    public @NotNull CodeStyleConfigurable createConfigurable(@NotNull CodeStyleSettings settings, @NotNull CodeStyleSettings cloneSettings) {
        return new FuCodeStyleConfigurable(settings, cloneSettings);
    }

    @Override
    public void customizeSettings(@NotNull CodeStyleSettingsCustomizable consumer, @NotNull SettingsType settingsType) {
        if (consumer instanceof FuCodeStyleAlignmentPanel) {
            consumer.showCustomOption(FuCodeStyleSettings.class, "goo", "… fu setting", "Some…");
            consumer.showCustomOption(FuCodeStyleSettings.class, "hoo", "… different fu setting", "A completely…");
        }
    }

    private class FuCodeStyleConfigurable extends CodeStyleAbstractConfigurable {
        public FuCodeStyleConfigurable(@NotNull CodeStyleSettings settings, @NotNull CodeStyleSettings cloneSettings) {
            super(settings, cloneSettings, FuLanguage.INSTANCE.getDisplayName());
        }

        @Override
        protected @NotNull CodeStyleAbstractPanel createPanel(final @NotNull CodeStyleSettings settings) {
            return new FuCodeStyleMainPanel(getCurrentSettings(), settings);
        }
    }
}