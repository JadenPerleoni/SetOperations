import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SetOperations {

    public static void main(String[] args) {

        // Gets the first set from the user and stores it as a string.
        System.out.println("Enter the first set of integers, separated by commas.");
        String sUserSetOne = new Scanner(System.in).nextLine();

        // Gets the second set from the user and stores it as a string.
        System.out.println("Enter the second set of integers, separated by commas.");
        String sUserSetTwo = new Scanner(System.in).nextLine();

        // Removes commas from user's input, and parses the numbers into a string array.
        String[] aSetOneAsString = sUserSetOne.split(",");

        // Make an array for set one
        int[] aSetOne = new int[aSetOneAsString.length];

        // Parse numbers from string array, and stores them into arrays of integers which we will
        // use for all of our methods.
        for (int i = 0; i < aSetOne.length; i++) {
          aSetOne[i] = Integer.parseInt(aSetOneAsString[i]);
        }

        // Same process but for the second set
        String[] aSetTwoAsString = sUserSetTwo.split(",");
        int[] aSetTwo = new int[aSetTwoAsString.length];

        for (int i = 0; i < aSetTwo.length; i++) {
            aSetTwo[i] = Integer.parseInt(aSetTwoAsString[i]);
        }

        // This method outputs the power set of set one.
        System.out.print("Set one power set: ");
        powerSets(aSetOne);

        System.out.print("Set two power set: ");
        powerSets(aSetTwo);

        // This method outputs the cartesian product of set one and set two.
        cartesianProduct(aSetOne, aSetTwo);

        // This method outputs the union of set one and set two.
        union(aSetOne, aSetTwo);

        // This method outputs the intersection of set one and set two.
        intersection(aSetOne, aSetTwo);

        // This method outputs the difference of set one and set two.
        difference(aSetOne,aSetTwo);

        // This method outputs the complement of set one.
        System.out.print("Set one complement:");
        complement(aSetOne);

        // This method outputs the complement of set two.
        System.out.print("Set two complement:");
        complement(aSetTwo);

    }

    // This method is taken from this website: https://www.geeksforgeeks.org/power-set/
    // I changed it a bit to format it, but it is not my work. I could not figure out how to write
    // this one on my own.
    public static void powerSets(int[] aSet) {

        long pow_set_size = (long)Math.pow(2, aSet.length);
        int counter, j;

        for(counter = 0; counter < pow_set_size; counter++) {
            System.out.print("{ ");
            for(j = 0; j < aSet.length; j++) {

                if((counter & (1 << j)) > 0)
                    System.out.print(aSet[j] + " ");
            }
            System.out.print("} ");
        }
        System.out.println();
    }

    public static void cartesianProduct(int[] aSetOne, int[] aSetTwo) {

        System.out.print("The cartesian product of set one and set two is: {");

        for (int i = 0; i < aSetOne.length; i++) {
            for (int j = 0; j < aSetTwo.length; j++) {
                System.out.print("(" + aSetOne[i] + ", " + aSetTwo[j] + ")");
            }
        }
        System.out.println("}");
    }

    public static void union(int[] aSetOne, int[] aSetTwo) {
        System.out.print("The union of set one and set two is: {");
        ArrayList<Integer> alUnion = new ArrayList<>();


        for (int i = 0; i < aSetOne.length; i++) {
         alUnion.add(aSetOne[i]);
        }
        for (int i = 0; i < aSetTwo.length; i++) {
            if (!alUnion.contains(aSetTwo[i])) {
                alUnion.add(aSetTwo[i]);
            }
        }
        Collections.sort(alUnion);
        System.out.println(alUnion + "}");
    }

    public static void intersection(int [] aSetOne, int[] aSetTwo) {

        System.out.print("The intersection of set one and two is: {");
        ArrayList<Integer> alSetOneList = new ArrayList<>();
        ArrayList<Integer> alIntersection = new ArrayList<>();


        for (int i = 0; i < aSetOne.length; i++) {
            alSetOneList.add(aSetOne[i]);
        }
        for (int i = 0; i < aSetTwo.length; i++) {
            if (alSetOneList.contains(aSetTwo[i])) {
                alIntersection.add(aSetTwo[i]);
            }
        }
        System.out.println(alIntersection + "}");
    }

    public static void difference(int[] aSetOne, int[] aSetTwo) {

        System.out.print("The difference of set one and set two is: {");
        ArrayList<Integer> alDifference = new ArrayList<>();

        for (int i = 0; i < aSetOne.length; i++) {
            alDifference.add(aSetOne[i]);
        }

        for (int j = 0; j < aSetTwo.length; j++) {
            if (alDifference.contains(aSetTwo[j])) {
                alDifference.remove(Integer.valueOf(aSetTwo[j]));
            }
        }
        System.out.println(alDifference + "}");
    }

    public static void complement(int[] aSet) {

        System.out.print(" {");
        ArrayList<Integer> alComplement = new ArrayList<>();

        for (int i = 0; i < aSet.length; i++) {
            alComplement.add(aSet[i]);
        }

        for (int i = 1; i <= 100; i++) {
            if (!alComplement.contains(i)) {
                System.out.print(i + ", ");
            }
        }
        System.out.println("}");

    }

}
