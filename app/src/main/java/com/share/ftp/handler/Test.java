package com.share.ftp.handler;

import java.util.ArrayList;

public class Test {
  public static void main(String[] args) {
    //    String[] names = {"박성준","a","b","c"};

    ArrayList<String> names  = new ArrayList<>();
    names.add("박성준");
    names.add("a");
    names.add("b");
    names.add("c");

    System.out.println("배열의 갯수 : "+ names.size());

    System.out.println("---------------------------------");

    ArrayList<String> names2  = new ArrayList<>();
    names2.add("박성준");
    names2.add("d");
    names2.add("e");
    names2.add("f");

    System.out.println( names2.get(0).equals("박성준"));
    System.out.println( names2.get(1).equals("박성준"));
    System.out.println( names2.get(1).equals("d"));
    System.out.println( names2.get(2).equals("e"));
    System.out.println( names2.get(3).equals("f"));
    System.out.println("--------------------------------");

    System.out.println( names2.contains("박성준"));
    System.out.println( names2.contains("d"));
    System.out.println( names2.contains("e"));
    System.out.println( names2.contains("f"));
    System.out.println( names2.contains("a"));

    System.out.println("배열의 갯수 : "+ names2.size());

    System.out.println("---------------------------------");

    String[] names3 = {"박성준","d","e","f"};

    System.out.println(names3[0].equals("박성준"));
    System.out.println(names3[1].equals("박성준"));

    System.out.println("---------------------------------");


    String[] test = {"박성준","d","e","f"};
    String[] test1 = {"박성준","d","e","f"};

    ArrayList<String> t = new ArrayList<>();
    t.add("박성준");
    t.add("d");
    t.add("e");
    t.add("f");

    ArrayList<String> t1 = new ArrayList<>();
    t1.add("박성준");
    t1.add("d");
    t1.add("e");
    t1.add("f");





  }
}
