import java.util.Arrays;
 
public class homework3horse {    
    public static void main(String[] args) {
        int N = 5;  //количество клеток доски
        int [][] desk = new int[N][N]; //доска
        Step(desk, 0, 0, 1);// метод ставит 1 ход в клетку 0:0
    }
    public static boolean Inside(int x, int y, int N) {// проверка
        if (x < 0 || y < 0 || x >= N || y >= N) { // в пределах поля
            return false;
        }
        else {
            return true;
        }
    }
    public static void Print(int [][] a) {
        for (var e : a) {
            System.out.println(Arrays.toString(e));// печать
        }
        System.out.println();
    }

    public static void Step(int[][] posDesk, int x, int y, int numStep) {
        int N = 5;
        int [] row = {1, 2, -2, -1, 1, 2, -2, -1};//варианты хода коня 
        int [] col = {2, 1, -1, -2, -2, -1, 1, 2};
        posDesk[x][y] = numStep;//отмечаем клетку номером хода

            if (numStep == N*N) {//если номер хода = количеству клеток доски
                Print(posDesk);//печать
                }                  
            for (int i = 0; i < 8; i++) {// перебор ходов коня
                int newX = x + row[i];//к текущей клетке прибавляем строки
                int newY = y + col[i];//и столбцы из установленных вариантов

                if (Inside(newX, newY, N) && posDesk[newX][newY] == 0) {//если
                                  // в пределах поля и не отмечено ходом
                    Step(posDesk, newX, newY, numStep + 1);//метод делает ход 
                    //из новой клетки и отмечает следующим номером хода
                }
            }
        posDesk[x][y] = 0; //обнуляет координаты для нового поиска                     
    }
}