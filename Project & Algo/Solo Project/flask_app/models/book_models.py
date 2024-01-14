from flask_app.config.mysqlconnection import connectToMySQL
from flask_app import DATABASE
from flask import flash
import re

class Book:
    def __init__(self,data) :
        self.id=data['id']
        self.user_id = data['user_id']
        self.title=data['tilte']
        self.description=data['description']
        self.created_at=data['created_at']
        self.updated_at=data['updated_at']
        
    @classmethod
    def create_book(cls,data):
            
            query="""INSERT INTO books (title,description,user_id) 
            VALUES (%(title)s,%(description)s,%(user_id)s);"""
            
            return connectToMySQL(DATABASE).query_db(query,data)
       
    @classmethod
    def get_all(cls):
            query="""SELECT * FROM books"""
            results= connectToMySQL(DATABASE).query_db(query)
            allBooks=[]
            for x in results:
                allBooks.append(cls(x))
            return allBooks
       
    @classmethod
    def get_by_id(cls,data):
            query="""SELECT * FROM books where id = %(id)s;"""