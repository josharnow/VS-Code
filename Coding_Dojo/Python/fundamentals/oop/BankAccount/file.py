# The BankAccount class should have a balance. When a new BankAccount instance is created, if an amount is given, the balance of the account should initially be set to that amount; otherwise, the balance should start at $0. The account should also have an interest rate, saved as a decimal (i.e. 1 % would be saved as 0.01), which should be provided upon instantiation. (Hint: when using default values in parameters, the order of parameters matters!)

from random import random

class BankAccount:

    all_accounts = []

    def __init__(self, int_rate, balance=0):
        self.int_rate = int_rate
        self.balance = balance
        BankAccount.all_accounts.append(self)

    def deposit(self, amount, times=1):
        original_balance = self.balance
        self.balance += (amount * times)
        # for i in range(times+1):
        #     deposit_x = i + 1
        #     return deposit_x
        print(f"${original_balance:.2f} + ${amount:.2f} = ${self.balance:.2f}")
        return self

    def withdraw(self, amount, times=1):
        original_balance = self.balance
        if (self.balance - amount) < 0:
            fee = 5
            print(f"Insufficient funds: Charging a ${fee} fee")
            original_balance -= fee
            print(f"${self.balance:.2f}")
            return self
        else:
            self.balance -= amount * times
            print(f"${original_balance:.2f} - ${amount:.2f} = ${self.balance:.2f}")
            return self

    def display_account_info(self):
        print(f"Balance: ${self.balance:.2f}")
        return self

    def yield_interest(self):
        percent_value = 100 * self.int_rate
        y = self.balance + (self.balance * self.int_rate)
        print(f"${self.balance:.2f} Balance + (${self.balance:.2f} Balance * {percent_value:.2f}% Interest) = ${y:.2f} New Balance")
        self.balance = y
        return self
    
    def randomize(self, num):
        num = random.randrange(num)
        return num
        # original_balance = self.balance
        # self.balance += amount
        # print(k)
        # yield k
        # i +=1

    @classmethod
    def all_balances(cls):
        sum = 0
        for account in cls.all_accounts:
            sum += account.balance
        print(f"${sum:.2f}")
        return sum
        # for inst_ref in cls.__refs__[cls]:
        #     inst = inst_ref()
        #     if inst is not None:
        #         yield inst
        # sum = 0
        # for account in cls.display_account_info():
        #     sum += account.balance
        # print(f"Balance of {cls.all_accounts}: ${cls.balance:.2f}")
        # return sum

# class User:
#     def __init__(self, name, email, account):
#         self.name = name
#         self.email = email
#         self.account = account
#         self.account = BankAccount(int_rate=0.02, balance=0)
#         # account = self.account

#     def make_deposit(self):
#         # self.amount = amount
#         # we can call the BankAccount instance's methods
#         # self.amount = amount
#         # self.account.deposit += amount
#         # print(self.account.balance)		# or access its attributes
#         # print(self.account)
#         # print(self.amount)
#         print(self)
#         return self
    
#     def test(self, account):
#         self.account = account
#         print(self.account)
#         return self

# User.test()
# print(User.make_deposit(50))


class User:
    def __init__(self, name, email):
        self.name = name
        self.email = email
        # self.account = account
        self.account = BankAccount(int_rate=0.02, balance=0)	# added this line
        # account = self.account

    def make_deposit(self, amount):
        # we can call the BankAccount instance's methods
        # self.amount = amount
        self.account.deposit(amount)
        # print(f"${self.account.balance}")
        # self.account.balance += amount
        # self.account.deposit(amount)
        # print(self.email("Josh", "j"))
        # print(self.amount)
        # print(self.email)
        # print(f"${self.account.balance:.2f}")
        return self
        # return self.amount # or access its attributes

    def make_withdrawal(self, amount):
        # self.amount = amount
        self.account.withdraw(amount)
        # print(f"${self.account.balance}")
        # self.account.balance -= amount
        # print(f"${self.account.balance:.2f}")
        return self
    
    def display_user_balance(self):
        self.account.balance
        print(f"${self.account.balance}")
        return self


import random

interest_percent = random.uniform(0,2)
interest = interest_percent / 100

value = random.randrange(1000)

bank_account = BankAccount(interest, value)

def randomize(num):
    k = bank_account.randomize(num)
    return k

bank_account.deposit(randomize(100)).deposit(randomize(100)).deposit(randomize(100)).withdraw(randomize(100)).yield_interest().display_account_info().all_balances()

bank_account.deposit(randomize(100)).deposit(randomize(100)).withdraw(randomize(100)).withdraw(randomize(100)).withdraw(randomize(100)).withdraw(randomize(100)).yield_interest().display_account_info().all_balances()

user_account = User("Josh", "fakeemail123@unreal.com")
user_account.make_deposit(100)
user_account.make_withdrawal(20)
user_account.display_user_balance()


# print(User(Josh, fakeemail123@unreal.com))

# print(User.make_deposit(200))

# print(User.make_deposit(200))

# deposit = []
# for i in

# def iterate_deposits(n):
#     d = []
#     # x = []
#     i = 1
#     # j = 0
#     for i in range(1, n+1):
#         d.append(random.randrange(100))
#         print(d[i-1])
#         i += 1
#     j = i
#     for j in range(n+1, -1):
#         print(j)


# def iterate_withdrawals(n):
#     w = {}
#     i = 0
#     for i in range(1, n+1):
#         w[f"deposit_{i}"] = random.randrange(100)
#         # print(w[f"deposit_{i}"])
#         return(w[f"deposit_{i}"])


# iterate_deposits(3)
# print(d[range(10)])
# while j < len(d):
#     d[j]
#     j += 1
# i += 1
# if i > n:
#     break

#     if d[i] == :

#         l.pop(i)
# else:
#     i += 1

# while i < (n + 1):
# # for i in range(1,n+1):
#     # if i == n - 1:
#     d.append(random.randrange(100))
#     # print(f"{d[f'deposit_{i}']}")
#     # print(d)
#     print(f"Making these deposits: {d}")
#     i += 1
#     if i == (n + 1):
#         # for j in d:
#         #         k = d[j]
#         #         print(k)
#         #         j += 1
#                 # if j = i:
#         break

# total_deposit = sum(d)
# print(d)
# print(f"{d[0]}")
# print(f"{total_deposit}")

# print(i)
# x = i
# return i
# else:
# d[f"deposit_{i}"] = random.randrange(100)
# print(d[f"deposit_{i}"])
# print(i)
# print(d)
# print(d[f"deposit_{i}"])
# print(x)
# return(d[f"deposit_{i}"])

# for i in deposit:
#     if i < 3:
#         deposit_x = deposit[i]

# if i < 2:
#     for d in deposit:
#         for w in withdraw:
#     all_accounts = dict[(i)

#     }


# for i in all_accounts:
#     while i < 3:
#         print(all_accounts[i])
        



# def deposit_times(self, num):
#     self.num = num
#     for i in self.num:
#             # d[f"deposit_{i}"] = random.randrange(100)
#             d += random.randrange(100)
#             return d


# def withdraw_times(self, num):
#     self.num = num
#     for i in self.num:
#         # d[f"deposit_{i}"] = random.randrange(100)
#         d += random.randrange(100)
#         return w

#         # if j <= 4:
#         #     # w[f"withdraw_{j}"] = random.randrange(100)
#         #     w += random.randrange(100)
#         #     return j


# print(deposit_i(1))
# print(d)
# w = {}

# account_1.display_every_account_info()

