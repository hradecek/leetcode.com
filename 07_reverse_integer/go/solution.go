package main

import "math"

func willOverflow(x int, digit int) bool {
    return x > (math.MaxInt32/10) || (x == math.MaxInt32/10 && digit > 7) || 
        x < (math.MinInt32/10) || (x == math.MinInt32/10 && digit < -8)
}

func reverse(x int) int {
    result := 0

    for x != 0 {
        digit := x % 10
        x /= 10

        if willOverflow(result, digit) {
            return 0
        }

        result = result * 10 + digit
    }

    return result
}

