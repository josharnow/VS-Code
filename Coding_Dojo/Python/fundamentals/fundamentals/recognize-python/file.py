num1 = 42 # Variable declaration | Data Type / Primitive / Number
num2 = 2.3 # Variable declaration | Data Type / Primitive / Number
boolean = True # Variable declaration | Data Type / Primitive / Boolean
string = 'Hello World' # Variable declaration | Data Type / Primitive / String
pizza_toppings = ['Pepperoni', 'Sausage', 'Jalepenos', 'Cheese', 'Olives'] # Variable declaration | Data Type / List / Initialize
person = {'name': 'John', 'location': 'Salt Lake', 'age': 37, 'is_balding': False} # Variable declaration | Data Type / Dictionary / Initialize
fruit = ('blueberry', 'strawberry', 'banana') # Variable declaration | Data Type / Tuple / Initialize
print(type(fruit)) # Log statement | Type check | Data Type / Tuple / Access value
print(pizza_toppings[1]) # Log statement | Length check | Data Type / List / Access value
pizza_toppings.append('Mushrooms') # Data Type / List / Add value
print(person['name']) # Log statement | Data Type / Dictionary / Access value
person['name'] = 'George' # Data Type / Dictionary / Change value
person['eye_color'] = 'blue' # Data Type / Dictionary / Add value
print(fruit[2]) # Log statement | Length check | Data Type / Tuple / Access value

if num1 > 45: # conditional / if
    print("It's greater") # Log statement
else: # conditional / else
    print("It's lower") # Log statement

if len(string) < 5: # conditional / if
    print("It's a short word!") # Log statement
elif len(string) > 15: # conditional / else if
    print("It's a long word!") # Log statement
else: # conditional / else
    print("Just right!") # Log statement

for x in range(5): # for loop / start = 0 / stop = 5 / step = 1
    print(x) # Log statement
for x in range(2,5): # for loop / start = 2 / stop = 5 / step = 1
    print(x) # Log statement
for x in range(2,10,3): # for loop / start = 2 / stop = 10 / step = 3
    print(x) # Log statement
x = 0 # while loop / start = 0
while(x < 5): # while loop / stop = 5
    print(x) # Log statement
    x += 1 # while loop / increment = 1

pizza_toppings.pop() # Data Type / List / Delete value ('Olives')
pizza_toppings.pop(1) # Data Type / List / Delete value ('Sausage')

print(person) # Log statement | Data Type / Dictionary / Access value
person.pop('eye_color') # Data Type / Dictionary / Delete value
print(person) # Log statement | Data Type / Dictionary / Access value

for topping in pizza_toppings: # for loop / start
    if topping == 'Pepperoni': # conditional / if | for loop / sequence
        continue # for loop / continue
    print('After 1st if statement') # Log statement
    if topping == 'Olives': # conditional / if | for loop / sequence
        break # for loop / break

def print_hello_ten_times(): # function
    for num in range(10):
        print('Hello') # Log statement

print_hello_ten_times() # function / return

def print_hello_x_times(x): # function(parameter)
    for num in range(x):
        print('Hello') # Log statement

print_hello_x_times(4) # function(argument)

def print_hello_x_or_ten_times(x = 10):
    for num in range(x):
        print('Hello') # Log statement

print_hello_x_or_ten_times() # function / return
print_hello_x_or_ten_times(4) # function(argument) / return


"""
Bonus section
"""

# print(num3)
# num3 = 72
# fruit[0] = 'cranberry'
# print(person['favorite_team'])
# print(pizza_toppings[7])
#   print(boolean)
# fruit.append('raspberry')
# fruit.pop(1)
