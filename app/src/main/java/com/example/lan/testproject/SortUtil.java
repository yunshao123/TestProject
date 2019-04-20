package com.example.lan.testproject;

import android.os.Build;
import android.support.annotation.RequiresApi;

import com.example.lan.testproject.bean.TestBean;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SortUtil {

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static List<TestBean> getList(List<TestBean> list) {
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(0).getType().equals("脚本下发")) {
                if (list.get(i).getType().equals("脚本下发")) {
                    CollectionsUtil.swap(list, 0, i);

                }
            }
        }
        List<TestBean> list2 = new ArrayList<>();
        List<TestBean> list3 = new ArrayList<>();
        LinkedHashMap<String, List<TestBean>> groupBySex = list.stream().collect(Collectors.groupingBy(TestBean::getType, LinkedHashMap::new, Collectors.toList()));

        //遍历分组
        for (Map.Entry<String, List<TestBean>> entryUser : groupBySex.entrySet()) {
            String key = entryUser.getKey();
            List<TestBean> entryUserList = entryUser.getValue();
            for (int i = 0; i < entryUserList.size(); i++) {
                list2.add(entryUserList.get(i));
            }
        }

        LinkedHashMap<String, List<TestBean>> groupName = list2.stream().collect(Collectors.groupingBy(TestBean::getName, LinkedHashMap::new, Collectors.toList()));
        for (Map.Entry<String, List<TestBean>> entryUser : groupName.entrySet()) {
            String key = entryUser.getKey();
            List<TestBean> entryUserList = entryUser.getValue();
            for (int i = 0; i < entryUserList.size(); i++) {
                list3.add(entryUserList.get(i));
            }
        }

        return list3;
    }


}
