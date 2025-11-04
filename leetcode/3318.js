/**
 * @param {number[]} nums
 * @param {number} k
 * @param {number} x
 * @return {number[]}
 */
var findXSum = function (nums, k, x) {
  const arr = [];
  for (let i = 0; i <= 50; i++) {
    arr.push(0);
  }
  for (let i = 0; i < k; i++) {
    arr[nums[i]]++;
  }
  const ans = [];
  for (let i = 0; i <= nums.length - k; i++) {
    let sum = 0;
    let c = 0;
    for (let j = 1; j < arr.length; j++) {
      if (arr[j] > 0) {
        c++;
        sum += j * arr[j];
      }
    }
    if (c < x) {
      ans.push(sum);
    } else {
      sum = 0;
      c = 0;
      let cloneArr = [...arr];

      while (c < x) {
        let max = -1;
        let idx = -1;
        for (let j = cloneArr.length - 1; j >= 0; j--) {
          if (max < cloneArr[j]) {
            max = cloneArr[j];
            idx = j;
          }
        }
        sum += idx * max;
        cloneArr[idx] = 0;
        c++;
      }
      ans.push(sum);
    }
    arr[nums[i]]--;
    arr[nums[i + k]]++;
  }
  return ans;
};
console.log(findXSum([1, 1, 2, 2, 3, 4, 2, 3], 6, 2));
