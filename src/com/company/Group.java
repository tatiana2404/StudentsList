package com.company;

import java.io.*;
import java.util.*;

public class Group implements  Voenkom, Serializable{

    private static final long serialVersionUID=1l;
    private List<Student> students=new ArrayList<>();
    private String nameGroup;
    private int k=0;

    public Group(){}

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getNameGroup() {
        Scanner s=new Scanner(System.in);
        System.out.println("Введите название группы");
        nameGroup=s.nextLine();
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }




    public void addStudent (Student student) throws MyNewException{

             if(k<10)  {
                 students.add(new Student(AddFact.newSurname(), AddFact.newName(), AddFact.newAge(), AddFact.newGender(),
                         AddFact.newCourse(), AddFact.newRecordBook()));
                 k++;
                 System.out.println("Студент успешно добавлен в группу. В группе "+k+" студ.");
                 return;
             }else{
                 throw new MyNewException();
             }


    }

    public void sortSurname(){
       TreeSet<Student> students1=new TreeSet<Student>(new SurnameComparator());
       for (int i=0;i<students.size();i++) {
           students1.add(students.get(i));
       }
        Iterator<Student> itr=students1.iterator();
        for(;itr.hasNext();){
            System.out.println(itr.next());
        }
    }
    public void sortSurnameGender(){
        TreeSet<Student> students1=new TreeSet<Student>(new SurnameComparator());
        for (int i=0;i<students.size();i++) {
            students1.add(students.get(i));
        }
        Iterator<Student> itr=students1.iterator();
        for(;itr.hasNext();){
            System.out.println(itr.next());
        }
    }

    public Student findStudent(){
        Scanner str=new Scanner(System.in);
        str.nextLine();
        System.out.println("Введите фамилию студента, которого хотите найти: ");
        String line = str.nextLine();
        for(int i = 0; i< students.size(); i++){
            if(line.equals(students.get(i).getSurname()))
            {
                System.out.println("Студент найден.");
                return students.get(i);
            }
        }
        return null;
    }
    public void deleteStudent(){
        Scanner str=new Scanner(System.in);
        str.nextLine();
        System.out.println("Введите фамилию студента, которого хотите удалить: ");
        String line = str.nextLine();
        for(int i = 0; i< students.size(); i++){
            if(line.equals(students.get(i).getSurname())){
                students.remove(students.get(i));
                k--;
                System.out.println("Студен удалён из этой группы. В группе "+k+" студ.");
            }
        }
    }

    public void saveToFile(){
        try(ObjectOutputStream OOS=new ObjectOutputStream(new FileOutputStream(getNameGroup()))){
            OOS.writeObject(students);
            System.out.println("Успешно сохранено");
            students =new ArrayList<>();
            k=0;
        } catch(IOException e){
            System.out.println("Ошибка при сохранение");
        }
    }
    public Group readFromFile(){
        Group readGroup=new Group();
        students=null;
        try (ObjectInputStream OIS=new ObjectInputStream(new FileInputStream(getNameGroup()))){
            students=(List<Student>) OIS.readObject();
            readGroup.setStudents(students);
            System.out.println("Успешно считано");
            return readGroup;
        } catch(IOException |
                ClassNotFoundException e){
            System.out.println("Ошибка считывания");
        }
       return null;
    }



    @Override
    public List<Student> otbor() {
        List<Student> voen=new ArrayList<>();
        int n=0;
        for(int i=0; i<k; i++){
            if(students.get(i).getGender().equals(Sex.man) && students.get(i).getAge()>18 ){
                voen.add(students.get(i));
                n++;
            }
        }
        if (n>0){
            return voen;
        }
        else {
            System.out.println("Таких студентов нет");
            return null;
        }
    }


    @Override
    public String toString() {
        return "Group{"  + students +
                '}';
    }
}