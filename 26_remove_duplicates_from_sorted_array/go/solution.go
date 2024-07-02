package main

func removeDuplicates(nums []int) int {
    if len(nums) == 0 {
        return 0
    }

    uniqueIndex := 0
    for i := 1; i < len(nums); i++ {
        if nums[uniqueIndex] != nums[i] {
            uniqueIndex++
            nums[uniqueIndex] = nums[i]
        }
    }
    return uniqueIndex + 1
}
