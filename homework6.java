// Уравнение
import java.util.ArrayList;
import java.util.Arrays;

public class homework6 {
    public static void main(String[] args) {
        String eq = "25 + ?? = ?2"; // a + b = c
        String[] q = eq.split(" ");
        System.out.println(Arrays.toString(q));
        ArrayList<String> first = new ArrayList<>();
        ArrayList<String> second = new ArrayList<>();
        for (int i = 0; i < q.length; i += 2) {
            var z = q[i];
            first.add(Character.toString(z.charAt(0)));
            second.add(Character.toString(z.charAt(1)));
        }
        int x;
        int y;
        int z;
        int v;
        int w;
        int g;
        boolean flag = true;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    for (int l = 1; l < 10; l++) {
                        for (int m = 1; m < 10; m++) {
                            for (int n = 1; n < 10; n++) {
                                if (!second.get(0).equals("?")) {
                                    x = Integer.parseInt(second.get(0));
                                } else
                                    x = i;
                                if (!second.get(1).equals("?")) {
                                    y = Integer.parseInt(second.get(1));
                                } else
                                    y = j;
                                if (!second.get(2).equals("?")) {
                                    z = Integer.parseInt(second.get(2));
                                } else
                                    z = k;
                                if (!first.get(0).equals("?")) {
                                    v = Integer.parseInt(first.get(0));
                                } else
                                    v = l;
                                if (!first.get(1).equals("?")) {
                                    w = Integer.parseInt(first.get(1));
                                } else
                                    w = m;
                                if (!first.get(2).equals("?")) {
                                    g = Integer.parseInt(first.get(2));
                                } else
                                    g = n;

                                if (10 * v + x + 10 * w + y == 10 * g + z) {
                                    System.out.printf("%d%d + %d%d = %d%d; ", v, x, w, y, g, z);
                                }else 
                                    flag = false;
                            }
                        }
                    }
                }
            }
        }
        if (flag == false) 
            System.out.println("Нет решений");
    }
}
