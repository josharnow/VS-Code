# Basic - Print all integers from 0 to 150.

x = range(151)
for n in x:
    print(n)

# Multiples of Five - Print all the multiples of 5 from 5 to 1,000

x = range(5, 1001, 5)

for n in x:
    print(n)

# Counting, the Dojo Way - Print integers 1 to 100. If divisible by 5, print "Coding" instead. If divisible by 10, print "Coding Dojo".


x = range(1, 101)

for n in x:
    if n % 5 == 0:
        if n % 10 == 0:
            print("Coding Dojo")
        else:
            print("Coding")
    else:
        print(n)

# Whoa. That Sucker's Huge - Add odd integers from 0 to 500,000, and print the final sum.

x = range(500001)
odd = 0

for n in x:
    if n % 2 == 1:
        odd += n

print(odd)

# Countdown by Fours - Print positive numbers starting at 2018, counting down by fours.

x = range(2018, -1, -4)

for n in x:
    print(n)


# Flexible Counter - Set three variables: lowNum, highNum, mult. Starting at lowNum and going through highNum, print only the integers that are a multiple of mult. For example, if lowNum=2, highNum=9, and mult=3, the loop should print 3, 6, 9 (on successive lines)

lowNum = 2
highNum = 9
mult = 3

x = range(lowNum, highNum + 1)

for n in x:
    if n % mult == 0:
        print(n)