from mysqlconnection import connectToMySQL

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
        results  = connectToMySQL("music_db").query_db(query)
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
        result = connectToMySQL("music_db").query_db(query, data)
        print(f" this is the return after INSERT one Singer == {result} ******** ")
        return result
