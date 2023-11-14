package graph;

/**
 * @author Lucas Su
 * @create 2023-09-22-0:49
 * 22 min
 */
public class FriendlyRooks {
    static int getMinFriendlyColoring(String[] board) {
        int[][] arr = new int[board.length][board[0].length()];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = board[i].charAt(j);
            }
        }

        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 'R') {
                    mark(arr, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private static void mark(int[][] arr, int a, int b) {
        for (int i = 0; i < arr[0].length; i++) {
            if (arr[a][i] == 'R') {
                arr[a][i] = 'M';
                mark(arr,a,i);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][b] == 'R') {
                arr[i][b] = 'M';
                mark(arr,i,b);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(getMinFriendlyColoring(new String[]
                {".R.R",
                "R.R.",
                ".R.R"}
        ));
        System.out.println(getMinFriendlyColoring(new String[]
                {"RRRRRRRRRRRRRRR"}
        ));
        System.out.println(getMinFriendlyColoring(new String[]
                {"...............",
                        "...............",
                        "...............",
                        "...............",
                        "...............",
                        "..............."}
        ));
        System.out.println(getMinFriendlyColoring(new String[]
                {"....R..........",
                        ".R...........R.",
                        "....R..........",
                        ".R........R....",
                        "....R..........",
                        "....R.....R...."}
        ));
        System.out.println(getMinFriendlyColoring(new String[]
                {"R.........R",
                        ".R.......R.",
                        "..R.....R..",
                        "...R...R...",
                        "....R.R....",
                        ".....R.....",
                        "....R.R....",
                        "...R...R...",
                        "..R.....R..",
                        ".R.......R.",
                        "R.........R"}
        ));
    }
}
