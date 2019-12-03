package yunzhe.plugin.translate.helper;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import yunzhe.plugin.translate.baidu.TransApi;

/**
 * Author:  LiuHao
 * Email:   114650501@qq.com
 * TIME:    2019-12-01 --> 20:25
 * Description: BaiDuHelper 简述：提供百度翻译，在百度提供翻译的基础上提供一些方法
 */
public class BaiDuHelper {

    // 在平台申请的APP_ID 详见 http://api.fanyi.baidu.com/api/trans/product/desktop?req=developer

    static final String APP_ID = "";
    static final String SECURITY_KEY = "";

    public static void main(String[] args) {
        translate("hello world,今天天气很好啊", TranslateType.ZH);
    }

    /**
     * 翻译指定的文本
     *
     * @param query 要翻译的内容
     */
    public static String translate(String query, TranslateType type) {

        TransApi api = new TransApi(APP_ID, SECURITY_KEY);

        String result = api.getTransResult(
                query,
                TranslateType.AUTO.getLanguage(),
                type.getLanguage());

        result = parseJson(result);

        print(result);

        return result;
    }

    /**
     * 解析
     * @param json 从百度api中获取的翻译结果
     */
    public static String parseJson(String json) {
        print("翻译获取源数据:" + json);
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray trans_result = jsonObject.optJSONArray("trans_result");
            JSONObject firstResult = trans_result.optJSONObject(0);
            String result = firstResult.optString("dst");
            return result;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;

    }

    /**
     * 提供对应的语言翻译主类型
     */
    public enum TranslateType {
        EN("en"), ZH("zh"), AUTO("auto");
        String language;


        TranslateType(String en) {
            this.language = en;
        }

        public String getLanguage() {
            return language;
        }
    }

    static void print(String message) {
        System.out.println(message);
    }
}
