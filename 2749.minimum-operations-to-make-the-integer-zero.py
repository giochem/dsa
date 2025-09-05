#
# @lc app=leetcode id=2749 lang=python
#
# [2749] Minimum Operations to Make the Integer Zero
#

# @lc code=start
class Solution(object):
    def makeTheIntegerZero(self, num1, num2):
        # num1 - (2^i_1 + num2) - (2^i_2 + num2) - ... - (2^i_k + num2) = 0
        # num1 = 2^i_1 + num2 + 2^i_2 + num2 + ... + 2^i_k + num2
        # num1 - k * num2 = 2^i_1 + 2^i_2 + ... + 2^i_k
        # both must >=1
        k = 1
        while True:
            x = num1 - num2 * k
            if x < k:
                return -1
            if k >= x.bit_count(): # x.bit_count() -> min to create 2^i
                return k
            k += 1
# solution = Solution()
# print(solution.makeTheIntegerZero(5, -21))
# @lc code=end

# 5, -21 -> 26, -21 -> 47
# 2^i
#  15 -> 16 -> 0
# 17 -> 16 -> 0