#include <stdio.h>

int main() {
    int n;
    scanf("%d", &n);

    int dp[n];

    dp[0] = 1; dp[1] = 1;

    for (int i = 2; i < n; i++) {
        dp[i] = dp[i - 2] + dp[i - 1];
    }

    printf("%d", dp[n - 1]);
    return 0;
}