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
        self.balance += amount
        # for i in range(times+1):
        #     deposit_x = i + 1
        #     return deposit_x
        print(f"${original_balance:.2f} + ${amount:.2f} = ${self.balance:.2f}")
        return self

    def withdraw(self, amount, times=1):
        original_balance = self.balance
        if (self.balance - amount) < 0:
            fee = 5
            print("Insufficient funds: Charging a ${fee} fee")
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

import random

interest_percent = random.uniform(0,2)
interest = interest_percent / 100
# print(f"{interest_percent:.10f}")

value = random.randrange(1000)





# deposit = []
# for i in 

deposit_1 = random.randrange(100)
deposit_2 = random.randrange(100)
deposit_3 = random.randrange(100)
withdraw_1 = random.randrange(100)
withdraw_2 = random.randrange(100)
withdraw_3 = random.randrange(100)
withdraw_4 = random.randrange(100)
account = BankAccount(interest, value)

def randomize(num):
    k = account.randomize(num)
    return k

account.deposit(randomize(100)).deposit(randomize(100)).deposit(randomize(100)).withdraw(randomize(100)).yield_interest().display_account_info().all_balances()

account.deposit(randomize(100)).deposit(randomize(100)).withdraw(randomize(100)).withdraw(randomize(100)).withdraw(randomize(100)).withdraw(randomize(100)).yield_interest().display_account_info().all_balances()

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

