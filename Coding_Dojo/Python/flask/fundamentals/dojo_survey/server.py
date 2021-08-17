from crypt import methods
from flask import Flask, render_template, redirect, request, session

app = Flask(__name__)

app.secret_key = 'keep it secret, keep it safe'

@app.route('/')
def index():
    if "name" not in session:
        session['name'] = 0
    if "location" not in session:
        session['location'] = 0
    if "favorite" not in session:
        session['favorite'] = 0
    if "comment" not in session:
        session['comment'] = 0
    return render_template("index.html")


@app.route('/process', methods=['POST'])
def process():
    # session["name"] = session
    session['name'] = request.form['name']
    session['location'] = request.form['location']
    session['favorite'] = request.form['favorite']
    session['comment'] = request.form['comment']
    print(session["name"])
    return redirect("/result")

@app.route('/result')
def result():
    # session["name"] = session
    print(session["name"])
    return render_template("result.html")

@app.route('/back')
def back():
    return redirect("/")

if __name__ == "__main__":
    app.run(debug=True)
