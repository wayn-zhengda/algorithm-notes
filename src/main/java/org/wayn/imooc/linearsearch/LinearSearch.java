package org.wayn.imooc.linearsearch;

/**
 * 定义清楚循环不变量
 * 维护循环不变量
 * 定义清楚函数的功能
 */
public class LinearSearch {

    public static <E> int search(E[] data, E target){
        for (int i = 0; i < data.length; i++) {
            // 循环不变量    明白循环中的循环不变量是关键
            if (data[i].equals(target)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this){
            return true;
        }
        if (null == obj){
            return false;
        }
        if (!(obj instanceof LinearSearch)){
            return false;
        }
        return super.equals(obj);
    }
}
