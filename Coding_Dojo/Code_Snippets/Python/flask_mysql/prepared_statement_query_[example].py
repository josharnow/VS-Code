from friend import Friend
from mysqlconnection import connectToMySQL
query = "UPDATE friends SET email = %(email)s WHERE id = %(id_num)s;"
data = {
    'email': request.form['email'] # value from a form [the placeholder variable is 'email', which must match the key name in the data dictionary]
    'id_num': # possibly a value from the url,
}
result = connectToMySQL('schema_name').query_db(query, data)

# connection to the db - mysql = the instance of the MySQLConnection class
# query string - "INSERT INTO ..." = the string that will eventually be executed on our MySQL server
# data dictionary = the values that will be interpolated into the query string
# data dictionary keys - email, id_num = the keys of the data dictionary used in the query string with % -interpolation
    # (i.e. %(key_name)s)

# the 'email' and 'id_num' Keys in data must be named to match the placeholders in the query.


# Class method example:

# import the function that will return an instance of a connection
from mysqlconnection import connectToMySQL
# model the class after the friend table from our database
class Friend:
    # ... other class methods
    # class method to save our friend to the database
    @classmethod
    def save(cls, data):
        query = "INSERT INTO friends ( first_name , last_name , occupation , created_at, updated_at ) VALUES ( %(fname)s , %(lname)s , %(occ)s , NOW() , NOW() );"
        # data is a dictionary that will be passed into the save method from server.py
        return connectToMySQL('first_flask').query_db(query, data )


# relevant code snippet from server.py
from friend import Friend
@app.route('/create_friend', methods=["POST"])
def create_friend():

    # First we make a data dictionary from our request.form coming from our template.
    # # The keys in data need to line up exactly with the variables in our query string.
    data = {
    "fname": request.form["fname"],
    "lname": request.form["lname"],
    "occ": request.form["occ"]
    }
    # We pass the data dictionary into the save method from the Friend class.
    Friend.save(data)
    # Don't forget to redirect after saving to the database.
    return redirect('/')
