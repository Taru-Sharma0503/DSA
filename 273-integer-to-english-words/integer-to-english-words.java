class Solution {
    HashMap<Integer, String> tensMap = new HashMap<>();
    HashMap<Integer, String> onesMap = new HashMap<>();

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        String number = Integer.toString(num);
        StringBuilder ans = new StringBuilder();
        int len = number.length(), idx = 0, zero = len - 1;

        onesMap.put(1, "One");
        onesMap.put(2, "Two");
        onesMap.put(3, "Three");
        onesMap.put(4, "Four");
        onesMap.put(5, "Five");
        onesMap.put(6, "Six");
        onesMap.put(7, "Seven");
        onesMap.put(8, "Eight");
        onesMap.put(9, "Nine");

        tensMap.put(2, "Twenty");
        tensMap.put(3, "Thirty");
        tensMap.put(4, "Forty");
        tensMap.put(5, "Fifty");
        tensMap.put(6, "Sixty");
        tensMap.put(7, "Seventy");
        tensMap.put(8, "Eighty");
        tensMap.put(9, "Ninety");

        tensMap.put(11, "Eleven");
        tensMap.put(12, "Twelve");
        tensMap.put(13, "Thirteen");
        tensMap.put(14, "Fourteen");
        tensMap.put(15, "Fifteen");
        tensMap.put(16, "Sixteen");
        tensMap.put(17, "Seventeen");
        tensMap.put(18, "Eighteen");
        tensMap.put(19, "Nineteen");

        buildNumber(number, ans, zero, idx);

        return ans.toString().trim();
    }

    public void buildNumber(String number, StringBuilder ans, int zero, int idx) {
        if (idx >= number.length()) {
            return;
        }

        int num = number.charAt(idx) - '0';

        if (zero == 9) {
            if (num != 0) {
                ans.append(onesMap.get(num)).append(" Billion ");
            }
            buildNumber(number, ans, zero - 1, idx + 1);
            return;
        }

        if (zero == 8) {
            if (num != 0) {
                ans.append(onesMap.get(num)).append(" Hundred");
                int next1 = number.charAt(idx + 1) - '0';
                int next2 = number.charAt(idx + 2) - '0';
                if (next1 == 0 && next2 == 0) {
                    ans.append(" Million ");
                } else {
                    ans.append(" ");
                }
            }
            buildNumber(number, ans, zero - 1, idx + 1);
            return;
        }

        if (zero == 7) {
            int next = number.charAt(idx + 1) - '0';
            boolean chunkNonZero = num != 0 || next != 0;

            if (num == 1) {
                int value = num * 10 + next;

                if (value == 10) {
                    ans.append("Ten ");
                } else {
                    ans.append(tensMap.get(value)).append(" ");
                }
            } else if (num != 0) {
                ans.append(tensMap.get(num));

                if (next != 0) {
                    ans.append(" ").append(onesMap.get(next));
                }

                ans.append(" ");
            } else if (next != 0) {
                ans.append(onesMap.get(next)).append(" ");
            }

            if (chunkNonZero) {
                ans.append("Million ");
            }
            buildNumber(number, ans, zero - 2, idx + 2);
            return;
        }

        if (zero == 6) {
            if (num != 0) {
                ans.append(onesMap.get(num)).append(" Million ");
            }
            buildNumber(number, ans, zero - 1, idx + 1);
            return;
        }

        if (zero == 5) {
            if (num != 0) {
                ans.append(onesMap.get(num)).append(" Hundred");
                int next1 = number.charAt(idx + 1) - '0';
                int next2 = number.charAt(idx + 2) - '0';
                if (next1 == 0 && next2 == 0) {
                    ans.append(" Thousand ");
                } else {
                    ans.append(" ");
                }
            }
            buildNumber(number, ans, zero - 1, idx + 1);
            return;
        }

        if (zero == 4) {
            int next = number.charAt(idx + 1) - '0';
            boolean chunkNonZero = num != 0 || next != 0;

            if (num == 1) {
                int value = num * 10 + next;

                if (value == 10) {
                    ans.append("Ten ");
                } else {
                    ans.append(tensMap.get(value)).append(" ");
                }
            } else if (num != 0) {
                ans.append(tensMap.get(num));

                if (next != 0) {
                    ans.append(" ").append(onesMap.get(next));
                }

                ans.append(" ");
            } else if (next != 0) {
                ans.append(onesMap.get(next)).append(" ");
            }

            if (chunkNonZero) {
                ans.append("Thousand ");
            }
            buildNumber(number, ans, zero - 2, idx + 2);
            return;
        }

        if (zero == 3) {
            if (num != 0) {
                ans.append(onesMap.get(num)).append(" Thousand ");
            }
            buildNumber(number, ans, zero - 1, idx + 1);
            return;
        }

        if (zero == 2) {
            if (num != 0) {
                ans.append(onesMap.get(num)).append(" Hundred ");
            }
            buildNumber(number, ans, zero - 1, idx + 1);
            return;
        }

        if (zero == 1) {
            int next = number.charAt(idx + 1) - '0';

            if (num == 1) {
                int value = num * 10 + next;

                if (value == 10) {
                    ans.append("Ten");
                } else {
                    ans.append(tensMap.get(value));
                }

                return;
            }

            if (num != 0) {
                ans.append(tensMap.get(num));

                if (next != 0) {
                    ans.append(" ").append(onesMap.get(next));
                }
            } else if (next != 0) {
                ans.append(onesMap.get(next));
            }

            return;
        }

        if (zero == 0) {
            if (num != 0) {
                ans.append(onesMap.get(num));
            }
        }
    }
}