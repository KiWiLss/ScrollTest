package com.kiwilss.lxkj.fourassembly.utils;

import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.kiwilss.lxkj.fourassembly.http.IEncrypt;

import java.net.URLEncoder;
import java.util.Map;
import java.util.Set;

public class Utils {
    public static float dpToPixel(float dp) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        return dp * metrics.density;
    }

    private static String buildGetUrl(String urlPath, Map<String, Object> params, IEncrypt encrypt) {
        if (TextUtils.isEmpty(urlPath) || params == null || params.size() == 0) {
            return urlPath;
        }
        if (!urlPath.endsWith("?")) {
            urlPath += "?";
        }

        String paramsStr = buildGetParams(params);
        if (encrypt != null) {
            paramsStr = (String) encrypt.encrypt(urlPath, params);

        }

        StringBuilder sbUrl = new StringBuilder(urlPath);
        sbUrl.append(paramsStr);
        return sbUrl.toString();
    }

    private static String buildGetParams(Map<String, Object> params) {
        StringBuilder sb = new StringBuilder();
        Set<String> keys = params.keySet();
        for (String key : keys) {
            if (params.get(key) == null) {
                continue;
            }
            sb = sb.append(key + "=" + URLEncoder.encode(params.get(key).toString()) + "&");
        }

        String paramsStr = sb.substring(0, sb.length() - 1).toString();
        return paramsStr;
    }


}
