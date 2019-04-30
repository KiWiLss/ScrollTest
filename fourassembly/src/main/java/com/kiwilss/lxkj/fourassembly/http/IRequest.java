package com.kiwilss.lxkj.fourassembly.http;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Lss kiwilss
 * @FileName: IRequest
 * @e-mail : kiwilss@163.com
 * @time : 2019-04-30
 * @desc : {DESCRIPTION}
 */
public interface IRequest {
    public String getBaseUrl();
    public String getMethod();
    public IEncrypt getEncrypt();
    public HashMap<String, Object> getParam();
    public Map<String, FilePair> getFilePair();
    public Map<String, String> getHeaders();
}
