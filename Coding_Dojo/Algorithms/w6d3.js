// inOrderCombinations(input, output, ...?)
// input is a string
// return an array with all strings you could make with the characters from the
// given input, in the order that they're presented - this is your output
// (output array order doesn't matter)
// "abc" -> ["", "c", "b", "bc", "a", "ac", "ab", "abc"] (8)
// "zhk" -> ["", "z", "h", "k", "hk", "zh", "zk", "zhk"] (8)
// "hjj" -> ["", "h", "j", "j", "hj", "hj", "jj", "hjj"]
// "tkps" -> ["", "t", "k", "p", "s", "tk", "tp", "ts", "kp", "ks", "ps",
// "tkp", "tks", "tps", "kps", "tkps"] (16)
// input of length n leads to 2^n output elements
// every character in the output appears with equal occurance
// test with at least 4 characters in input
// make sure to use recursion
// don't forget a base case to end recursion
//
// your parameters... maybe three, maybe four?
// suggestions:
// a parameter to keep track of which letter you're looking at?
// a parameter to keep track of the string you're building from call to call?
// other parameters probably have a default too


// tkps: each letter appears once
// if selecting any letter, 50% chance of containing any letter
// each character is present/not present in any output string

function inOrderCombinations(input, x = 0, output = [""]) {
    for (let i = 0; i < input.length; i++) {
        
        console.log(output);
        console.log(input[i]);

        
        output.push(input[i]);
        if (input[i] < input[i+1]) {
            inOrderCombinations[i+1]
            output.push()
        // }
        console.log(output)
    }
    return output;
}

var x = inOrderCombinations('tkps')
console.log(x.length == 16);