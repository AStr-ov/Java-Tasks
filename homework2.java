// Сортировка слиянием

import java.util.Arrays;

public class homework2 {
    public static void main(String[] args) {
        int[] a = new int [] {7, 2, 9, 3, 8, 5, 10, 0, 4, 6, 1};
        SortMerge(a, a.length);
        System.out.println(Arrays.toString(a));
    }
    public static void SortMerge(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n/2;
        int[] left = new int[mid];
        int[] right = new int[n-mid];
        System.arraycopy(a, 0, left, 0, mid);
        System.arraycopy(a, mid, right, 0, n-mid);

        SortMerge(left, mid);
        SortMerge(right, n-mid);

        Merge(a, left, right, mid, n-mid);
    }
    public static void Merge(int[] a, int[] l, int[] r, int lenL, int lenR) {
        int i = 0, j = 0, k = 0;
        while (i < lenL && j < lenR) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else
                a[k++] = r[j++];
        }
        while (i < lenL) {
            a[k++] = l[i++];
        }
        while (j < lenR) {
            a[k++] = r[j++];
        }
    }
}
