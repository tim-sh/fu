package fu.lang;

import com.intellij.lang.Language;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.LanguageSubstitutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class FuLanguageSubstitutor extends LanguageSubstitutor {
    @Override
    public @Nullable Language getLanguage(@NotNull VirtualFile virtualFile, @NotNull Project project) {
        if (virtualFile.getName().endsWith(".fu")) {
            return FuLanguage.INSTANCE;
        }
        return null;
    }
}
