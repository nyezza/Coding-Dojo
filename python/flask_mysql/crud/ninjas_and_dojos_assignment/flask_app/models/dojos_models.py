from flask_app.config.mysqlconnection import connectToMySQL
from flask_app import DATABASE
class Dojos:
    def __init__(self,data):
        self.id=data['id']
        self.name=data['name']
        self.created_at=data['created_at']
        self.updated_at=data['updated_at']
    
    @classmethod
    def create(cls,data):
        query="""INSERT INTO dojos_and_ninjas.dojos (name) VALUES (%(name)s);"""
        results=connectToMySQL(DATABASE).query_db(query,data)
        return results
    
    @classmethod
    def get_all_dojos(cls):
        query="""SELECT * FROM dojos;"""
        results=connectToMySQL(DATABASE).query_db(query)
        dojoslist=[]
        for x in results:
            dojoslist.append(cls(x))
        return dojoslist
    @classmethod
    def get_name_by_id(cls,data):
        query="""SELECT * FROM dojos WHERE id = %(id)s;"""
        results= connectToMySQL(DATABASE).query_db(query,data)
        return results[0]
    
    @classmethod
    def get_by_id(cls,data):
        query="""SELECT first_name,last_name,age FROM ninjas LEFT JOIN dojos ON dojos.id = ninjas.dojo_id WHERE dojos.id=%(id)s;""" 
        return connectToMySQL(DATABASE).query_db(query,data)