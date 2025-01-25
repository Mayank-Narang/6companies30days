class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> frequencyByNum = new HashMap<>();
        var left = 0;
        var maxLength = 0;

        for (var right = 0; right < nums.length; right++) {
            var num = nums[right];
            var frequency = frequencyByNum.compute(num, (key, value) -> value == null ? 1 : value + 1);

            while (frequency > k) {
                var leftNum = nums[left];
                var leftFrequency = frequencyByNum.computeIfPresent(leftNum, (key, value) -> value - 1);

                if (leftNum == num) {
                    frequency = leftFrequency;
                }

                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
