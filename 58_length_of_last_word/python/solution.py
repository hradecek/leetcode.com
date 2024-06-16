#!/usr/bin/env python3
class Solution:
  def lengthOfLastWord(self, s: str) -> int:
    length = 0
    for c in reversed(s):
      if c == ' ':
        if length > 0:
          break
      else:
        length += 1
    return length

