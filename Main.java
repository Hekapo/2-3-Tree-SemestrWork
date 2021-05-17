package TwoThreeSemestrWork;

import java.util.*;


public class Main {
    public static void main(String[] args) {

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

        TwoThreeTree tree = new TwoThreeTree();

        int n = numbersForInsertion.size();
        for (int i = n; i > 0; i--) {
            int num = numbersForInsertion.get(new Random().nextInt(i));
            long start = System.nanoTime();
            tree.Insert(num);
            insertionTime.add((int) (System.nanoTime() - start));
            numbersForInsertion.remove((Object) num);
            n--;


        }
        System.out.println(TwoThreeTree.iterationsInsert);
        System.out.println(TwoThreeTree.iterationsDelete);
        System.out.println(TwoThreeTree.iterationsSearch);
        double averageInsertionTime = insertionTime.stream().mapToInt(e -> e).average().getAsDouble();
        System.out.println("Insertion " + averageInsertionTime);

        int[] arrToSearch = pickNRandom(numbersForSearching, search);
        for (int i = arrToSearch.length - 1; i > 0; i--) {
            long start = System.nanoTime();
            tree.Search(arrToSearch[i]);
            searchingTime.add((int) (System.nanoTime() - start));

        }
        double averageSearchTime = searchingTime.stream().mapToInt(e -> e).average().getAsDouble();
        System.out.println("Search " + averageSearchTime);

        int[] arrNumsToRemove = pickNRandom(numbersToRemove, deleteTo);
        for (int i = arrNumsToRemove.length - 1; i > 0; i--) {
            long start = System.nanoTime();
            tree.Remove(arrNumsToRemove[i]);
            removeTime.add((int) (System.nanoTime() - start));

        }
        double averageRemoveTime = removeTime.stream().mapToInt(e -> e).average().getAsDouble();
        System.out.println("Remove " + averageRemoveTime);


    }

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