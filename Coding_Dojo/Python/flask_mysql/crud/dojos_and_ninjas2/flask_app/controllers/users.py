from crypt import methods
from flask import render_template, redirect, request, session, flash
from flask_app import app
from flask_app.models.user import User

@app.route('/')
def index():
    return redirect('/users')

@app.route('/users')
def users():
    return render_template("users.html",users=User.get_all())

@app.route('/users/new')
def new():
    return render_template("new_user.html")

@app.route('/users/new/create', methods=["POST"])
def create():
    data = {
        "first_name": request.form['first_name'],
        "last_name": request.form['last_name'],
        "email": request.form['email']
    }
    User.save(data)
    return redirect('/users')


@app.route('/users/<int:user_id>')
def detail_page(user_id):
    data = {
        'id': user_id
    }
    return render_template("details_page.html", user=User.get_one(data))

@app.route('/edit_page/<int:user_id>')
def edit_page(user_id):
    data = {
        'id': user_id
    }
    return render_template("edit_page.html", user=User.get_one(data))

@app.route('/update/<int:user_id>', methods=['POST'])
def update(user_id):
    data = {
        'id': user_id,
        "first_name": request.form['first_name'],
        "last_name": request.form['last_name'],
        "email": request.form['email']
    }
    User.update(data)
    return redirect(f"/users/{user_id}")

@app.route('/delete/<int:user_id>')
def delete(user_id):
    data = {
        'id': user_id
    }
    User.destroy(data)
    return redirect('/users')