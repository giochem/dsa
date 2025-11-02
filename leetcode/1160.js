/**
 * @param {string[]} words
 * @param {string} chars
 * @return {number}
 */
var countCharacters = function (words, chars) {
  let arr = [];
  for (let i = 0; i < 122 - 97 + 1; i++) {
    arr.push(0);
  }
  for (let i = 0; i < chars.length; i++) {
    const idx = chars.charCodeAt(i) - 97;
    arr[idx]++;
  }
  let count = 0;
  for (let i = 0; i < words.length; i++) {
    let good = true;
    let cloneArr = [...arr];
    for (let j = 0; j < words[i].length; j++) {
      cloneArr[words[i].charCodeAt(j) - 97]--;
      if (cloneArr[words[i].charCodeAt(j) - 97] < 0) {
        good = false;
        break;
      }
    }
    if (good) {
      count += words[i].length;
    }
  }
  return count;
};
