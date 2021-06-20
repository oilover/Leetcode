from typing import Dict, List


class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        right = {}
        for i,ch in enumerate(s):
            right[ch] = i
        print(right)

s = Solution()
s.partitionLabels("sadfas")
