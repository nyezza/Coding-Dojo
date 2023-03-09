from flask_app.config.mysqlconnection import connectToMySQL
from flask_app import DATABASE
class Ninjas:
    def __init__(self,data):
        self.id=data['id']
        self.first_name=data['first_name']
        self.last_name=data['last_name']
        self.age=data['age']
        self.dojo_id=data['dojo_id']
        self.created_at=data['created_at']
        self.updated_at=data['updated_at']

    @classmethod
    def create_ninjas(cls,data):
        query="""INSERT INTO ninjas (first_name,last_name,age,dojo_id) VALUES (%(first_name)s,%(last_name)s,%(age)s,%(dojo_id)s;"""
        results=connectToMySQL(DATABASE).query_db(query,data)
        return results