package org.primary.sample.model.web.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.primary.sample.model.common.util.StringComUtils;

import java.io.File;
import java.io.IOException;

/**
 * json 参数加载.
 *
 * @author wangchuanqi
 * @since 2020/12/22
 * @since 0.0.1
 */
public class JsonParam {
    /**
     * 读取json参数
     *
     * @param path
     * @return
     */
    public static String readJsonParam(String path) {
        ObjectMapper objMapper = new ObjectMapper();
        try {
            // 获取文件路径
            String fileName =
                    JsonParam.class.getClassLoader().getResource(StringComUtils.append("param/", path)).getPath();
            JsonNode rootNode = objMapper.readTree(new File(fileName));
            return rootNode.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
