// Remove duplicate characters (case-sensitive) including
// punctuation. Keep only the last instance of each character
// and don't you dare use built in functions for this one!
// "Snaps! crackles! pops! -> Snrackle ops!"

const dedupe = (str) => {
    let outputString = "";
    // let usedCharacters = [];
    // let duplicatePositions = [];
    let useValue = true;
    for (let i = str.length - 1; i >= str.length -1; --i) {
        for (let j = 0; j < str.length - 1; j++) {
            if (str[i] !== str[j]) {
                outputString += str[j];
            }
            console.log(str[i]);
            console.log(str[j]);
        }
    return outputString;

        
    //     for (let j = 0; j < str.length - 1; --j) {
            
            
    //     }
    //     if () {
            
    //     }

    //     if   }

    // for (let i = str.length - 1; i >= 0; --i) {
    //     outputString = str[i] + outputString;
    //     usedCharacters.push(str[i]);
    // }
    // return outputString;

    // for (let index = 0; index < array.length; index++) {
    //     const element = array[index];
        
    // }
    // dedupe.forEach(element => {
    //     console.log(element)
    // });
}
// while (i > str.length) {
    
// }


}

console.log(dedupe("Snaps! crackles! pops!"));
console.log(dedupe("Did I shine my shoes today?"));
