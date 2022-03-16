package com.dkit.gd2.johnloane;

//This class is needed to answer question 2

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Employee
{
    private String firstName;
    private String lastName;
    private ArrayList <Employee> listOfEmployees = new ArrayList<>();
    private HashMap<String,Employee> uniqueNames = new HashMap<>();

    public Employee(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Employee()
    {
        populateMap(listOfEmployees);
        uniqueNames = turnsArrayListIntoHashMap(listOfEmployees);
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    @Override
    public String toString()
    {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    private void populateMap(ArrayList<Employee> passingValue)
    {
        passingValue.add(new Employee("Dylan","Dockery"));
        passingValue.add(new Employee("James","Dockery"));
        passingValue.add(new Employee("Ben","Dockery"));
        passingValue.add(new Employee("Luke","Dockery"));
        passingValue.add(new Employee("John","Dockery"));
    }


    private void pickLuckyWinner(ArrayList<Employee> passingValue)
    {
        Random random = new Random();
        int upper = 5;
        int pickAtRandom = random.nextInt(upper);

        for(Employee currentEmployees: passingValue)
        {
            if(pickAtRandom == passingValue.indexOf(currentEmployees))
            {
                System.out.println(currentEmployees.getFirstName() + " is the lucky winner");
            }
        }
    }

    public void displayUniqueNames()
    {
        for(Map.Entry<String,Employee> entry:uniqueNames.entrySet())
        {
            System.out.println(entry.getKey());
        }
    }


    private HashMap<String,Employee> turnsArrayListIntoHashMap(ArrayList<Employee> listOfEmployees)
    {
        HashMap<String,Employee> newListOfEmployees = new HashMap<>();

        for(Employee currentEmployee: listOfEmployees)
        {
            newListOfEmployees.put(currentEmployee.getFirstName(),currentEmployee);
        }

        return  newListOfEmployees;
    }


    private void printAndCountName(String name)
    {
        int count = 0;

        for(Map.Entry<String,Employee> entry:uniqueNames.entrySet())
        {
            if(entry.getKey().contains(name))
            {
                count++;
                System.out.println(entry.getKey() + " " + count);
            }

        }
    }

    public void printWaitingList()
    {
        getNextOnWaitingList(listOfEmployees);
    }

    private void getNextOnWaitingList(ArrayList<Employee> passingValue)
    {
        //System.out.println(passingValue.get(0));

        for(int i =0; i < passingValue.size(); i++)
        {
            System.out.println("Next on waiting list is " + passingValue.get(i));
        }
    }
}
