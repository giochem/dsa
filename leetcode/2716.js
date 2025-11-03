/**
 * @param {string} s
 * @return {number}
 */
var minimizedStringLength = function (s) {
  const arr = [];
  for (let i = 0; i < 35; i++) {
    arr.push(0);
  }
  for (let i = 0; i < s.length; i++) {
    arr[s.charCodeAt(i) - 97]++;
  }
  let c = 0;
  for (let i = 0; i < arr.length; i++) {
    if (arr[i] !== 0) {
      c++;
    }
  }
  return c;
};
