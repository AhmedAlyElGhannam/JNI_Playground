package com.example.lab;

public class FactorialHelperJava {
    public static native void calcFactorial(int num);
    public static void showResultsOnApp(long res) {
        MainActivity.updateUI(res);
    }
}
