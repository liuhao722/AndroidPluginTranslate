package yunzhe.plugin.translate;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import org.apache.commons.lang.StringUtils;
import yunzhe.plugin.translate.helper.TranslateHelper;

/**
 * Author:  LiuHao
 * Email:   114650501@qq.com
 * TIME:    2019-12-01 --> 14:21
 * Description: TranslateAction 简述：翻译的action
 */
public class TranslateAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {

        final Editor mEditor = e.getData(PlatformDataKeys.EDITOR);

        SelectionModel selectionModel = mEditor.getSelectionModel();

        if (StringUtils.isEmpty(selectionModel.getSelectedText())) {    //  当选中的文字为空，或者不是双击选中了文字，仅仅是悬浮着鼠标
            selectionModel.selectWordAtCaret(true);                  //  设置光标浮动的文字为选中，从而选中文字
        }

        String query = selectionModel.getSelectedText();                //  获取的text内容

        TranslateHelper.translate(mEditor, query);
    }
}
