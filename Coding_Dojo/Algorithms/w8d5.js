const stringToWordArray = (str) => {
    arr = []
    word = ""
    for (let i = 0; i < str.length; i++) {
        if (str[i] !== " ") {
            word += str[i];
        }
        if (str[i] === " " && str[i + 1] !== " ") {
            // word += '"'
            arr.push(word);
            word = "";
        }

    }
    if (word.length > 0) {
        arr.push(word);
    }

    return arr;
}


const reverseWordOrder = (str) => {
    arr = []
    word = ""
    for (let i = 0; i < str.length; i++) {
        if (str[i] !== " ") {
            word += str[i];
        }
        if (str[i] === " " && str[i + 1] !== " ") {
            // word += '"'
            arr.push(word);
            word = "";
        }

    }
    if (word.length > 0) {
        arr.push(word);
        word = ""
    }

    for (let i = arr.length - 1; i >= 0; i--) {
        word += arr[i];
        word += " ";
    }

    return word;
}