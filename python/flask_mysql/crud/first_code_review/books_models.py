from mysqlconnection import connectToMySQL

class Book:
    def __init__(self, data):
        self.id=data['id']
        self.isbn=data['isbn']
        self.title=data['title']
        self.author=data['author']
        self.publisher=data['publisher']
        self.publish_year=data['publish_year']
        self.image_s=data['image_s']
        self.image_m=data['image_m']
        self.image_l=data['image_l']
        self.created_at=data['created_at']
        self.updated_at=data['updated_at']
        
    @classmethod
    def get_all(cls):
        query = """
            SELECT * FROM books;
        """
        result=connectToMySQL("books_store").query_db(query)
        # print ("*"*20, result, "*"*20)
        books=[]
        for row in result:
            books.append(cls(row))
        return books