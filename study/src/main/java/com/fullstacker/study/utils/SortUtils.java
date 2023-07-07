package com.fullstacker.study.utils;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * @author xgs
 * @create 2018-08-14-18:37
 **/
public class SortUtils {

    /**
     * 降序
     */
    public static String DESC = "desc";

    /**
     * 升序
     */
    public static String ASC = "asc";

    /**
     * <p>功能描述：按指定字段，指定排序顺序排序
     * 支持int,double,long,float,Date类型字段，不在以上类型的字段转换为String比较
     * </p>
     *
     * @return
     * @author xgs
     * @Date 2018-08-15 14:22
     * @since 1.0
     */
    public static <T> List<T> sortList(List<T> list, final String field, final String sort) {

        Collections.sort(list, new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                try {
                    Field sortField = o1.getClass().getDeclaredField(field);
                    Class<?> sortFieldType = sortField.getType();
                    sortField.setAccessible(Boolean.TRUE);
                    int ret = 0;

                    if (sortFieldType == int.class || sortFieldType == Integer.class) {
                        ret = Integer.compare((int) sortField.get(o1), (int) sortField.get(o2));
                    } else if (sortFieldType == double.class || sortFieldType == Double.class) {
                        ret = Double.compare((Double) sortField.get(o1), (Double) sortField.get(o2));
                    } else if (sortFieldType == long.class || sortFieldType == Long.class) {
                        ret = Long.compare((Long) sortField.get(o1), (Long) sortField.get(o2));
                    } else if (sortFieldType == float.class || sortFieldType == Float.class) {
                        ret = Float.compare((Float) sortField.get(o1), (Float) sortField.get(o2));
                    } else if (sortFieldType == Date.class) {
                        Long time1 = ((Date) sortField.get(o1)).getTime();
                        Long time2 = ((Date) sortField.get(o2)).getTime();
                        ret = Long.compare(time1, time2);
                    } else {
                        ret = String.valueOf(sortField.get(o1)).compareTo(String.valueOf(sortField.get(o2)));
                    }
                    if (sort != null && sort.toLowerCase().equals(DESC)) {
                        return -ret;
                    } else {
                        return ret;
                    }

                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                return 0;
            }
        });
        return list;
    }
}
