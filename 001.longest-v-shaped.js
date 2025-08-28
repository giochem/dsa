// https://leetcode.com/problems/length-of-longest-v-shaped-diagonal-segment/description/
/**
 * @param {number[][]} grid
 * @return {number}
 */
const longestDialonal = (grid, row, col, follow, direction) => {
  let diagonal = 0;
  if (direction === "top-left to bottom-right") {
    while (
      row < grid.length &&
      col < grid[row].length &&
      grid[row][col] === follow
    ) {
      diagonal++;
      row++;
      col++;
      if (follow === 2) {
        follow = 0;
      } else {
        follow = 2;
      }
    }
  } else if (direction === "bottom-right to top-left") {
    while (row >= 0 && col >= 0 && grid[row][col] === follow) {
      diagonal++;
      row--;
      col--;
      if (follow === 2) {
        follow = 0;
      } else {
        follow = 2;
      }
    }
  } else if (direction === "top-right to bottom-left") {
    while (row < grid.length && col >= 0 && grid[row][col] === follow) {
      diagonal++;
      row++;
      col--;
      if (follow === 2) {
        follow = 0;
      } else {
        follow = 2;
      }
    }
  } else if (direction === "bottom-left to top-righ") {
    while (row >= 0 && col < grid[row].length && grid[row][col] === follow) {
      diagonal++;
      row--;
      col++;
      if (follow === 2) {
        follow = 0;
      } else {
        follow = 2;
      }
    }
  }
  return diagonal;
};
var lenOfVDiagonal = function (grid) {
  let maxDiagonalClockwise = 0;

  for (let i = 0; i < grid.length; i++) {
    for (let j = 0; j < grid[i].length; j++) {
      if (grid[i][j] === 1) {
        maxDiagonalClockwise = Math.max(maxDiagonalClockwise, 1);
        if (i - 1 >= 0 && j - 1 >= 0 && grid[i - 1][j - 1] === 2) {
          let row = i;
          let col = j;
          let diagonal = 1;
          let follow = 2;

          while (
            row - 1 >= 0 &&
            col - 1 >= 0 &&
            grid[row - 1][col - 1] === follow
          ) {
            diagonal++;
            row--;
            col--;
            if (follow === 2) {
              follow = 0;
            } else {
              follow = 2;
            }
            // check 90-degree turn
            if (
              row - 1 >= 0 &&
              col + 1 < grid[row].length &&
              grid[row - 1][col + 1] === follow
            ) {
              maxDiagonalClockwise = Math.max(
                maxDiagonalClockwise,
                diagonal +
                  longestDialonal(
                    grid,
                    row - 1,
                    col + 1,
                    follow,
                    "bottom-left to top-righ"
                  )
              );
            }
          }
          maxDiagonalClockwise = Math.max(maxDiagonalClockwise, diagonal);
        }

        if (i - 1 >= 0 && j + 1 < grid[i].length && grid[i - 1][j + 1] === 2) {
          let row = i;
          let col = j;
          let diagonal = 1;
          let follow = 2;
          while (
            row - 1 >= 0 &&
            col + 1 < grid[row].length &&
            grid[row - 1][col + 1] === follow
          ) {
            diagonal++;
            row--;
            col++;
            if (follow === 2) {
              follow = 0;
            } else {
              follow = 2;
            }
            if (
              row + 1 < grid.length &&
              col + 1 < grid[row].length &&
              grid[row + 1][col + 1] === follow
            ) {
              maxDiagonalClockwise = Math.max(
                maxDiagonalClockwise,
                diagonal +
                  longestDialonal(
                    grid,
                    row + 1,
                    col + 1,
                    follow,
                    "top-left to bottom-right"
                  )
              );
            }
          }
          maxDiagonalClockwise = Math.max(maxDiagonalClockwise, diagonal);
        }

        if (
          i + 1 < grid.length &&
          j + 1 < grid[i].length &&
          grid[i + 1][j + 1] === 2
        ) {
          let row = i;
          let col = j;
          let diagonal = 1;
          let follow = 2;
          while (
            row + 1 < grid.length &&
            col + 1 < grid[row].length &&
            grid[row + 1][col + 1] === follow
          ) {
            diagonal++;
            row++;
            col++;
            if (follow === 2) {
              follow = 0;
            } else {
              follow = 2;
            }
            // check 90-degree turn
            if (
              row + 1 < grid.length &&
              col - 1 >= 0 &&
              grid[row + 1][col - 1] === follow
            ) {
              maxDiagonalClockwise = Math.max(
                maxDiagonalClockwise,
                diagonal +
                  longestDialonal(
                    grid,
                    row + 1,
                    col - 1,
                    follow,
                    "top-right to bottom-left"
                  )
              );
            }
          }
          maxDiagonalClockwise = Math.max(maxDiagonalClockwise, diagonal);
        }

        if (i + 1 < grid.length && j - 1 >= 0 && grid[i + 1][j - 1] === 2) {
          let row = i;
          let col = j;
          let diagonal = 1;
          let follow = 2;

          while (
            row + 1 < grid.length &&
            col - 1 >= 0 &&
            grid[row + 1][col - 1] === follow
          ) {
            diagonal++;
            row++;
            col--;
            if (follow === 2) {
              follow = 0;
            } else {
              follow = 2;
            }
            // check 90-degree turn
            if (
              row - 1 >= 0 &&
              col - 1 >= 0 &&
              grid[row - 1][col - 1] === follow
            ) {
              maxDiagonalClockwise = Math.max(
                maxDiagonalClockwise,
                diagonal +
                  longestDialonal(
                    grid,
                    row - 1,
                    col - 1,
                    follow,
                    "bottom-right to top-left"
                  )
              );
            }
          }
          maxDiagonalClockwise = Math.max(maxDiagonalClockwise, diagonal);
        }
      }
    }
  }
  return maxDiagonalClockwise;
};

lenOfVDiagonal([
  [1, 0, 1, 2, 2, 1, 2],
  [0, 1, 2, 1, 2, 0, 0],
  [1, 0, 1, 1, 0, 0, 2],
]);
