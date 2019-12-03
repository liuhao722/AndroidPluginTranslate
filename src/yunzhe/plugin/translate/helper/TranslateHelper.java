package yunzhe.plugin.translate.helper;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.ui.popup.Balloon;
import com.intellij.openapi.ui.popup.JBPopupFactory;
import com.intellij.ui.JBColor;

import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Author:  LiuHao
 * Email:   114650501@qq.com
 * TIME:    2019-12-01 --> 20:01
 * Description: TranslateHelper 简述：翻译的一些辅助
 */
public class TranslateHelper {

    public static void main(String[] args) {
        boolean isContainChinese = isContainChinese(" ssz中s");
        System.out.println("是否包含中文：\t" + isContainChinese);
    }


    /**
     * 查询选中的文字进行中英文翻译
     */
    public static void translate(Editor mEditor, String query) {
        BaiDuHelper.TranslateType type = TranslateHelper.isContainChinese(query) ?
                BaiDuHelper.TranslateType.EN :
                BaiDuHelper.TranslateType.ZH;

        String translateResult = BaiDuHelper.translate(query, type);

        TranslateHelper.showDialog(mEditor, query + " ：" + translateResult, 5);
    }

    /**
     * 翻译弹窗
     */
    public static void showDialog(final Editor editor, final String result, final int fadeoutTime) {
        ApplicationManager.getApplication().invokeLater(() -> {
            JBPopupFactory factory = JBPopupFactory.getInstance();
            factory.createHtmlTextBalloonBuilder(result, null,
                    new JBColor(new Color(116, 214, 238),
                            new Color(76, 112, 117)), null)
                    .setFadeoutTime(fadeoutTime * 1000)
                    .createBalloon()
                    .show(factory.guessBestPopupLocation(editor), Balloon.Position.below);
        });
    }

    /**
     * @param title  来自demo演示
     * @param result 响应结果显示
     */
    public static void showMessage(String title, String result) {
        Messages.showInfoMessage(result, title);
    }


    /**
     * 判断字符串中是否包含中文
     *
     * @param str 待校验字符串
     * @return 是否为中文
     * @warn 不能校验是否为中文标点符号
     */
    public static boolean isContainChinese(String str) {
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }
}
