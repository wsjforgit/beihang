package com.sk.base.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * 模板引擎用于生成字符串使用
 */
public class TemplateEngine {
    private static org.slf4j.Logger log = LoggerFactory.getLogger(TemplateEngine.class);

    public static String generate(String template, Map<String, String> context) {
        if (StringUtils.isBlank(template) || context == null) {
            return null;
        }
        for (Map.Entry<String, String> entry : context.entrySet()) {
            template = template.replace("#{" + entry.getKey() + "}", entry.getValue()
                    .replace("#{", "").replace("}", ""));
        }
        return template;
    }


    public static String generate(String template, Object object) {

        if (StringUtils.isBlank(template) || object == null) {
            return null;
        }


        Field[] declaredFields = object.getClass().getDeclaredFields();

        for (Field field : declaredFields) {
            field.setAccessible(true);
            try {
                Object value = field.get(object);
                if (value != null) {
                    template = template.replace("#{" + field.getName() + "}", value.toString()
                            .replace("#{", "").replace("}", ""));

                }
            } catch (IllegalAccessException e) {
                log.debug(e.getMessage());
            }
        }
        template = template.replaceAll("#\\{.+?\\}", "");

        return template;
    }
}
