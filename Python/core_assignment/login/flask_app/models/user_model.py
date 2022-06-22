from flask_app.config.mysqlconnection import MySQLConnection, connectToMySQL
from flask_app import DATABASE
from flask import flash, session
import re

EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')

class User:
    def __init__(self, data):
        self.id = data['id']
        self.first_name = data['first_name']
        self.last_name = data['last_name']
        self.email = data['email']
        self.password = data['password']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']

#=====this checks to see if email already exists in database
    @classmethod
    def get_one( cls, data):
        query = "SELECT * "
        query += "FROM register " 
        query += "WHERE email = %(email)s;"

        result = connectToMySQL( DATABASE ).query_db( query, data)
        print(result)
        if len( result ) > 0:
            return cls( result[0] )
        else:
            return None


# This method allows us to register/create a user
    @classmethod
    def register_one_user( cls,data ):

        query = "INSERT INTO register (first_name, last_name, email, password) "
        query += "VALUES ( %(first_name)s, %(last_name)s, %(email)s, %(password)s );"

        return connectToMySQL( DATABASE ).query_db(query, data)


    @staticmethod
    def validate_registration(data):
        is_valid = True
        query = "SELECT * from register WHERE email %(email)s;"
        results = connectToMySQL(DATABASE).query_db(query,data)
        if len(data['first_name']) < 2:
            flash("Name must be at least 2 characters", 'error_first_name' )
            is_valid = False

        if len(data['last_name']) < 2:
            flash("Name must be at least 2 characters", 'error_last_name')
            is_valid = False

        if data['email'] == "":
            flash("Please provide email.", 'error_duplicate_email')

        if not EMAIL_REGEX.match(data['email']):
            flash("Invalid email address", 'error_invalid_email')
            is_valid = False

        if len(data['password']) < 8:
            flash("Name must be at least 8 characters", 'error_password')
            is_valid = False

        return is_valid
        
    
