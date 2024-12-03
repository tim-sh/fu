package fu.lang;

public class FuLanguage extends com.intellij.lang.Language {

    public static final FuLanguage INSTANCE = new FuLanguage();

    public static final String LABEL = "fu";

    private FuLanguage() {
        super(LABEL);
    }
}