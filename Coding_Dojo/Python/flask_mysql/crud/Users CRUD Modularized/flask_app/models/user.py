from flask_app.config.mysqlconnection import connectToMySQL

class User:
    def __init__(self, data):
        self.id = data['id']
        self.first_name = data['first_name']
        self.last_name = data['last_name']
        self.email = data['email']
        self.created_at = data['created_at']
        self.update_at = data['update_at']

    @classmethod
    def save(cls, data):
        query = "Insert INTO users (first_name,last_name,email,created_at,update_at) VALUES(%(first_name)s,%(last_name)s,%(email)s,NOW(),NOW());"
        user_id = connectToMySQL('users_schema').query_db(query, data)
        return user_id

    @classmethod
    def get_all(cls):
        query = "SELECT * FROM users;"
        users_from_db = connectToMySQL('users_schema').query_db(query)
        users = []
        for u in users_from_db:
            users.append(cls(u))
        return users