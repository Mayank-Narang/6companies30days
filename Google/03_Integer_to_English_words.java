class Solution {
    public String numberToWords(int num) {
        if (num == 0) return "Zero";

        String[] big = {"", "Thousand", "Million", "Billion"};
        String[] single = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String[] ones = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

        StringBuilder result = new StringBuilder();
        int segmentIndex = 0;

        while (num > 0) {
            int segment = num % 1000; // Process 3 digits at a time
            if (segment != 0) {
                result.insert(0, processSegment(segment, single, ones, tens) + (segmentIndex > 0 ? " " + big[segmentIndex] : "") + " ");
            }
            num /= 1000;
            segmentIndex++;
        }

        return result.toString().trim();
    }

    private String processSegment(int num, String[] single, String[] ones, String[] tens) {
        StringBuilder segment = new StringBuilder();

        if (num >= 100) {
            segment.append(single[num / 100]).append(" Hundred ");
            num %= 100;
        }

        if (num >= 20) {
            segment.append(tens[num / 10]).append(" ");
            num %= 10;
        } else if (num >= 10) {
            segment.append(ones[num - 10]).append(" ");
            return segment.toString().trim();
        }

        if (num > 0) {
            segment.append(single[num]).append(" ");
        }

        return segment.toString().trim();
    }
}
