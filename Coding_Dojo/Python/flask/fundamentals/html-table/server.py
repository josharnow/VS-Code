from calendar import c
from flask import Flask, render_template
app = Flask(__name__)
@app.route('/')
def index():
    users = [
        {'first_name': 'Michael', 'last_name': 'Choi'},
        {'first_name': 'John', 'last_name': 'Supsupin'},
        {'first_name': 'Mark', 'last_name': 'Guillen'},
        {'first_name': 'KB', 'last_name': 'Tonel'}
    ]
    i = 0
    while (i < len(users)):
        print(users[i])
        print(users[i]["first_name"])
        print(users[i]["last_name"])
        i += 1
    length = len(users)
    # x = users['first_name']
    # y = users['last_name']
    return render_template("index.html", length=length, users=users)




if __name__ == "__main__":
    app.run(debug=True)
