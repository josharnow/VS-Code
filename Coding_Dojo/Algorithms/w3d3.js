// generateCoinChange(input)
// input is an integer representing an amount of money
// output is an object representing the most optimal
// (i.e. fewest coins) way to represent that amount
// with standard U.S. coins
// if the input is 74 cents, the output would be:
// {quarters: 2, dimes: 2, nickels: 0, pennies: 4}
// if the input is 109 cents, the output would be:
// {quarters: 4, dimes: 0, nickels: 1, pennies: 4}





function generateCoinChange(input) {
    let remain1 = input % 25;
    let remain2 = remain1 % 10;
    let remain3 = remain2 % 5;
    let quarters = 0;
    let dimes = 0;
    let nickels = 0;
    let pennies = 0;

    if (remain1 === 0) {
        let quarters = input / 25;
    } else if (remain2 === 0) {
        let quarters = (input - remain1) / 25;
        let dimes = remain1;
    } else if (remain3 === 0) {
        let quarters = (input - remain1) / 25;
        let dimes = remain1 / 10;
        let nickels = remain2;
    }
    // } else {
    //     let pennies = remain3;
    // }

    return(quarters, dimes, nickels, pennies);

    // print
    // let d = q;
    // let n = 5;
    // let p = 1;
    // input 



    // if (input % q == 0) {

    //     let remain

    //     numQ = input / q;
    // } else if (input % d == 0) {
    //     numD = input
    // }

    // console.log(numQ);
}
console.log(generateCoinChange(100));


// (q + d + n + p) == input

// try out your own cases!
console.log(generateCoinChange(74))

// generateCoinChangeWithGivenValues(input, values)
// input is an integer representing an amount of money
// values is an array of arrays - each array represents a
// denomination of currency (string) and its value (integer)
// (a denomination of 1 will always be present)
// that array is in order of denomination
// the output is an object representing the most optimal
// way to represent that amount given the denominations
// if the input is 127 cents, and the values are:
// [ ['metadime', 15],
//  ['supernickel', 6]
//  ['very regular penny', 1]]
// the output would be:
// {metadimes: 8, supernickels: 1, very regular pennys: 1}
// (note the pluralization)
// if the input was 127, but the values were:
// [ ['halfquarter', 12],
//  ['greater nickel', 8],
//  ['lesser dime', 3]
//  ['just-a-penny', 1]]
// the output would be:
// {halfquarters: 10, greater nickels: 0, lesser dimes: 2, just-a-pennys: 0}
// if the input was 127, but the values were:
// [ ['half-dollar', 50],
//  ['dime', 10],
//  ['nickel', 5]
//  ['penny', 1]]
// the output would be:
// {'half-dollars': 2, 'dimes': 2, 'nickels': 1, 'pennys': 2}
// (these values -could- be an object, a set of key-value pairs,
// but I want to get you used to the concept of arrays within arrays
// and accessing that data within them)
//
// bonus: what would you do if we couldn't guarantee a denomination of 1
// being present? there are a few different answers, none strictly 'correct'

function generateCoinChangeWithGivenValues(input, values) {

}

generateCoinChangeWithGivenValues(52, [['halfquarter', 12], ['greater nickel', 8], ['lesser dime', 3], ['just-a-penny', 1]]);