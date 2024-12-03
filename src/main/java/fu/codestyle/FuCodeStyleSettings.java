package fu.codestyle;

import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CustomCodeStyleSettings;

public class FuCodeStyleSettings extends CustomCodeStyleSettings {

    public boolean goo = true;
    public boolean hoo = false;

    public FuCodeStyleSettings(CodeStyleSettings settings) {
        super("FuCodeStyleSettings", settings);
    }

}
