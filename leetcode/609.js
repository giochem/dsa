/**
 * @param {string[]} paths
 * @return {string[][]}
 */
var findDuplicate = function (paths) {
  let dict = {};
  for (let path of paths) {
    const format = path.split(" ");
    const root = format[0];
    for (let i = 1; i < format.length; i++) {
      const file = format[i].split("(");
      const fileName = root + "/" + file[0];
      const content = file[1].substring(0, file[1].length - 1);
      if (dict[content] !== undefined) {
        dict[content].push(fileName);
      } else {
        dict[content] = [fileName];
      }
    }
  }
  let duplicate = [];
  for (const val of Object.values(dict)) {
    if (val.length >= 2) {
      duplicate.push(val);
    }
  }
  return duplicate;
};
console.log(
  findDuplicate([
    "root/a 1.txt(abcd) 2.txt(efgh)",
    "root/c 3.txt(abcd)",
    "root/c/d 4.txt(efgh)",
    "root 4.txt(efgh)",
  ])
);
