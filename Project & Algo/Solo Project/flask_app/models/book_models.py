from flask_app.config.mysqlconnection import connectToMySQL
from flask_app import DATABASE
from flask_app.models import user_models
from flask import flash
import re

class Book:
    def __init__(self,data) :
        self.id=data['id']
        self.user_id = data['user_id']
        self.title=data['title']
        self.description=data['description']
        self.created_at=data['created_at']
        self.updated_at=data['updated_at']
        self.owner= {'first_name':user_models.User.get_by_id({"id":self.user_id}).first_name ,
                     'last_name':user_models.User.get_by_id({"id":self.user_id}).last_name}
        
    @classmethod
    def create_book(cls,data):
            
            query="""INSERT INTO books (title,description,user_id) 
            VALUES (%(title)s,%(description)s,%(user_id)s);"""
            
            return connectToMySQL(DATABASE).query_db(query,data)

    @classmethod
    def get_all(cls):
            query="""SELECT * FROM books """
            results= connectToMySQL(DATABASE).query_db(query)
            print(results)
            allBooks=[]
            for x in results:
                allBooks.append(cls(x))
            return allBooks

    @classmethod
    def get_by_id(cls,data):
            query="""SELECT * FROM books where id = %(id)s;"""
            results=connectToMySQL(DATABASE).query_db(query,data)
            print(results)
            if len(results)<1:
                return False
            return cls(results[0])
    @classmethod
    def get_user_book_by_id(cls,data):
        
        query= """select * from 
                users_liked_books inner join
                books on %(id)s = users_liked_books.book_id inner join
                users on users.id = users_liked_books.user_id;"""
        
        results=connectToMySQL(DATABASE).query_db(query,data)
        print (results)
        bookfound=[]
        for x in results:
                bookfound.append(x)
        return bookfound
        
    @classmethod
    def update(cls,data):
        query="""UPDATE books 
            SET title = %(title)s , description = %(description)s
            WHERE id= %(id)s;
        """
        return connectToMySQL(DATABASE).query_db(query,data)
    
    @staticmethod
    def validation(data):
        is_valid=True
        if len(data['title'])<2:
            is_valid=False
            flash("A valid Title is really required!!! , , at least should contain 3 characters!!!","create")
        if len(data['description'])<2:
            is_valid=False
            flash("A valid description is really required!!! , at least should contain 3 characters!!!","create")
        return is_valid
    
    @classmethod
    def remove(cls,data):
        query="""DELETE FROM books where id=%(id)s"""
        return connectToMySQL(DATABASE).query_db(query,data)