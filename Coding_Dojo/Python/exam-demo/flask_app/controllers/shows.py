from crypt import methods
from flask_app import app
from flask import render_template, redirect, session, request, flash

from flask_app.models.show import Show
from flask_app.models.user import User


@app.route('/shows')
def dashboard():
    if 'user_id' not in session:
        flash('Please log in to view this page.')
        return redirect('/')
    
    shows = Show.get_all_shows()

    return render_template('dashboard.html', shows=shows)

@app.route('/shows/new')
def new_show():
    if 'user_id' not in session:
        flash('Please log in to view this page.')
        return redirect('/')

    return render_template('new_show.html')

@app.route('/shows/create', methods=['POST'])
def create_show():
    if Show.show_validator(request.form):
        data = {
            'name': request.form['name'],
            'date': request.form['date'],
            'description': request.form['description'],
            'max_attendees': request.form['max_attendees'],
            'user_id': session['user_id']
        }
        Show.create_show(data)
        
        # session['show_id'] = id
        # print(session['show_id'])
    return redirect('/shows')


@app.route('/shows/<int:id>')
def view_show(id):
    if 'user_id' not in session:
        flash('Please log in to view this page.')
        return redirect('/')
    
    session['show_id'] = id
    print(session['show_id'])
    
    data = {
        'id': id
        }

    # all_shows = Show.get_all_shows()
    # print(all_shows)
    # print(all_shows[0])
    
    # print(data)
    # user = Show.show.id
    shows = Show.get_show_by_id(data)
    users = User.get_users_with_id(data)
    
    print(users)
    # creator = Show.get_shows_with_user_id(data)
    # creator = User.get_users_with_id(data)
    # print(creator)
    # print(user)
    
    # print(creator)
    # print(Show.user)
    
    # show_creator = Show.get_show_creator(data)
    # print(show_creator)

    return render_template('show_data.html', shows=shows, users=users)


@app.route('/shows/<int:id>/edit')
def edit_show(id):
    if 'user_id' not in session:
        flash('Please log in to view this page.')
        return redirect('/')

    session['show_id'] = id
    print(session['show_id'])
    
    data = {
        'id': id
    }

    print(data)

    shows = Show.get_show_by_id(data)
    print(shows)
    
    return render_template('edit_show.html', shows=shows)


@app.route('/shows/<int:id>/update', methods=['POST'])
def update_show(id):
    if 'user_id' not in session:
        flash('Please log in to view this page.')
        return redirect('/')
    
    # data = []
    if Show.show_validator(request.form):
        data = {
            'name': request.form['name'],
            'date': request.form['date'],
            'description': request.form['description'],
            'max_attendees': request.form['max_attendees'],
            'id': id
        }
        Show.update_show(data)
        return redirect('/shows')
    return redirect('/shows/<int:id>/edit')


@app.route('/shows/<int:id>/delete')
def delete_show(id):
    if 'user_id' not in session:
        flash('Please log in to view this page.')
        return redirect('/')
    
    data = {
        'id': id
    }
    shows = Show.get_show_by_id(data)
    
    return render_template('confirm_delete.html', shows=shows)

@app.route('/shows/<int:id>/confirm_delete')
def confirm_delete(id):
    if 'user_id' not in session:
        flash('Please log in to view this page.')
        return redirect('/')

    data = {
        'id': id
    }
    
    shows = Show.delete_show(data)
    return redirect('/shows')
