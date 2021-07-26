// var left = ["A, B, C, D, E"]
// // var right = ["E, D, C, B, A"]
// // var temp = arr[left]
// var right = left

// function reverse(arr) {
//     for (var left = 0; left < arr.length / 2; left++) {
//         var right = left.length - 1 - left;
//         if (arr.length < ) {
            
//         }
//         }
//     }


// console.log(right);

var arr = [1,"blue",3,true,5,6,7,8,9,10]

function reverse(arr) {
    for(var i=0; i< Math.floor(arr.length/2); i++) {
        // Both above and below are valid methods to make most efficient loop (i.e. instead of using arr.length / 2, which runs loop one additional time than necessary)
    // for (var i = 0; i < arr.length / 2.5; i++) {
        var temp = arr[i];
        // places array value at "i" in placeholder
        // var position = arr.length - i - 1;
        arr[i] = arr[arr.length - i - 1]
        // Dynamically adjusts position down by 1
        arr[arr.length - i - 1] = temp;
        // arr[i] = arr[position];
        // arr[position] = temp;
    }
}

reverse(arr);
console.log(arr);