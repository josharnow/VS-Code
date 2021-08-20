from crypt import methods
from flask import render_template, redirect, request, session, flash
from flask_app import app
from flask_app.models.user import User

@app.route('/users')
def users():
	return render_template('users.html', users=User.get_all())

@app.route('/users/new')
def new():
	return render_template('new_user.html')

@app.route('/users/new/create', methods=["POST"])
def create():
    data = {
        "first_name": request.form['first_name'],
        "last_name": request.form['last_name'],
        "email": request.form['email']
    }
    User.save(data)
    return redirect('/users')
