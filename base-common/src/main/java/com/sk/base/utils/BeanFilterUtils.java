package com.sk.base.utils;

import java.lang.reflect.Field;
import java.util.*;

/**
 * 对象属性过滤器
 */
public class BeanFilterUtils {

    private BeanFilterUtils() {
    }

    /**
     * 仅仅显示某些属性
     *
     * @param obj
     * @param properties
     * @return
     */
    public static Map<String, Object> onlyShowProperties(Object obj, String... properties) {
        Set<String> names = new HashSet<>(Arrays.asList(properties));
        Map<String, Object> map = new LinkedHashMap<>();
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (!names.contains(field.getName())) {
                continue;
            }
            field.setAccessible(true);
            try {
                map.put(field.getName(), field.get(obj));
            } catch (Exception e) {
            }
        }

        return map;
    }

    /**
     * 仅仅显示某些属性
     *
     * @param obj
     * @param properties
     * @return
     */
    public static Map<String, Object> onlyHideProperties(Object obj, String... properties) {
        Set<String> names = new HashSet<>(Arrays.asList(properties));
        Map<String, Object> map = new LinkedHashMap<>();
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (names.contains(field.getName())) {
                continue;
            }
            field.setAccessible(true);
            try {
                map.put(field.getName(), field.get(obj));
            } catch (Exception e) {
            }
        }
        return map;
    }
}
