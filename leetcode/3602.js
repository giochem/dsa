/**
 * @param {number} n
 * @return {string}
 */
var concatHex36 = function (n) {
  let hexadecimal = "";
  let hexatrigesimal = "";
  let n2 = Math.pow(n, 2);
  let n3 = Math.pow(n, 3);
  const hexa = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, "A", "B", "C", "D", "E", "F"];
  const hexatri = [
    "0",
    "1",
    "2",
    "3",
    "4",
    "5",
    "6",
    "7",
    "8",
    "9",
    "A",
    "B",
    "C",
    "D",
    "E",
    "F",
    "G",
    "H",
    "I",
    "J",
    "K",
    "L",
    "M",
    "N",
    "O",
    "P",
    "Q",
    "R",
    "S",
    "T",
    "U",
    "V",
    "W",
    "X",
    "Y",
    "Z",
  ];

  while (n2 !== 0) {
    hexadecimal = String(hexa[n2 % 16]) + hexadecimal;
    n2 = Math.trunc(n2 / 16);
  }
  while (n3 !== 0) {
    hexatrigesimal = String(hexatri[n3 % 36]) + hexatrigesimal;
    n3 = Math.trunc(n3 / 36);
  }
  return hexadecimal + hexatrigesimal;
};
console.log(concatHex36(36));
