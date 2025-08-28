# https://leetcode.com/problems/sort-matrix-by-diagonals/description/
class Solution(object):
    def sortMatrix(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: List[List[int]]
        """
        n = len(grid)
        for i in range(n):
            # sort decreasing
            # find all value and sort -> then replace
            arr = []
            row = i
            for col in range(n):
                arr.append(grid[row][col])
                row += 1
                if(row >= n):
                    break
            arr.sort(reverse=True)
            # update sort grid
            row = i
            for col in range(n):
                grid[row][col] = arr.pop(0)
                row += 1
                if(row >= n): break

        for i in range(1, n):
            arr = []
            col = i
            for row in range(n):
                arr.append(grid[row][col])
                col += 1
                if(col >= n): break
            arr.sort()
            # update sort grid
            col = i
            for row in range(n):
                grid[row][col] = arr.pop(0)
                col += 1
                if(col >= n): break
        return grid
solution  = Solution()
print(solution.sortMatrix([[1,7,3],[9,8,2],[4,5,6]]))