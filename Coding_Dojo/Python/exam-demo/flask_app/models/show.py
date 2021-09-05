from unittest import result
from flask import flash, session
from flask_app import app
import re
from flask_app.config.mysqlconnection import connectToMySQL
from flask_app.models.user import User

class Show():

    def __init__(self, data):
        self.id = data['id']
        self.name = data['name']
        self.description = data['description']
        self.date = data['date']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']
        self.user_id = data['user_id']
        self.max_attendees = data['max_attendees']
        # self.user = User.get_users_with_id(data)

    @classmethod
    def create_show(cls, data):
        query = 'INSERT INTO shows (name, description, date, user_id, max_attendees) VALUES (%(name)s, %(description)s, %(date)s, %(user_id)s, %(max_attendees)s);'

        result = connectToMySQL('exam_demo').query_db(query, data)

        # result is the ID of what's created
        return result
    
    @classmethod
    def get_all_shows(cls):
        query = 'SELECT * FROM shows JOIN users ON shows.user_id = users.id;'

        results = connectToMySQL('exam_demo').query_db(query)

        shows = []

        for item in results:
            shows.append(Show(item))

        # for item in results:
        #     show = Show(item)
        #     user_data = {
        #         'id': item['users.id'],
        #         'first_name': item['first_name'],
        #         'last_name': item['last_name'],
        #         'nickname': item['nickname'],
        #         'email': item['email'],
        #         'password': item['password'],
        #         'created_at': item['users.created_at'],
        #         'updated_at': item['users.updated_at']
        #     }
        #     user = User(user_data)
        #     show.user = user
        #     shows.append(show)
        print(shows)

        return shows

    @classmethod
    def get_show_by_id(cls, data):

        query = 'SELECT * FROM shows JOIN users ON shows.user_id = users.id WHERE shows.id = %(id)s;'

        result = connectToMySQL('exam_demo').query_db(query, data)

        shows = []

        for item in result:
            shows.append(Show(item))
            
        return shows

    @classmethod
    def get_shows_with_user_id(cls, data):

        query = "SELECT * FROM shows JOIN users ON shows.user_id = users.id WHERE shows.user_id = %(id)s;"

        results = connectToMySQL('exam_demo').query_db(query, data)

        shows = []

        for item in results:
            shows.append(Show(item))

        return shows

    @classmethod
    def get_user_shows(cls, data):
        query = 'SELECT * FROM shows JOIN users ON shows.user_id = users.id WHERE shows.user_id = users.id;'

        results = connectToMySQL('exam_demo').query_db(query, data)
        
        shows = []
        
        for item in results:
            shows.append(Show(item))
        
        # for item in results:
        #     show = Show(item)
        #     user_id = {
        #         'id': item['users.id']
        #     }
        #     user = User(user_id)
        #     show.user = user
        #     shows.append(show)

        return shows

        # for item in results:
        #     shows.append(Show(item))
        
        # return shows

    @classmethod
    def update_show(cls, data):
        query = 'UPDATE shows SET name = %(name)s, date = %(date)s, description = %(description)s, max_attendees = %(max_attendees)s WHERE id = %(id)s;'
        
        results = connectToMySQL('exam_demo').query_db(query, data)
        
        # shows = []

        # for item in results:
        #     shows.append(Show(item))
            
        return results

    @classmethod
    def delete_show(cls, data):
        query = 'DELETE FROM shows WHERE id = %(id)s;'
        results = connectToMySQL('exam_demo').query_db(query, data)
        return results
    
    # @classmethod
    # def delete_show(cls, data):
    #     query = 'SELECT * FROM shows JOIN users ON shows.user_id = users.id WHERE shows.user_id = users.id;'
    #     results = connectToMySQL('exam_demo').query_db(query, data)
    #     return results
    
    # @classmethod
    # def display_guest_list(cls, data):
    #     query = 'SELECT * FROM shows JOIN users ON shows.user_id = users.id WHERE shows.user_id = users.id'
    #     results = connectToMySQL('exam_demo').query_db(query, data)
    #     return results

    # @classmethod
    # def add_to_guest_list(cls, data):
    #     query = 'UPDATE shows SET shows.attending = 1 WHERE id = %(id)s;'
    #     result = connectToMySQL('exam_demo').query_db(query, data)

    #     # result is the ID of what's created
    #     return result
    
    # @classmethod
    # def remove_from_guest_list(cls, data):
    #     query = 'INSERT INTO shows (name, description, date, user_id, max_attendees) VALUES (%(name)s, %(description)s, %(date)s, %(user_id)s, %(max_attendees)s);'

    #     result = connectToMySQL('exam_demo').query_db(query, data)

    #     # result is the ID of what's created
    #     return result
    
    @classmethod
    def get_show_id(cls, data):
        query = 'SELECT id FROM shows WHERE shows.id = %(id)s;'

        result = connectToMySQL('exam_demo').query_db(query, data)

        shows = []
        for item in result:
            shows.append(Show(item))

        return shows

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
