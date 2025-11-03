/**
 * @param {string[]} garbage
 * @param {number[]} travel
 * @return {number}
 */
var garbageCollection = function (garbage, travel) {
  let m = 0;
  let p = 0;
  let g = 0;
  for (let i = garbage.length - 1; i >= 0; i--) {
    let j = 0;
    while (j < garbage[i].length) {
      if (garbage[i][j] === "M") {
        m++;
      } else if (garbage[i][j] === "P") {
        p++;
      } else if (garbage[i][j] === "G") {
        g++;
      }
      j++;
    }
  }
  const arr = [false, false, false];
  for (let i = garbage.length - 1; i >= 0; i--) {
    if (arr[0] === false && garbage[i].includes("M")) {
      for (let j = 0; j <= i - 1; j++) {
        m += travel[j];
      }
      arr[0] = true;
    }
    if (arr[1] === false && garbage[i].includes("P")) {
      for (let j = 0; j <= i - 1; j++) {
        p += travel[j];
      }
      arr[1] = true;
    }
    if (arr[2] === false && garbage[i].includes("G")) {
      for (let j = 0; j <= i - 1; j++) {
        g += travel[j];
      }
      arr[2] = true;
    }
  }
  return m + p + g;
};

console.log(garbageCollection(["G", "P", "GP", "GG"], [2, 4, 3]));
