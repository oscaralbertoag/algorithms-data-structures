package geeksforgeeks.mergesortedarrays;

public class MergeSortedArrays {
    public int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int aIndex = 0;
        int bIndex = 0;
        int resultIndex = 0;
        boolean aReachedEnd;
        boolean bReachedEnd;
        while (resultIndex < a.length + b.length) {
            aReachedEnd = aIndex >= a.length;
            bReachedEnd = bIndex >= b.length;
            if (!aReachedEnd && !bReachedEnd) {
                if (a[aIndex] <= b[bIndex]) {
                    result[resultIndex++] = a[aIndex++];
                } else {
                    result[resultIndex++] = b[bIndex++];
                }
            } else if (!aReachedEnd) {
                result[resultIndex++] = a[aIndex++];
            } else {
                result[resultIndex++] = b[bIndex++];
            }
        }
        return result;
    }
}
