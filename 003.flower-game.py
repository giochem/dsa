# https://leetcode.com/problems/alice-and-bob-playing-flower-game/description/
class Solution:
    def flowerGame(self, n: int, m: int) -> int:
        # 5 6
        # 2 4 - 1 3 5
        # 1 3 5 - 2 4 6
        # odd/ even
        n_even = n // 2
        m_odd = (m + 1) // 2 
        even_odd = n_even * m_odd

        n_odd  = (n + 1) // 2
        m_even = m // 2
        odd_even = n_odd * m_even

        total_pairs =  even_odd + odd_even
        return total_pairs


solution = Solution()
print(solution.flowerGame(3, 2))
print(solution.flowerGame(1, 1))