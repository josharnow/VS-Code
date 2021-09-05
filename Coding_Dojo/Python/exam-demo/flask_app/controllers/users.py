from crypt import methods
from flask_app import app
from flask import render_template, redirect, session, request, flash

from flask_app.models.user import User

from flask_bcrypt import Bcrypt

bcrypt = Bcrypt(app)

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/users/register', methods=['POST'])
def register_user():
    # validates form data
    print(request.form)
    
    if User.validate_registration(request.form):
        # hash password here
        data = {
            'first_name': request.form['first_name'],
            'last_name': request.form['last_name'],
            'nickname': request.form['nickname'],
            'email': request.form['email'],
            'password': bcrypt.generate_password_hash(request.form['password'])
        }
        User.create_user(data)
        users = User.get_users_with_email(request.form)
        print(users)
        
        user = users[0]
        
        session['user_id'] = user.id
        print(session['user_id'])
        
        session['user_first_name'] = user.first_name
        print(session['user_first_name'])
        
        session['user_last_name'] = user.last_name
        print(session['user_last_name'])
        
        session['user_nickname'] = user.nickname
        print(session['user_nickname'])
        
        session['user_email'] = user.email
        print(session['user_email'])
        
        return redirect('/shows')
        # create user if data is valid
    return redirect('/')

@app.route('/users/login', methods=['POST'])
def login_user():
    users = User.get_users_with_email(request.form)
    # print (users)
    
    if len(users) != 1:
        flash('User with the given email does not exist')
        return redirect('/')

    user = users[0]
    print(user)
    
    if not bcrypt.check_password_hash(user.password, request.form['password']):
        flash('Password for the given user is incorrect.')
        return redirect('/')

    session['user_id'] = user.id
    print(session['user_id'])
    
    session['user_first_name'] = user.first_name
    print(session['user_first_name'])
    
    session['user_last_name'] = user.last_name
    print(session['user_last_name'])
    
    session['user_nickname'] = user.nickname
    print(session['user_nickname'])
    
    session['user_email'] = user.email
    print(session['user_email'])
    
    return redirect('/shows')

# def success():
#     if 'user_id' not in session:
#         flash('Please log in to view this page.')
#         return redirect('/')
#     return render_template('success.html')

@app.route('/logout')
def logout():
    session.clear()
    return redirect('/')
