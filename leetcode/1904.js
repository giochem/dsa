/**
 * @param {string} loginTime
 * @param {string} logoutTime
 * @return {number}
 */
var numberOfRounds = function (loginTime, logoutTime) {
  let [loginH, loginM] = loginTime.split(":").map((e) => Number(e));
  let [logoutH, logoutM] = logoutTime.split(":").map((e) => Number(e));
  let over = false;
  if (loginH <= logoutH && loginM <= logoutM) {
    over = true;
  }
  if (0 < loginM && loginM < 15) {
    loginM = 15;
  } else if (15 < loginM && loginM < 30) {
    loginM = 30;
  } else if (30 < loginM && loginM < 45) {
    loginM = 45;
  } else if (45 < loginM && loginM < 60) {
    loginM = 0;
    loginH += 1;
  }
  if (0 < logoutM && logoutM < 15) {
    logoutM = 0;
  } else if (15 < logoutM && logoutM < 30) {
    logoutM = 15;
  } else if (30 < logoutM && logoutM < 45) {
    logoutM = 30;
  } else if (45 < logoutM && logoutM < 60) {
    logoutM = 45;
  }
  let rounds = 0;
  if (over && (loginH > logoutH || (loginH == logoutH && loginM > logoutM))) {
    return rounds;
  }
  if (loginH > logoutH || (loginH == logoutH && loginM > logoutM)) {
    while (loginH <= 23 && loginM <= 45) {
      rounds++;
      loginM += 15;
      if (loginM >= 60) {
        loginH++;
        loginM -= 60;
      }
    }
    loginH = 0;
  }
  while (loginH < logoutH || (loginH === logoutH && loginM < logoutM)) {
    rounds++;
    loginM += 15;
    if (loginM >= 60) {
      loginM -= 60;
      loginH++;
    }
  }
  return rounds;
};
console.log(numberOfRounds("21:30", "03:00"));
