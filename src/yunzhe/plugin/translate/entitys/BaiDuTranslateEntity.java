package yunzhe.plugin.translate.entitys;

import java.io.Serializable;
import java.util.List;

public class BaiDuTranslateEntity implements Serializable {
    public List<TransResult> trans_result;

    public static class TransResult implements Serializable {
        public String dst;//翻译的内容

    }
}
