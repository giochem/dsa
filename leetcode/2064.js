/**
 * @param {number} n
 * @param {number[]} quantities
 * @return {number}
 */
var minimizedMaximum = function (n, quantities) {
  let maxi = -1;
  let sum = 0;
  for (let i = 0; i < quantities.length; i++) {
    sum += quantities[i];
    if (maxi < quantities[i]) {
      maxi = quantities[i];
    }
  }
  let l = Math.trunc(sum / n);
  let r = maxi;
  let ans = -1;
  while (l <= r) {
    let mid = Math.trunc((r + l) / 2);
    let c = 0;
    for (let j = 0; j < quantities.length; j++) {
      c +=
        Math.trunc(quantities[j] / mid) + (quantities[j] % mid !== 0 ? 1 : 0);
      if (c > n) {
        break;
      }
    }
    if (c <= n) {
      ans = mid;
      r = mid - 1;
    } else {
      l = mid + 1;
    }
  }
  return ans;
};
// console.log(minimizedMaximum(6, [11, 6]));
console.log(
  minimizedMaximum(22, [25, 11, 29, 6, 24, 4, 29, 18, 6, 13, 25, 30])
);
