const balancePoint = (arr) => {
  if (arr.length < 1)
    return false
  let sum = 0
  arr.forEach(value => sum += value)
  let counterSum = 0
  for (var i = 0; i < arr.length - 1; i++) {
    sum -= arr[i]
    counterSum += arr[i]
    if (sum == counterSum)
      return true;
  }
  return false;
}

console.log(balancePoint([1, 2, 3, 4, 10])) // TRUE
// ---> 1+2+3+4 = 10     10 == 10 so balanced
console.log(balancePoint([1, 2, 3, 2, 1])) // FALSE
console.log(balancePoint([1, 2, 3, 1, 2, 3, 2, 1])) // FALSE
console.log(balancePoint([2, 2])) // TRUE

const balanceIndex = (arr) => {
  if (arr.length < 2)
    return false
letr sum = 0
  arr.forEach(value => sum += value)
  let counterSum = 0
  sum -= arr[0]
  for (let i = 1; i < arr.length - 1; i++) {
    sum -= arr[i]
    counterSum += arr[i - 1]
    if (sum == counterSum)
      return true;
  }
  return false;
}

console.log(balanceIndex([-2, 5, 7, 0, 3]))  // TRUE
console.log(balanceIndex([9, 9])) // FALSE
console.log(balanceIndex([4, 2, 2, 6])) // TRUE
console.log(balanceIndex([9, 1, 9])) // TRUE
console.log(balanceIndex([1, 8, 1, 2, 3, 4])) // TRUE