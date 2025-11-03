/**
 * @param {string} colors
 * @param {number[]} neededTime
 * @return {number}
 */
var minCost = function (colors, neededTime) {
  let sum = 0;
  let i = 0;

  while (i < colors.length - 1) {
    let maxi = 0;
    while (i < colors.length - 1 && colors[i] === colors[i + 1]) {
      sum += neededTime[i];
      maxi = Math.max(maxi, neededTime[i]);
      i++;
    }
    maxi = Math.max(maxi, neededTime[i]);
    sum += neededTime[i];
    if (maxi !== 0) {
      sum -= maxi;
    }
    i++;
  }
  return sum;
};
console.log(minCost("abaac", [1, 2, 3, 4, 5]));
