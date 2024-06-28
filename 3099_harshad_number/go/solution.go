package main

func sumDigits(x int) int {
    sum := 0
    number := x
    for number > 0 {
        sum += number % 10
        number /= 10
    }
    return sum
}

func sumOfTheDigitsOfHarshadNumber(x int) int {
    if x == 0 {
        return -1
    }

    sum := sumDigits(x)
    if x % sum == 0 {
        return sum
    }
    return -1
}

