from flask_app.config.mysqlconnection import connectToMySQL
class Dojo:
    def __init__(self,data):
        self.name=data['name']
        self.created_at=data['created_at']
        self.updated_at=data['updated_at']
    def display():
        