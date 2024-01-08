public class BinarySearch {
    public static void main(String[] args) {
        int[] prices = {13, 17, 19, 25, 25, 25, 25, 25, 25, 27, 30};

        System.out.println("Для 31: " + countMore(prices, 31)); // 0
        System.out.println("Для 26: " + countMore(prices, 26)); // 2
        System.out.println("Для 25: " + countMore(prices, 25)); // 2
        System.out.println("Для 20: " + countMore(prices, 20)); // 8
    }

    //Если в middle доступный товар, то искать нужно правее - left = middle + 1
    //Если в middle недоступный товар, то искать нужно левее - right = middle - 1

    public static int countMore(int[] prices, int money) {
        if (prices[0] > money) {
            return prices.length; // все недоступны
        }

        if (prices[prices.length - 1] < money) {
            return 0; // все доступны
        }

        int targetIndx = 0;
        int left = 0;
        int right = prices.length - 1;
        int middle = (left + right) / 2;
        while (left < right) {
            if (prices[middle] <= money) {
                targetIndx = middle;
                left = middle + 1;
                middle = left + (right - left) / 2;
            } else if (prices[middle] > money) {
                right = middle - 1;
                middle = (right - left) / 2 + 1;
            }
        }
        int countInaccessible = prices.length - targetIndx - 1;
        return countInaccessible;
    }
}