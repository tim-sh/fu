package fu;

import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.util.NlsContexts;
import com.intellij.openapi.util.NlsSafe;
import fu.lang.FuLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.plugins.textmate.TextMateBackedFileType;

import javax.swing.*;

public final class FuFileType extends LanguageFileType implements TextMateBackedFileType {

    public static final FuFileType INSTANCE = new FuFileType();
    public static final String EXTENSION = "fu";

    private FuFileType() {
        super(FuLanguage.INSTANCE);
    }

    @Override
    public @NonNls @NotNull String getName() {
        return "fu";
    }

    @Override
    public @NlsContexts.Label @NotNull String getDescription() {
        return "Fu file";
    }

    @Override
    public @NlsSafe @NotNull String getDefaultExtension() {
        return EXTENSION;
    }

    @Override
    public Icon getIcon() {
        return null;
    }
}
