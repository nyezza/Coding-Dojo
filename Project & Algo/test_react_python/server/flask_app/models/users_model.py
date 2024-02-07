from flask_app.config.mysqlconnection import connectToMySQL
from flask_app import DATABASE
from flask import flash

class User:
    def __init__(self,data):
        self.id=data["id"]
        self.name=data["name"]
        self.age=data["age"]
        self.created_at=data["created_at"]
        self.updated_at=data["updated_at"]
    
    @classmethod
    def create_one(cls,data):
        query="""INSERT INTO users (name,age) VALUES (%(name)s,%(age)s)"""
        return connectToMySQL(DATABASE).query_db(query,data)
        