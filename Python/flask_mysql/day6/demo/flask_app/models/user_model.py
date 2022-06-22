from flask_app.config.mysqlconnection import connectToMySQL
from flask_app import DATABASE
from flask import flash, session

class User:
    def __init__( self, data):
        self.id = data[ 'id' ]
        self.first_name = data[ 'first_name' ]
        self.last_name = data[ 'last_name' ]
        self.email = data[ 'email' ]
        self.password = data[ 'password' ]
        self.created_at = data[ 'created_at' ]
        self.updated_at = data[ 'updated_at' ]

# =====================this checks to see if user already exists by checking for existing email
    @classmethod
    def get_one( cls, data ):
        query = "SELECT * "
        query += "FROM users "
        query += "WHERE email = %(email)s;"

        result = connectToMySQL( DATABASE ).query_db(query, data)
# ======================this will return only one result which will always be index 0 when it finds it in the list
        if len( result ) > 0:
            return cls( result[0] )
        else:
            return None
    
    @classmethod
    def create( cls, data ):
        query = "INSERT INTO users( email, first_name, last_name, password ) "
        query += "VALUES( %(email)s, %(first_name)s, %(last_name)s, %(password)s );"

        return connectToMySQL( DATABASE ).query_db( query, data )

    @staticmethod
    def validate_register(data):
        isValid = True

        if data['first_name'] == "":
            isValid = False
            flash("Please provide first name.", "error_register_first_name" )

        if len(data['first_name']) < 2:
            isValid = False
            flash( "Your first name must have at least 2 characters.", "error_register_first_name" )

        if data['last_name'] == "":
            isValid = False
            flash("Please provide last name.", "error_register_last_name" )

        if len(data['last_name']) < 2:
            isValid = False
            flash( "Your last name must have at least 2 characters.", "error_register_last_name" )

        if data['email'] == "":
            isValid = False
            flash("Please provide your email", "error_register_email" )

        if data['password'] != data['password_confirmation']:
            isValid = False
            flash("Your passwords do not match.", "error_register_password_confirmation" )
        
        if data['password'] == "":
            isValid = False
            flash("You must provide a password", "error_register_password" )
        
        if data['password_confirmation'] == "":
            isValid = False
            flash("You must provide a password confirmation", "error_register_password_confirmation" )
        
        return isValid

    @staticmethod
    def validate_session():
        if "user_id" not in session:
            return False
        else:
            return True