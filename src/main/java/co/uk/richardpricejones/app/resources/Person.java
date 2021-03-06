package co.uk.richardpricejones.app.resources;

import java.util.UUID;

public class Person {


    private String name;
    private int age;
    private Job job;
    private String id;

    public Person(String name, int age, Job job) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.id = UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job=" + job +
                ", id='" + id + '\'' +
                '}';
    }
}
