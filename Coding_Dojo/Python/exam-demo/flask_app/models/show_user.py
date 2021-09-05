from unittest import result
from flask import flash, session
from flask_app import app
import re
from flask_app.config.mysqlconnection import connectToMySQL
from flask_app.models.user import User
from flask_app.models.show import Show

class Show_User():

    def __init__(self, data):
        self.id = data['id']
        self.show_id = data['show_id']
        self.user_id = data['user_id']
        
    @classmethod
    def attend_show(cls, data):
        query = 'INSERT INTO shows_users (show_id, user_id) VALUES (%(show_id)s, %(user_id)s);'

        result = connectToMySQL('exam_demo').query_db(query, data)

        # result is the ID of what's created
        return result
