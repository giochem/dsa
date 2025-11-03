/**
 * @param {string} s
 * @param {string} t
 * @return {character}
 */
var findTheDifference = function (s, t) {
  let arr = [];
  for (let i = 0; i < 35; i++) {
    arr.push(0);
  }
  for (let i = 0; i < s.length; i++) {
    arr[s.charCodeAt(i) - 97]++;
  }
  for (let i = 0; i < t.length; i++) {
    if (arr[t.charCodeAt(i) - 97] === 0) {
      return t[i];
    } else {
      arr[t.charCodeAt(i) - 97]--;
    }
  }
};
