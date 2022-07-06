public class homework3queen {
    public static void main(String[] args) {
        
        int [] queen ={0,0,0,0,0,0,0,0};//индекс элемента - строка
                                        //значение - столбец
        int numQ_Row = 0;//номер устанавливаемого ферзя и строки
        int col = 0;//начинаем с 1 столбца
        while (numQ_Row < 8) { //пока ферзей < 8
            int isAttac = 0;

            for (int i = 0; i < numQ_Row; i++) {
                if (queen[i] == col) { //столбец где стоит ферзь
                    isAttac = 1;       // под атакой
                }                                     
                int defRows = numQ_Row - i; // разница ординат
                int defCols = col - queen[i];//разница абцисс
                if (defRows == defCols || defRows == -defCols) {//диагональ 
                    isAttac = 1;             //под атакой
                }
            }                        
                if (isAttac == 0) { //если не под атакой
                    queen[numQ_Row] = col; //ставим ферзя в этот  стобец
                    numQ_Row++; //размещаем следующего ферзя на следующей строке
                    col = 0;   // начинаем проверять с первого столбца
                    if (numQ_Row == 8) {//если количество ферзей 8
                        for (int i = 0; i < queen.length; i++) {// печать
                            System.out.printf("%d:%d; ",i,queen[i]);//строка:столбец
                        }
                    }
                }
                else {// если под атакой
                    col++; // перемещаем в следующий столбец
                    while (col == 8) {// пока в 8 столбец нельзя ставить ферзя
                        numQ_Row--;// возвращаемся на предыдущую строку и
                        col=queen[numQ_Row]+1;// здесь пробуем следующий столбец
                    }
                }           
        }                       
    }   
}            

