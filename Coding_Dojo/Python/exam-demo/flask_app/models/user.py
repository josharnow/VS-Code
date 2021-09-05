from flask import flash
from flask_app import app
import re

from flask_app.config.mysqlconnection import connectToMySQL

class User():

    def __init__(self, data):
        self.id = data['id']
        self.first_name = data['first_name']
        self.last_name = data['last_name']
        self.nickname = data['nickname']
        self.email = data['email']
        self.password = data['password']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']


    @classmethod
    def create_user(cls, data):
        query = "INSERT INTO users (first_name, last_name, nickname, email, password) VALUES (%(first_name)s, %(last_name)s, %(nickname)s, %(email)s, %(password)s);"

        result = connectToMySQL('exam_demo').query_db(query, data)

        return result

    @classmethod
    def get_users_with_email(cls, data):

        query = "SELECT * FROM users WHERE email = %(email)s;"

        results = connectToMySQL('exam_demo').query_db(query, data)

        users = []

        for item in results:
            users.append(User(item))

        return users

    @classmethod
    def get_users_with_nickname(cls, data):
        query = "SELECT * FROM users WHERE nickname = %(nickname)s;"

        results = connectToMySQL('exam_demo').query_db(query, data)

        users = []

        for item in results:
            users.append(User(item)) 

        return users
    
    @classmethod
    def get_users_with_id(cls, data):

        query = "SELECT * FROM users WHERE users.id = %(id)s;"

        results = connectToMySQL('exam_demo').query_db(query, data)

        users = []

        for item in results:
            users.append(User(item))

        return users

    @staticmethod
    def validate_registration(data):

        is_valid = True

        email_regex = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')

        if len(data['first_name']) < 2 or len(data['first_name']) > 32:
            flash("First name should be 2 to 32 characters")
            is_valid = False
            
        if len(data['last_name']) < 2 or len(data['last_name']) > 50:
            flash("Last name should be 2 to 50 characters")
            is_valid = False
            
        if len(data['nickname']) < 2 or len(data['nickname']) > 32:
            flash("Nickname should be 2 to 32 characters")
            is_valid = False
        
        if not email_regex.match(data['email']):
            flash("Please provide a valid email address.")
            is_valid = False

        if len(data['password']) < 8:
            flash("Please use a password of at least eight characters.")
            is_valid = False
            
        if data['password'] != data['confirm_password']:
            flash("Please ensure password and confirm password match.")
            is_valid = False

        # ensures nickname is not in use
        if len(User.get_users_with_nickname({'nickname': data['nickname']})) != 0:
            flash("This nickname is already in use.")
            is_valid = False
        
        # ensures email address is not in use
        if len(User.get_users_with_email({'email': data['email']})) != 0:
            flash("This email address is already in use.")
            is_valid = False

        return is_valid
