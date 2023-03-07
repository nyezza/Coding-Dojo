from flask_app.config.mysqlconnection import connectToMySQL
from flask_app import DATABASE
class Singer:

    #constructor 
    def __init__(self, data_dict) :
        self.id = data_dict['id']
        self.image = data_dict['image']
        self.name = data_dict['name']
        self.nationality = data_dict['nationality']
        self.best_song = data_dict['best_song']
        self.rate = data_dict['rate']
        self.created_at = data_dict['created_at']
        self.updated_at = data_dict['updated_at']

        # CRUD Queries ==  CREATE READ UPDATE DELETE

        # ! All Queries Are CLASS METHODS

        #  - READ ALL
    @classmethod
    def get_all(cls):
        query = """
        SELECT * FROM singers ;
        """
        results  = connectToMySQL(DATABASE).query_db(query)
        # print(results)
        all_singers = []
        for row in results :
            all_singers.append(cls(row))
        return all_singers
    
    # CREATE

    @classmethod
    def create(cls,data):
        query = """
            INSERT INTO singers (name, image,nationality, rate, best_song) 
            VALUES (%(name)s, %(image)s,%(nationality)s, %(rate)s,%(best_song)s) ;
        """
        result = connectToMySQL(DATABASE).query_db(query, data)
        print(f" this is the return after INSERT one Singer == {result} ******** ")
        return result
    #  Read One 
    @classmethod
    def get_by_id(cls, data):
        query = """
            SELECT * FROM singers WHERE id  = %(id)s;
        """
        results = connectToMySQL(DATABASE).query_db(query, data)
        
        print("One Singer ==  ", results, "-"*20) 
        return cls(results[0])
    
    # Update 
    @classmethod
    def update(cls, data):

        query = """
            UPDATE singers SET name = %(name)s, nationality = %(nationality)s, rate = %(rate)s,
              best_song = %(best_song)s, image =%(image)s WHERE id = %(id)s;
        """
        return connectToMySQL(DATABASE).query_db(query, data)
    
    @classmethod
    def delete(cls, data):
        query = """
            DELETE FROM singers WHERE id  = %(id)s;
        """
        return connectToMySQL(DATABASE).query_db(query, data)