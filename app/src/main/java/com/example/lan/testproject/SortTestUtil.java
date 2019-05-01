package com.example.lan.testproject;

import com.example.lan.testproject.bean.TestBean;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SortTestUtil {
    public static List<TestBean> getList(List<TestBean> list){
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(0).getType().equals("脚本下发")) {
                if (list.get(i).getType().equals("脚本下发")) {
                    CollectionsUtil.swap(list, 0, i);
                }
            }
        }
        ArrayList<TestBean> list1=new ArrayList<>();
        ArrayList<TestBean> list2=new ArrayList<>();
        LinkedHashMap<String, List<TestBean>> mapType = new LinkedHashMap<>();
        //同名的分为一组
        for (int i = 0; i < list.size(); i++) {
            TestBean student = list.get(i);
            //如果不存在实体字段的键，则创建一个list，并将list添加至map
            if (!mapType.containsKey(student.getType())) {
                ArrayList<TestBean> li = new ArrayList<>();
                li.add(student);
                mapType.put(student.getType(), li);
            } else {
                //如果存在，则直接在list中添加一个即可
                mapType.get(student.getType()).add(student);
            }
        }

        for (Map.Entry<String, List<TestBean>> entry : mapType.entrySet()) {
            for (int i = 0; i <entry.getValue().size() ; i++) {
                list1.add(entry.getValue().get(i));
            }

        }
        LinkedHashMap<String, List<TestBean>> mapName = new LinkedHashMap<>();
        //同名的分为一组
        for (int i = 0; i < list1.size(); i++) {
            TestBean student = list1.get(i);
            //如果不存在实体字段的键，则创建一个list，并将list添加至map
            if (!mapName.containsKey(student.getName())) {
                ArrayList<TestBean> li = new ArrayList<>();
                li.add(student);
                mapName.put(student.getName(), li);
            } else {
                //如果存在，则直接在list中添加一个即可
                mapName.get(student.getName()).add(student);
            }
        }

        for (Map.Entry<String, List<TestBean>> entry : mapName.entrySet()) {
            for (int i = 0; i <entry.getValue().size() ; i++) {
                list2.add(entry.getValue().get(i));
            }

        }
        return list2;
    }

}
