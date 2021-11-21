package com.soft.enums;

import java.util.*;

public class EnumMapDemo {
    public static void main(String[] args) {
        List<StudyJava> list = new ArrayList<>();
        list.add(new StudyJava("January", ProjectEnum.SSH));
        list.add(new StudyJava("February", ProjectEnum.SSM));
        list.add(new StudyJava("March", ProjectEnum.SSM));
        list.add(new StudyJava("April", ProjectEnum.SPRINGBOOT));
        list.add(new StudyJava("May", ProjectEnum.SPRINGBOOT));
        list.add(new StudyJava("June", ProjectEnum.SPRINGCLOUD));
        // 1. 使用hashmap
        Map<ProjectEnum, Integer> hashMap = new HashMap<>();
        list.stream().map(StudyJava::getProjectEnum).forEach(project -> {
            hashMap.merge(project, 1, Integer::sum);
        });
        System.out.println(hashMap);

        // 2. 使用EnumMap
        Map<ProjectEnum, Integer> enumMap = new EnumMap<ProjectEnum, Integer>(ProjectEnum.class);
        for (StudyJava studyJava : list) {
            ProjectEnum project = studyJava.getProjectEnum();
            enumMap.merge(project, 1, Integer::sum);
        }
        System.out.println(enumMap);
    }
}

enum ProjectEnum {
    /**
     * 枚举
     */
    SSM,
    SSH,
    SPRINGBOOT,
    SPRINGCLOUD;
}

class StudyJava {
    private String month;
    private ProjectEnum projectEnum;

    public StudyJava(String month, ProjectEnum projectEnum) {
        this.month = month;
        this.projectEnum = projectEnum;
    }

    public String getMonth() {
        return this.month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public ProjectEnum getProjectEnum() {
        return this.projectEnum;
    }

    public void setProjectEnum(ProjectEnum projectEnum) {
        this.projectEnum = projectEnum;
    }
}
