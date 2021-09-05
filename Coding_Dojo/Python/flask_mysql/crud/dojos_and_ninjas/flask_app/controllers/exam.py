from flask_app import app

from flask import render_template, redirect, session, request, flash

from flask_app.models.user import User
from flask_app.models.show import Show

@app.route('/exam')
def exam_index():
    if 'user_id' not in session:
        flash('Please log in to view this page.')
        return redirect('/')
    shows = Show.get_all_shows()
    return render_template('dashboard.html', shows = shows)

@app.route('/shows/new')
def new_show():
    if 'user_id' not in session:
        flash('Please log in to view this page.')
        return redirect('/')
    return render_template('new_show.html')

@app.route('/shows/create', methods=['POST'])
def create_show():
    print(request.form)
    if Show.show_validator(request.form):
        data = {
            'name': request.form['name'],
            'description': request.form['description'],
            'date': request.form['date'],
            'users_id': session['user_id']
        }
        Show.create_show(data)
        return redirect('/exam')

    return redirect('/shows/new')

# @app.route('/shows/create', methods=['POST'])
# def create_show():
#     print(request.form)
#     if Show.show_validator(request.form):
#         data = {
#             'name': request.form['name'],
#             'description': request.form['description'],
#             'date': request.form['date'],
#             'users_id': session['user_id']
#         }
#         show_id = Show.create_show(data)
#         return redirect(f'/shows/{show_id}')

#     return redirect('/shows/new')


@app.route('/shows/<int:show_id>')
def show_information(show_id):

    show = Show.get_show_by_id({'id': show_id})

    return render_template('show_data.html', show = show)

@app.route('/shows/<int:show_id>/edit')
def edit_show(show_id):

    show = Show.get_show_by_id({'id': show_id})

    if show.user.id != session['user_id']:
        return redirect('/exam')

    return render_template('edit_show.html', show = show)

@app.route('/shows/<int:show_id>/update', methods=['POST'])
def update_show(show_id):
    show = Show.get_show_by_id({'id': show_id})

    if show.user.id != session['user_id']:
        return redirect('/exam')

    data = {
        'id': show_id,
        'name': request.form['name'],
        'description': request.form['description'],
        'date': request.form['date'],
    }

    Show.update_show(data)

    return redirect(f'/shows/{show.id}')

@app.route('/shows/<int:show_id>/delete')
def delete_show(show_id):
    show = Show.get_show_by_id({'id': show_id})

    if show.user.id != session['user_id']:
        return redirect('/exam')

    return render_template('confirm_delete.html', show = show)

@app.route('/shows/<int:show_id>/confirm_delete')
def confirm_delete(show_id):
    show = Show.get_show_by_id({'id': show_id})

    if show.user.id != session['user_id']:
        return redirect('/exam')

    Show.delete_show({'id': show_id})

    return redirect('/exam')