//Волновой алгоритм
import java.util.ArrayList;
import java.util.Stack;

public class homework5 {
    public static void Print(String[][] ar) {
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar[0].length; j++) {
                System.out.print(ar[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String[][] desk = {
                { "X", "0", "0", "0", "0", "X"},
                { "0", "0", "X", "0", "0", "0" },
                { "0", "X", "X", "0", "0", "0" },
                { "0", "X", "0", "X", "X", "0" },
                { "0", "X", "0", "0", "0", "0" } };
        int x1 = 1, y1 = 1, x2 = 3, y2 = 2;
        desk[x1][y1] = "S"; // start
        desk[x2][y2] = "F"; // finish
        Print(desk);
        int x = 0;
        int y = 0;
        int[] dx = new int[] { 0, -1, 1, 0 };
        int[] dy = new int[] { -1, 0, 0, 1 };
        ArrayList<Integer> X = new ArrayList<Integer>();
        ArrayList<Integer> Y = new ArrayList<Integer>();
        X.add(x1);
        Y.add(y1);
        int count = 0;
        boolean b = false;
        int m = desk.length, n = desk[0].length;
        while (b == false && count < m * n) {
            int size = X.size();
            count++;
            for (int e = 0; e < size; e++) {
                x = X.get(e);
                y = Y.get(e);
                for (int i = 0; i < 4; i++) {
                    if (x + dx[i] >= 0 && x + dx[i] < m && y + dy[i] >= 0 && y + dy[i] < n) {
                        if (desk[x + dx[i]][y + dy[i]] == "F") {
                            b = true;
                        } else if (desk[x + dx[i]][y + dy[i]] == "0") {
                            desk[x + dx[i]][y + dy[i]] = Integer.toString(count);
                            X.add(x + dx[i]);
                            Y.add(y + dy[i]);
                        }
                    }
                }
            }
        }
        if (b == false && count == m * n) {
            System.out.println("Решений нет");
        } else {
            System.out.printf("Мин количество шагов - %d", count);
            System.out.println();
            Print(desk);
            Stack stack = new Stack<>();
            stack.push(y2 + "; ");
            stack.push(x2 + " ");
            for (int i = 0; i < desk.length; i++) {
                for (int j = 0; j < desk[0].length; j++) {
                    while (count > 1) {
                        if (y2 - 1 >= 0 && desk[x2][y2 - 1].equals(Integer.toString(count - 1))) {
                            y2 -= 1;
                            break;
                        } else if (y2 + 1 < desk[0].length && desk[x2][y2 + 1].equals(Integer.toString(count - 1))) {
                            y2 += 1;
                            break;
                        } else if (x2 - 1 >= 0 && desk[x2 - 1][y2].equals(Integer.toString(count - 1))) {
                            x2 -= 1;
                            break;
                        } else if (x2 + 1 < desk.length && desk[x2 + 1][y2].equals(Integer.toString(count - 1))) {
                            x2 += 1;
                            break;
                        }
                        stack.push(y2 + "; ");
                        stack.push(x2 + " ");
                        count--;
                    }
                }
            }
            stack.push(y1 + "; ");
            stack.push(x1 + " ");
            System.out.println("Кратчайший путь от стартa до финиша: ");
            while (!stack.isEmpty()) {
                System.out.print(stack.pop());
            }
        }
        System.out.println();
    }
}
