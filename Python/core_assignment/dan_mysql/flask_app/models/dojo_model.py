from flask_app.config.mysqlconnection import MySQLConnection, connectToMySQL
from flask_app.models import ninja_model

class Dojo:

    def __init__( self, data ):
        self.id = data[ 'id' ]
        self.name = data['name']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']
        self.ninjas = []


# ==================this class method allows us to create new dojos and add to datbase
    @classmethod
    def create_one_dojo( cls, data):

        query = "INSERT into dojos (name)"
        query += "VALUES ( %(name)s );"

        return connectToMySQL("dojos_and_ninjas_schema").query_db( query, data)
# =======================================this class method should show all dojos in database

    @classmethod 
    def get_all_dojos(cls):
        query = "SELECT * FROM dojos;"
        results = connectToMySQL("dojos_and_ninjas_schema").query_db(query)
        print(results)

        all_dojos = []

        for row in results:
            all_dojos.append(cls(row))
        
        return all_dojos
    

    # ===================this method  shows ninjas in each dojo
    @classmethod
    def get_dojo_with_ninjas(cls,data):
# ==========join query pulls ninjas with specific dojo.id
        query = "SELECT * FROM dojos JOIN ninjas on dojos.id = ninjas.dojo_id WHERE dojo_id = %(id)s; "

        results = connectToMySQL("dojos_and_ninjas_schema").query_db(query, data)
        print (results)
        
        dojo = cls( results[0] )
        for data in results:

            data = {
                "id" : data['ninjas.id'],
                "first_name" : data['first_name'],
                "last_name" : data['last_name'],
                "created_at": data['ninjas.created_at'],
                "updated_at" : data['ninjas.updated_at'],
                "dojo_id": data['dojo_id']
            }
# ====================this adds the ninjas being pulled to list above
            dojo.ninjas.append( ninja_model.Ninja( data ) )
        return dojo
