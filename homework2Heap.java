import java.util.Arrays;

public class homework2Heap {
    public static void main(String[] args) {
        int[] array = new int[] {9,6,1,7,-10,3,2};
        System.out.println("Начальный массив:");
        System.out.println(Arrays.toString(array));
        SortH(array);
        System.out.println("Отсортированный массив:");
        System.out.println(Arrays.toString(array));
    }
    public static void SortH(int[] a) {
        int n = a.length;
        for (int i = n/2-1; i >= 0; i--) {
            biHeap(a, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            int tmp = a[0];
            a[0] = a[i];
            a[i] = tmp;
            biHeap(a, i, 0);
        }
    }
    public static void biHeap(int[] a, int n, int i) {
        int max = i;
        int l = 2*i+1;
        int r = 2*i+2;

        if (l < n && a[l] > a[max]) {
            max =l;
        }
        
        if (r < n && a[r] > a[max]) {
            max = r;
        }
        if (max != i) {
            int tmp = a[i];
            a[i] = a[max];
            a[max] = tmp;
            biHeap(a, n, max);
        }
        
    }
}
