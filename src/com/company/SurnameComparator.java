package com.company;

import java.util.Comparator;

public class SurnameComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {

        String surname1=o1.getSurname();
        String surname2=o2.getSurname();
        if(surname1.compareTo(surname2)>0){
            return 1;
        }
        if(surname1.compareTo(surname2)<0){
            return -1;
        }
        return 0;
    }
}
