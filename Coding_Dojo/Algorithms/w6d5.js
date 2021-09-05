// binarySearch(input, target ... ?)
// given an input (a array of sorted integers) and a target value to search for
// return true if the value is found in the array and false otherwise
// we gotta do this recursively!
// max of 4 parameters - any extras should have a default
// this will have a big O time complexity of log n
// https://www.bigocheatsheet.com/
// remember - ctrl-C to break a running program


function binarySearch(input, target, startpoint = 0, endpoint = input.length - 1) {

    var middle = Math.floor((startpoint + endpoint) / 2);
    console.log(`Start: ${startpoint}, middle: ${middle}, end: ${endpoint}`)
    if (input[startpoint] == target || input[endpoint] == target) {
        return true;
    }
    if (target < input[startpoint] || target > input[endpoint]) {
        return false;
    }
    if (input[middle] == target) {
        return true;
    }
    if (input[middle] > target) {
        return binarySearch(input, target, startpoint, middle - 1)
    }
    if (input[middle] < target) {
        return binarySearch(input, target, middle + 1, endpoint)
    }

}

var testArray = [1, 2, 4, 5, 6, 7, 8, 10, 11, 13, 14, 16, 17, 18, 20];

console.log(binarySearch(testArray, -1)); // returns false
console.log(binarySearch(testArray, 54)); // returns false
console.log(binarySearch(testArray, 3)); // returns false
console.log(binarySearch(testArray, 9)); // returns false
console.log(binarySearch(testArray, 12)); // returns false
console.log(binarySearch(testArray, 15)); // returns false
console.log(binarySearch(testArray, 19)); // returns false

console.log(binarySearch(testArray, 1)); // returns true
console.log(binarySearch(testArray, 2)); // returns true
console.log(binarySearch(testArray, 4)); // returns true
console.log(binarySearch(testArray, 5)); // returns true
console.log(binarySearch(testArray, 6)); // returns true
console.log(binarySearch(testArray, 7)); // returns true
console.log(binarySearch(testArray, 8)); // returns true
console.log(binarySearch(testArray, 10)); // returns true
console.log(binarySearch(testArray, 11)); // returns true
console.log(binarySearch(testArray, 13)); // returns true
console.log(binarySearch(testArray, 14)); // returns true
console.log(binarySearch(testArray, 16)); // returns true
console.log(binarySearch(testArray, 17)); // returns true
console.log(binarySearch(testArray, 18)); // returns true
console.log(binarySearch(testArray, 20)); // returns true