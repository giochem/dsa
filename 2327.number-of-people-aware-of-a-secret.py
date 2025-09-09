class Solution(object):
    def peopleAwareOfSecret(self, n, delay, forget):
        """
        :type n: int
        :type delay: int
        :type forget: int
        :rtype: int
        """
        modulus = 10**9 + 7

        persons = []
        for i in range(1, n + 1):
            if len(persons) == 0:
                persons.append(1)
                continue
            if len(persons) == forget:
                # share
                persons.pop(0)
            shares = 0
            for j in range(0, len(persons)+1-delay):
                shares += persons[j]
            shares % modulus
            persons.append(shares)
        
        return sum(persons) % modulus

solution = Solution()
# print(solution.peopleAwareOfSecret(4,1,3))
# print(solution.peopleAwareOfSecret(6,2,4))
# print(solution.peopleAwareOfSecret(7,3,5))
print(solution.peopleAwareOfSecret(684,18,496))