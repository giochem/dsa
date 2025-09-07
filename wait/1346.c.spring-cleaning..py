# https://codeforces.com/contest/1346/problem/C
class Solution(object):
    def springCleaning(self, arr, k, x, y):
        arr.sort(reverse=True)
        sum_arr = sum(arr)
        max_sum = k * len(arr)
        i = 0
        min_seconds = 0
        min_distrubute = float('inf')
        while max_sum < sum_arr or (i < len(arr) and arr[i] > k):
            if max_sum >= sum_arr:
                min_distrubute = min(min_distrubute, min_seconds + y)
            if arr[i] > k:
                sum_arr -= arr[i]
                min_seconds += x
            i += 1
        return min(min_seconds, min_distrubute)
solution = Solution()

t = int(input())
for i in range(t):
    n, k, x, y = list(map(int, input().split(' ')))
    arr =  list(map(int, input().split(' ')))
    print(solution.springCleaning(arr, k, x, y))