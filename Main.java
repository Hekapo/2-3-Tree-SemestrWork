
package TwoThreeSemestrWork;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        // Reading input from file
        Scanner sc = new Scanner(new File("C:\\SemestrWork\\2-3Tree-SemestrWork\\src\\main\\java\\random.txt"));
        String s;   // To capture line from file
        PrintWriter out = new PrintWriter(new File("C:\\SemestrWork\\2-3Tree-SemestrWork\\src\\main\\java\\random.txt"));

        int deleteTo = 1000;
        int search = 100;


        List<Integer> numbersForInsertion = new ArrayList<>();
        List<Integer> insertionTime = new ArrayList<>();
        List<Integer> searchingTime = new ArrayList<>();
        List<Integer> removeTime = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            numbersForInsertion.add(i);

        }
        List<Integer> numbersForSearching = new ArrayList<>(numbersForInsertion);
        List<Integer> numbersToRemove = new ArrayList<>(numbersForInsertion);

        // Creating a new 2-3 tree
        TwoThreeTree tree = new TwoThreeTree();

        // File Processing starts here

        int n = numbersForInsertion.size();
        for (int i = n; i > 0; i--) {
            int num = numbersForInsertion.get(new Random().nextInt(i));
            long start = System.nanoTime();

            tree.insert(num);

            insertionTime.add((int) (System.nanoTime() - start));

            numbersForInsertion.remove((Object) num);
            n--;


        }
        for (int i = 0; i < insertionTime.size(); i++) {
            out.print(insertionTime.get(i));
            out.println();

        }
        out.close();
        double averageInsertionTime = insertionTime.stream().mapToInt(e -> e).average().getAsDouble();
        System.out.println("Insertion " + averageInsertionTime);

        int[] arrToSearch = pickNRandom(numbersForSearching, search);
        for (int i = arrToSearch.length - 1; i > 0; i--) {
            long start = System.nanoTime();
            tree.search(arrToSearch[i]);
            searchingTime.add((int) (System.nanoTime() - start));

        }

        double averageSearchTime = searchingTime.stream().mapToInt(e -> e).average().getAsDouble();
        System.out.println("Search " + averageSearchTime);

        int[] arrNumsToRemove = pickNRandom(numbersToRemove, deleteTo);
        for (int i = arrNumsToRemove.length - 1; i > 0; i--) {
            long start = System.nanoTime();
            tree.remove(arrNumsToRemove[i]);
            removeTime.add((int) (System.nanoTime() - start));

        }
        double averageRemoveTime = removeTime.stream().mapToInt(e -> e).average().getAsDouble();
        System.out.println("Remove " + averageRemoveTime);


//        OUTER:
//        while (true) {
//
//            // Read line from file
//            s = sc.nextLine();
//            // Split commands and values
//            String[] tokens = s.split(" ");
//            String command = tokens[0];
//
//            switch (command) {
//                // Case Insert
//                case "I": {
//                    // Get value to be inserted
//                    int value = Integer.parseInt(tokens[1]);
//                    // Try to insert the value and return result
//                    boolean success = tree.insert(value);
//                    if (success) {
//                        // If the value was inserted
//                        System.out.printf("Key %s inserted\n", value);
//                    } else {
//                        // If insertion fails
//                        System.out.printf("Key %s already exists\n", value);
//                    } // end of if else
//                    break;
//                } // end of case I
//
//                // Case Delete
//                case "D": {
//                    // Get value to be deleted
//                    int value = Integer.parseInt(tokens[1]);
//                    // Try to delete the value and return result
//                    boolean success = tree.remove(value);
//                    if (success) {
//                        // If the value was deleted
//                        System.out.printf("Key %s deleted\n", value);
//                    } else {
//                        // If deletion fails
//                        System.out.printf("Key %s doesn't exist\n", value);
//                    } // end of if else
//                    break;
//                } // end of case D
//
//
//                // Case Search
//                case "S": {
//                    // Get the value to be searched
//                    int value = Integer.parseInt(tokens[1]);
//                    // Try to find the value and return result
//                    boolean success = tree.search(value);
//                    if (success) {
//                        // If the search finds the key
//                        System.out.printf("Key %s found\n", value);
//                    } else {
//                        // If the key wasn't found
//                        System.out.printf("Key %s doesn't exist\n", value);
//                    } // end of if else
//                    break;
//                } // end of case S
//
//                // Case KeyOrderList
//                case "K":
//                    // Print keys in order
//                    tree.keyOrderList();
//                    break;
//
//                // Case BFSList
//                case "B":
//                    // Print keys in level Order
//                    tree.bfsList();
//                    break;
//
//                // Case Height
//                case "H":
//                    // Get height of the tree
//                    int height = tree.height();
//                    // Print height
//                    System.out.printf("Height %s\n", height);
//                    break;
//
//                // Case number of nodes
//                case "M":
//                    // Get the number of nodes
//                    int size = tree.numberOfNodes();
//                    // Print the number of nodes in the tree
//                    System.out.printf("Size %s\n", size);
//                    break;
//
//                // Case end
//                case "E":
//                    // Break the loop
//                    break OUTER;
//                default:
//                    break;
//            } // switch ends here
//        } // end of while loop


    } // end of main

    public static int[] pickNRandom(List<Integer> array, int n) {

        List<Integer> list = new ArrayList<>(array.size());
        list.addAll(array);
        Collections.shuffle(list);

        int[] answer = new int[n];
        for (int i = 0; i < n; i++)
            answer[i] = list.get(i);
        Arrays.sort(answer);

        return answer;

    }
}