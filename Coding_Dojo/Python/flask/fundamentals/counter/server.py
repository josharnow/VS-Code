from crypt import methods
from flask import Flask, render_template, request, redirect, session, url_for
app = Flask(__name__)
# set a secret key for security purposes
app.secret_key = 'keep it secret, keep it safe'

@app.route('/', methods=["POST", "GET"])
# request 
def index():
    print(request.form.values)
    count = 0
    if request.method  == "POST":
        session["click"] = request.form["click"]
        x = session["click"]
        return redirect(url_for("show", x=x))
    else:
    # Here we add two properties to session to store the name and email
    # session['click'] = request.form['click']
    # session['useremail'] = request.form['email']
    # if 'key_name' in session:
    #     print('key exists!')
    # else:
    #     print("key 'key_name' does NOT exist")
        return render_template("index.html", counter=count)

@app.route('/count', methods=['POST'])
# request
def count():
    # Here we add two properties to session to store the name and email
    session['click'] += request.form['click']
    # counter += 1
    # x = session['click']
    # print(session['click'])
    # print(request.form['click'])
    # session['useremail'] = request.form['email']
    # if 'key_name' in session:
    #     print('key exists!')
    # else:
    #     print("key 'key_name' does NOT exist")
    return redirect('/show')

@app.route('/show')
def show(x):
    # x = count.x
    return render_template('index.html', counter=x)

@app.route('/destroy_session', methods=['POST'])
def reset():
    request.form['reset'] = session.clear()
    # session.clear()		# clears all keys
    session.pop('key_name')		# clears a specific key
    return redirect('/')

if __name__ == "__main__":
    app.run(debug=True)
