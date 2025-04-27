package hospitalmanagementsystem;

public class QuickSort {
    // Public method to start sorting and return the sorted array

    String[][] newdata;

    public String[][] sort(String[][] data, String order) {
        newdata = data;

        Sort(0, data.length - 1, order);

        return newdata;
    }

    public void Sort(int l, int r, String order) {
        if (l < r) {
            int p = partition(l, r, order);
            Sort(l, p - 1, order);
            Sort(p + 1, r, order);
        }
    }

    public int partition(int l, int r, String order) {
        int x = l ;
        int y = r;

        String[] pivot = newdata[l];

        while (x<y) {
            // Move x to the right as long as elements are less than or equal to pivot
            if (order.equalsIgnoreCase("Ascending")) {
                while (x <= r && newdata[x][1].compareToIgnoreCase(pivot[1]) <= 0) {
                    x++;
                }

                // Move y to the left as long as elements are greater than pivot
                while (y >= l + 1 && newdata[y][1].compareToIgnoreCase(pivot[1]) > 0) {
                    y--;
                }
            } else {
                while (x <= r && newdata[x][1].compareToIgnoreCase(pivot[1]) >= 0) {
                    x++;
                }

                // Move y to the left as long as elements are greater than pivot
                while (y >= l + 1 && newdata[y][1].compareToIgnoreCase(pivot[1]) < 0) {
                    y--;
                }
            }

            // If x crosses y, stop
            if (x < y) {
    // Swap x and y
            String[] temp = newdata[x];
            newdata[x] = newdata[y];
            newdata[y] = temp;
            }

        
        }

        // Swap pivot with y
        newdata[l] = newdata[y];
        newdata[y] = pivot;

        return y;
    }

    public static void main(String[] args) {
//        String[][] data = {{"101", "Lanish"}, {"102", "Raj"}, {"103", "Sameer"}, {"104", "Akash"}, {"102", "Yelan"},};
//        QuickSort q = new QuickSort();
//        String[][] sort1 = q.sort(data, "Ascending");
//        for (String[] row : sort1) {
//            System.out.println(row[0] + " " + row[1]);
//        }
//        System.out.println("\n");
//        String[][] sort2 = q.sort(data, "Descending");
//        for (String[] row : sort2) {
//            System.out.println(row[0] + " " + row[1]);
//        }
//        
    }
}
