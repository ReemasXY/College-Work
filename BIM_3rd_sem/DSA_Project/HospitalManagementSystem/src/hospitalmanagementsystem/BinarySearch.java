package hospitalmanagementsystem;

public class BinarySearch {

    public int search(String data[][], int l, int r, String key) {
         System.out.println(data[l][0]);
        if (l == r) {
            if (data[l][0].equals(key)) {
                return l;
            } else {
                return -1;
            }

        } else {
            int m = (l + r) / 2;
            if (data[m][0].equals(key)) {
                return m;
            } else if (data[m][0].compareToIgnoreCase(key) < 0) {
                return search(data, m + 1, r, key);
            }
            else
                return search(data,l,m-1,key);
        }

    }
}
