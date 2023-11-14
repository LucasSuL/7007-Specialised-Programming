//package bruteforce;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class test{
//    public static List<int[]> getDiagonalCoordinates(int i, int j, int size) {
//        List<int[]> diagonalCoords = new ArrayList<>();
//
//        // 方向1：从左上到右下的对角线
//        for (int diff = -size + 1; diff < size; diff++) {
//            int x = i + diff;
//            int y = j + diff;
//
//            if (x >= 0 && x < size && y >= 0 && y < size) {
//                int[] coord = {x, y};
//                diagonalCoords.add(coord);
//            }
//        }
//
//        // 方向2：从右上到左下的对角线
//        for (int diff = -size + 1; diff < size; diff++) {
//            int x = i + diff;
//            int y = j - diff;
//
//            if (x >= 0 && x < size && y >= 0 && y < size) {
//                int[] coord = {x, y};
//                diagonalCoords.add(coord);
//            }
//        }
//
//        return diagonalCoords;
//    }
//
//    public static void main(String[] args) {
//        int i = 0;
//        int j = 0;
//        int size = 50;
//
//        List<int[]> diagonalCoords = getDiagonalCoordinates(i, j, size);
//
//        for (int[] coord : diagonalCoords) {
//            System.out.println("(" + coord[0] + ", " + coord[1] + ")");
//        }
//    }
//}
