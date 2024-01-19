import math
from typing import List


class Solution:
    reference: int = 0

    # recursion works pretty worse than usual loop
    def search_rec(self, nums: List[int], target: int) -> int:
        if not nums or (len(nums) == 1 and not nums[0]) == target:
            return -1
        i = int(len(nums) / 2)
        if nums[i] == target:
            self.reference += i
            return self.reference
        elif nums[i] > target:
            return self.search(nums[:i], target)
        else:
            self.reference = self.reference + i
            return self.search(nums[i:], target)

    def search(self, nums: List[int], target: int) -> int:
        start, end = 0, len(nums) - 1
        while start <= end:
            if start == end and not nums[start] == target:
                return -1
            mid = (int((start + end) / 2))
            if nums[mid] == target:
                return mid
            if nums[mid] < target:
                start = mid + 1
            else:
                end = mid
        else:
            return -1


if __name__ == '__main__':
    print(Solution().search([-1, 0, 3, 5, 9, 12], 12))
