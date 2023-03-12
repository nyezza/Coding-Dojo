from flask_app.config.mysqlconnection import connectToMySQL
from flask_app import DATABASE
from flask import flash
from flask_app.models import user_models


class Recipe:
    def __init__(self,data):
        self.id=data['id']
        self.user_id=data['user_id']
        self.name=data['name']
        self.description=data['description']
        self.instruction=data['instruction']
        self.date_made=data['date_made']
        self.under_30=data['under_30']
        self.created_at=data['created_at']
        self.updated_at=data['updated_at']
        self.owner=user_models.User.get_by_id({"id":self.user_id}).first_name
        
    @classmethod
    def create_recipe(cls,data):
        query="""
            INSERT INTO recipes (user_id,name,description,instruction,date_made,under_30) VALUES (%(user_id)s,%(name)s,%(description)s,%(instruction)s,%(date_made)s,%(under_30)s);
        """
        return connectToMySQL(DATABASE).query_db(query,data)
    @classmethod
    def get_by_id(cls,data):
        query="""
            SELECT * FROM recipes WHERE id= %(id)s;
        """
        results=connectToMySQL(DATABASE).query_db(query,data)
        if len(results)<1:
            return False
        return cls(results[0])
    @classmethod
    def get_all(cls):
        query="""SELECT * FROM recipes """
        results=connectToMySQL(DATABASE).query_db(query)
        all_reipes=[]
        for x in results:
            all_reipes.append(cls(x))
        return all_reipes
    @classmethod
    def update(cls,data):
        query="""UPDATE recipes 
            SET name = %(name)s , description = %(description)s , instruction = %(instruction)s , date_made = %(date_made)s , under_30 = %(under_30)s 
            WHERE id= %(id)s;
        """
        return connectToMySQL(DATABASE).query_db(query,data)
    @classmethod
    def remove(cls,data):
        query="""DELETE FROM recipes where id=%(id)s"""
        return connectToMySQL(DATABASE).query_db(query,data)
    
    @staticmethod
    def validation(data):
        is_valid=True
        if len(data['name'])<2:
            is_valid=False
            flash("A valid Name is really required!!!")
        if len(data['description'])<2:
            is_valid=False
            flash("A valid description is really required!!!")
        if len(data['instruction'])<6:
            is_valid=False
            flash("A valid instruction is really required!!!")    
        if data["date_made"] =="":
            is_valid = False
            flash("made date must not be emty!!!!")
        return is_valid