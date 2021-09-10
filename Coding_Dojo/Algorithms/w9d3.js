const encode = (str) => {
    var output = "";
    var count = 1;
    output += str[0];
    for (var i = 1; i < str.length; ++i) {
        if (str[i] === str[i - 1]) {
            ++count;
        } else {
            output += count;
            output += str[i];
            count = 1;
        }
    }
    output += count;
    return output;
}

console.log(encode("aaabbccccaacaa"));
console.log(encode("ddddeeeeeffgggg"));
console.log(encode("aaaaabbbbbbbc"));
console.log(encode("bb"));

//given an encoded string, decode and return it
//given "a3b2c1d3" return "aaabbcddd"
//parseInt() is ok
//special note: can your function handle "g14f12"?

const decode = (str) => {
    var output = ""
    var num = ""
    var char = "";
    for (var i = 0; i < str.length; ++i) {
        console.log(`str[i] ${str[i]}`)
        if (!isNaN(str[i])) {
            num += str[i];
            console.log(`num ${num}`);
        } else {
            output += char.repeat(parseInt(num));
            char = str[i];
            num = "";
        }
    }
    output += char.repeat(parseInt(num));
    return output;
}

console.log(decode("a3b2c4"));
console.log(decode("t2h10j4"));