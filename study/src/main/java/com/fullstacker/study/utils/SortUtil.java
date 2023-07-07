package com.fullstacker.study.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortUtil<E> {

    public void sort(List<E> list, final String method, final String sort) {
        Collections.sort(list, new Comparator<Object>() {
            public int compare(Object a, Object b) {
                int ret = 0;
                try {
                    Method m1 = ((E) a).getClass().getMethod(method, null);
                    Method m2 = ((E) b).getClass().getMethod(method, null);
                    if (sort != null && "desc".equalsIgnoreCase(sort))//倒序
                    {
                        ret = m2.invoke(((E) b), null).toString().compareTo(m1.invoke(((E) a), null).toString());
                    } else//正序
                    {
                        ret = m1.invoke(((E) a), null).toString().compareTo(m2.invoke(((E) b), null).toString());
                    }
                } catch (NoSuchMethodException ne) {
                    System.out.println(ne);
                } catch (IllegalAccessException ie) {
                    System.out.println(ie);
                } catch (InvocationTargetException it) {
                    System.out.println(it);
                }
                return ret;
            }
        });
    }

    public void sortByInterger(List<E> list, final String method, final String sort) {
        Collections.sort(list, new Comparator<E>() {
            public int compare(E a, E b) {
                int ret = 0;
                try {
                    Method m1 = a.getClass().getMethod(method, null);
                    Method m2 = b.getClass().getMethod(method, null);
                    if (sort != null && "desc".equalsIgnoreCase(sort)) {//倒序
                        Integer m2Value = Integer.parseInt(m2.invoke(((E) b), null).toString());
                        Integer m1Value = Integer.parseInt(m1.invoke(((E) a), null).toString());
                        ret = m2Value.compareTo(m1Value);
                    } else {//正序
                        Integer m2Value = Integer.parseInt(m2.invoke(((E) b), null).toString());
                        Integer m1Value = Integer.parseInt(m1.invoke(((E) a), null).toString());
                        ret = m1Value.compareTo(m2Value);
                    }
                } catch (NoSuchMethodException ne) {
                    System.out.println(ne);
                } catch (IllegalAccessException ie) {
                    System.out.println(ie);
                } catch (InvocationTargetException it) {
                    System.out.println(it);
                }
                return ret;
            }
        });
    }

    public void sortByLong(List<E> list, final String method, final String sort) {
        Collections.sort(list, new Comparator<E>() {
            public int compare(E a, E b) {
                int ret = 0;
                try {
                    Method m1 = a.getClass().getMethod(method, null);
                    Method m2 = b.getClass().getMethod(method, null);
                    if (sort != null && "desc".equalsIgnoreCase(sort)) {//倒序
                        Long m2Value = Long.parseLong(m2.invoke(((E) b), null).toString());
                        Long m1Value = Long.parseLong(m1.invoke(((E) a), null).toString());
                        ret = m2Value.compareTo(m1Value);
                    } else {//正序
                        Long m2Value = Long.parseLong(m2.invoke(((E) b), null).toString());
                        Long m1Value = Long.parseLong(m1.invoke(((E) a), null).toString());
                        ret = m1Value.compareTo(m2Value);
                    }
                } catch (NoSuchMethodException ne) {
                    System.out.println(ne);
                } catch (IllegalAccessException ie) {
                    System.out.println(ie);
                } catch (InvocationTargetException it) {
                    System.out.println(it);
                }
                return ret;
            }
        });
    }
}
