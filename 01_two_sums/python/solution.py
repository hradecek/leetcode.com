#!/usr/bin/env python3
from typing import List

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        for hop in range(1, len(nums)):
            for i, first in enumerate(nums):
                if i + hop >= len(nums):
                    break
                second = nums[i + hop]
                if (first + second) == target:
                    return [i, i + hop]
        return Nil

