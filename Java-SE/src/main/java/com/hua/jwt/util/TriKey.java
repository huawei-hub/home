package com.hua.jwt.util;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public final class TriKey <X,Y,Z,V>{
    private X x;
    private Y y;
    private Z z;
    private ConcurrentHashMap<X, ArrayList<V>> xList = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Y, ArrayList<V>> yList = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Z, ArrayList<V>> zList = new ConcurrentHashMap<>();

    public Set getSet() {
        return xList.keySet();
    }

    public void put(X x,Y y,Z z,V v){
        ArrayList<V> avialable = get(x,y,z);
        if (null != avialable){
            xList.get(x).removeAll(avialable);
            yList.get(y).removeAll(avialable);
            zList.get(z).removeAll(avialable);
        }
        if (xList.containsKey(x)){
            xList.get(x).add(v);
        } else {
            ArrayList<V> xArrList = new ArrayList<>();
            xArrList.add(v);
            xList.put(x,xArrList);
        }

        if (yList.containsKey(y)){
            yList.get(y).add(v);
        } else {
            ArrayList<V> yArrList = new ArrayList<>();
            yArrList.add(v);
            yList.put(y,yArrList);
        }

        if (zList.containsKey(z)){
            zList.get(z).add(v);
        } else {
            ArrayList<V> zArrList = new ArrayList<>();
            zArrList.add(v);
            zList.put(z,zArrList);
        }
    }

    public ArrayList<V> get(X x, Y y, Z z){
        ArrayList<V> xs = xList.get(x);
        ArrayList<V> ys = yList.get(y);
        ArrayList<V> zs = zList.get(z);

        if(null==xs || null==ys || null==zs) return null;

        ArrayList<V> result = new ArrayList<>(xs);
        result.retainAll(ys);
        result.retainAll(zs);
        return result;
    }

}
