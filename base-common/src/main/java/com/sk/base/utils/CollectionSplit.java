package com.sk.base.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WangYa on 2016/8/13.
 */
public class CollectionSplit {


    public static <T> List<List<T>> split(List<T> list, int length) {
        List<List<T>> ls = new ArrayList<>();
        if (list.size() <= length) {
            ls.add(list);
            return ls;
        }
        for (int i = 0; i < (list.size() + length - 1) / length; i++) {
            if (i * length + length >= list.size()) {
                ls.add(list.subList(i * length, list.size()));
            } else {
                ls.add(list.subList(i * length, i * length + length));
            }
        }
        return ls;
    }
}
