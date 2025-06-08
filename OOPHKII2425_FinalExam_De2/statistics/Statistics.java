package hus.oop.statistics;

import java.util.Arrays;

public class Statistics {
    private MyList data;

    /**
     * Khởi tạo dữ liệu cho BasicStatistic.
     */
    public Statistics(MyList data) {
        this.data = data;
    }

    /**
     * Lấy giá trị lớn nhất trong list.
     * @return giá trị lớn nhất.
     */
    public double max() {
        double max = Double.NEGATIVE_INFINITY;
        MyIterator iterator = data.iterator(0);
        while (iterator.hasNext()) {
            double value = iterator.next().doubleValue();
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    /**
     * Lấy giá trị nhỏ nhất trong list.
     * @return giá trị nhỏ nhất.
     */
    public double min() {
        double min = Double.POSITIVE_INFINITY;
        MyIterator iterator = data.iterator(0);
        while (iterator.hasNext()) {
            double value = iterator.next().doubleValue();
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    /**
     * Tính kỳ vọng của mẫu theo dữ liệu trong list.
     * @return kỳ vọng.
     */
    public double mean() {
        double sum = 0;
        int count = 0;
        MyIterator iterator = data.iterator(0);
        while (iterator.hasNext()) {
            sum += iterator.next().doubleValue();
            count++;
        }
        return sum / count;
    }

    /**
     * Tính phương sai của mẫu theo dữ liệu trong list.
     * @return phương sai.
     */
    public double variance() {
        double mean = mean();
        double sumSquaredDifferences = 0;
        int count = 0;
        MyIterator iterator = data.iterator(0);
        while (iterator.hasNext()) {
            double value = iterator.next().doubleValue();
            sumSquaredDifferences += Math.pow(value - mean, 2);
            count++;
        }
        return sumSquaredDifferences / count;
    }

    /**
     * Tìm kiếm trong list có phẩn tử nào có giá trị bằng data không, sử dụng binarySearch trong list.
     * Trả về index một phần tử có giá trị bằng data, nếu không tìm thấy thì trả về -1.
     * @return
     */
    public int search(double data) {
        if (this.data instanceof MyArrayList) {
            MyArrayList sortedList = (MyArrayList) this.data.sortIncreasing();
            return sortedList.binarySearch(data);
        } else if (this.data instanceof MyLinkedList) {
            MyLinkedList sortedList = (MyLinkedList) this.data.sortIncreasing();
            return sortedList.binarySearch(data);
        }
        return -1;
    }

    /**
     * Tính rank của các phần tử trong list.
     * @return rank của các phần tử trong list
     */
    public double[] rank() {
        int size = data.size();
        double[] values = new double[size];
        double[] ranks = new double[size];

        // Lưu các giá trị trong mảng values
        MyIterator iterator = data.iterator(0);
        int index = 0;
        while (iterator.hasNext()) {
            values[index++] = iterator.next().doubleValue();
        }

        double[] sortedValues = Arrays.copyOf(values, values.length);
        Arrays.sort(sortedValues);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (values[i] == sortedValues[j]) {
                    ranks[i] = j + 1;
                    break;
                }
            }
        }

        return ranks;
    }
}
