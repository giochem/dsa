/**
 * @param {string[]} words
 * @return {string[]}
 */
var findWords = function (words) {
  const f = "qwertyuiop";
  const s = "asdfghjkl";
  const t = "zxcvbnm";
  const arr = [];
  const res = [];
  for (let i = 97; i <= 122; i++) {
    arr.push(0);
  }
  for (let i = 0; i < s.length; i++) {
    arr[s.charCodeAt(i) - 97] = 1;
  }
  for (let i = 0; i < t.length; i++) {
    arr[t.charCodeAt(i) - 97] = 2;
  }
  for (let i = 0; i < words.length; i++) {
    const lowerWord = words[i].toLowerCase();
    const is = arr[lowerWord.charCodeAt(0) - 97];
    let j = 1;
    while (j < lowerWord.length && arr[lowerWord.charCodeAt(j) - 97] === is) {
      j++;
    }
    if (j === lowerWord.length) {
      res.push(words[i]);
    }
  }
  return res;
};
console.log(findWords(["asdfghjkl", "qwertyuiop", "zxcvbnm"]));
