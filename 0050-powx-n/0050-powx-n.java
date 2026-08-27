class Solution {
    public double myPow(double x, int n) {

        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            return 1 / myPow(x, -(n + 1)) / x;
        }

        double halfpower = myPow(x, n / 2);
        double halfpowersq = halfpower * halfpower;

        if (n % 2 != 0) {
            halfpowersq = x * halfpowersq;
        }

        return halfpowersq;
    }
}