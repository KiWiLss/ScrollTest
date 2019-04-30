package com.kiwilss.lxkj.fourassembly.http;

import java.util.Map;

/**
 * @author : Lss kiwilss
 * @FileName: IEncrypt
 * @e-mail : kiwilss@163.com
 * @time : 2019-04-30
 * @desc : {DESCRIPTION}
 */
public interface IEncrypt {
    public String encrypt(String src, Map<String, Object> params);
    public String dencrypt(String src);
}
