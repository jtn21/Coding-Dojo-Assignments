from flask_app.config.mysqlconnection import MySQLConnection, connectToMySQL


class User:

    def __init__( self, data ):
        self.id = data[ 'id' ]
        self.first_name = data[ 'first_name' ]
        self.last_name = data [ 'last_name' ]
        self.email = data [ 'email' ]
        self.created_at = data [ 'created_at' ]
        self.updated_at = data [ 'updated_at' ]
    
    @classmethod
    def get_all ( cls ):
        query = 'SELECT *'
        query += 'FROM users;'

        result = connectToMySQL( "users_schema" ).query_db( query )
        allusers = []
        for user in result:
            allusers.append( cls( user ) )

        return allusers

    @classmethod
    def create( cls, data):
        query = "INSERT INTO users ( first_name, last_name, email) "
        query += "VALUES( %(first_name)s, %(last_name)s, %(email)s );"

        # id_new_user = connectToMySQL( "users_schema" ).query_db( query, data )
        # print( id_new_user )
        return connectToMySQL( "users_schema" ).query_db( query, data )

    @classmethod
    def get_all_users(cls):
        query = "SELECT * FROM users "
        results = connectToMySQL("users_schema").query_db(query)
        print(results)

        all_users = []

        for row in results:
            all_users.append(cls(row))
        return all_users
    
    @classmethod
    def get_one_user(cls, data):

        query = "SELECT * FROM users WHERE ID = %(user_id)s;"

        result = connectToMySQL("users_schema").query_db(query, data)
        return cls(result[0])

    @classmethod 
    def edit_one_user(cls, data):
        query = "UPDATE users "
        query += "SET first_name = %(first_name)s, last_name = %(last_name)s, email = %(email)s WHERE id = %(user_id)s;"

        result = connectToMySQL("users_schema").query_db(query,data)
        return
    
    @classmethod
    def delete_one_user(cls, data):
        query = "DELETE FROM users WHERE id = %(user_id)s ;"
        return connectToMySQL("users_schema").query_db(query,data)