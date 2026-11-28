class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] freq = new int[n + 1];
        int minPrice = Integer.MAX_VALUE;
        for (int[] item : items) {
            freq[item[0]]++;
            minPrice = Math.min(minPrice, item[1]);
        }
        int[] gain = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j += i) {
                gain[i] += freq[j];
            }
            gain[i]--;
        }
        int[][] candidates = new int[n][2];
        int size = 0;
        for (int[] item : items) {
            int factor = item[0];
            int price = item[1];
            if (gain[factor] > 0 && price < 2L * minPrice) {
                candidates[size][0] = price;
                candidates[size][1] = gain[factor];
                size++;
            }
        }
        java.util.Arrays.sort(candidates, 0, size,
            (a, b) -> Integer.compare(a[0], b[0]));
        long ans = 0;
        long remaining = budget;
        for (int i = 0; i < size; i++) {
            long price = candidates[i][0];
            long count = candidates[i][1];
            long buy = Math.min(count, remaining / price);
            ans += buy * 2;
            remaining -= buy * price;
        }
        ans += remaining / minPrice;
        return (int) ans;
    }
}