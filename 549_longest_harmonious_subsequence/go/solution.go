package main

func createFrequencyMap(nums []int) map[int]int {
    counts := make(map[int]int)
    for i := 0; i < len(nums); i++ {
        counts[nums[i]]++
    }
    return counts
}

func findLHS(nums []int) int {
    counts := createFrequencyMap(nums)
    lhs := 0
    for number, count := range counts {
        if neighborCount, exists := counts[number - 1]; exists {
            lhs = max(lhs, neighborCount + count)
        }
        if neighborCount, exists := counts[number + 1]; exists {
            lhs = max(lhs, neighborCount + count)
        }
    }

    return lhs
}

