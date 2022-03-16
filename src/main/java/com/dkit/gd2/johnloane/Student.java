package com.dkit.gd2.johnloane;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class Student
{
    private int id;
    private String name;
    private int age;
    private ArrayList<Student> listOfStudents = new ArrayList<>();

    //Adding students Time complexity 0(n) sorting and printing is 0(n)
    public Student(int id, String name, int age)
    {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Student()
    {
        populateList(listOfStudents);
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }

    private void populateList(ArrayList<Student> passingListOfStudents)
    {
        listOfStudents.add(new Student(100,"Dylan",23));
        listOfStudents.add(new Student(101,"Ben",24));
        listOfStudents.add(new Student(102,"Luke",25));
        listOfStudents.add(new Student(103,"James",26));
    }

    public void printStudentsByAge()
    {
        Collections.sort(listOfStudents, new StudentComparator());

        for(Student currentStudent: listOfStudents)
        {
            System.out.println("Name: " + currentStudent.getName() + "Age: " + currentStudent.getAge());
        }
    }

    public void printStudentsByName()
    {
        for(Student currentStudent: listOfStudents)
        {

            System.out.println("Name: " + currentStudent.getName() + "Age: " + currentStudent.getAge());
        }
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name);
    }
}
