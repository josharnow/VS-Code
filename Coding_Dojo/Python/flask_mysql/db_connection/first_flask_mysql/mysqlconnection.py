import pymysql.cursors # a cursor is the object we use to interact with the database
class MySQLConnection: # this class will give us an instance of a connection to our database
    def __init__(self, db):
        connection = pymysql.connect(host='localhost',
            user='root', # change the user as needed
            password='xyjqen-Naxcar-4sepxa', # change the password as needed
            db=db,
            charset='utf8mb4',
            cursorclass=pymysql.cursors.DictCursor,
            autocommit=True)
        self.connection = connection # establish the connection to the database

    def query_db(self, query, data=None): # the method to query the database
        with self.connection.cursor() as cursor:
            try:
                query = cursor.mogrify(query, data)
                print("Running Query:", query)

                executable = cursor.execute(query, data)
                if query.lower().find("insert") >= 0: # INSERT queries will return the ID NUMBER of the row inserted
                    self.connection.commit()
                    return cursor.lastrowid
                elif query.lower().find("select") >= 0: # SELECT queries will return the data from the database as a LIST OF DICTIONARIES
                    result = cursor.fetchall()
                    return result
                else: # UPDATE and DELETE queries will return nothing
                    self.connection.commit()
            except Exception as e: # if the query fails the method will return FALSE
                print("Something went wrong", e)
                return False
            finally:
                self.connection.close()# close the connection

def connectToMySQL(db): # connectToMySQL receives the database we're using and uses it to create an instance of MySQLConnection
    return MySQLConnection(db)