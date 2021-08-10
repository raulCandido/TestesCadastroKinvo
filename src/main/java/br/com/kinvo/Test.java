package br.com.kinvo;

import java.util.Random;

public class Test {

    public static void main(String[] args) {
	System.out.println("email@mail-" + new Random().nextInt(1000)+ ".com");
    }
}
