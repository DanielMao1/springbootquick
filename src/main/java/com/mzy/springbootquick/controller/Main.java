package com.mzy.springbootquick.controller;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int busNum = sc.nextInt();
        String list = sc.next();
        StringBuilder schedule[] = Schedule(busNum, list);


        if (busNum <= 0) {
            System.out.println("Bus Number is negative or zero, error!");

        } else if (schedule[0].equals("Time Table error!")) {
            System.out.println("Time Table error!");
        } else if (schedule[0].equals("Dispatching failed!")) {
            System.out.println("Dispatching failed!");

        } else
            for (StringBuilder b : schedule) {
                System.out.println(b.toString());

            }
    }


    public static StringBuilder[] Schedule(int busNum, String list) {

        StringBuilder[] Schedule = new StringBuilder[0];

        String[] s = list.split("_");

        for (int i = 0; i < s.length - 1; i++) {
            if (Integer.valueOf(s[i].replace(':', '0')) > Integer.valueOf(s[i + 1].replace(':', '0')))
                Schedule(busNum, list)[0].append("Time Table error!");
            i = s.length;
        }


        for (int i = 0; i < s.length; i++) {
            if (Integer.valueOf(s[i].substring(0, 2)) > 23 || Integer.valueOf(s[i].substring(3, 5)) > 59)
                Schedule(busNum, list)[0].append("Time Table error!");
            i = s.length + 1;
        }

        int counter = 0;
        for (int i = 1; i < s.length; i++) {
            if (s[i].equals(s[i - 1]))
                counter = counter + 1;
        }
        if (busNum < counter)
            Schedule(busNum, list)[0].append("Dispatching failed!");


        if (busNum >= s.length) {
            for (int i = 0; i < s.length; i++) {
                Schedule(busNum, list)[i].append(s[i]);
            }

        } else

            for (int a = 0; a < busNum; a++) {
                StringBuilder s1 = new StringBuilder();
                for (int i = a; i < s.length; i += busNum) {
                    s1.append(s[a] + "_");
                }
                int k = s1.length();

                String s2 = s1.substring(0, k - 1);
                Schedule(busNum, list)[a].append(s2);
            }


        return Schedule;




    }
}

