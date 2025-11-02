/**
 * @param {number} x
 * @param {number} y
 * @param {number} bound
 * @return {number[]}
 */
var powerfulIntegers = function (x, y, bound) {
  if (x === 1 && y === 1) {
    if (bound >= 2) {
      return [2];
    }
    return [];
  } else if (x === 1) {
    let arr = new Set();
    let i = 0;
    let sum = Math.pow(y, i) + 1;
    while (sum <= bound) {
      arr.add(sum);
      i++;
      sum = Math.pow(y, i) + 1;
    }
    return [...arr];
  } else if (y === 1) {
    let arr = new Set();
    let i = 0;
    let sum = Math.pow(x, i) + 1;
    while (sum <= bound) {
      arr.add(sum);
      i++;
      sum = Math.pow(x, i) + 1;
    }
    return [...arr];
  }
  let arr = new Set();
  let i = 0;
  let powerX = Math.pow(x, i);
  while (powerX < bound) {
    let j = 0;
    let powerY = Math.pow(y, j);
    while (powerY + powerX <= bound) {
      arr.add(powerY + powerX);
      j++;
      powerY = Math.pow(y, j);
    }
    i++;
    powerX = Math.pow(x, i);
  }
  return [...arr];
};

console.log(powerfulIntegers(2, 1, 10));

console.log(powerfulIntegers(2, 3, 10));
