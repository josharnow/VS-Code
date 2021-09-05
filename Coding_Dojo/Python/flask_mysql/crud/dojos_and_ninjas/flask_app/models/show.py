from flask import flash
from flask_app import app
from flask_app.config.mysqlconnection import MySQLConnection
from flask_app.models.user import User

class Show():

    def __init__(self, data):
        self.id = data['id']
        self.name = data['name']
        self.description = data['description']
        self.date = data['date']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']
        self.users_id = data['users_id']
        self.user = None

    @classmethod
    def create_show(cls, data):
        query = 'INSERT INTO shows (name, description, date, users_id) VALUES (%(name)s, %(description)s, %(date)s, %(users_id)s);'

        result = MySQLConnection('august_exam_demo').query_db(query, data)

        # result is the ID of what's created
        return result

    @classmethod
    def get_all_shows(cls):

        query = 'SELECT * FROM shows JOIN users ON shows.users_id = users.id;'

        results = MySQLConnection('august_exam_demo').query_db(query)

        shows = []

        for item in results:
            show = Show(item)
            user_data = {
                'id': item['users.id'],
                'nickname': item['nickname'],
                'email': item['email'],
                'password': item['password'],
                'created_at': item['users.created_at'],
                'updated_at': item['users.updated_at']
            }
            user = User(user_data)
            show.user = user
            shows.append(show)

        return shows

    @classmethod
    def get_show_by_id(cls, data):

        query = 'SELECT * FROM shows JOIN users ON shows.users_id = users.id WHERE shows.id = %(id)s;'

        result = MySQLConnection('august_exam_demo').query_db(query, data)[0]

        show = Show(result)
        user_data = {
                'id': result['users.id'],
                'nickname': result['nickname'],
                'email': result['email'],
                'password': result['password'],
                'created_at': result['users.created_at'],
                'updated_at': result['users.updated_at']
            }
        
        show.user = User(user_data)

        return show

    @classmethod
    def update_show(cls, data):
        query = 'UPDATE shows SET name = %(name)s, date = %(date)s, description = %(description)s WHERE id = %(id)s;'

        MySQLConnection('august_exam_demo').query_db(query, data)

    @classmethod
    def delete_show(cls, data):
        query = 'DELETE FROM shows WHERE id = %(id)s;'
        MySQLConnection('august_exam_demo').query_db(query, data)

    @staticmethod
    def show_validator(data):
        is_valid = True

        if len(data['name']) < 1 or len(data['name']) > 100:
            flash("Show name should be 1 to 100 characters")
            is_valid = False

        if len(data['date']) != 10:
            flash('Please provide a valid date')
            is_valid = False
            # python datetime

        if len(data['description']) < 1 or len(data['description']) > 500:
            flash('Show description should be 1 to 500 characters in length')
            is_valid = False

        return is_valid