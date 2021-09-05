from crypt import methods
from flask_app import app
from flask import render_template, redirect, session, request, flash

from flask_app.models.show import Show
from flask_app.models.user import User
from flask_app.models.show_user import Show_User

@app.route('/shows/<int:id>/attend')
def attend_show():
    if 'user_id' not in session:
        flash('Please log in to view this page.')
        return redirect('/')

    
    data = {
        'user_id': session['user_id'],
        'show_id': session['show_id']
    }
    # print(data)
    Show_User.attend_show(data)
    
    return redirect('/shows/<int:id>')
