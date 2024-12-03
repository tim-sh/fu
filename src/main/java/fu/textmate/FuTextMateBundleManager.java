package fu.textmate;


import com.intellij.ide.AppLifecycleListener;
import com.intellij.ide.plugins.DynamicPluginListener;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.startup.ProjectActivity;
import com.intellij.openapi.startup.StartupActivity;
import com.intellij.util.PathUtil;
import fu.lang.FuLanguage;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.plugins.textmate.TextMateServiceImpl;
import org.jetbrains.plugins.textmate.configuration.TextMateUserBundlesSettings;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FuTextMateBundleManager implements AppLifecycleListener, StartupActivity, ProjectActivity, DynamicPluginListener {

    public static final FuTextMateBundleManager INSTANCE = new FuTextMateBundleManager();

    private volatile Boolean isBundleRegistered = false;

    @NotNull
    private static TextMateUserBundlesSettings getBundlesSettings() {
        TextMateUserBundlesSettings settings = TextMateUserBundlesSettings.getInstance();
        assert settings != null;
        return settings;
    }

    @NotNull
    private static String getBundlePath() {
        Path thisPath = Paths.get(PathUtil.getJarPathForClass(FuTextMateBundleManager.class));
        return thisPath
                .getParent()
                .resolve(FuTextMateBundle.RELATIVE_PATH)
                .toString();
    }

    public void registerBundle() {
        if (isBundleRegistered) {
            return;
        }
        isBundleRegistered = true;

        TextMateUserBundlesSettings settings = getBundlesSettings();
        settings.addBundle(getBundlePath(), FuLanguage.LABEL); // Will also update existing bundle.
        TextMateServiceImpl.getInstance().reloadEnabledBundles();
    }

    @Override
    public void appFrameCreated(@NotNull List<String> commandLineArgs) {
        registerBundle();
    }

    @Override
    public void runActivity(@NotNull Project project) {
        registerBundle();
    }

    @Nullable
    @Override
    public Object execute(@NotNull Project project, @NotNull Continuation<? super Unit> continuation) {
        registerBundle();
        return null;
    }
}
