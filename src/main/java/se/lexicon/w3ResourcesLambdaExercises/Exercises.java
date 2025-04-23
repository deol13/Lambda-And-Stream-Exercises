package se.lexicon.w3ResourcesLambdaExercises;

import se.lexicon.FunctionalInterfacePractice.Action;
import se.lexicon.FunctionalInterfacePractice.Conditional;
import se.lexicon.FunctionalInterfacePractice.Product;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;


public class Exercises {



    public static void main(String[] args) {
        // Task 1:
        IntOperator addition = (num1, num2) -> num1 + num2;
        System.out.println("Task 1 - 10 + 20: "+addition.apply(10, 20));

        // Task 2:
        Predicate<String> empty = str -> str.isEmpty();
        System.out.println("Task 2 - Hello world: " + empty.test("Hello World"));
        System.out.println("Task 2 - : " + empty.test(""));

        // Task 3:
        String[] arr1 = {"Hello","World","By","The","Way","Vehicle","Car"};
        ArrayList<String> strList = new ArrayList<>(List.of(arr1));

        List<String> uppercaseList = strList.stream().map(p -> p.toUpperCase()).toList();
        strList.replaceAll(String::toLowerCase);

        System.out.println("Task 3 uppercase list: " + uppercaseList);
        System.out.println("Task 3 lowercase list: " + strList);

        // Task 4:
        Integer[] intArr1 = {1,2,3,4,5,6,7,8,9,10};
        ArrayList<Integer> intList = new ArrayList<>(List.of(intArr1));

        Predicate<Integer> even = i -> i % 2 == 0;
        List<Integer> evenList = intList.stream().filter(even).toList();
        List<Integer> oddList = intList.stream().filter(i -> i % 2 != 0).toList();

        System.out.println("Task 4 even list: "+evenList);
        System.out.println("Task 4 odd list: "+oddList);

        // Task 5:
            // Version 1
        List<String> sortedArr = Arrays.stream(arr1).sorted(Comparator.naturalOrder()).toList();
        System.out.println("Task 5.1 original list: " + Arrays.stream(arr1).toList());
        System.out.println("Task 5.1 sorted list: " + sortedArr);

            // Version 2
        List<String> colors = Arrays.asList("red", "green", "blue", "black", "pink");
        System.out.println("Task 5.2 original list: " + colors);

        colors.sort((str1, str2) -> str1.compareToIgnoreCase(str2));
        colors.sort(String::compareToIgnoreCase);

        System.out.println("Task 5.2 sorted list: " + colors);

        // Task 6:
        Double[] doubleArr1 = {1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0,10.0};
        ArrayList<Double> doubleList = new ArrayList<>(List.of(doubleArr1));
        OptionalDouble avg = doubleList.stream().mapToDouble(Double::doubleValue).average(); //d -> d
        System.out.println("Task 6 List of numbers: " + doubleList);
        System.out.println("Task 6 Average: "+avg.getAsDouble());

        // Task 7:
        Integer[] duplicateArr = {1,1,2,3,4,5,5,7,8,9,9,3};
        ArrayList<Integer> duplicateList = new ArrayList<>(List.of(duplicateArr));

        List<Integer> noDuplicatesList = Arrays.stream(duplicateArr).distinct().toList();

        System.out.println("Task 7 original list: " + duplicateList);
        System.out.println("Task 7 no duplicates list: " + noDuplicatesList);

        // Task 8:
        Function<Integer, Integer> factorial = i -> {
            int sum = 1;
            for (int j = 1; j < i+1; j++) {
                sum *= j;
            }
            return sum;
        };

        System.out.println("Task 8 factorial of 10: "+factorial.apply(10));
    }
}
