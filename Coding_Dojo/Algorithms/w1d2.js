// predict the output 1
// var a = 25;
// a = a - 13;
// console.log(a/2);

// a = "hello";
// console.log(a + "hello");
// // 6 hello hello

// for(var i=0; i<10; i++) {
//     console.log(i);
//     i = i + 3;
// }

// console.log("outside of the loop" + i);

function getTotal(arrayOfNumbers) {

    var sum = arrayOfNumbers[0];

    for(var i=0; i<arrayOfNumbers.length; i++) {
        sum += arrayOfNumbers[i]
        console.log("the current sum is: " + sum);
    }
    console.log("the total is: " + sum);

}

getTotal([1,3,5]);
// sum = 1 --> 2 --> 5 --> 10
// i = 0 --> 1 --> 2 --> 3
// arrayOfNumbers.length = 3