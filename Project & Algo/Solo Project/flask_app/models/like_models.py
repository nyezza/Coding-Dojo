from flask_app.config.mysqlconnection import connectToMySQL
from flask_app import DATABASE

class Liked:
    def __init__(self,data):
        self.book_id=data['book_id']
        self.user_id=data['user_id']
        
    @classmethod
    def add_like(self,data):
        query="""INSERT INTO users_liked_books (book_id,user_id) VALUES (%(book_id)s,%(user_id)s);"""
        return connectToMySQL(DATABASE).query_db(query,data)
    
    @classmethod
    def get_user_by_id(cls,data):
        query="""SELECT * FROM users_liked_books WHERE user_id=%(user_id)s"""
        results=connectToMySQL(DATABASE).query_db(query,data)
        if len(results)<1:
            return False
        liked=[]
        for x in results:
            liked.append(x)
        return liked
    
    @classmethod
    def get_book_by_id(cls,data):
        query="""SELECT * FROM users_liked_books WHERE book_id=%(book_id)s"""
        results=connectToMySQL(DATABASE).query_db(query,data)
        if len(results)<1:
            return False
        liked=[]
        for x in results:
            liked.append(x)
        return liked