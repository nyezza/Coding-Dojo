from flask_app.config.mysqlconnection import connectToMySQL
from flask_app import DATABASE
from flask import flash
import re
EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$') 

class User:
    def __init__(self,data):
        self.id=data['id']
        self.first_name=data['first_name']
        self.last_name=data['last_name']
        self.email=data['email']
        self.password=data['password']
        self.created_at=data['created_at']
        self.updated_at=data['updated_at']

    @classmethod
    def create_user(cls,data):
        query="""
            INSERT INTO users (first_name,last_name,email,password) VALUES (%(first_name)s,%(last_name)s,%(email)s,%(password)s);
        """
        return connectToMySQL(DATABASE).query_db(query,data)
    @classmethod
    def get_by_email(cls,data):
        query="""
            SELECT * FROM users WHERE email=%(email)s;
        """
        results=connectToMySQL(DATABASE).query_db(query.data)
        if len(results)<1:
            return False
        return cls(results[0])
    
    @staticmethod
    def validation(data):
        is_valid=True
        if len(data['first_name'])<2:
            is_valid=False
            flash("A valid First Name is really required!!!")
        if len(data['last_name'])<2:
            is_valid=False
            flash("A valid Last Name is really required!!!")
        if not EMAIL_REGEX.match(data['email']):
            is_valid = False
            flash("A valid Last Name is really required!!!")
        elif User.get_by_email({'email':data['email']}):
            is_valid = False
            flash("this email exist!!!!")
        if len(data['password'])<7:
            is_valid = False
            flash("password must have at least 7 caracters!!!!")
        elif (data['password'] != data['confirm_password']):
            is_valid = False
            flash("password and his confirm must be identique!!!")
        return is_valid
        