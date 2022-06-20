from flask_app.config.mysqlconnection import MySQLConnection, connectToMySQL

class Ninja:

    def __init__ (self, data):
        self.id = data['id']
        self.first_name = data['first_name']
        self.last_name = data['last_name']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']
        self.dojo_id = data['dojo_id']

    @classmethod
    def create_one_ninja(cls, data):

        query = "INSERT into ninjas (first_name, last_name, dojo_id) "
        query += "VALUES ( %(first_name)s, %(last_name)s, %(dojo_id)s );"

        return connectToMySQL("dojos_and_ninjas_schema").query_db(query,data)
    
    @classmethod
    def get_all_ninjas(cls):

        query = "SELECT * FROM ninjas WHERE dojo_id = %(dojo_id)s;"
        results = connectToMySQL("dojos_and_ninjas_schema").query_db(query)
        print(results)

        all_ninjas = []

        for row in results:
            all_ninjas.append(cls(row))

        return all_ninjas