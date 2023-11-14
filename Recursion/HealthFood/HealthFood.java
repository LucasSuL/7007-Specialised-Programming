package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lucas Su
 * @create 2023-08-02-20:53
 */
public class HealthFood {
    public int[] selectMeals(int[] protein, int[] carbs, int[] fat, String[] dietPlans) {
        int[] res = new int[dietPlans.length];
        List<Integer> resList = new ArrayList<>();
        for (int i = 0; i < dietPlans.length; i++) {
            String plan = dietPlans[i]; //"tFc"
            List<Integer> list = new ArrayList<>();
            recursion(plan, protein, carbs, fat, list, resList);
        }
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        return res;
    }
    private void recursion(String plan, int[] protein, int[] carbs, int[] fat, List<Integer> list, List<Integer> resList) {
        if(plan.isEmpty()) {
            resList.add(0);
            return;
        }
        char c = plan.charAt(0); //'t'
        plan = plan.substring(1); //"Fc"
        List<Integer> newList = null;
        switch (c) {
            case 'P' -> newList = searchMaxIndex(protein, list);
            case 'p' -> newList = searchMinIndex(protein, list);
            case 'C' -> newList = searchMaxIndex(carbs, list);
            case 'c' -> newList = searchMinIndex(carbs, list);
            case 'F' -> newList = searchMaxIndex(fat, list);
            case 'f' -> newList = searchMinIndex(fat, list);
            case 'T' -> newList = searchMaxTTIndex(protein, carbs, fat, list);
            case 't' -> newList = searchMinTTIndex(protein, carbs, fat, list);
        }
        if (newList.size() == 1 || plan.isEmpty()) {
            resList.add(newList.get(0));
            return;
        }
        recursion(plan, protein, carbs, fat, newList, resList);
    }

    private List<Integer> searchMaxIndex(int[] arr, List<Integer> list) {
        List<Integer> newList = new ArrayList<>();
        int max = 0;
        int maxIndex = 0;
        if (list.size() == 0) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > max) {
                    newList.clear();
                    max = arr[i];
                    maxIndex = i;
                    newList.add(maxIndex);
                } else if (arr[i] == max) {
                    newList.add(i);
                }
            }
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (arr[list.get(i)] > max) {
                    newList.clear();
                    max = arr[list.get(i)];
                    maxIndex = list.get(i);
                    newList.add(maxIndex);
                } else if (arr[list.get(i)] == max) {
                    newList.add(list.get(i));
                }
            }
        }
        return newList;
    }

    private List<Integer> searchMinIndex(int[] arr, List<Integer> list) {
        List<Integer> newList = new ArrayList<>();
        int min = 9999;
        int minIndex = 0;
        if (list.size() == 0) {

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] < min) {
                    newList.clear();
                    min = arr[i];
                    minIndex = i;
                    newList.add(minIndex);
                } else if (arr[i] == min) {
                    newList.add(i);
                }
            }
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (arr[list.get(i)] < min) {
                    newList.clear();
                    min = arr[list.get(i)];
                    minIndex = list.get(i);
                    newList.add(minIndex);
                } else if (arr[list.get(i)] == min) {
                    newList.add(list.get(i));
                }
            }
        }
        return newList;
    }

    private List<Integer> searchMaxTTIndex(int[] protein, int[] carbs, int[] fat, List<Integer> list) {
        List<Integer> newList = new ArrayList<>();
        int max = 0;
        int maxIndex = 0;
        if (list.size() == 0) {
            for (int i = 0; i < protein.length; i++) {
                int compare = 5 * protein[i] + 5 * carbs[i] + 9 * fat[i];
                if (compare > max) {
                    list.clear();
                    max = compare;
                    maxIndex = i;
                    list.add(maxIndex);
                } else if (compare == max) {
                    list.add(i);
                }
            }
        } else {
            for (int i = 0; i < list.size(); i++) {
                int compare = 5 * protein[list.get(i)] + 5 * carbs[list.get(i)] + 9 * fat[list.get(i)];
                if (compare > max) {
                    list.clear();
                    max = compare;
                    maxIndex = list.get(i);
                    list.add(maxIndex);
                } else if (compare == max) {
                    list.add(list.get(i));
                }
            }
        }
        return list;
    }

    private List<Integer> searchMinTTIndex(int[] protein, int[] carbs, int[] fat, List<Integer> list) {
        List<Integer> newList = new ArrayList<>();
        int min = 9999;
        int minIndex = 0;
        if (list.size() == 0) {
            for (int i = 0; i < protein.length; i++) {
                if (5 * protein[i] + 5 * carbs[i] + 9 * fat[i] < min) {
                    newList.clear();
                    min = 5 * protein[i] + 5 * carbs[i] + 9 * fat[i];
                    minIndex = i;
                    newList.add(minIndex);
                } else if (5 * protein[i] + 5 * carbs[i] + 9 * fat[i] == min) {
                    newList.add(i);
                }
            }
        } else {
            for (int i = 0; i < list.size(); i++) {
                int compare = 5 * protein[list.get(i)] + 5 * carbs[list.get(i)] + 9 * fat[list.get(i)];
                if (compare < min) {
                    newList.clear();
                    min = compare;
                    minIndex = list.get(i);
                    newList.add(minIndex);
                } else if (compare == min) {
                    newList.add(list.get(i));
                }
            }
        }
        return newList;
    }

    public static void main(String[] args) {
//        int[] protein = {3, 4};
//        int[] carbs = {2, 8};
//        int[] fat = {5, 2};
//        String[] dietPlans = {"P", "p", "C", "c", "F", "f", "T", "t"};
//
//        int[] protein = {3, 4, 1, 5};
//        int[] carbs = {2, 8, 5, 1};
//        int[] fat = {5, 2, 4, 4};
//        String[] dietPlans = {"tFc", "tF", "Ftc"};
//        String[] dietPlans = {"tF"};

        int[] protein = {18, 86, 76,  0, 34, 30, 95, 12, 21};
        int[] carbs = {26, 56,  3, 45, 88,  0, 10, 27, 53};
        int[] fat = {93, 96, 13, 95, 98, 18, 59, 49, 86};
        String[] dietPlans = {"f", "Pt", "PT", "fT", "Cp", "C", "t", "",
                "cCp", "ttp", "PCFt", "P", "pCt", "cP", "Pc"}


                ;

        HealthFood h = new HealthFood();
        int[] res = h.selectMeals(protein, carbs, fat, dietPlans);

        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]+", ");
        }

//        List list = new ArrayList<>();
//        int []arr = {1,2,3,3,2,3};
//        list = h.searchMaxIndex(arr);
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
    }
}
