package com.company;

import java.util.Comparator;

public class GenderComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        Sex gender1=o1.getGender();
        Sex gender2=o2.getGender();
        if(gender1.compareTo(gender2)>0){
            return 1;
        }
        if(gender1.compareTo(gender2)<0){
            return -1;
        }
        return 0;
    }
}
