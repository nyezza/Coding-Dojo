from mysqlconnection import connectToMySQL

class Book:
    def __init__(self, data) :
        self.id= data['id']
        self.title= data['title']
        self.isbn= data['isbn']
        self.author= data['author']
        self.publisher= data['publisher']
        self.publish_year= data['publish_year']
        self.image_small= data['image_small']
        self.image_medium= data['image_medium']
        self.image_large= data['image_large']
        self.created_at= data['created_at']
        self.updated_at= data['updated_at']
    
    @classmethod
    def get_all(cls):
        query = """
            SELECT * FROM books;
        """
        results = connectToMySQL("books_store").query_db(query)
        # print("*"*20,results,"20"*20)
        books = []
        for row in results:
            books.append(cls(row))
        return books
    
    @classmethod
    def create(cls,data):
        query = """
            INSERT INTO books 
            (title, isbn, author, publisher, publish_year,image_small,image_medium,image_large)
            VALUES (%(title)s, %(isbn)s, %(author)s, %(publisher)s, %(publish_year)s,%(image_small)s,%(image_medium)s,%(image_large)s);
        """
        result = connectToMySQL("books_store").query_db(query,data)
        return result