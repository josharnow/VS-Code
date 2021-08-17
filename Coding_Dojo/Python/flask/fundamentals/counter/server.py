from crypt import methods
from flask import Flask, render_template, redirect, session

app = Flask(__name__)

# set a secret key for security purposes
app.secret_key = 'keep it secret, keep it safe'

@app.route('/')
# request
def index():
    if "count" not in session:
        session['count'] = 0
    else:
        session['count'] += 1
    return render_template("index.html")

@app.route('/destroy_session')
def reset():
    session.clear()
    return redirect('/')

if __name__ == "__main__":
    app.run(debug=True)

# @app.route('/')
# # request
# def index():
#     if "count" not in session and "temp" not in session:
#         session['count'] = 0
#         session['temp'] = 0
#     elif session['temp'] == 0:  # allows for counter to go up on page refresh
#         session['count'] += 1
#     # print(session['temp'])
#     # print(session['count'])
#     session['temp'] = 0
#     return render_template("index.html")


# @app.route('/increment')
# def increment():
#     # print(session['temp'])
#     session['count'] += 1  # allows for counter to go up on button click
#     session['temp'] += 1
#     return redirect('/')

# @app.route('/destroy_session', methods=['POST'])
    # def reset():
