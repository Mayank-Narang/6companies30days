class Solution {

    private long[] find(int[] arr) {
        int n = arr.length;
        long sum = 0;
        long sumOfSquares = 0;
        long expectedSum = n * (n + 1L) / 2;
        long expectedSumOfSquares = n * (n + 1L) * (2L * n + 1L) / 6;

        for (int num : arr) {
            sum += num;
            sumOfSquares += (long) num * num;
        }

        return new long[]{sum, sumOfSquares, expectedSum, expectedSumOfSquares};
    }

    ArrayList<Integer> findTwoElement(int arr[]) {
        long[] result = find(arr);
        long actualSum = result[0];
        long actualSumOfSquares = result[1];
        long expectedSum = result[2];
        long expectedSumOfSquares = result[3];

        long sumDiff = expectedSum - actualSum;
        long squareSumDiff = expectedSumOfSquares - actualSumOfSquares;
        
        long sumOfNums = squareSumDiff / sumDiff;
        long missing = (sumDiff + sumOfNums) / 2;
        long repeated = sumOfNums - missing;

        ArrayList<Integer> resultArray = new ArrayList<>();
        resultArray.add((int) repeated);
        resultArray.add((int) missing);
        return resultArray;
    }
}
