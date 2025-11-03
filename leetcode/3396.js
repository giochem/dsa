/**
 * @param {number[]} nums
 * @return {number}
 */
var minimumOperations = function (nums) {
  const dict = {};
  let idx = 0;
  for (let i = nums.length - 1; i >= 0; i--) {
    if (dict[nums[i]] === undefined) {
      dict[nums[i]] = true;
    } else {
      idx = i + 1;
      break;
    }
  }
  return Math.trunc(idx / 3) + (idx % 3 !== 0 ? 1 : 0);
};
console.log(minimumOperations([1, 2, 3, 4, 2, 3, 3, 5, 7]));
