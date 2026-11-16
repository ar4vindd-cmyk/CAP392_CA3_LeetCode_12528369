class Solution {
    public String numberToWords(int num) {
        if (num == 0) return "Zero";

        String[] below20 = {
            "", "One", "Two", "Three", "Four", "Five",
            "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen",
            "Fifteen", "Sixteen", "Seventeen", "Eighteen",
            "Nineteen"
        };

        String[] tens = {
            "", "", "Twenty", "Thirty", "Forty",
            "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
        };

        String[] thousands = {
            "", "Thousand", "Million", "Billion"
        };

        StringBuilder result = new StringBuilder();
        int i = 0;

        while (num > 0) {
            int part = num % 1000;

            if (part != 0) {
                StringBuilder temp = new StringBuilder();

                if (part >= 100) {
                    temp.append(below20[part / 100])
                        .append(" Hundred");
                    part %= 100;

                    if (part > 0) temp.append(" ");
                }

                if (part >= 20) {
                    temp.append(tens[part / 10]);
                    part %= 10;

                    if (part > 0) temp.append(" ");
                }

                if (part > 0) {
                    temp.append(below20[part]);
                }

                if (i > 0) {
                    temp.append(" ").append(thousands[i]);
                }

                if (result.length() > 0) {
                    temp.append(" ").append(result);
                }

                result = temp;
            }

            num /= 1000;
            i++;
        }

        return result.toString();
    }
}