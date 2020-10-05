package com.example.coordinate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String args[]) {

        /*  OUTPUT Should be
            pA Box2
            pB Box3
            pC Box3
            pD Box1
        */

        List<Box> boxes = new ArrayList<>();
        List<Person> persons = new ArrayList<>();

        List<Double> distances = new ArrayList<>();
        HashMap<Double, Box> hashMap = new HashMap<>();

        Box box1 = new Box("Box1", 8, -6);
        Box box2 = new Box("Box2", 6, 10);
        Box box3 = new Box("Box3", 4, 5);

        Person pA = new Person("pA", 8, 8);
        Person pB = new Person("pB", 2, 7);
        Person pC = new Person("pC", -2, 1);
        Person pD = new Person("pD", -5, -7);

        boxes.add(box1);
        boxes.add(box2);
        boxes.add(box3);

        persons.add(pA);
        persons.add(pB);
        persons.add(pC);
        persons.add(pD);

        for (Person p : persons) {

            distances.clear();
            for (Box b : boxes) {

                Double distance = Math.round(distance(p.x, p.y, b.x, b.y)*100000.0)/100000.0;
                System.out.println("Distance B/W "+p.name+" - "+b.name+": "+distance);

                distances.add(distance);

                hashMap.put(distance, b);
            }

            Collections.sort(distances);

            // System.out.println("end person "+p.name+" nearest distance is "+distances.get(0));

            Box boxNearest = hashMap.get(distances.get(0));
            System.out.println(p.name+" closed to "+boxNearest.name);
            System.out.println("");
        }

    }


    static double distance(int x1, int y1, int x2, int y2)
    {
        // Calculating distance
        return Math.sqrt(Math.pow(x2 - x1, 2) +
                Math.pow(y2 - y1, 2) * 1.0);
    }

    public static class Box {

        public String name;
        public int x, y;

        public Box(String name, int x, int y) {
            this.name = name;
            this.x = x;
            this.y = y;
        }

    }

    public static class Person {

        public String name;
        public int x, y;

        public Person(String name, int x, int y) {
            this.name = name;
            this.x = x;
            this.y = y;
        }

    }
}
